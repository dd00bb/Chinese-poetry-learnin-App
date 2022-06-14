package com.example.work001;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ReviewActivity extends AppCompatActivity {


    public ImageView reMeansPic;

    public TextView textView1;
    public TextView textView2;
    public TextView textView3;
    public TextView textView4;
    public TextView textView5;
    public TextView textView6;

    public DatabaseHelper dbHelper;
    public SQLiteDatabase database1;
    public SQLiteDatabase database2;
    public SQLiteDatabase database3;
    public SQLiteDatabase database4;
    public SQLiteDatabase database5;
    public SQLiteDatabase database6;
    public SQLiteDatabase database7;
    public SQLiteDatabase database8;
    public SQLiteDatabase database9;
    public SQLiteDatabase database10;
    public SQLiteDatabase database11;
    public SQLiteDatabase database12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review);

        textView1 = findViewById(R.id.reTitle);
        textView2 = findViewById(R.id.reAuthor);
        textView3 = findViewById(R.id.reLine1);
        textView4 = findViewById(R.id.reLine2);
        textView5 = findViewById(R.id.reLine3);
        textView6 = findViewById(R.id.reLine4);

        reMeansPic = findViewById(R.id.reMeas);

        dbHelper = new DatabaseHelper(this);//创建一个数据库帮助类对象
        database1 = dbHelper.getReadableDatabase();//调用帮助类对象的getReadableDatabase方法用来创建数据库
        Cursor c = database1.query("my_poem", null, "_id=1",
                null, null, null, null);
        c.moveToFirst();
        String reTitle=c.getString(1);
        textView1.setText(reTitle);
        String reAuthor=c.getString(2);
        textView2.setText(reAuthor);

        c.close();
        database1.close();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //ImageView对应的id

        reMeansPic=findViewById(R.id.reMeas);




        Button button1=findViewById(R.id.remember);
        Button button2=findViewById(R.id.vague);
        Button button3=findViewById(R.id.forget);

        final int[] a = {0};
        final int[] b = {0};

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (a[0] == 0||b[0]==1) {
                    database2 = dbHelper.getReadableDatabase();//调用帮助类对象的getReadableDatabase方法用来创建数据库
                    Cursor c2 = database2.query("my_poem", null, "_id=2",
                            null, null, null, null);
                    c2.moveToFirst();
                    String reTitle2=c2.getString(1);
                    textView1.setText(reTitle2);
                    String reAuthor2=c2.getString(2);
                    textView2.setText(reAuthor2);

                    textView3.setText(null);
                    textView4.setText(null);
                    textView5.setText(null);
                    textView6.setText(null);

                    reMeansPic.setImageDrawable(null);

                    c2.close();
                    database2.close();

                    a[0]++;

                }else
                if (a[0] == 1||b[0]==2) {
                    database3 = dbHelper.getReadableDatabase();//调用帮助类对象的getReadableDatabase方法用来创建数据库
                    Cursor c3 = database3.query("my_poem", null, "_id=3",
                            null, null, null, null);
                    c3.moveToFirst();
                    String reTitle3=c3.getString(1);
                    textView1.setText(reTitle3);
                    String reAuthor3=c3.getString(2);
                    textView2.setText(reAuthor3);

                    textView3.setText(null);
                    textView4.setText(null);
                    textView5.setText(null);
                    textView6.setText(null);

                    reMeansPic.setImageDrawable(null);

                    c3.close();
                    database3.close();

                    a[0]++;

                }else
                if (a[0] == 2||b[0]==3) {
                    database4 = dbHelper.getReadableDatabase();//调用帮助类对象的getReadableDatabase方法用来创建数据库
                    Cursor c4 = database4.query("my_poem", null, "_id=4",
                            null, null, null, null);
                    c4.moveToFirst();
                    String reTitle4=c4.getString(1);
                    textView1.setText(reTitle4);
                    String reAuthor4=c4.getString(2);
                    textView2.setText(reAuthor4);

                    textView3.setText(null);
                    textView4.setText(null);
                    textView5.setText(null);
                    textView6.setText(null);

                    reMeansPic.setImageDrawable(null);

                    c4.close();
                    database4.close();

                    a[0]++;

                }else {
                    Toast.makeText(ReviewActivity.this, "你已经复习完所有内容了", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (a[0] == 0) {
                    database5 = dbHelper.getReadableDatabase();//调用帮助类对象的getReadableDatabase方法用来创建数据库
                    Cursor c5 = database5.query("my_poem", null, "_id=1",
                            null, null, null, null);
                    c5.moveToFirst();

                    String reLine11=c5.getString(3);
                    textView3.setText(reLine11);
                    String reLine21=c5.getString(4);
                    textView4.setText(reLine21);
                    String reLine31=c5.getString(5);
                    textView5.setText(reLine31);
                    String reLine41=c5.getString(6);
                    textView6.setText(reLine41);
                    c5.close();
                    database5.close();

                    b[0]=1;

                }else
                if (a[0] == 1) {
                    database6 = dbHelper.getReadableDatabase();//调用帮助类对象的getReadableDatabase方法用来创建数据库
                    Cursor c6 = database6.query("my_poem", null, "_id=2",
                            null, null, null, null);
                    c6.moveToFirst();

                    String reLine12 = c6.getString(3);
                    textView3.setText(reLine12);
                    String reLine22 = c6.getString(4);
                    textView4.setText(reLine22);
                    String reLine32= c6.getString(5);
                    textView5.setText(reLine32);
                    String reLine42 = c6.getString(6);
                    textView6.setText(reLine42);
                    c6.close();
                    database6.close();

                    b[0]=2;
                }

                else
                if (a[0] == 2) {
                    database7 = dbHelper.getReadableDatabase();//调用帮助类对象的getReadableDatabase方法用来创建数据库
                    Cursor c7 = database7.query("my_poem", null, "_id=3",
                            null, null, null, null);
                    c7.moveToFirst();

                    String reLine13=c7.getString(3);
                    textView3.setText(reLine13);
                    String reLine23=c7.getString(4);
                    textView4.setText(reLine23);
                    String reLine33=c7.getString(5);
                    textView5.setText(reLine33);
                    String reLine43=c7.getString(6);
                    textView6.setText(reLine43);
                    c7.close();
                    database7.close();

                    b[0]=3;

                }else
                if (a[0] == 3) {
                    database8 = dbHelper.getReadableDatabase();//调用帮助类对象的getReadableDatabase方法用来创建数据库
                    Cursor c8 = database8.query("my_poem", null, "_id=4",
                            null, null, null, null);
                    c8.moveToFirst();

                    String reLine14=c8.getString(3);
                    textView3.setText(reLine14);
                    String reLine24=c8.getString(4);
                    textView4.setText(reLine24);
                    String reLine34=c8.getString(5);
                    textView5.setText(reLine34);
                    String reLine44=c8.getString(6);
                    textView6.setText(reLine44);
                    c8.close();
                    database8.close();


                    b[0]=4;

                }else {
                    Toast.makeText(ReviewActivity.this, "你已经复习完所有内容了", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a[0]==0||b[0]==1){
                    database9 = dbHelper.getReadableDatabase();//调用帮助类对象的getReadableDatabase方法用来创建数据库
                    Cursor c9 = database9.query("my_poem", null, "_id=1",
                            null, null, null, null);
                    c9.moveToFirst();

                    String reLine11=c9.getString(3);
                    textView3.setText(reLine11);
                    String reLine21=c9.getString(4);
                    textView4.setText(reLine21);
                    String reLine31=c9.getString(5);
                    textView5.setText(reLine31);
                    String reLine41=c9.getString(6);
                    textView6.setText(reLine41);
                    c9.close();
                    database9.close();
                    reMeansPic.setImageResource(R.drawable.means);
                }else
                if(a[0]==1||b[0]==2){
                    database10 = dbHelper.getReadableDatabase();//调用帮助类对象的getReadableDatabase方法用来创建数据库
                    Cursor c10 = database10.query("my_poem", null, "_id=2",
                            null, null, null, null);
                    c10.moveToFirst();

                    String reLine11=c10.getString(3);
                    textView3.setText(reLine11);
                    String reLine21=c10.getString(4);
                    textView4.setText(reLine21);
                    String reLine31=c10.getString(5);
                    textView5.setText(reLine31);
                    String reLine41=c10.getString(6);
                    textView6.setText(reLine41);
                    c10.close();
                    database10.close();
                    reMeansPic.setImageResource(R.drawable.means1);
                }else
                if(a[0]==2||b[0]==3){
                    database11 = dbHelper.getReadableDatabase();//调用帮助类对象的getReadableDatabase方法用来创建数据库
                    Cursor c11 = database11.query("my_poem", null, "_id=3",
                            null, null, null, null);
                    c11.moveToFirst();

                    String reLine11=c11.getString(3);
                    textView3.setText(reLine11);
                    String reLine21=c11.getString(4);
                    textView4.setText(reLine21);
                    String reLine31=c11.getString(5);
                    textView5.setText(reLine31);
                    String reLine41=c11.getString(6);
                    textView6.setText(reLine41);
                    c11.close();
                    database11.close();
                        reMeansPic.setImageResource(R.drawable.means2);
                }else
                if(a[0]==3||b[0]==4){
                    database12 = dbHelper.getReadableDatabase();//调用帮助类对象的getReadableDatabase方法用来创建数据库
                    Cursor c12 = database12.query("my_poem", null, "_id=4",
                            null, null, null, null);
                    c12.moveToFirst();

                    String reLine11=c12.getString(3);
                    textView3.setText(reLine11);
                    String reLine21=c12.getString(4);
                    textView4.setText(reLine21);
                    String reLine31=c12.getString(5);
                    textView5.setText(reLine31);
                    String reLine41=c12.getString(6);
                    textView6.setText(reLine41);
                    c12.close();
                    database12.close();
                        reMeansPic.setImageResource(R.drawable.means3);
                }else{
                    Toast.makeText(ReviewActivity.this, "你已经复习完所有内容了", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
