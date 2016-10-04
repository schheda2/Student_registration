package com.example.himanshu.studentregistrationform;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
public class EditActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText_email, editText_name;
    TextView textView_dept, textView_mood;
    String name, email_address, department;
RadioButton SIS, CS, BIO, Others;
    int indicator;
    public static final int REQ_CODE=100;
    Button save_button;
    int Button_Id;
    public static final String FINAL_NAME_KEY="name";
    Student student;
    RadioGroup rg;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        SIS=(RadioButton)findViewById(R.id.radioButton_SIS);
        CS=(RadioButton)findViewById(R.id.radioButton_CS);
        BIO=(RadioButton)findViewById(R.id.radioButton_BIO);
        Others=(RadioButton)findViewById(R.id.radioButton_Others);
        /*Log.d("demo","jaa na");
        String id=getIntent().getExtras().getString(DisplayActivity.BUTTON_KEY);
        Log.d("demo",id);*/
        student = (Student) getIntent().getExtras().getSerializable(MainActivity.STUDENT_KEY);

        editText_email = (EditText) findViewById(R.id.editText_email);
        editText_name = (EditText) findViewById(R.id.editText_name);
        rg=(RadioGroup)findViewById(R.id.radioGroup);
        textView_dept=(TextView)findViewById(R.id.textView_department);
        textView_mood=(TextView)findViewById(R.id.textView_mood);
        seekBar=(SeekBar)findViewById(R.id.seekBar_mood);

        save_button=(Button)findViewById(R.id.button_submit);
        save_button.setOnClickListener(this);

       Button_Id = Integer.parseInt(getIntent().getExtras().getString(DisplayActivity.BUTTON_KEY));

       if(getIntent().getExtras()!=null)
       {
           if(Button_Id==1) {

               editText_email.setVisibility(View.INVISIBLE);
               textView_dept.setVisibility(View.INVISIBLE);
               textView_mood.setVisibility(View.INVISIBLE);
               rg.setVisibility(View.INVISIBLE);
               seekBar.setVisibility(View.INVISIBLE);
               editText_name.setText(student.name);
         }

else if(Button_Id==2)
           {
               editText_name.setVisibility(View.INVISIBLE);
               textView_dept.setVisibility(View.INVISIBLE);
               textView_mood.setVisibility(View.INVISIBLE);
               rg.setVisibility(View.INVISIBLE);
               seekBar.setVisibility(View.INVISIBLE);
               editText_email.setText( student.email_address );
           }
else if (Button_Id==3)
           {
               editText_name.setVisibility(View.INVISIBLE);
               editText_email.setVisibility(View.INVISIBLE);
               seekBar.setVisibility(View.INVISIBLE);
               textView_mood.setVisibility(View.INVISIBLE);
               department = getIntent().getExtras().getString(DisplayActivity.DEPARTMENT_KEY);

               rg=(RadioGroup)findViewById(R.id.radioGroup);
               rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                   @Override
                   public void onCheckedChanged(RadioGroup group, int checkedId) {
                       RadioButton rb=(RadioButton)findViewById(checkedId);

                   }
               });

               if(student.department.equals("SIS"))
               {
                   student.department="SIS";
                   SIS.setChecked(true);

               }
                else if(student.department.equals("CS"))
               {
                   student.department="CS";
                   CS.setChecked(true);
               }
               else if(student.department.equals("BIO"))
               {
                   student.department="BIO";
                    BIO.setChecked(true);
               }
               else
               {
                   student.department="Others";
                   Others.setChecked(true);
               }
               //String s=getIntent().getExtras().getString(DisplayActivity.DEPARTMENT_KEY);


              /*// Log.d("demo",dept+"hie");
               if(dept=="SIS"){
                   RadioGroup r =(RadioGroup) findViewById(R.id.radioGroup);
                   if(r.getId()==R.id.radioButton_SIS);
               }
               else if (dept=="CS"){
                   RadioButton r= (RadioButton)findViewById(R.id.radioButton_CS);
                   r.setChecked(true);
               }
               else if(dept=="BIO"){
                   RadioButton r = (RadioButton)findViewById(R.id.radioButton_BIO);
                   r.setChecked(true);
               }
               else if(dept=="Others"){
                   RadioButton r=(RadioButton)findViewById(R.id.radioButton_Others);
                   r.setChecked(true);
               }*/
           }
           else if(Button_Id==4){
               editText_name.setVisibility(View.INVISIBLE);
               editText_email.setVisibility(View.INVISIBLE);
               textView_dept.setVisibility(View.INVISIBLE);
               rg.setVisibility(View.INVISIBLE);
               //Log.d("demo","start");
               //int temp_count= getIntent().getExtras().getInt(DisplayActivity.MOOD_KEY);
               //Log.d("demo",temp_count+"");
               seekBar.setProgress(student.mood);
               seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                   @Override
                   public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                  student.mood=progress;
                   }

                   @Override
                   public void onStartTrackingTouch(SeekBar seekBar) {

                   }

                   @Override
                   public void onStopTrackingTouch(SeekBar seekBar) {

                   }
               });
           }
           }


    }

    @Override
    public void onClick(View v) {


        if(Button_Id==1) student.name=editText_name.getText().toString();
        else if (Button_Id==2) student.email_address = editText_email.getText().toString();
else if(Button_Id==3) student.department= ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();



        Intent intent=new Intent(EditActivity.this,DisplayActivity.class);
        intent.putExtra(MainActivity.STUDENT_KEY,student);
        startActivity(intent);

    }
}
