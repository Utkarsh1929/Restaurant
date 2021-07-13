package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class cartAdapter extends RecyclerView.Adapter<cartAdapter.ViewHolder>{
    private Context context;
    private ArrayList<Cartgetset> cartArrayList;

    public cartAdapter(Context context, ArrayList<Cartgetset> cartArrayList) {
        this.context = context;
        this.cartArrayList= cartArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new cartAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.cart_list,parent,false));
    }

    @Override
    public void onBindViewHolder(cartAdapter.ViewHolder holder, int position) {

        Cartgetset cart = cartArrayList.get(position);
        holder.textname.setText(cart.getName());
        holder.texttype.setText(cart.getType());
        holder.textcost.setText(cart.getCost());
        holder.elegantNumberButton.setRange(0,10);
        holder.elegantNumberButton.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(holder.elegantNumberButton.getNumber());
                if(num==0)
                {
                    String removeItem = cart.getDocumentId();
                    holder.dbCollection.document(removeItem).delete();
                    cartArrayList.remove(position);
                    notifyItemChanged(position);
                    notifyItemRangeChanged(position,cartArrayList.size());
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return cartArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textname, texttype, textcost;
        private final CardView cardView;
        ElegantNumberButton elegantNumberButton;
        FirebaseFirestore db;
        CollectionReference dbCollection;
        public ViewHolder(View itemView) {

            super(itemView);
            db= FirebaseFirestore.getInstance();
            dbCollection = db.collection("cartItem");
            textname=itemView.findViewById(R.id.txt_cartlistname);
            texttype=itemView.findViewById(R.id.txt_cartlisttype);
            textcost=itemView.findViewById(R.id.txt_cartlistcost);
            cardView = itemView.findViewById(R.id.idCartItem);
            elegantNumberButton = itemView.findViewById(R.id.btn_cnt);
        }
    }
}
