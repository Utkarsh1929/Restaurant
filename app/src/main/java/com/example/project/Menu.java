package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


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
            case R.id.bill:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
            case R.id.cart:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
            case R.id.care:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
            case R.id.settings:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
            case R.id.issue:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}