package com.example.remembermytext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button button;
    String text="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editTextTextPersonName);
        button =  findViewById(R.id.button);
        SharedPreferences sharedPreferences= this.getSharedPreferences("package com.example.remembermytext",
                Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("text" , "");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(editText.getText().toString());
                sharedPreferences.edit().putString("text" , editText.getText().toString()).apply();
                textView.setText(sharedPreferences.getString("text", ""));
            }
        });
        textView.setText(sharedPreferences.getString("text", ""));
    }
}