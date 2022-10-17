package com.example.finalcontacttracing;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Dashboard extends AppCompatActivity {

    EditText name,age,contact,address,gender;
    Button procceed;
    Button datacancel,dataaccept;
    TextView datahead,datacontent,datacontent1,datacontent2,datacontent3,datacontent4,datacontent5,datacontent6;
    AlertDialog.Builder dialogbuilder;
    AlertDialog dialog;
    FirebaseDatabase root;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        name = findViewById(R.id.idnameedit);
        age = findViewById(R.id.idageedit);
        contact = findViewById(R.id.idcontactedit);
        address= findViewById(R.id.idhomeedit);
        gender = findViewById(R.id.idgenderedit);

        procceed= findViewById(R.id.procceedbtn);

        procceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fname = name.getText().toString();
                String fage = age.getText().toString();
                String fcontact = contact.getText().toString();
                String faddress = address.getText().toString();
                String fgender = gender.getText().toString();

            if(name.getText().toString().isEmpty()){
                name.setError("Required Filled");
                return;
            }
                if(age.getText().toString().isEmpty()){
                    age.setError("Required Filled");
                    return;
                }
                if(contact.getText().toString().isEmpty()){
                    contact.setError("Required Filled");
                    return;
                }
                if(address.getText().toString().isEmpty()){
                    address.setError("Required Filled");
                    return;
                }
                if(gender.getText().toString().isEmpty()){
                    gender.setError("Required Filled");
                    return;
                }
                dataprivacy();
            }


        });
    }
    public void dataprivacy(){

    dialogbuilder = new AlertDialog.Builder(this);
    View datapop = getLayoutInflater().inflate(R.layout.dataprivacyact,null);
    datahead =datapop.findViewById(R.id.data_header);
    datacontent=datapop.findViewById(R.id.data_content);
    datacontent1=datapop.findViewById(R.id.data_content1);
        datacontent2=datapop.findViewById(R.id.data_content2);
        datacontent3=datapop.findViewById(R.id.data_content3);
        datacontent4=datapop.findViewById(R.id.data_content4);
        datacontent5=datapop.findViewById(R.id.data_content5);
        datacontent6=datapop.findViewById(R.id.data_content6);

    datacancel=datapop.findViewById(R.id.databtncanel);
    dataaccept=datapop.findViewById(R.id.databtnaccept);
    dialogbuilder.setView(datapop);
    dialog = dialogbuilder.create();
    dialog.show();
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);


dataaccept.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String fname = name.getText().toString();
        String fage = age.getText().toString();
        String fcontact = contact.getText().toString();
        String faddress = address.getText().toString();
        String fgender = gender.getText().toString();

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("key 1",fname);
        editor.putString("key 2",fage);
        editor.putString("key 3",fcontact);
        editor.putString("key 4",faddress);
        editor.putString("key 5", fgender);
        editor.commit();

        Intent intent = new Intent(Dashboard.this, HealthInfo.class);
        startActivity(intent);
        finish();
    }
});

datacancel.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
dialog.dismiss();
    }
});
    }
}