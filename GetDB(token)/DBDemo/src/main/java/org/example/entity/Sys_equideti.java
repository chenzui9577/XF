package org.example.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.hutool.core.annotation.Alias;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
//部件明细
public class Sys_equideti implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Excel(name = "主键",orderNum = "1")
    @Alias("序号")
    private int Id;
    @Alias("控制器编码")
    private String Engicode;//控制器编码
    @Alias("设备名称")
    private String Name;//部件名称
    @Alias("部件注释")
    private String Addr;//部件注释（设备位置）
    @Alias("用户编码")
    private String Usercode;//用户编码
    @Alias("机号")
    private String Number;//机号
    @Alias("回路")
    private String Loops;//回路
    @Alias("地址码")
    private String Eaddr;//地址码
    @Alias("盘号")
    private String tray;//盘号
    @Alias("手动键号")
    private String handkey;//手动键号

    private Sys_equitype sys_equitype;

    public Sys_equitype getSys_equitype() {
        return sys_equitype;
    }

    public void setSys_equitype(Sys_equitype sys_equitype) {
        this.sys_equitype = sys_equitype;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEngicode() {
        return Engicode;
    }
    public void setEngicode(String engicode) {
        Engicode = engicode;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
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

    public String getTray() {
        return tray;
    }

    public void setTray(String tray) {
        this.tray = tray;
    }

    public String getHandkey() {
        return handkey;
    }

    public void setHandkey(String handkey) {
        this.handkey = handkey;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddr() {
        return Addr;
    }

    public void setAddr(String addr) {
        Addr = addr;
    }

    public String getUsercode() {
        return Usercode;
    }

    public void setUsercode(String usercode) {
        Usercode = usercode;
    }

    public Sys_equideti(){

    }
    /*public Sys_equideti(int id, String engicode, String typecode_bak, String name, String addr, String usercode, int loops, String eaddr, String equicode) {
        Id = id;
        Engicode = engicode;
        Typecode_bak = typecode_bak;
        Name = name;
        Addr = addr;
        Usercode = usercode;
        Loops = loops;
        Eaddr = eaddr;
        Equicode = equicode;
    }
*/
}

