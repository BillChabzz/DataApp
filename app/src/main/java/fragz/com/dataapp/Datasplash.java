package fragz.com.dataapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.github.channguyen.adv.AnimatedDotsView;

/**
 * Created by bill on 11/11/15.
 */
public class Datasplash extends Activity {

    public static int SPLASH_TIME_OUT = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        final AnimatedDotsView white =(AnimatedDotsView)findViewById(R.id.adv_1);
        white.startAnimation();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent data = new Intent(Datasplash.this,Databutton.class);
                startActivity(data);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
