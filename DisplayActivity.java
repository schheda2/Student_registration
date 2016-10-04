package com.example.himanshu.studentregistrationform;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import android.widget.ImageButton;

import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textView_name, textView_email, textView_department, textView_mood;
    Student student, student1;
    int mood;
    String department,email,name,temp;
    public static final String NAME_KEY="name";
    public static final String EMAIL_KEY="email";
    public static final String BUTTON_KEY="imageButton";
    public static final String DEPARTMENT_KEY="department";
    public static final String MOOD_KEY="mood";

    public static final int REQ_CODE=100;
    public static final String VALUE_ID="value";
    ImageButton imageButton;
    Intent intent;
    int flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        textView_name=(TextView)findViewById(R.id.textView_NameEntry);
        textView_email=(TextView)findViewById(R.id.textView_EmailEntry);
        textView_department=(TextView)findViewById(R.id.textView_DepartmentEntry);
        textView_mood=(TextView)findViewById(R.id.textView_MoodEntry);

        if(getIntent().getExtras()!=null){
//if(MainActivity.ACTIVITY_FLAG.equals(0)) {
    student = (Student) getIntent().getExtras().getSerializable(MainActivity.STUDENT_KEY);
    mood = student.mood;
    email = student.email_address;
    name = student.name;
    department = student.department;

//}
          /* else if(MainActivity.ACTIVITY_FLAG.equals(1)) {
    student1 = (Student) getIntent().getExtras().getSerializable(EditActivity.FINAL_NAME_KEY);
    name=student1.name;

}*/
            Toast.makeText(this,student.toString(), Toast.LENGTH_LONG).show();

            textView_name.setText(name);
            textView_email.setText(email);
            textView_department.setText(department);
            textView_mood.setText(mood + "% Positive");

            imageButton=(ImageButton)findViewById(R.id.imageButton_editName);
            imageButton.setOnClickListener(this);

            imageButton=(ImageButton)findViewById(R.id.imageButton_editEmail);
            imageButton.setOnClickListener(this);

            imageButton=(ImageButton)findViewById(R.id.imageButton_editDepartment);
            imageButton.setOnClickListener(this);

            imageButton=(ImageButton)findViewById(R.id.imageButton_editMood);
            imageButton.setOnClickListener(this);



        }
        else
        {

        }
        //finish();
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();

        Intent intent=new Intent(DisplayActivity.this,EditActivity.class);
        intent.putExtra(MainActivity.STUDENT_KEY,student);



        if(id==R.id.imageButton_editName)
        {

            /*Toast.makeText(getApplicationContext(),"Image button pressed",Toast.LENGTH_LONG).show();
            intent=new Intent(DisplayActivity.this,EditActivity.class);
            intent.putExtra(NAME_KEY,name);*/
            intent.putExtra(BUTTON_KEY,"1");
        }
        else if(id==R.id.imageButton_editEmail)
        {

            /*Toast.makeText(getApplicationContext(),"Image button pressed",Toast.LENGTH_LONG).show();
            intent=new Intent(DisplayActivity.this,EditActivity.class);
            intent.putExtra(EMAIL_KEY,email);*/
            intent.putExtra(BUTTON_KEY,"2");



        }
        else if(id==R.id.imageButton_editDepartment)
        {
            /*Toast.makeText(getApplicationContext(),"Image button pressed",Toast.LENGTH_LONG).show();
            intent=new Intent(DisplayActivity.this,EditActivity.class);
            intent.putExtra(DEPARTMENT_KEY,temp);*/
            intent.putExtra(BUTTON_KEY,"3");


        }
        else if(id==R.id.imageButton_editMood)
        {
            /*Toast.makeText(getApplicationContext(),"Image button pressed",Toast.LENGTH_LONG).show();
            intent=new Intent(DisplayActivity.this,EditActivity.class);
            intent.putExtra(MOOD_KEY,mood);*/
            intent.putExtra(BUTTON_KEY,"4");


        }
        startActivity(intent);



    }
}
