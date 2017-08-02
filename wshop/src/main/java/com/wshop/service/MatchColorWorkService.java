package com.wshop.service;

import com.github.pagehelper.PageHelper;
import com.wshop.dao.MatchColorWorkMapper;
import com.wshop.dto.condition.MatchColorWorkCondition;
import com.wshop.entity.MatchColorWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MatchColorWorkService {
    @Autowired
    private MatchColorWorkMapper matchColorWorkMapper;

    @Transactional
    public Integer addMatchColorWork(MatchColorWork matchColorWork){
    	Integer result = matchColorWorkMapper.insertSelective(matchColorWork);
        return result;
    }

    
    public List<MatchColorWork> selectAll(MatchColorWorkCondition condition){
    	PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
    	
    	List<MatchColorWork> matchColorWorks = matchColorWorkMapper.selectAll(condition);
        return matchColorWorks;
    }
    
    public MatchColorWork selectByPrimaryKey(Integer id){
        MatchColorWork matchColorWork = matchColorWorkMapper.selectByPrimaryKey(id);
        return matchColorWork;
    }

    @Transactional
    public Integer editMatchColorWork(MatchColorWork matchColorWork){
    	Integer result = matchColorWorkMapper.updateByPrimaryKey(matchColorWork);
        return result;
    }
    
    public void deleteMatchColorWorkById(Integer id){
    	if(null!=id){
            matchColorWorkMapper.deleteByPrimaryKey(id);
    	}
    }
}
