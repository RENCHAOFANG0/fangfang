package com.bwie.voovapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.voovapp.R;
import com.bwie.voovapp.pre.AppPre;
import com.bwie.voovapp.view.IUserLogin;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView back;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

    }

    public void init(){
        back = (ImageView)findViewById(R.id.login_back);
        textView = (TextView)findViewById(R.id.qita);
        textView.setOnClickListener(this);
        //关联Pre层

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.qita:
                startActivity(new Intent(LoginActivity.this,PhoneLoginActivity.class));
                break;
        }
    }

}
