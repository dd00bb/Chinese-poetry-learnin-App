package com.example.work001;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public Context context;
    private static final String DATABASE_NAME="poemDB.db";
    private static final String TABLE_NAME="my_poem";
    private static final String COLUMN_ID="_id";
    private static final String COLUMN_TITLE="poem_title";
    private static final String COLUMN_AUTHOR="poem_author";
    private static final String COLUMN_PAGE1="poem_page1";
    private static final String COLUMN_PAGE2="poem_page2";
    private static final String COLUMN_PAGE3="poem_page3";
    private static final String COLUMN_PAGE4="poem_page4";

    public DatabaseHelper(@Nullable Context context){
        super(context,DATABASE_NAME,null,1);//context:上下文；name:数据库文件的名称 factory:用于创建cursor对象，默认是null
        this.context=context;

    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String query="CREATE TABLE "+TABLE_NAME+
                "("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COLUMN_TITLE+" TEXT, "+
                COLUMN_AUTHOR+" TEXT, "+
                COLUMN_PAGE1+" TEXT, "+
                COLUMN_PAGE2+" TEXT, "+
                COLUMN_PAGE3+" TEXT, "+
                COLUMN_PAGE4+" TEXT);";
        db.execSQL(query);//执行
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    void addPoem(String title,String author,String page1,String page2,String page3,String page4){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        //insert方法要求把数据都打包到ContentValues中，
        // ContentValues其实就是一个Map，Key值是字段名称，Value值是字段的值。
        // 通过ContentValues的put方法就可以把数据放到ContentValues对象中，然后插入到表中去。

        cv.put(COLUMN_TITLE,title);
        cv.put(COLUMN_AUTHOR,author);
        cv.put(COLUMN_PAGE1,page1);
        cv.put(COLUMN_PAGE2,page2);
        cv.put(COLUMN_PAGE3,page3);
        cv.put(COLUMN_PAGE4,page4);
        long result=db.insert(TABLE_NAME,null,cv);
        if(result==-1){
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context,"Successfully",Toast.LENGTH_SHORT).show();
        }
    }


}
