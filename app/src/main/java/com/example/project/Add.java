package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add extends AppCompatActivity {
    EditText itemname, itemtype, price;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        itemname=findViewById(R.id.edt_itemname);
        itemtype=findViewById(R.id.edt_itemtype);
        price=findViewById(R.id.edt_price);
        add=findViewById(R.id.addnewitem);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = itemname.getText().toString().trim();
                String type = itemtype.getText().toString().trim();
                String cost = price.getText().toString().trim();


                Bundle bundle = new Bundle();
                bundle.putString("item", item);
                bundle.putString("type", type);
                bundle.putString("cost", cost);

                Intent i = new Intent(Add.this, Menu.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });


    }
}