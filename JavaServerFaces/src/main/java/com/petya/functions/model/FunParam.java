package com.petya.functions.model;

import java.util.Date;

public class FunParam {

    private long id;
    private long idFun;
    private String name;
    private String descr;
    private Date cTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdFun() {
        return idFun;
    }

    public void setIdFun(long idFun) {
        this.idFun = idFun;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

	@Override
	public String toString() {
		return "FunParam [id=" + id + ", idFun=" + idFun + ", name=" + name + ", descr=" + descr + ", cTime=" + cTime
				+ "]";
	}
    
    

}