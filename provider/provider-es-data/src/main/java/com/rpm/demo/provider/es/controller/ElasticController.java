package com.rpm.demo.provider.es.controller;


import com.rpm.demo.provider.es.docment.DocBean;
import com.rpm.demo.provider.es.service.IElasticService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Log4j2
@RestController
@RequestMapping("/elastic")
public class ElasticController {

    @Autowired
    private IElasticService elasticService;

    @GetMapping("/init")
    public void init(){
        elasticService.createIndex();
        List<DocBean> list =new ArrayList<>();
        list.add(new DocBean(1L,"XX0193","XX8064","我是id为1的。",1));
        list.add(new DocBean(2L,"XX0210","XX7475","我是第二名。比第一的大了一岁",1));
        list.add(new DocBean(3L,"XX0257","XX8097","我前面有两个人。总是比我跑的快",1));
        elasticService.saveAll(list);

    }

    @GetMapping("/all")
    public Iterator<DocBean> all(){
        return elasticService.findAll();
    }

    @GetMapping("/get/{key}")
    public Page<DocBean> getKey(@PathVariable String key , @RequestParam String keyWord){

        if (key.equals("first")){
            return elasticService.findByFirstCode(keyWord);
        }
        if (key.equals("secord")){
            return elasticService.findBySecordCode(keyWord);
        }
        return null;
    }
    @GetMapping("/content")
    public Page<DocBean> getKey(@RequestParam String keyWord){
        Page<DocBean> page = elasticService.findByContent(keyWord);
        return  page;
    }

}

