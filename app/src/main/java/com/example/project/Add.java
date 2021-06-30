package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class Add extends AppCompatActivity {
    EditText itemname, itemtype, price;
    Button add;
    itemData itemsdata;
    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        itemname=findViewById(R.id.edt_itemname);
        itemtype=findViewById(R.id.edt_itemtype);
        price=findViewById(R.id.edt_price);
        add=findViewById(R.id.addnewitem);
        firebaseFirestore=FirebaseFirestore.getInstance();


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = itemname.getText().toString().trim();
                String type = itemtype.getText().toString().trim();
                String cost = price.getText().toString().trim();

                if(item.isEmpty())
                {
                    itemname.setError("Please enter an item");
                    itemname.requestFocus();
                }
                else if(type.isEmpty())
                {
                    itemtype.setError("Please enter item's type");
                    itemtype.requestFocus();
                }
                else if(cost.isEmpty())
                {
                    price.setError("Please enter cost of the item");
                    price.requestFocus();
                }
                else
                {
                    itemsdata=new itemData(item,type,cost);
                    firebaseFirestore.collection("itemData").document(item).set(itemsdata).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {

                            Bundle bundle = new Bundle();
                            bundle.putString("item", item);
                            bundle.putString("type", type);
                            bundle.putString("cost", cost);
                            Toast.makeText(Add.this, "item added successfully", Toast.LENGTH_SHORT).show();

                            Intent i = new Intent(Add.this, Menu.class);
                            i.putExtras(bundle);
                            startActivity(i);

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(Exception e) {
                            Toast.makeText(Add.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    });
                }


            }
        });


    }
}