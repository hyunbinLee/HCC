package com.crossit.hcc.vo;

import java.io.Serializable;

public class School implements Serializable {
 
    private String region;
    private String name;
 
    public School() {
    }
 
    public School(String name, String region) {
        super();
        this.name = name;
        this.region = region;
    }
 
 
    public String getRegion() {
        return region;
    }
 
    public void setRegion(String region) {
        this.region = region;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
       
 
}
