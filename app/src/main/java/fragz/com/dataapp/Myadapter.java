package fragz.com.dataapp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.View;


import java.util.List;

/**
 * Created by bill on 11/13/15.
 */
public class Myadapter extends RecyclerView.Adapter<Myadapter.DataHolderViewHolder> {

    public static class DataHolderViewHolder extends RecyclerView.ViewHolder {
        TextView company_name;
        TextView country;
        TextView credit_card;
        TextView email;
        TextView last_name;
        TextView first_name;
        CardView cv;
        public DataHolderViewHolder(View itemView) {
            super(itemView);

            cv = (CardView)itemView.findViewById(R.id.cardView);
            first_name =(TextView)itemView.findViewById(R.id.first_name_field);
            last_name = (TextView)itemView.findViewById(R.id.last_name_field);
            email = (TextView)itemView.findViewById(R.id.email_field);
            credit_card = (TextView)itemView.findViewById(R.id.credit_field);
            country = (TextView)itemView.findViewById(R.id.country_field);
            company_name = (TextView)itemView.findViewById(R.id.co_name_field);
        }
    }

    List<DataHolder> dataObject;
    Myadapter(List<DataHolder> dataObject){
        this.dataObject = dataObject;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public DataHolderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.firebase_card_item,parent,false);
        DataHolderViewHolder vh = new DataHolderViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(DataHolderViewHolder holder, int position) {
        holder.company_name.setText(dataObject.get(position).company_name);
        holder.first_name.setText(dataObject.get(position).first_name);
        holder.last_name.setText(dataObject.get(position).last_name);
        holder.email.setText(dataObject.get(position).email);
        holder.country.setText(dataObject.get(position).country);
        holder.credit_card.setText(String.valueOf(dataObject.get(position).credit_card));
    }

    @Override
    public int getItemCount() {
        return dataObject.size();
    }
}