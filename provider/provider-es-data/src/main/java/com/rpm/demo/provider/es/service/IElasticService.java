package com.rpm.demo.provider.es.service;


import com.rpm.demo.provider.es.docment.DocBean;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.SearchHit;


import java.util.Iterator;
import java.util.List;

public interface IElasticService {

    void createIndex();

    void deleteIndex(String index);

    void save(DocBean docBean);

    void saveAll(List<DocBean> list);

    Iterator<DocBean> findAll();

    Page<DocBean> findByContent(String content);

    Page<DocBean> findByFirstCode(String firstCode);

    Page<DocBean> findBySecordCode(String secordCode);

}

