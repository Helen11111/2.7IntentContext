package com.example.intentcontext;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    Button btn_enter;
    Button btn_open;
    Button btn_send;
    Button btn_result;
    EditText edText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();

    }

    private void setupUI() {
        btn_enter = findViewById(R.id.enter_btn);
        btn_open = findViewById(R.id.open_file);
        btn_send = findViewById(R.id.send_file);
        btn_result = findViewById(R.id.result);
        edText = findViewById(R.id.edit_txt);

        btn_enter.setOnClickListener(this);
        btn_open.setOnClickListener(this);
        btn_send.setOnClickListener(this);
        btn_result.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.enter_btn:
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}