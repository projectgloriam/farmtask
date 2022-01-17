package com.example.farmtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText name, mobile, customer_id, password;
    private String idType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ///////////////////////////////////////
        //idType
        Spinner idTypeSpinner = (Spinner) findViewById(R.id.id_type);

        idTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                // do something upon option selection
                idType = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });

        /////////////////////////////////////
        ImageButton submit = findViewById(R.id.imageButton);

        //Setting onClickListeners
        submit.setOnClickListener(view -> {

            //name
            name = findViewById(R.id.editTextTextPersonName);

            //mobile
            mobile = findViewById(R.id.editTextPhone);

            // customer id
            customer_id = findViewById(R.id.editTextTextID);

            // customer password
            password = findViewById(R.id.editTextTextPassword);

            if (name.getText().toString().matches("") || mobile.getText().toString().matches("") || customer_id.getText().toString().matches("") || password.getText().toString().matches("") ) {
                Toast.makeText(this, "Please don't leave any field blank", Toast.LENGTH_SHORT).show();
                return;
            }

            try {

                //New Customer
                Customer customer = new Customer(-1, name.getText().toString(), mobile.getText().toString(), idType, customer_id.getText().toString(), password.getText().toString());
                //Database Helper
                DatabaseHelper databaseHelper = new DatabaseHelper(RegisterActivity.this);

                if(databaseHelper.addCustomer(customer)) {
                    //Move to next activity upon successful add
                    Intent intent = new Intent(this, NewFarmActivity.class);
                    startActivity(intent);
                }
            } catch (Exception e){
                Toast.makeText(RegisterActivity.this, "Error registering user", Toast.LENGTH_SHORT).show();
            }

        });
    }
}