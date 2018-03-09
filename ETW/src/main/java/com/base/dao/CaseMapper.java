package com.base.dao;

import com.base.dao.pojo.Case;

import java.util.List;

public interface CaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Case record);

    int insertSelective(Case record);

    Case selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Case record);

    int updateByPrimaryKey(Case record);

    List<Case> selectCases();

    int deleteCasesByIds(List<Integer> cases);
}