package com.example.signup;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText textuser,textpass;
    Button btnSignup;
    String re ="(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textuser=(EditText)findViewById(R.id.signup_uname);
        textpass=(EditText)findViewById(R.id.signup_pass);
        btnSignup=(Button)findViewById(R.id.signup_button);
        btnSignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String un=textuser.getText().toString();
        String p=textpass.getText().toString();
        if(validatePassword(p)){
            Bundle bundle=new Bundle();     // pass parcel from one activity to another
            bundle.putString("user",un);
            bundle.putString("pwd",p);
            Intent it=new Intent(this, Login.class);     //to start another activity
            it.putExtra("data",bundle);
            startActivity(it);



        }
        else{
            Toast.makeText(getApplicationContext(),"INVALID PASSWORD",Toast.LENGTH_LONG).show();
        }

    }
    public boolean validatePassword(String p){
        Pattern pattern=Pattern.compile(re);
        Matcher matcher = pattern.matcher(p);
        return matcher.matches();

        //return Pattern.matches(re,p);

    }
}