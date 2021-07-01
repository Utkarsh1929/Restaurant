package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {

    private ItemsAdapter itemsAdapter;
    private RecyclerView recyclerView;
    private ArrayList<itemData> menuArrayList;
    private FirebaseFirestore db;
    ProgressBar loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        recyclerView=findViewById(R.id.recyc_menu);
        loading=findViewById(R.id.progbar);
        db= FirebaseFirestore.getInstance();
        menuArrayList=new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemsAdapter = new ItemsAdapter(menuArrayList,this);
        recyclerView.setAdapter(itemsAdapter);

        db.collection("itemData").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if(!queryDocumentSnapshots.isEmpty())
                {
                    loading.setVisibility(View.GONE);
                    List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                    for(DocumentSnapshot d:list)
                    {
                        itemData i= d.toObject(itemData.class);
                        menuArrayList.add(i);

                    }
                    itemsAdapter.notifyDataSetChanged();
                }
                else
                {
                    Toast.makeText(Menu.this, "No data found in database", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(Exception e) {
                Toast.makeText(Menu.this, "Fail to get data", Toast.LENGTH_SHORT).show();
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bill:
                Intent i =new Intent(Menu.this,Bill.class);
                Menu.this.startActivity(i);
                Toast.makeText(this, "Bill", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cart:
                Toast.makeText(this, "Cart", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add:
                Intent i2=new Intent(Menu.this,Add.class);
                Menu.this.startActivity(i2);
                break;
            case R.id.del:
                Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.edit:
                Toast.makeText(this, "edit", Toast.LENGTH_SHORT).show();
                break;
            case R.id.care:
                Toast.makeText(this, "care", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Intent i3=new Intent(Menu.this,Settings.class);
                Menu.this.startActivity(i3);
                Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.issue:
                Toast.makeText(this, "issue", Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

}