package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText name;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText) findViewById(R.id.editTextTextPersonName);
        submit=(Button) findViewById(R.id.button);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String user=name.getText().toString();
        Intent intent=new Intent(this,User.class);
        intent.putExtra("name",user);
        startActivity(intent);
        Toast.makeText(this, "Start Quiz", Toast.LENGTH_LONG).show();
    }
}