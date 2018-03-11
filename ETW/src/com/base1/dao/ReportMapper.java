package com.base1.dao;

import com.base1.dao.pojo.Report;
import com.base1.dao.pojo.ReportWithBLOBs;

public interface ReportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReportWithBLOBs record);

    int insertSelective(ReportWithBLOBs record);

    ReportWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReportWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ReportWithBLOBs record);

    int updateByPrimaryKey(Report record);
}