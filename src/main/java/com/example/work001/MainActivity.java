package com.example.work001;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public ImageView mImageView;
    public TextView textView1;
    public TextView textView2;
    public TextView textView3;
    public TextView textView4;
    public TextView textView5;
    public TextView textView6;
    public DatabaseHelper dbHelper;
    public SQLiteDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.title);
        textView2 = findViewById(R.id.author);
        textView3 = findViewById(R.id.line1);
        textView4 = findViewById(R.id.line2);
        textView5 = findViewById(R.id.line3);
        textView6 = findViewById(R.id.line4);

        Random random = new Random();
        int index = random.nextInt(4);

        dbHelper = new DatabaseHelper(this);//创建一个数据库帮助类对象
        database = dbHelper.getReadableDatabase();//调用帮助类对象的getReadableDatabase方法用来创建数据库
        Cursor c = database.query("my_poem", null, "_id="+index,
                null, null, null, null);
        c.moveToFirst();
        String title=c.getString(1);
        textView1.setText(title);
        String author=c.getString(2);
        textView2.setText(author);
        String line1=c.getString(3);
        textView3.setText(line1);
        String line2=c.getString(4);
        textView4.setText(line2);
        String line3=c.getString(5);
        textView5.setText(line3);
        String line4=c.getString(6);
        textView6.setText(line4);
        c.close();
        database.close();

    }



    @Override
    protected void onStart() {
        super.onStart();
        //ImageView对应的id
        mImageView = findViewById(R.id.iv_bg);


        //把图片资源文件变成数组，注意R文件中数据对应的都是int类型
        int[] mArray = {
                R.drawable.backimg,
                R.drawable.backimg1,
                R.drawable.backimg2,
                R.drawable.backimg3};

        //生成随机数，设置为5，是[0,4)，包含0而不包含4。0,1,2,3 四个数
        Random random = new Random();
        int index = random.nextInt(4);


        //随机图片对应R文件的int值：mArray[index]，实例Drawable类
        Drawable drawable = getApplicationContext().getResources().getDrawable(mArray[index]);

        //设置图片
        mImageView.setImageDrawable(drawable);


        Button button1 = findViewById(R.id.study);
        //对STUDY按钮进行监听
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, StudyActivity.class);
                startActivity(intent);
            }
        });


        Button button2 = findViewById(R.id.review);
        //对按钮进行监听
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ReviewActivity.class);
                startActivity(intent);
            }
        });

        Button button3 = findViewById(R.id.button);
        button3.setVisibility(View.INVISIBLE);
        //对按钮进行监听
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, InsertActivity.class);
                startActivity(intent);
            }
        });

        Button button4 =findViewById(R.id.sign);
        button4.setOnClickListener(new View.OnClickListener() {//对按钮进行监听
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "签到成功", Toast.LENGTH_SHORT).show();
                button4.setVisibility(View.INVISIBLE);//点击后按钮隐藏
            }
        });
    }
}