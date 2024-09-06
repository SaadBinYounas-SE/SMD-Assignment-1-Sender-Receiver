package com.example.senderreciever_a1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RecieverActivity extends AppCompatActivity {
    EditText etREmail,etRName,etRInfo,etRCountry,etRAddress;

    Button btnRNext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciever);

        init();

        Intent intent = getIntent();

        String email = intent.getStringExtra("email");
        String name = intent.getStringExtra("name");
        String info = intent.getStringExtra("info");
        String country = intent.getStringExtra("country");
        String address = intent.getStringExtra("address");

        btnRNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Remail = etREmail.getText().toString().trim();
                String Rname = etRName.getText().toString().trim();
                String Rinfo = etRInfo.getText().toString().trim();
                String Rcountry = etRCountry.getText().toString().trim();
                String Raddress = etRAddress.getText().toString().trim();

                if (Remail.isEmpty() || Rname.isEmpty() || Rinfo.isEmpty() || Rcountry.isEmpty() || Raddress.isEmpty()) {
                    Toast.makeText(RecieverActivity.this, "Fields should not be empty", Toast.LENGTH_SHORT).show();
                }
                else if(!Remail.contains("@gmail.com"))
                {
                    Toast.makeText(RecieverActivity.this, "Email invalid", Toast.LENGTH_SHORT).show();
                }
                else if(Rinfo.length()!=11){
                    Toast.makeText(RecieverActivity.this, "Phone number invalid", Toast.LENGTH_SHORT).show();
                }
                else if(Remail.equals(email))
                {
                    Toast.makeText(RecieverActivity.this, "Use a different email id", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(RecieverActivity.this, ReviewActivity.class);
                    intent.putExtra("Remail", Remail);
                    intent.putExtra("Rname", Rname);
                    intent.putExtra("Rinfo", Rinfo);
                    intent.putExtra("Rcountry", Rcountry);
                    intent.putExtra("Raddress", Raddress);
                    intent.putExtra("email", email);
                    intent.putExtra("name", name);
                    intent.putExtra("info", info);
                    intent.putExtra("country", country);
                    intent.putExtra("address", address);
                    startActivity(intent);
                }
            }
        });

    }

    void init()
    {
        etREmail=findViewById(R.id.etREmail);
        etRName=findViewById(R.id.etRName);
        etRInfo=findViewById(R.id.etRInfo);
        etRCountry=findViewById(R.id.etRCountry);
        etRAddress=findViewById(R.id.etRAddress);

        btnRNext=findViewById(R.id.btnRNext);
    }
}
