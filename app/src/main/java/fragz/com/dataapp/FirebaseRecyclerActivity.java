package fragz.com.dataapp;

import android.os.Bundle;


import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;


import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.List;

public class FirebaseRecyclerActivity extends AppCompatActivity {

    Data object;
    private List<DataHolder> data_set;
    private RecyclerView rv;
    RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_recycler);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Firebase.setAndroidContext(this);


         rv = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        rv.setHasFixedSize(true);
        getData("https://leapp.firebaseio.com/");
        initializeAdapter();
    }
    public void initializeAdapter(){
        Myadapter adapter = new Myadapter(data_set);
        rv.setAdapter(adapter);
    }
    public void getData(String url){
        data_set = new ArrayList<>();
        Firebase ref = new Firebase(url);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data : dataSnapshot.getChildren()){
                    object = data.getValue(Data.class);
                    data_set.add(new DataHolder(
                            object.getId(),
                            object.getCompany_name(),
                            object.getCredit_card(),
                            object.getEmail(),
                            object.getFirst_name(),
                            object.getFirst_name(),
                            object.getLast_name()

                    ));
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("Read failed: " + firebaseError.getMessage());

            }
        });
    }

}
