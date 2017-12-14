package com.bwie.voovapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.voovapp.R;
import com.bwie.voovapp.pre.AppPre;
import com.bwie.voovapp.view.IUserLogin;

public class PhoneLoginActivity extends AppCompatActivity implements View.OnClickListener,IUserLogin {

    private TextView resgit;
    private TextView youke;
    private AppPre appPre;
    private EditText username;
    private EditText userpass;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_login);
        init();
    }
    public void init(){
        youke = (TextView)findViewById(R.id.youke_1);
        resgit = (TextView)findViewById(R.id.zhuce);
        username = (EditText)findViewById(R.id.username);
        userpass = (EditText)findViewById(R.id.userpass);
        login = (Button)findViewById(R.id.login);
        resgit.setOnClickListener(this);
        login.setOnClickListener(this);
        youke.setOnClickListener(this);
        appPre = new AppPre(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.zhuce:
                startActivity(new Intent(PhoneLoginActivity.this,ResgitActivity.class));
                break;
            case R.id.youke_1:
                //跳转到主界面上面去
                startActivity(new Intent(PhoneLoginActivity.this,ZhuJieMianActivity.class));
                break;
            case R.id.login:
                //实现登录
                appPre.getLogin(getLoginPhone(),getLoginPass());
                break;
        }
    }

    @Override
    public String getLoginPhone() {
        return username.getText().toString();
    }

    @Override
    public String getLoginPass() {
        return userpass.getText().toString();
    }

    @Override
    public void LoginSuccess() {
        Toast.makeText(PhoneLoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(PhoneLoginActivity.this,ZhuJieMianActivity.class));
    }
    @Override
    public void LogintError() {
        Toast.makeText(PhoneLoginActivity.this,"笨蛋，用心一点",Toast.LENGTH_SHORT).show();

    }
}
