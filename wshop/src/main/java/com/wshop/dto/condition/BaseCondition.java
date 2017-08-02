package com.wshop.dto.condition;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class BaseCondition {

    /**
     * 当前分页数
     */
    @ApiModelProperty(value = "当前分页数")
    private Integer pageNum = 1;

    /**
     * 每页显示的记录数
     */
    @ApiModelProperty(value = "每页显示的记录数")
    private Integer pageSize = 10;

    @ApiModelProperty(hidden = true)
    private Integer userID;

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }
}
