package com.wshop.dao;

import com.github.pagehelper.Page;
import com.wshop.dto.condition.MatchColorWorkCondition;
import com.wshop.entity.MatchColorWork;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MatchColorWorkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MatchColorWork record);

    int insertSelective(MatchColorWork record);

    MatchColorWork selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MatchColorWork record);

    int updateByPrimaryKey(MatchColorWork record);
    
    Page<MatchColorWork> selectAll(MatchColorWorkCondition condition);

    List<MatchColorWork> selectAllMCW(MatchColorWorkCondition condition);
}