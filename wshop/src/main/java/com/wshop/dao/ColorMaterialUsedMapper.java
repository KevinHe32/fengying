package com.wshop.dao;


import com.wshop.entity.ColorMaterialUsed;

public interface ColorMaterialUsedMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ColorMaterialUsed record);

    int insertSelective(ColorMaterialUsed record);

    ColorMaterialUsed selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ColorMaterialUsed record);

    int updateByPrimaryKey(ColorMaterialUsed record);
}