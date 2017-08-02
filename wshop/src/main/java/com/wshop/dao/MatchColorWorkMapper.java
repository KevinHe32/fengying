package com.wshop.dao;

import com.wshop.dto.condition.MatchColorWorkCondition;
import com.wshop.entity.MatchColorWork;

import java.util.List;

public interface MatchColorWorkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MatchColorWork record);

    int insertSelective(MatchColorWork record);

    MatchColorWork selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MatchColorWork record);

    int updateByPrimaryKey(MatchColorWork record);
    
    List<MatchColorWork> selectAll(MatchColorWorkCondition condition);
}