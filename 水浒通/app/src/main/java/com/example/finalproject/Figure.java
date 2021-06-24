package com.example.finalproject;

import java.io.Serializable;

/**

 * 三国人物信息
 */

public class Figure implements Serializable {
    public static final String TABLE="Figures";
    public static final String KEY_ID="ID";
    public static final String KEY_Name="Name";
    public static final String KEY_Life="Life";
    public static final String KEY_Star="Star";
    public static final String KEY_Nickname="Nickname";
    public static final String KEY_Origin="Origin";
    public static final String KEY_Pic="Pic";
    public static final String KEY_PicPath="PicPath";
    private int ID;
    //姓名
    private String Name;
    //生卒年月
    private String Life;
    //天罡地煞
    private String Star;
    //绰号
    private String Nickname;
    //籍贯
    private String Origin;


    private int Pic = R.mipmap.nopic;

    private String PicPath;

    public Figure(int ID, String Name, String Life, String Star, String Nickname, String Origin, int Pic, String PicPath)
    {
        this.ID=ID;
        this.Name = Name;
        this.Life = Life;
        this.Star = Star;
        this.Nickname = Nickname;
        this.Origin = Origin;
        this.Pic=Pic;
        this.PicPath=PicPath;
    }
    public Figure()
    {    }

    public int getID() {
        return ID;
    }

    public String getName()
    {
        return Name;
    }

    public String getLife()
    {
        return Life;
    }

    public String getStar()
    {
        return Star;
    }

    public String getNickname()
    {
        return Nickname;
    }

    public String getOrigin()
    {
        return Origin;
    }

    public int getPic() {
        return Pic;
    }
    public String getPicPath(){
        return PicPath;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setLife(String life) {
        Life = life;
    }

    public void setStar(String star) {
        Star = star;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    public void setOrigin(String origin) {
        Origin = origin;
    }

    public void setPic(int pic) {
        Pic = pic;
    }

    public void setPicPath(String picPath)
    {
        PicPath=picPath;
    }
}
