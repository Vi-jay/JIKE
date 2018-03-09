package com.base.dao;

import com.base.dao.pojo.Case;
import com.base.dao.pojo.Report;
import com.base.dao.pojo.ReportWithBLOBs;

import java.util.List;

public interface ReportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReportWithBLOBs record);

    int insertSelective(ReportWithBLOBs record);

    ReportWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReportWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ReportWithBLOBs record);

    int updateByPrimaryKey(Report record);

    List<ReportWithBLOBs> selectReports();

    int deleteReportByIds(List list);
}