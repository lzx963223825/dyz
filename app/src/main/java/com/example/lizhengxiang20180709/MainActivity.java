package com.example.lizhengxiang20180709;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lizhengxiang20180709.view.MyView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyView myView = findViewById(R.id.MyView);
    }
}
