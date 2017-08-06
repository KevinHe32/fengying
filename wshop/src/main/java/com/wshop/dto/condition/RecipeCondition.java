package com.wshop.dto.condition;

import io.swagger.annotations.ApiModel;

@ApiModel
public class RecipeCondition extends BaseCondition{

    private String color_name;

    private String material;

    public String getColor_name() {
        return color_name;
    }

    public void setColor_name(String color_name) {
        this.color_name = color_name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public RecipeCondition() {
    }
}
