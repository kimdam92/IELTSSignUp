package com.example.ieltssignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class BookingProcess extends AppCompatActivity {
    EditText username , password;
    boolean validation_state = false;
    String user1 = "Dan" , pw1 = "123";
    InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_process);
        username = findViewById(R.id.user_edit);
        password = findViewById(R.id.pw_edit);
        imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    public void OnLogin(View view) {
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        validation_state = onValidation();
        if (validation_state)
        {
            if(username.getText().toString().equals(user1) && password.getText().toString().equals(pw1))
            {
                Toast.makeText(this, "Login success", Toast.LENGTH_LONG).show();
                Intent intent = new Intent ( this, IELTS_TestList.class);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(this, "Login Failed , Please try again.. ",Toast.LENGTH_LONG).show();
                username.getText().clear();
                password.getText().clear();
                username.requestFocus();
            }
        }
        else
        {
            Toast.makeText(this, "Please fill the fields", Toast.LENGTH_LONG).show();
        }

    }

    public void OnRegister(View view) {

        Intent register = new Intent(this,Registration.class);
        startActivity(register);
    }

    public boolean onValidation()
    {
        if (username.getText().toString().isEmpty() && password.getText().toString().isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
