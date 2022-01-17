package com.example.farmtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {
    ImageButton submit;
    EditText card, cvc, bill, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        /////////////////////////////////////
        submit = findViewById(R.id.payNowImageButton);

        //Setting onClickListeners
        submit.setOnClickListener(view -> {

            //Card
            card = findViewById(R.id.editTextCard);

            //CVC
            cvc = findViewById(R.id.editTextCVC);

            // Bill
            bill = findViewById(R.id.editTextBill);

            // Date
            date = findViewById(R.id.expireEditTextDate);

            if (card.getText().toString().matches("") || cvc.getText().toString().matches("") || bill.getText().toString().matches("") || date.getText().toString().matches("") ) {
                Toast.makeText(this, "Please don't leave any field blank", Toast.LENGTH_SHORT).show();
                return;
            }

            try {

                //New Payment
                Payment payment = new Payment(-1, card.getText().toString(), cvc.getText().toString(), bill.getText().toString(), date.getText().toString());
                //Database Helper
                DatabaseHelper databaseHelper = new DatabaseHelper(PaymentActivity.this);

                if(databaseHelper.addPayment(payment)) {
                    //Move to next activity upon successful add
                    Intent intent = new Intent(this, FarmActivity.class);
                    startActivity(intent);
                }
            } catch (Exception e){
                Toast.makeText(PaymentActivity.this, "Error registering payment method", Toast.LENGTH_SHORT).show();
            }

        });
    }
}