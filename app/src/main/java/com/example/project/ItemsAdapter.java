package com.example.project;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder>
{
    
    private ArrayList<itemData> menuArrayList;
    private AlertDialog.Builder builder;
    private Context context;

    public ItemsAdapter(ArrayList<itemData> menuArrayList, Context context)
    {
        this.context=context;
        this.menuArrayList=menuArrayList;
    }
    @NonNull
    @Override
    public ItemsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.ViewHolder holder, int position)
    {
        itemData item = menuArrayList.get(position);
        holder.textname.setText(item.getItemName());
        holder.texttype.setText(item.getItemType());
        holder.textcost.setText(item.getItemCost());


        builder = new AlertDialog.Builder(context);
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setCancelable(false);
                builder.setMessage("Delete this item");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        menuArrayList.remove(position);
                        notifyItemChanged(position);
                        notifyItemRangeChanged(position, menuArrayList.size());
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Toast.makeText(context,"Item not deleted",Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alert = builder.create();
                alert.setTitle("Are you sure");
                alert.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return menuArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final Button delete;
        private final TextView textname, texttype, textcost;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textname=itemView.findViewById(R.id.txt_listname);
            texttype=itemView.findViewById(R.id.txt_listtype);
            textcost=itemView.findViewById(R.id.txt_listcost);
            delete=itemView.findViewById(R.id.btn_del);
        }
    }
}
