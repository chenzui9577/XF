package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@lombok.Setter
@lombok.Getter
//部件状态管理
public class Sys_equistate {
    private int Id;
    private String Typecode;//部件类型(系统类型)
    private String code;//操作类型编码
    private String Retcode;//设备返回操作类型
    private String States;//状态码
    private String Retstate;//设备返回状态码
    private String Statename;//状态描述

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRetcode() {
        return Retcode;
    }

    public void setRetcode(String retcode) {
        Retcode = retcode;
    }

    public String getStates() {
        return States;
    }

    public void setStates(String states) {
        States = states;
    }

    public String getRetstate() {
        return Retstate;
    }

    public void setRetstate(String retstate) {
        Retstate = retstate;
    }

    public String getStatename() {
        return Statename;
    }

    public void setStatename(String statename) {
        Statename = statename;
    }
}
