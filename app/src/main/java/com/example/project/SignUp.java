package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    TextView txtbgroup,txtgender;
    EditText edtemail,edtname,edtgst,edtpass,edtconpass,edtmobile;
    Button btnregis;
    RadioGroup radioGroup;
    RadioButton radiomale,radiofemale,genderradiob;
    String group[] = {"A+","B+","AB+","O+","A-","B-","AB-","O-"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        txtbgroup = findViewById(R.id.txt_ph);
        txtgender = findViewById(R.id.txt_gen);
        edtemail = findViewById(R.id.edt_mail);
        edtname = findViewById(R.id.edt_name);
        edtgst = findViewById(R.id.edt_gst);
        edtpass = findViewById(R.id.edt_pass);
        edtconpass = findViewById(R.id.edt_conf);
        edtmobile = findViewById(R.id.edt_mob);
        btnregis = findViewById(R.id.btn_regis);
        radiomale = findViewById(R.id.radio_male);
        radiofemale = findViewById(R.id.radio_female);
        radioGroup = findViewById(R.id.radio_group);

        spinner = findViewById(R.id.spin_ph);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, group);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);


        btnregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String name =edtname.getText().toString();
                String email =edtemail.getText().toString();
                String gst =edtgst.getText().toString();
                String pass =edtpass.getText().toString();
                String conpass =edtconpass.getText().toString();
                String mobile =edtmobile.getText().toString();


                int selectId= radioGroup.getCheckedRadioButtonId();
                genderradiob = findViewById(selectId);

                Toast.makeText(getApplicationContext(),
                        name+" "+email+" "+gst+" "+pass+" "+conpass+" "+mobile+" "+" "+genderradiob.getText(),
                        Toast.LENGTH_LONG).show();

                Intent intent=new Intent(SignUp.this,Menu.class);
                SignUp.this.startActivity(intent);

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(this,group[position],Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}