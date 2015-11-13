package fragz.com.dataapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Created by bill on 11/11/15.
 */
public class Databutton extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_button);

        Button dataButton = (Button)findViewById(R.id.data_btn);

        dataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent(Databutton.this,FirebaseRecyclerActivity.class);
                startActivity(data);
            }
        });

    }
}
