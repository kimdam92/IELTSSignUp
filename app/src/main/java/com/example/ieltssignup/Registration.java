package com.example.ieltssignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    EditText fname,lname,phoneno,dob;
    RadioButton genderbtn;
    RadioGroup gender;
    DatePicker datePicker;


    public static String mypreferences = "IELTS_Reg";
    SharedPreferences store_data;


    String firstname,lastname,contactno,dateofbirth;
    String genderText = "";
    String result="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        fname = findViewById(R.id.first_edit);
        lname = findViewById(R.id.second_edit);
        gender = findViewById(R.id.gender);
        phoneno = findViewById(R.id.phone_edit);
        dob = findViewById(R.id.date_edit);
        store_data = getSharedPreferences(mypreferences, Context.MODE_PRIVATE);

    }

    public void OnSubmit(View view)
    {
        firstname = fname.getText().toString();
        lastname =  lname.getText().toString();
        contactno = phoneno.getText().toString();
        dateofbirth = dob.getText().toString();

        if(OnValidation())
        {
            Toast.makeText(this,"Please fill all the field ",Toast.LENGTH_LONG).show();
        }
        else
        {
            SharedPreferences.Editor editor = store_data.edit();
            editor.putString("first_name",firstname);
            editor.putString("last_name",lastname);
            editor.putString("gender",result);
            editor.putString("PhoneNo",contactno);
            editor.putString("Dob",dateofbirth);
            editor.commit();
            Toast.makeText(this," Record Saved",Toast.LENGTH_LONG).show();
        }
        //   Toast.makeText(this,result,Toast.LENGTH_SHORT).show();

    }

    public boolean OnValidation()
    {
        int gender_id = gender.getCheckedRadioButtonId();

        genderbtn = findViewById(gender_id);


        if(R.id.male_btn == gender_id)
        {
            result = "Male";
        }
        if(R.id.female_btn == gender_id)
        {
            result = "Female";
        }


        if(firstname.equals("") || lastname.equals("")  || contactno.equals("") || dateofbirth.equals("") || result.equals(""))
        {
            return  true;
        }
        else
        {

            return false;
        }
    }

    public void OnRecordView(View view) {

        String s = String.valueOf(store_data.getAll());
        String testing  = String.valueOf(store_data.getString("first_name",null));

        Toast.makeText(this,"Record Details  :  "+testing,Toast.LENGTH_LONG).show();


    }
}
