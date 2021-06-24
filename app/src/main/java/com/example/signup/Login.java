package com.example.signup;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText textuser,textpass;
    Button btnSignin;
    String ruser,rpwd;
    int count=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        textuser=(EditText)findViewById(R.id.login_uname);
        textpass=(EditText)findViewById(R.id.login_pass);
        btnSignin=(Button)findViewById(R.id.login_button);
        btnSignin.setOnClickListener(this);
        Bundle bundle=getIntent().getBundleExtra("data");
        ruser=bundle.getString("user");
        rpwd=bundle.getString("pwd");

    }
    @Override
    public void onClick(View v) {
        String luser=textuser.getText().toString();
        String lpass=textpass.getText().toString();
        if(ruser.equals(luser)&& rpwd.equals(lpass)){
            Toast.makeText(getApplicationContext(),"LOGIN SUCCESSFUL",Toast.LENGTH_LONG).show();
        }
        else{
            count++;
            // Toast.makeText(getApplicationContext(),3-count+" Attempts left",Toast.LENGTH_LONG).show();
            if(count==3){
                btnSignin.setEnabled(false);
                Toast.makeText(getApplicationContext(),"LOGIN FAILED",Toast.LENGTH_LONG).show();
            }
        }

    }
}