package com.dse.tgang.dam.domain;

import java.io.Serializable;

/**
 * Created by gaoq on 2017-3-9.
 */
public class BasicFeature implements Serializable{

    public BasicFeature(){

    }
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
