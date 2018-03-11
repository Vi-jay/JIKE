package com.base.controller;

import com.alibaba.fastjson.JSONObject;
import com.base.bean.Datagrid;
import com.base.bean.PageBean;
import com.base.code.Ret;
import com.base.code.RetCode;
import com.base.dao.pojo.Case;
import com.base.dao.pojo.Report;
import com.base.dao.pojo.ReportWithBLOBs;
import com.base.service.ClientService;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RequestMapping("/client")
@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    /**
     * case相关
     *
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "case", method = RequestMethod.GET)
    public String showCase(ModelMap modelMap) {
        modelMap.addAttribute("caseList", clientService.selectCases());
        return "client/case";
    }

    @RequestMapping(value = "updateCase", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object updateCase(@RequestBody Case caseModel) {
        int i = clientService.updateCaseByModel(caseModel);
        RetCode code = RetCode.SUCCESS;
        if (i < 0) code = RetCode.ERROR;
        return new Ret(code);
    }
    @ResponseBody
    @RequestMapping(value = "/listCases", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    @ApiOperation(value = "查找所有案例", httpMethod = "POST", response = Case.class, notes = "listCases")
    public String getCaseList( @ApiParam(required = true, name = "PageBean", value = "pageBean") @RequestBody PageBean pageBean) {
        Datagrid datagrid = clientService.selectCasesListAndPage(pageBean.getPageNum(), pageBean.getPageSize());
        return JSONObject.toJSONString(datagrid);
    }

    @RequestMapping(value = "addCase", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object addCase(@RequestBody Case caseModel) {
        int i = clientService.addCaseByModel(caseModel);
        RetCode code = RetCode.SUCCESS;
        if (i < 0) code = RetCode.ERROR;
        return new Ret(code);
    }

    @RequestMapping(value = "deleteCases", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object deleteCases(@RequestBody List<Case> cases) {
        int i = clientService.deleteCasesByIds(cases);
        RetCode code = RetCode.SUCCESS;
        if (i < 0) code = RetCode.ERROR;
        return new Ret(code);
    }


    /**
     * report相关
     *
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "report", method = RequestMethod.GET)
    public String showReport(ModelMap modelMap) {
        List<ReportWithBLOBs> reports = clientService.selectReportsListAndPage(0, 0).getRows();
        int impSize = 0;
        Map<Integer,String> reportTimes  = new HashMap<Integer, String>();
        for (ReportWithBLOBs report:reports) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
            String dateString  = dateFormat.format(report.getDate());
            reportTimes.put(report.getId(),dateString);
            if (report.getState()==1)impSize++;
        }
        modelMap.addAttribute("reportList", reports);
        modelMap.addAttribute("reportTimes", reportTimes);

        return "client/report";
    }
@RequestMapping(value = "report/{path}", method = RequestMethod.GET)
    public String showReportFrame(ModelMap modelMap, @PathVariable("path") String path) {
        ReportWithBLOBs report = clientService.selectReportByPrimaryKey(Integer.parseInt(path));
        modelMap.addAttribute("html",report.getReportHtml());
        return "client/reportFrame";
    }

    @RequestMapping(value = "listReports", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    @ApiOperation(value = "获取所有公司动态",response = Datagrid.class,httpMethod = "POST")
    public Object getReportList(@ApiParam(required = true) @RequestBody PageBean pageBean) {
        Datagrid datagrid = clientService.selectReportsListAndPage(pageBean.getPageNum(), pageBean.getPageSize());
        return JSONObject.toJSON(datagrid);
    }

    @RequestMapping(value = "updateReport", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object updateReport(@RequestBody ReportWithBLOBs reportModel) {
        int i = clientService.updateReportByModel(reportModel);
        RetCode code = RetCode.SUCCESS;
        if (i < 0) code = RetCode.ERROR;
        return new Ret(code);
    }

    @RequestMapping(value = "addReport", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object addReport(@RequestBody ReportWithBLOBs reportModel) {
        int i = clientService.addReportByModel(reportModel);
        RetCode code = RetCode.SUCCESS;
        if (i < 0) code = RetCode.ERROR;
        return new Ret(code);
    }

    @RequestMapping(value = "deleteReports", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object deleteReports(@RequestBody List<Report> reports) {
        int i = clientService.deleteReportsByIds(reports);
        RetCode code = RetCode.SUCCESS;
        if (i < 0) code = RetCode.ERROR;
        return new Ret(code);
    }


    /**
     * 页面转跳
     *
     * @param modelMap
     * @param path
     * @return
     */
    @RequestMapping(value = "page/{path}", method = RequestMethod.GET)
    public String showRichPage(ModelMap modelMap, @PathVariable("path") String path) {
        return "client/" + path;
    }

}






