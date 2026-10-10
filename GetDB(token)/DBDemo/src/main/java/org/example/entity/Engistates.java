package org.example.entity;

import cn.hutool.core.annotation.Alias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Engistates {
    @Alias("ID")
    private Integer Id;
    @Alias("工程名称")
    private String Unitname;//工程名称
    @Alias("控制器编码（项目代码）")
    private String Engicode;//控制器编码（项目代码）
    @Alias("控制器名称（项目名称）")
    private String Enginame;//控制器名称（项目名称）
    @Alias("部件名称")
    private String Equiname;//部件名称
    @Alias("部件注释")
    private String Addr;//部件注释
    @Alias("状态描述")
    private String Statename;//状态描述
    @Alias("用户编码")
    private String Usercode;//用户编码
    @Alias("机号")
    private String Number;//用户编码
    @Alias("回路")
    private String Loops;//回路
    @Alias("地址码")
    private String Eaddr;//地址码
    @Alias("时间")
    private String Dt;//时间

    @Override
    public String toString() {
        return "Engistates{" +
                "Id=" + Id +
                ", Unitname='" + Unitname + '\'' +
                ", Engicode='" + Engicode + '\'' +
                ", Enginame='" + Enginame + '\'' +
                ", Equiname='" + Equiname + '\'' +
                ", Addr='" + Addr + '\'' +
                ", Statename='" + Statename + '\'' +
                ", Usercode='" + Usercode + '\'' +
                ", Number='" + Number + '\'' +
                ", Loops='" + Loops + '\'' +
                ", Eaddr='" + Eaddr + '\'' +
                ", Dt='" + Dt + '\'' +
                '}';
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
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

    public String getEquiname() {
        return Equiname;
    }

    public void setEquiname(String equiname) {
        Equiname = equiname;
    }

    public String getAddr() {
        return Addr;
    }

    public void setAddr(String addr) {
        Addr = addr;
    }

    public String getStatename() {
        return Statename;
    }

    public void setStatename(String statename) {
        Statename = statename;
    }

    public String getUsercode() {
        return Usercode;
    }

    public void setUsercode(String usercode) {
        Usercode = usercode;
    }

    public String getLoops() {
        return Loops;
    }

    public void setLoops(String loops) {
        Loops = loops;
    }

    public String getEaddr() {
        return Eaddr;
    }

    public void setEaddr(String eaddr) {
        Eaddr = eaddr;
    }

    public String getDt() {
        return Dt;
    }

    public void setDt(String dt) {
        Dt = dt;
    }
}
