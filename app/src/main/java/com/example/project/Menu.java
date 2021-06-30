package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {


    RecyclerView recyclerView;


    ArrayList<itemss> menuitems;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        recyclerView=findViewById(R.id.recyc_menu);

        Bundle bundle= getIntent().getExtras();
        String name = bundle.getString("item");
        String type = bundle.getString("type");
        String cost = bundle.getString("cost");
        menuitems=new ArrayList<>();
        menuitems.add(new itemss(name, type, cost));
        ItemsAdapter itemsAdapter = new ItemsAdapter(this,menuitems);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(itemsAdapter);

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