package com.rpm.demo.provider.es.repository;

import com.rpm.demo.provider.es.docment.DocBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Highlight;
import org.springframework.data.elasticsearch.annotations.HighlightField;
import org.springframework.data.elasticsearch.annotations.HighlightParameters;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author renpiming
 */
public interface ElasticRepository extends ElasticsearchRepository<DocBean, Long> {


    @Query("{\"match\": {\"content\": {\"query\": \"?0\",\"analyzer\": \"ik_max_word\"}}}")
    @Highlight(fields = {@HighlightField(name = "content",parameters=@HighlightParameters(preTags = "<strong><font style='color:red'>",postTags = "</font></strong>"))})
    List<SearchHit<DocBean>> findByContent(String query, Pageable pageable);

    @Query(" {    \"bool\" : {      \"must\" :         {          \"match\":{            \"firstCode\" : \"?0\"          }        }    }  }")
    Page<DocBean> findByFirstCode(String firstCode, Pageable pageable);

    @Query(" {    \"bool\" : {      \"must\" :         {          \"match\":{            \"secordCode\" : \"?0\"          }        }    }  }")
    Page<DocBean> findBySecordCode(String secordCode, Pageable pageable);


}
