package com.mtpv.manohar.my_vehicle_wallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Complaints_register extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    String[] TypesofComplaints={"RTA","INSURANCE","REGISTRATION",};
    //String usertype=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaints_register);
      //  usertype=getIntent().getStringExtra("usertypeKEY");


        Spinner spin = (Spinner) findViewById(R.id.simpleSpinner);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,TypesofComplaints);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

        Button Btn_newregister=(Button)findViewById(R.id.Btn_newregister);

        Btn_newregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Complaints_register.this,Newcompliant_Insurance.class);
             //   i.putExtra("usertypeKEY",usertype);
                startActivity(i);

            }
        });

        Button Btn_oldstatus=(Button)findViewById(R.id.Btn_oldstatus);

        Btn_oldstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Complaints_register.this,ComplaintsServices.class);
              //  i.putExtra("usertypeKEY",usertype);
                startActivity(i);
            }
        });

    }
     @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(), TypesofComplaints[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
// TODO Auto-generated method stub

    }
}
