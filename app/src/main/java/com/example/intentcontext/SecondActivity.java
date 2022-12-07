package com.example.intentcontext;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity implements View.OnClickListener {
    Button btn_back;
    Button btn_res;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setupUI();
    }

    private void setupUI() {
        btn_back = findViewById(R.id.button_back);
        btn_res = findViewById(R.id.button_result);
        btn_back.setOnClickListener(this);
        btn_res.setOnClickListener(this);

        txt = findViewById(R.id.text);
        String myText = getIntent().getStringExtra("my text");
        if(myText != null) {
            txt.setText(myText);
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_back:
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.button_result:
                Intent intent2 = new Intent();
                intent2.putExtra("text321", "8999");
                setResult(RESULT_OK, intent2);
                finish();
        }
    }
}