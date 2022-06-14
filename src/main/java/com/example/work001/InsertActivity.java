package com.example.work001;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InsertActivity extends AppCompatActivity {
    EditText title_input,author_input,line1_input,line2_input,line3_input,line4_input;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert);
    }

    @Override
    protected void onStart() {
        super.onStart();


        title_input=findViewById(R.id.title);
        author_input=findViewById(R.id.author);
        line1_input=findViewById(R.id.line1);
        line2_input=findViewById(R.id.line2);
        line3_input=findViewById(R.id.line3);
        line4_input=findViewById(R.id.line4);

        button=findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper poemDB=new DatabaseHelper(InsertActivity.this);
                poemDB.addPoem(title_input.getText().toString().trim(),
                        author_input.getText().toString().trim(),
                        line1_input.getText().toString().trim(),
                        line2_input.getText().toString().trim(),
                        line3_input.getText().toString().trim(),
                        line4_input.getText().toString().trim());
            }
        });

    }
}
