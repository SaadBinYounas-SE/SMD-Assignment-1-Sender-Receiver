package com.example.senderreciever_a1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etEmail,etName,etInfo,etCountry,etAddress;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String name = etName.getText().toString().trim();
                String info = etInfo.getText().toString().trim();
                String country = etCountry.getText().toString().trim();
                String address = etAddress.getText().toString().trim();

                if (email.isEmpty() || name.isEmpty() || info.isEmpty() || country.isEmpty() || address.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Fields should not be empty", Toast.LENGTH_SHORT).show();
                }
                else if(!email.contains("@gmail.com"))
                {
                    Toast.makeText(MainActivity.this, "Email invalid", Toast.LENGTH_SHORT).show();
                }
                else if(info.length()!=11){
                    Toast.makeText(MainActivity.this, "Phone number invalid", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, RecieverActivity.class);
                    intent.putExtra("email", email);
                    intent.putExtra("name", name);
                    intent.putExtra("info", info);
                    intent.putExtra("country", country);
                    intent.putExtra("address", address);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

    void init()
    {
        etEmail=findViewById(R.id.etEmail);
        etName=findViewById(R.id.etName);
        etInfo=findViewById(R.id.etInfo);
        etCountry=findViewById(R.id.etCountry);
        etAddress=findViewById(R.id.etAddress);

        btnNext=findViewById(R.id.btnNext);
    }
}