package com.example.userpasssharedpref;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("login_prefs", Context.MODE_PRIVATE);

        if (checkCredentials()) {
            // User is already logged in, open success page
            openSuccessPage();
        } else {
            // No stored credentials, open login page
            openLoginPage();
        }
    }

    private boolean checkCredentials() {
        String username = sharedPreferences.getString("username", null);
        String password = sharedPreferences.getString("password", null);
        return username != null && !username.isEmpty() && password != null && !password.isEmpty();
    }

    private void openLoginPage() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void openSuccessPage() {
        Intent intent = new Intent(this, SuccessActivity.class);
        startActivity(intent);
        finish();
    }
}