package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * * 项目信息
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sys_program {
    private int Id;
    private String Unitname;//工程名称
    private String Engicode;//控制器编码（项目代码）
    private String Enginame;//控制器名称（项目名称）
    private String Protypename;//项目类型名称
    private String Address;//项目地址
    private String Client;//隶属机构

    @Override
    public String toString() {
        return "Sys_program{" +
                "Id=" + Id +
                ", Engicode='" + Engicode + '\'' +
                ", Enginame='" + Enginame + '\'' +
                ", Unitname='" + Unitname + '\'' +
                ", Address='" + Address + '\'' +
                ", Protypename='" + Protypename + '\'' +
                ", Client='" + Client + '\'' +
                '}';
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUnitname() {
        return Unitname;
    }

    public void setUnitname(String unitname) {
        Unitname = unitname;
    }

    public String getEngicode() {
        return Engicode;
    }

    public void setEngicode(String engicode) {
        Engicode = engicode;
    }

    public String getEnginame() {
        return Enginame;
    }

    public void setEnginame(String enginame) {
        Enginame = enginame;
    }

    public String getProtypename() {
        return Protypename;
    }

    public void setProtypename(String protypename) {
        Protypename = protypename;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getClient() {
        return Client;
    }

    public void setClient(String client) {
        Client = client;
    }
}
