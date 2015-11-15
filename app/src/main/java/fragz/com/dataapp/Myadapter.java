package fragz.com.dataapp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.firebase.client.core.view.View;

import java.util.List;

/**
 * Created by bill on 11/13/15.
 */
public class Myadapter extends RecyclerView.Adapter<Myadapter.DataHolderViewHolder>{

    public static class DataHolderViewHolder extends RecyclerView.ViewHolder{
        CardView cv;

        TextView companyName;
        TextView country;
        TextView creditCard;
        TextView email;
        TextView firstName;
        TextView lastName;
        DataHolderViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cardView);
            firstName = (TextView)itemView.findViewById(R.id.first_name_field);
            lastName = (TextView)itemView.findViewById(R.id.last_name_field);
            email = (TextView)itemView.findViewById(R.id.email_field);
            creditCard = (TextView)itemView.findViewById(R.id.credit_field);
            country = (TextView)itemView.findViewById(R.id.country_field);
            companyName = (TextView)itemView.findViewById(R.id.co_name_field);
        }
    }
    List<DataHolder> dataObj;

    Myadapter(List<DataHolder> dataObj){
        this.dataObj = dataObj;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public JDataObjectViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.data_item, viewGroup, false);
        JDataObjectViewHolder svh = new JDataObjectViewHolder(v);
        return svh;
    }


    @Override
    public void onBindViewHolder(JDataObjectViewHolder dataObjectViewHolder, int i) {
        dataObjectViewHolder.firstName.setText(dataObj.get(i).first_name);
        dataObjectViewHolder.lastName.setText(dataObj.get(i).last_name);
        dataObjectViewHolder.companyName.setText(dataObj.get(i).company_name);
        dataObjectViewHolder.country.setText(dataObj.get(i).country);
        dataObjectViewHolder.email.setText(dataObj.get(i).email);
        dataObjectViewHolder.creditCard.setText(String.valueOf(dataObj.get(i).credit_card));
//        speakerViewHolder.personName.setText(speakers.get(i).name);
//        speakerViewHolder.personAge.setText(speakers.get(i).age);
//        speakerViewHolder.personPhoto.setImageResource(speakers.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return dataObj.size();
    }


}