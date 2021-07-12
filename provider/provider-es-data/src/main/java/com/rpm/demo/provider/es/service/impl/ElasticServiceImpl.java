package com.rpm.demo.provider.es.service.impl;

import com.rpm.demo.provider.es.docment.DocBean;
import com.rpm.demo.provider.es.repository.ElasticRepository;
import com.rpm.demo.provider.es.service.IElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service("elasticService")
public class ElasticServiceImpl implements IElasticService {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;
    @Autowired
    private ElasticRepository elasticRepository;

    private Pageable pageable = PageRequest.of(0,10);

    @Override
    public void createIndex() {
        if(!elasticsearchTemplate.indexOps(DocBean.class).exists()) {
            elasticsearchTemplate.indexOps(DocBean.class).create();
        }
    }

    @Override
    public void deleteIndex(String index) {
        if(elasticsearchTemplate.indexOps(DocBean.class).exists()) {
            elasticsearchTemplate.indexOps(DocBean.class).delete();
        }
    }

    @Override
    public void save(DocBean docBean) {
        elasticRepository.save(docBean);
    }

    @Override
    public void saveAll(List<DocBean> list) {
        elasticRepository.saveAll(list);
    }

    @Override
    public Iterator<DocBean> findAll() {
        return elasticRepository.findAll().iterator();
    }

    @Override
    public Page<DocBean> findByContent(String content) {
        List<SearchHit<DocBean>> list  = elasticRepository.findByContent(content,pageable);
        List<DocBean> docBeans  = new ArrayList<>();
        for (SearchHit<DocBean> hit  :list){
           DocBean bean = hit.getContent();
           List<String> higlight  = hit.getHighlightField("content");
           bean.setContent(higlight.get(0));
           docBeans.add(hit.getContent());
        }
        Page<DocBean> page = new PageImpl<DocBean>(docBeans);
        return page;
    }

    @Override
    public Page<DocBean> findByFirstCode(String firstCode) {
        return elasticRepository.findByFirstCode(firstCode,pageable);
    }

    @Override
    public Page<DocBean> findBySecordCode(String secordCode) {
        return elasticRepository.findBySecordCode(secordCode,pageable);
    }


}

