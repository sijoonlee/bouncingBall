package github.sijoonlee.bouncingball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        float height = metrics.heightPixels;
        float width = metrics.widthPixels;
        BouncingBallView bouncingBallView = new BouncingBallView(this, width, height);
        //setContentView(R.layout.activity_main);
        setContentView(bouncingBallView);


    }
}
