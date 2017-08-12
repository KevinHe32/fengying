package com.wshop.dto.condition;

import io.swagger.annotations.ApiModel;

import java.text.SimpleDateFormat;
import java.util.Date;

@ApiModel
public class RecipeCondition extends BaseCondition{

    private String color_number;

    private String material;

    private String birthtimeStart;

    private String birthtimeEnd;

    private String birthtimeStart3;

    private String birthtimeEnd3;

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
    public Date getBirthtimeStart() {
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(this.birthtimeStart);
            date.setHours(0);
            date.setMinutes(0);
            date.setSeconds(0);
            return  date;
        }catch (Exception e){

        }
        return null;
    }

    public String getBirthTimeStart2(){
        return birthtimeStart;
    }
    public void setBirthtimeStart(String birthtimeStart) {
        this.birthtimeStart = birthtimeStart;
    }

    public Date getBirthtimeEnd() {
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(this.birthtimeEnd);
            date.setHours(0);
            date.setMinutes(0);
            date.setSeconds(0);
            return  date;
        }catch (Exception e){

        }
        return null;
    }

    public String getBirthtimeEnd2(){
        return birthtimeEnd;
    }

    public void setBirthtimeEnd(String birthtimeEnd) {
        this.birthtimeEnd = birthtimeEnd;
    }

    public String getBirthtimeStart3() {
        return birthtimeStart3;
    }

    public void setBirthtimeStart3(String birthtimeStart3) {
        this.birthtimeStart3 = birthtimeStart3;
    }

    public String getBirthtimeEnd3() {
        return birthtimeEnd3;
    }

    public void setBirthtimeEnd3(String birthtimeEnd3) {
        this.birthtimeEnd3 = birthtimeEnd3;
    }
}
