package com.wshop.entity;

import java.util.Date;

public class ColorMaterialUsed {
    private Integer id;

    private Integer idMatchColorWork;

    private String colorMaterial;

    private Long baseRecipe;

    private Long number;

    private Date produceTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdMatchColorWork() {
        return idMatchColorWork;
    }

    public void setIdMatchColorWork(Integer idMatchColorWork) {
        this.idMatchColorWork = idMatchColorWork;
    }

    public String getColorMaterial() {
        return colorMaterial;
    }

    public void setColorMaterial(String colorMaterial) {
        this.colorMaterial = colorMaterial == null ? null : colorMaterial.trim();
    }

    public Long getBaseRecipe() {
        return baseRecipe;
    }

    public void setBaseRecipe(Long baseRecipe) {
        this.baseRecipe = baseRecipe;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Date getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(Date produceTime) {
        this.produceTime = produceTime;
    }
}