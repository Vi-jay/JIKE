package com.base.service;

import com.base.dao.PagesMapper;
import com.base.dao.pojo.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagesService {
    @Autowired
    private PagesMapper pagesMapper;

    public int insert(Pages record){
        return pagesMapper.insert(record);
    }


    public Pages selectByPrimaryKey(Integer id){
        return pagesMapper.selectByPrimaryKey(id);
    }public Pages selectByPage(Pages pages){
        return pagesMapper.selectByPage(pages);
    }


    public int updateByPage(Pages pages) {
        return pagesMapper.updateByPrimaryKeySelective(pages);
    }
}
