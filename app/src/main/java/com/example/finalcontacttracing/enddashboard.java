package com.example.finalcontacttracing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class enddashboard extends AppCompatActivity {
    Animation top,bottom;
    ImageView endimage;
    TextView name,thanks,con;
    Button endbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_enddashboard);

        top = AnimationUtils.loadAnimation(this,R.anim.top_anim);
        bottom = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        endimage =findViewById(R.id.endimage);
        name =findViewById(R.id.endname);
        thanks = findViewById(R.id.thanks);
        con = findViewById(R.id.cont);

        endbtn = findViewById(R.id.endbtn);

        endimage.setAnimation(top);
        name.setAnimation(top);
        thanks.setAnimation(bottom);
        con.setAnimation(bottom);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        String fullname =sharedPref.getString("key 1","");

        name.setText(""+fullname);

        endbtn.setAnimation(bottom);


        endbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(enddashboard.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}