package com.wshop.rest;

/**
 * Created by dell on 2017/4/1.
 */

public class CompanyResult{
    private Integer companyCenterId;
    private String companyCenterName;

    private Integer branchCompanyId;
    private String branchCompanyName;

    private Integer departmentId;
    private String departmentName;

    public Integer getCompanyCenterId() {
        return companyCenterId;
    }

    public void setCompanyCenterId(Integer companyCenterId) {
        this.companyCenterId = companyCenterId;
    }

    public String getCompanyCenterName() {
        return companyCenterName;
    }

    public void setCompanyCenterName(String companyCenterName) {
        this.companyCenterName = companyCenterName;
    }

    public Integer getBranchCompanyId() {
        return branchCompanyId;
    }

    public void setBranchCompanyId(Integer branchCompanyId) {
        this.branchCompanyId = branchCompanyId;
    }

    public String getBranchCompanyName() {
        return branchCompanyName;
    }

    public void setBranchCompanyName(String branchCompanyName) {
        this.branchCompanyName = branchCompanyName;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}