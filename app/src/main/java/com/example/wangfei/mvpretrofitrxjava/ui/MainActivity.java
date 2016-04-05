package com.example.wangfei.mvpretrofitrxjava.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wangfei.mvpretrofitrxjava.R;
import com.example.wangfei.mvpretrofitrxjava.callback.ActivityCallBack;
import com.example.wangfei.mvpretrofitrxjava.persenter.MainPersenter;

public class MainActivity extends AppCompatActivity implements ActivityCallBack,View.OnClickListener{

    private Button button;
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(this);
        textview = (TextView) findViewById(R.id.textview1);
    }

    @Override
    public void toUI(int action, Object object) {
        switch (action){
            case MainPersenter.ACTION_1:
                if (object != null) {
                    textview.setText((String) object);
                }
            break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                MainPersenter.getInstance().Operation(this);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MainPersenter.getInstance().destoryInstence();
    }
}
