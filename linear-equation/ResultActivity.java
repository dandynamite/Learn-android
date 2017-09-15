package com.example.dandynamite.linearequation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tvResult = (TextView) findViewById(R.id.tvResult);
        Intent callerIntent = getIntent();
        Bundle packBundle = callerIntent.getBundleExtra("MyPackage");
        int a = packBundle.getInt("soA");
        int b = packBundle.getInt("soB");
        doLinearEquation(a, b);
    }
    public void doLinearEquation(int a, int b){
        if(a == 0){
            if(b == 0){
                tvResult.setText("Phuong trinh co vo so nghiem.");
            }
            else {
                tvResult.setText("Phuong trinh vo nghiem.");
            }
        }
        else {
            tvResult.setText("X = "+ String.valueOf((float)(-b/a)));
        }
    }
}
