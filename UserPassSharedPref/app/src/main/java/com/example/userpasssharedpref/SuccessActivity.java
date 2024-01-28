package com.example.userpasssharedpref;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SuccessActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        sharedPreferences = getSharedPreferences("login_prefs", Context.MODE_PRIVATE);

        Button clearCredentialsButton = findViewById(R.id.buttonClearCredentials);
        clearCredentialsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear stored credentials in SharedPreferences
                clearCredentials();

                // Open login page
                openLoginPage();
            }
        });
    }

    private void clearCredentials() {
        // Clear stored credentials in SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("username");
        editor.remove("password");
        editor.apply();
    }

    private void openLoginPage() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}