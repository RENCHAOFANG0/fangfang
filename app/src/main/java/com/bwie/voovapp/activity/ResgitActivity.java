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
import com.bwie.voovapp.view.IUserNameView;

public class ResgitActivity extends AppCompatActivity implements View.OnClickListener,IUserNameView {
    private EditText name;
    private EditText pass;
    private Button resgit;
    private TextView youke2;
    private AppPre appPre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgit);
        init();
    }
    public void init(){
        name = (EditText)findViewById(R.id.resgit_name);
        pass = (EditText)findViewById(R.id.resgit_pass);
        resgit = (Button)findViewById(R.id.resgit);
        youke2 = (TextView)findViewById(R.id.youke_2);
        resgit.setOnClickListener(this);
        youke2.setOnClickListener(this);
        //进行注册Pre
        appPre = new AppPre(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.resgit:
                //进行注册账号
                Toast.makeText(ResgitActivity.this, "我点击了", Toast.LENGTH_SHORT).show();
                appPre.getResgit(getUserName(),getUserPass());
                break;
            case R.id.youke_2:
                //进行游客的登录
                startActivity(new Intent(ResgitActivity.this,ZhuJieMianActivity.class));
                break;
        }
    }

    @Override
    public String getUserName() {
        return name.getText().toString();
    }

    @Override
    public String getUserPass() {
        return pass.getText().toString();
    }

    @Override
    public void ResgitSuccess() {
        Toast.makeText(ResgitActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(ResgitActivity.this,PhoneLoginActivity.class));
    }
    @Override
    public void ResgitError() {
        Toast.makeText(ResgitActivity.this,"笨蛋，用心一点",Toast.LENGTH_SHORT).show();
    }
}
