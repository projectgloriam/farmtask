package com.example.farmtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class NewFarmActivity extends AppCompatActivity {
    private RadioGroup farmTypeRadioGroup, categoryRadioGroup, payWithRadioGroup;
    private RadioButton farmTypeRadioButton, categoryRadioButton, payWithRadioButton;
    private String cultivate, farmSize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_farm);

        //farm type
        farmTypeRadioGroup = (RadioGroup) findViewById(R.id.farm_type_radio_group);

        //category
        categoryRadioGroup = (RadioGroup) findViewById(R.id.category_radio_group);

        //pay with
        payWithRadioGroup = (RadioGroup) findViewById(R.id.pay_with_radio_group);

        ///////////////////////////////////////
        //cultivate
        Spinner cultivateSpinner = (Spinner) findViewById(R.id.cultivate_spinner);

        cultivateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                // do something upon option selection
                cultivate = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });

        ////////////////////////////////////
        //farm size
        Spinner farmSizeSpinner = (Spinner) findViewById(R.id.farm_size_spinner);

        farmSizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                // do something upon option selection
                farmSize = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });


        /////////////////////////////////////
        ImageButton submit = findViewById(R.id.imageButton2);

        //Setting onClickListeners
        submit.setOnClickListener(view -> {

            //farm type
            // get selected radio button from radioGroup
            int farmTypeSelectedId = farmTypeRadioGroup.getCheckedRadioButtonId();

            // find the radiobutton by returned id
            farmTypeRadioButton = (RadioButton) findViewById(farmTypeSelectedId);

            //category
            // get selected radio button from radioGroup
            int categorySelectedId = categoryRadioGroup.getCheckedRadioButtonId();

            // find the radiobutton by returned id
            categoryRadioButton = (RadioButton) findViewById(categorySelectedId);

            //pay with
            // get selected radio button from radioGroup
            int payWithSelectedId = payWithRadioGroup.getCheckedRadioButtonId();

            // find the radiobutton by returned id
            payWithRadioButton = (RadioButton) findViewById(payWithSelectedId);

            if (farmTypeRadioButton.getText().toString().matches("") || categoryRadioButton.getText().toString().matches("") || payWithRadioButton.getText().toString().matches("") ) {
                Toast.makeText(this, "Please don't leave any option unselected", Toast.LENGTH_SHORT).show();
                return;
            }

            try {

                //New Farm Object
                Farm farm = new Farm(farmTypeRadioButton.getText().toString(), categoryRadioButton.getText().toString(), cultivate, farmSize, payWithRadioButton.getText().toString(), -1);

                //Database Helper
                DatabaseHelper databaseHelper = new DatabaseHelper(NewFarmActivity.this);

                if(databaseHelper.addFarm(farm)){
                    //Move to next activity upon successful add
                    Intent intent = new Intent(this, PaymentActivity.class);
                    startActivity(intent);
                }

            } catch (Exception e){
                Toast.makeText(NewFarmActivity.this, "Error creating farm", Toast.LENGTH_SHORT).show();
            }

        });
    }

}