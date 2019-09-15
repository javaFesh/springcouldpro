package com.xjx.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MenuVO implements Serializable {
    private int code;
    private String msg;
    private int count;
    private List<Menu> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Menu> getData() {
        return data;
    }

    public void setData(List<Menu> data) {
        this.data = data;
    }
}
