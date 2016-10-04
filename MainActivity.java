package com.example.himanshu.studentregistrationform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
EditText editText_name, editText_email;
    RadioGroup radioGroup_department;
    SeekBar seekBar_mood;
    Button button_submit;

    int indicator;
    String department;

    String name,email;
    public static final String STUDENT_KEY="student";
    public static final String ACTIVITY_FLAG="flag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText_email=(EditText)findViewById(R.id.editText_email);
        editText_name=(EditText)findViewById(R.id.editText_name);


        seekBar_mood=(SeekBar)findViewById(R.id.seekBar_mood);
        seekBar_mood.setProgress(0);
        seekBar_mood.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                indicator=  progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        radioGroup_department=(RadioGroup)findViewById(R.id.radioGroup);
        radioGroup_department.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb=(RadioButton)findViewById(checkedId);
            }
        });


        findViewById(R.id.button_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name=editText_name.getText().toString();
                email=editText_email.getText().toString();
                indicator=seekBar_mood.getProgress();

                if(editText_name.getText().toString().equals("") || editText_email.getText().toString().equals("") || indicator==0) {
                    Toast.makeText(getApplicationContext(),"Enter all the fields before clicking on submit",Toast.LENGTH_LONG).show();
                }
                else
                {
                    if(radioGroup_department.getCheckedRadioButtonId()== R.id.radioButton_SIS)
                    {
                        department="SIS";

                    }
                    else if(radioGroup_department.getCheckedRadioButtonId()==R.id.radioButton_BIO)
                    {
                        department="BIO";

                    }
                    else if(radioGroup_department.getCheckedRadioButtonId()==R.id.radioButton_CS)
                    {
                        department="CS";
                    }
                    else
                    {
                        department="Others";
                    }

                    Student student=new Student(name.toString(), email.toString(), department.toString(), (int)indicator);

                    Toast.makeText(getApplicationContext(),student.toString(),Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(MainActivity.this,DisplayActivity.class);
                    intent.putExtra(STUDENT_KEY, student);
                    intent.putExtra(ACTIVITY_FLAG, 0);
                    startActivity(intent);
                }



            }
        });


    }
}
