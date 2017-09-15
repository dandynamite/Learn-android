package com.example.dandynamite.linearequation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText etNumberA, etNumberB;
    TextView tvEquation;
    Button btnResolve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        etNumberA.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
            setEquation();
            }
        });
        etNumberB.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                setEquation();
            }
        });
        btnResolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etNumberA.getText().toString() != "" && etNumberA.getText().toString()!="") {
                    Intent myIntent = new Intent(MainActivity.this, ResultActivity.class);
                    int a = Integer.parseInt(etNumberA.getText().toString());
                    int b = Integer.parseInt(etNumberB.getText().toString());
                    Bundle bundle = new Bundle();
                    bundle.putInt("soA", a);
                    bundle.putInt("soB", b);
                    myIntent.putExtra("MyPackage", bundle);
                    startActivity(myIntent);
                }
            }
        });

    }
    void mapping(){
        etNumberA = (EditText) findViewById(R.id.teNumberA);
        etNumberB = (EditText) findViewById(R.id.teNumberB);
        tvEquation = (TextView) findViewById(R.id.tvEquation);
        btnResolve = (Button) findViewById(R.id.btnResolve);
    }
    void setEquation(){
        tvEquation.setText(etNumberA.getText().toString() +" X + "+etNumberB.getText().toString()+ " = 0.");
    }
}
