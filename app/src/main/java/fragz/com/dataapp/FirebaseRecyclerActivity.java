package fragz.com.dataapp;

import android.os.Bundle;


import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

import com.firebase.ui.FirebaseRecyclerViewAdapter;

import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.client.Firebase;

public class FirebaseRecyclerActivity extends AppCompatActivity {

    RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_recycler);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
    @Override
    protected void onStart(){
        super.onStart();
        Firebase.setAndroidContext(this);
        final Firebase ref = new Firebase("https://leapp.firebaseio.com/");

        final RecyclerView card = (RecyclerView)findViewById(R.id.recycler_view);
        card.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        card.setLayoutManager(mLayoutManager);

        FirebaseRecyclerViewAdapter<Data,DataHolder>
                adapter = new FirebaseRecyclerViewAdapter<Data,DataHolder>(Data.class,R.layout.activity_firebase_recycler,DataHolder.class,ref)
        {
            @Override
        public void populateViewHolder(DataHolder dataViewHolder,Data data){
                dataViewHolder.f_name.setText(data.getFirst_name());
                dataViewHolder.l_name.setText(data.getLast_name());
                dataViewHolder.cred_num.setText(data.getCredit_card());
                dataViewHolder.email.setText(data.getEmail());
                dataViewHolder.id.setText(data.getId());
                dataViewHolder.co_name.setText(data.getCompany_name());
                dataViewHolder.country.setText(data.getCountry());
            }
        };
    card.setAdapter(adapter);

    }

     public static class DataHolder extends RecyclerView.ViewHolder{
         TextView f_name;
         TextView l_name;
         TextView email;
         TextView id;
         TextView co_name;
         TextView cred_num;
         TextView country;



         public DataHolder(View itemView) {
             super(itemView);
             f_name =(TextView)itemView.findViewById(R.id.first_name_field);
             l_name =(TextView)itemView.findViewById(R.id.last_name_field);
             email =(TextView)itemView.findViewById(R.id.email_field);
             id =(TextView)itemView.findViewById(R.id.id_field);
             co_name =(TextView)itemView.findViewById(R.id.co_name_field);
             cred_num =(TextView)itemView.findViewById(R.id.credit_field);
             country =(TextView)itemView.findViewById(R.id.country_field);
         }
     }

}
