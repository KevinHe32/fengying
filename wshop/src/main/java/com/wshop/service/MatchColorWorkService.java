package com.wshop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wshop.dao.MatchColorWorkMapper;
import com.wshop.dto.condition.MatchColorWorkCondition;
import com.wshop.dto.model.MatchColorWorkModel;
import com.wshop.entity.MatchColorWork;
import com.wshop.entity.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    
    public PageInfo<MatchColorWorkModel> selectAll(MatchColorWorkCondition condition){
    	PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
    	
    	List<MatchColorWork> matchColorWorks = matchColorWorkMapper.selectAll(condition);
        List<MatchColorWorkModel> list = new ArrayList<>();
        for(MatchColorWork matchColorWork : matchColorWorks){
            MatchColorWorkModel matchColorWorkModel = new MatchColorWorkModel();
            BeanUtils.copyProperties(matchColorWork, matchColorWorkModel);
            list.add(matchColorWorkModel);
        }
        PageInfo<MatchColorWorkModel> results = new PageInfo<MatchColorWorkModel>(list);
        return results;
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

    public List<MatchColorWorkModel> selectAllMCW(MatchColorWorkCondition condition){

        List<MatchColorWork> matchColorWorks = matchColorWorkMapper.selectAllMCW(condition);
        List<MatchColorWorkModel> list = new ArrayList<>();
        for(MatchColorWork matchColorWork : matchColorWorks){
            MatchColorWorkModel matchColorWorkModel = new MatchColorWorkModel();
            BeanUtils.copyProperties(matchColorWork, matchColorWorkModel);
            list.add(matchColorWorkModel);
        }
        return list;
    }

}
