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

public class StudyActivity extends AppCompatActivity {


    public ImageView meansPic;
    public TextView textView1;
    public TextView textView2;
    public TextView textView3;
    public TextView textView4;
    public TextView textView5;
    public TextView textView6;


    public DatabaseHelper dbHelper;
;
    public SQLiteDatabase database1;
    public SQLiteDatabase database2;
    public SQLiteDatabase database3;
    public SQLiteDatabase database4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study);


    }

    @Override
    protected void onStart() {
        super.onStart();
        meansPic=findViewById(R.id.means);
        meansPic.setImageResource(R.drawable.means);

        textView1 = findViewById(R.id.sTitle);
        textView2 = findViewById(R.id.sAuthor);
        textView3 = findViewById(R.id.sLine1);
        textView4 = findViewById(R.id.sLine2);
        textView5 = findViewById(R.id.sLine3);
        textView6 = findViewById(R.id.sLine4);

        dbHelper = new DatabaseHelper(this);//创建一个数据库帮助类对象
        database1 = dbHelper.getReadableDatabase();//调用帮助类对象的getReadableDatabase方法用来创建数据库
        Cursor c1 = database1.query("my_poem", null, "_id=1",
                null, null, null, null);
        c1.moveToFirst();

        String sTitle=c1.getString(1);
        textView1.setText(sTitle);
        String sAuthor=c1.getString(2);
        textView2.setText(sAuthor);
        String sLine1=c1.getString(3);
        textView3.setText(sLine1);
        String sLine2=c1.getString(4);
        textView4.setText(sLine2);
        String sLine3=c1.getString(5);
        textView5.setText(sLine3);
        String sLine4=c1.getString(6);
        textView6.setText(sLine4);
        c1.close();
        database1.close();


        Button button=findViewById(R.id.next);

        final int[] a = {0};

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (a[0] == 0) {

                    database2 = dbHelper.getReadableDatabase();//调用帮助类对象的getReadableDatabase方法用来创建数据库
                    Cursor c2 = database2.query("my_poem", null, "_id=2",
                            null, null, null, null);
                    c2.moveToFirst();
                    String sTitle2=c2.getString(1);
                    textView1.setText(sTitle2);
                    String sAuthor2=c2.getString(2);
                    textView2.setText(sAuthor2);
                    String sLine12=c2.getString(3);
                    textView3.setText(sLine12);
                    String sLine22=c2.getString(4);
                    textView4.setText(sLine22);
                    String sLine32=c2.getString(5);
                    textView5.setText(sLine32);
                    String sLine42=c2.getString(6);
                    textView6.setText(sLine42);
                    c2.close();
                    database2.close();
                    meansPic.setImageResource(R.drawable.means1);
                    a[0]++;

                }else
                if (a[0] == 1) {

                    database3 = dbHelper.getReadableDatabase();//调用帮助类对象的getReadableDatabase方法用来创建数据库
                    Cursor c3 = database3.query("my_poem", null, "_id=3",
                            null, null, null, null);
                    c3.moveToFirst();
                    String sTitle3=c3.getString(1);
                    textView1.setText(sTitle3);
                    String sAuthor3=c3.getString(2);
                    textView2.setText(sAuthor3);
                    String sLine13=c3.getString(3);
                    textView3.setText(sLine13);
                    String sLine23=c3.getString(4);
                    textView4.setText(sLine23);
                    String sLine33=c3.getString(5);
                    textView5.setText(sLine33);
                    String sLine43=c3.getString(6);
                    textView6.setText(sLine43);
                    c3.close();
                    database3.close();
                    meansPic.setImageResource(R.drawable.means2);
                    a[0]++;

                }else
                if (a[0] == 2) {

                    database4 = dbHelper.getReadableDatabase();//调用帮助类对象的getReadableDatabase方法用来创建数据库
                    Cursor c4 = database4.query("my_poem", null, "_id=4",
                            null, null, null, null);
                    c4.moveToFirst();
                    String sTitle4=c4.getString(1);
                    textView1.setText(sTitle4);
                    String sAuthor4=c4.getString(2);
                    textView2.setText(sAuthor4);
                    String sLine14=c4.getString(3);
                    textView3.setText(sLine14);
                    String sLine24=c4.getString(4);
                    textView4.setText(sLine24);
                    String sLine34=c4.getString(5);
                    textView5.setText(sLine34);
                    String sLine44=c4.getString(6);
                    textView6.setText(sLine44);
                    c4.close();
                    database4.close();
                    meansPic.setImageResource(R.drawable.means3);
                    a[0]++;

                }else{
                    Toast.makeText(StudyActivity.this, "你已经学完所有内容了", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
