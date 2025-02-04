package com.example.herizon;

import android.os.Bundle;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // redirect to login page
        Intent intent = new Intent(MainActivity.this, Login.class);
        startActivity(intent);
    }
}