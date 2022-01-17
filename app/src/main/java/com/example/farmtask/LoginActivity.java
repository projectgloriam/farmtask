package com.example.farmtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private EditText mobile, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /////////////////////////////////////
        Button submit = findViewById(R.id.login_button);

        //Setting onClickListeners
        submit.setOnClickListener(view -> {
            boolean auth = false;
            DatabaseHelper databaseHelper = new DatabaseHelper(LoginActivity.this);
            List<Customer> customers = databaseHelper.getCustomers();

            //Mobile
            mobile = findViewById(R.id.editTextPhoneLogin);

            //Password
            password = findViewById(R.id.editTextTextPasswordLogin);

            for (int i=0; i<customers.size(); i++) {
                //System.out.println(customers.get(i));

                if(mobile.getText().toString().equals(customers.get(i).getMobile()) && password.getText().toString().equals(customers.get(i).getPassword())){
                    auth = true;
                    break;
                }
            }

            if(auth){
                //if authentication is successful
                Intent intent = new Intent(this, FarmActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Wrong username and password or either fields are blank", Toast.LENGTH_SHORT).show();
            }

        });
    }
}