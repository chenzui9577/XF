package org.example.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
控制器信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sys_controller  {

    private int id;
    private String Engicode;//控制器编码（项目代码）
    private String Typecode;//部件类型代码
    private String Enginame;//控制器名称（项目名称）
    private String Typename;//部件类型名称
    private String Ccode;//控制器返回码
    private String Notes;//备注

    @Override
    public String toString() {
        return "Sys_controller{" +
                "id=" + id +
                ", Engicode='" + Engicode + '\'' +
                ", Typecode='" + Typecode + '\'' +
                ", Enginame='" + Enginame + '\'' +
                ", Typename='" + Typename + '\'' +
                ", Ccode='" + Ccode + '\'' +
                ", Notes='" + Notes + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEngicode() {
        return Engicode;
    }

    public void setEngicode(String engicode) {
        Engicode = engicode;
    }

    public String getTypecode() {
        return Typecode;
    }

    public void setTypecode(String typecode) {
        Typecode = typecode;
    }

    public String getEnginame() {
        return Enginame;
    }

    public void setEnginame(String enginame) {
        Enginame = enginame;
    }

    public String getTypeame() {
        return Typename;
    }

    public void setTypeame(String typeame) {
        Typename = typeame;
    }

    public String getCcode() {
        return Ccode;
    }

    public void setCcode(String ccode) {
        Ccode = ccode;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

}
