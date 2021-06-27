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
    Context context;
    ArrayList<itemss> menuitems;
    AlertDialog.Builder builder;
    ItemsAdapter(Context context, ArrayList<itemss> menuitems)
    {
        this.context=context;
        this.menuitems=menuitems;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View listitem=inflater.inflate(R.layout.list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(listitem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.ViewHolder holder, int position)
    {
        builder = new AlertDialog.Builder(context);
        addItem(position,holder);
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setCancelable(false);
                builder.setMessage("Delete this item");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        menuitems.remove(position);
                        notifyItemChanged(position);
                        notifyItemRangeChanged(position, menuitems.size());
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
    private void addItem(int position, ViewHolder holder)
    {
        itemss item = menuitems.get(position);
        holder.textname.setText(item.getName());
        holder.texttype.setText(item.getType());
        holder.textcost.setText(item.getCost());

    }

    @Override
    public int getItemCount() {
        return menuitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public Button delete;
        public TextView textname, texttype, textcost;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textname=itemView.findViewById(R.id.txt_listname);
            this.texttype=itemView.findViewById(R.id.txt_listtype);
            this.textcost=itemView.findViewById(R.id.txt_listcost);
            this.delete=itemView.findViewById(R.id.btn_del);


        }
    }
}
