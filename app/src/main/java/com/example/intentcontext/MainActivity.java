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

            case R.id.open_file:
                Intent intentOpenFile = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intentOpenFile.setType("*/*");
                startActivityForResult(intentOpenFile, 123);
                break;
            case R.id.send_file:
                String text = edText.getText().toString();
                Intent intentWithInfo = new Intent(this, SecondActivity.class);
                intentWithInfo.putExtra("my text", text);
                startActivity(intentWithInfo);
            case R.id.result:
                Intent intentResult = new Intent(this, SecondActivity.class);
                startActivityForResult(intentResult, 321);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(RESULT_OK == resultCode) {
            if(requestCode == 123) {
                Toast.makeText(this, data.getStringExtra("text123"), Toast.LENGTH_SHORT).show();
            }
            if(requestCode == 321) {
                Toast.makeText(this, data.getStringExtra("text321"), Toast.LENGTH_SHORT).show();
            }

        }

    }
}