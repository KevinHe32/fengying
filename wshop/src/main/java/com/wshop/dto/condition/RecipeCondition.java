package com.wshop.dto.condition;

import io.swagger.annotations.ApiModel;

@ApiModel
public class RecipeCondition extends BaseCondition{

    private String color_number;

    private String material;

    public String getColor_number() {
        return color_number;
    }

    public void setColor_number(String color_number) {
        this.color_number = color_number;
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
