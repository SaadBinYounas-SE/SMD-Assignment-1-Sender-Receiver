package com.example.senderreciever_a1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ReviewActivity extends AppCompatActivity {

    TextView tvSName,tvRName, tvSCountry,tvRCountry,tvSAddress,tvRAddress,tvSInfo,tvRInfo;
    View fab;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        init();

        // Get the Intent that started this activity
        Intent intent = getIntent();

        // Retrieve the data passed from the previous activity
        String Remail = intent.getStringExtra("Remail");
        String Rname = intent.getStringExtra("Rname");
        String Rinfo = intent.getStringExtra("Rinfo");
        String Rcountry = intent.getStringExtra("Rcountry");
        String Raddress = intent.getStringExtra("Raddress");

        String email = intent.getStringExtra("email");
        String name = intent.getStringExtra("name");
        String info = intent.getStringExtra("info");
        String country = intent.getStringExtra("country");
        String address = intent.getStringExtra("address");

        tvRName.setText(Rname);
        tvRInfo.setText(Rinfo);
        tvRCountry.setText(Rcountry);
        tvRAddress.setText(Raddress);

        tvSName.setText(name);
        tvSInfo.setText(info);
        tvSCountry.setText(country);
        tvSAddress.setText(address);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ReviewActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    void init()
    {
        tvRName = findViewById(R.id.tvRName);
        tvRInfo = findViewById(R.id.tvRInfo);
        tvRCountry = findViewById(R.id.tvRCountry);
        tvRAddress = findViewById(R.id.tvRAddress);

        tvSName = findViewById(R.id.tvSName);
        tvSInfo = findViewById(R.id.tvSInfo);
        tvSCountry = findViewById(R.id.tvSCountry);
        tvSAddress = findViewById(R.id.tvSAddress);

        fab=findViewById(R.id.fab);
    }
}
