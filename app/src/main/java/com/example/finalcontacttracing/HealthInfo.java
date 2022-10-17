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

public class HealthInfo extends AppCompatActivity {
    EditText q1,q2,q3;
    EditText typeoftranspo,route;
    EditText location,duration,position;
    TextView datahead,datacontent,datacontent1,datacontent2,datacontent3,datacontent4,datacontent5,datacontent6;
    AlertDialog.Builder dialogbuilder;
    AlertDialog dialog;
    Button Submitinfo;
    Button datacancel,dataaccept;
    FirebaseDatabase root;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_info);


        typeoftranspo = findViewById(R.id.idtranspoedit);
        route = findViewById(R.id.idrouteedit);

        location = findViewById(R.id.idplacesedit);
        duration = findViewById(R.id.iddurationedit);
        position = findViewById(R.id.idpositionedit);

        q1=findViewById(R.id.idq1edit);
        q2=findViewById(R.id.idq2edit);
        q3=findViewById(R.id.idq3edit);

        Submitinfo=findViewById(R.id.submitbtn);

        Submitinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(typeoftranspo.getText().toString().isEmpty()){
                    typeoftranspo.setError("Required Filled");
                    return;
                }
                if(route.getText().toString().isEmpty()){
                    route.setError("Required Filled");
                    return;
                }

                if(location.getText().toString().isEmpty()){
                    location.setError("Required Filled");
                    return;
                }
                if(duration.getText().toString().isEmpty()){
                    duration.setError("Required Filled");
                    return;
                }
                if(position.getText().toString().isEmpty()){
                    position.setError("Required Filled");
                    return;
                }

                if(q1.getText().toString().isEmpty()){
                    q1.setError("Required Filled");
                    return;
                }
                if(q2.getText().toString().isEmpty()){
                    q2.setError("Required Filled");
                    return;
                }
                if(q3.getText().toString().isEmpty()){
                    q3.setError("Required Filled");
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

        String fullname =sharedPref.getString("key 1","");
        String age =sharedPref.getString("key 2","");
        String contact =sharedPref.getString("key 3","");
        String address =sharedPref.getString("key 4","");
        String gender =sharedPref.getString("key 5","");

        dataaccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String fname = (""+fullname);
                String fage = (""+age);
                String fcontact =(""+contact);
                String faddress = (""+address);
                String fgender = (""+gender);
                String ftranspo = typeoftranspo.getText().toString();
                String froute = route.getText().toString();

                String flocation = location.getText().toString();
                String fduration=duration.getText().toString();
                String fposition=position.getText().toString();

                String fq1 =q1.getText().toString();
                String fq2 = q2.getText().toString();
                String fq3 = q3.getText().toString();

                SharedPreferences.Editor editor = sharedPref.edit();

                editor.putString("key 1",fname);
                editor.commit();

                root = FirebaseDatabase.getInstance();
                ref = root.getReference("Registry");
                basicinfohelperclass basicinfohelperclass = new basicinfohelperclass(fname,fage,fcontact,faddress,fgender,ftranspo,froute,flocation,fduration,fposition,fq1,fq2,fq3);
                ref.push().child(fullname).setValue(basicinfohelperclass);

                Intent intent = new Intent(HealthInfo.this, enddashboard.class);
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