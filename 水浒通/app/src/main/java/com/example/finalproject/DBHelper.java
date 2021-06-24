package com.example.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=3;
    private static final String DATABASE_NAME="MySQLite.db";
    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建数据表
        String CREATE_TABLE_Figures="CREATE TABLE "+Figure.TABLE+"("
                +Figure.KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +Figure.KEY_Name+" TEXT,"
                +Figure.KEY_Star+" TEXT,"
                +Figure.KEY_Origin+" TEXT,"
                +Figure.KEY_Pic+" INTEGER,"
                +Figure.KEY_Nickname+" TEXT,"
                +Figure.KEY_PicPath+" TEXT,"
                +Figure.KEY_Life+" TEXT)"
                ;
        db.execSQL(CREATE_TABLE_Figures);
        /* 始时往数据库中插入10个人物 */
        final String[] Name = {"武松", "李逵", "时迁", "林冲", "花荣", "吴用", "燕青", "鲁智深", "宋江", "卢俊义"};
        final String[] Star = {"天伤星","天杀星","地贼星","天雄星","天英星","天机星","天巧星","天孤星","天魁星","天罡星"};
        final String[] Life = {"1088-1095","?-1124","? - ?","1089 - 1143","? - ?","1296 - 1371","1098 - ?","? - ?","1073 - 1124","1084 - 1156"};
        final String[] Origin = {"清河县(河北邢台)","沂水县(山东临沂)","高唐县(山东聊城)","东京(河南开封)","山东青州清风镇","湖南武岗","北京大名府","渭州(甘肃陇西)","山东郓城县宋家村","北京大名府"};
        final String[] Nickname = {"行者", "黑旋风", "鼓上蚤", "豹子头", "小李广", "智多星", "浪子", "花和尚", "及时雨", "玉麒麟"};
        final int[] Pic = {R.mipmap.wusong, R.mipmap.likui, R.mipmap.shiqian, R.mipmap.linchong, R.mipmap.huarong, R.mipmap.wuyong, R.mipmap.yanqing, R.mipmap.luzhishen, R.mipmap.songjiang, R.mipmap.lujunyi};

        for(int i = 0; i < 10; i++)
        {
            Figure figure= new Figure(i,Name[i], Life[i], Star[i], Nickname[i], Origin[i], Pic[i],null);
            ContentValues values=new ContentValues();
            values.put(Figure.KEY_ID,figure.getID());
            values.put(Figure.KEY_Name,figure.getName());
            values.put(Figure.KEY_Star,figure.getStar());
            values.put(Figure.KEY_Life,figure.getLife());
            values.put(Figure.KEY_Origin,figure.getOrigin());
            values.put(Figure.KEY_Nickname,figure.getNickname());
            values.put(Figure.KEY_Pic,figure.getPic());
            long ID=db.insert(Figure.TABLE,null,values);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //如果旧表存在，删除，所以数据将会消失
        db.execSQL("DROP TABLE IF EXISTS "+Figure.TABLE );
        //再次创建表
        onCreate(db);
    }
}
