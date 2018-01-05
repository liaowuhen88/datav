package com.example.demo.bean;

import java.io.Serializable;

/**
 * Created by houqijun on 2017/3/17.
 */
public class DataViewResp implements Serializable{
    private static final long serialVersionUID = 664064573704453955L;

    private String name;

    private String value;

    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
