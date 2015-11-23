package fragz.com.dataapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;


/**
 * Created by bill on 11/11/15.
 */
public class Datasplash extends Activity {

    public static int SPLASH_TIME_OUT = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                    findViewById(R.id.avloadingIndicatorView).setVisibility(View.VISIBLE);

                Intent data = new Intent(Datasplash.this, Databutton.class);
                startActivity(data);
                finish();
            }
        },SPLASH_TIME_OUT);
    }

}
