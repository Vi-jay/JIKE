package com.base.service;

import com.base.bean.Datagrid;
import com.base.dao.CaseMapper;
import com.base.dao.ReportMapper;
import com.base.dao.pojo.Case;
import com.base.dao.pojo.Report;
import com.base.dao.pojo.ReportWithBLOBs;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private CaseMapper caseMapper;
    @Autowired
    private ReportMapper reportMapper;

    /**
     * case相关
     *
     * @return
     */
    public List<Case> selectCases() {
        return caseMapper.selectCases();
    }

    public Datagrid selectCasesListAndPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("id desc");
        List<Case> cases = caseMapper.selectCases();
        PageInfo<Case> pageInfo = new PageInfo<Case>(cases);
        return new Datagrid(pageInfo.getTotal(), pageInfo.getList());
    }

    public int updateCaseByModel(Case caseModel) {
        return caseMapper.updateByPrimaryKey(caseModel);
    }

    public int deleteCasesByIds(List<Case> cases) {
        List list = new ArrayList<Integer>();
        for (Case caseModel : cases) {
            list.add(caseModel.getId());
        }
        return caseMapper.deleteCasesByIds(list);
    }

    public int addCaseByModel(Case caseModel) {
        return caseMapper.insert(caseModel);
    }


    /**
     * report相关
     *
     * @return
     */

    public Datagrid<ReportWithBLOBs> selectReportsListAndPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("date asc");
        List<ReportWithBLOBs> reports = reportMapper.selectReports();
        PageInfo<ReportWithBLOBs> pageInfo = new PageInfo<ReportWithBLOBs>(reports);
        return new Datagrid<ReportWithBLOBs>(pageInfo.getTotal(), pageInfo.getList());
    }
    public ReportWithBLOBs selectReportByPrimaryKey(int id){
     return reportMapper.selectByPrimaryKey(id);
    }

    public int updateReportByModel(ReportWithBLOBs reportModel) {
        return reportMapper.updateByPrimaryKeyWithBLOBs(reportModel);
    }

    public int addReportByModel(ReportWithBLOBs reportModel) {

        return reportMapper.insert(reportModel);
    }

    public int deleteReportsByIds(List<Report> reports) {
        List list = new ArrayList<Integer>();
        for (Report reportModel : reports) {
            list.add(reportModel.getId());
        }
        return reportMapper.deleteReportByIds(list);

    }
}
