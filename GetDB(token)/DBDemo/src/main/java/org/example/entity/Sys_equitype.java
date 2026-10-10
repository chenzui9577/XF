package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//部件类型
public class Sys_equitype {
    private int Id;
    private String Code;//部件代码
    private String Name_eqt;//部件名称
    private String Systype;//系统类型
    private String Bus;//总线类型
    private String Notes;//备注

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName_eqt() {
        return Name_eqt;
    }

    public void setName_eqt(String name_eqt) {
        Name_eqt = name_eqt;
    }

    public String getSystype() {
        return Systype;
    }

    public void setSystype(String systype) {
        Systype = systype;
    }

    public String getBus() {
        return Bus;
    }

    public void setBus(String bus) {
        this.Bus = bus;
    }
}

