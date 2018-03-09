package com.base.controller;

import com.alibaba.fastjson.JSONObject;
import com.base.code.Ret;
import com.base.code.RetCode;
import com.base.dao.pojo.Pages;
import com.base.service.PagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("editor")
public class EditorController {
    @Autowired
    private PagesService pagesService;



    @RequestMapping(value = "updatePage", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object updatePage(@RequestBody Pages pages, ModelMap modelMap) {
        RetCode code = RetCode.SUCCESS;
        if (pagesService.updateByPage(pages) < 0) code = RetCode.ERROR;
        return new Ret(code, pages);
    }

    @RequestMapping(value = "searchPage/{pageId}")
    public String searchPage(@PathVariable Integer pageId, ModelMap modelMap) {
        Pages pages = pagesService.selectByPrimaryKey(pageId);
        modelMap.addAttribute("html", pages.getPage());
        return "manager/page";
    }

    @RequestMapping(value = "getHtml", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object getHtml(Pages page) {
        Pages pages = pagesService.selectByPage(page);
        return JSONObject.toJSON(pages);
    }
}
