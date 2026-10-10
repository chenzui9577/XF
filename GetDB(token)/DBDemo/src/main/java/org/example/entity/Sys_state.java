package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//部件状态标准
public class Sys_state {
    private int id;
    private String States;//状态码
    private String Statename;//状态描述
    private String Notes;//备注

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStates() {
        return States;
    }

    public void setStates(String states) {
        States = states;
    }

    public String getStatename() {
        return Statename;
    }

    public void setStatename(String statename) {
        Statename = statename;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }
}
