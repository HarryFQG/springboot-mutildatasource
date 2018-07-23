package com.tangcheng.datasource.notaop.model;

public class SubClassify {
    private String id;

    private String name;

    private String classifyNo;

    private String usrOrg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getClassifyNo() {
        return classifyNo;
    }

    public void setClassifyNo(String classifyNo) {
        this.classifyNo = classifyNo == null ? null : classifyNo.trim();
    }

    public String getUsrOrg() {
        return usrOrg;
    }

    public void setUsrOrg(String usrOrg) {
        this.usrOrg = usrOrg == null ? null : usrOrg.trim();
    }
}