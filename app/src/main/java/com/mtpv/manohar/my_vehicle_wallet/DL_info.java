package com.mtpv.manohar.my_vehicle_wallet;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mtpv.manohar.my_vehicle_wallet.Driving_License_Module.E_Driving_Track;
import com.mtpv.manohar.my_vehicle_wallet.Services.ServiceHelper;
import com.mtpv.manohar.my_vehicle_wallet.Vehcle_Module.E_Vehicle_track_Tab;
import com.mtpv.manohar.my_vehicle_wallet.model.DLDetailsPojos;
import com.mtpv.manohar.my_vehicle_wallet.model.Rc_Details_Pojo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DL_info extends AppCompatActivity {


    EditText Ed_dlno;
    public static DLDetailsPojos dldetailsPojos;
    String dlno=null;
    ImageView Img_dlimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dl_info);
      //  usertype=getIntent().getStringExtra("usertypeKEY");

        Ed_dlno=(EditText)findViewById(R.id.Ed_dlno);

        Ed_dlno.setText("TS00920170001974");



        Img_dlimage=(ImageView)findViewById(R.id.Img_dlimage);



        Button Btn_dldetails=(Button)findViewById(R.id.Btn_dldetails);

        Btn_dldetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (Ed_dlno.getText().toString().trim().equals("")) {
//                    edit_id.setError(Html.fromHtml("<font color='red'>Please Enter Id!</font>"));

                    showtoast("Validation","Please fill the Field to continue");
                    Ed_dlno.requestFocus();
                }

                else {
                    dlno=Ed_dlno.getText().toString();

                    DLdetails dLdetails=new DLdetails();
                    dLdetails.execute();



                }
            }
        });


    }


    public class DLdetails extends AsyncTask<String, Void, String> {

        ProgressDialog dialog;

        protected void onPreExecute() {
            dialog = new ProgressDialog(DL_info.this);
            dialog.setTitle("Getting DL Details");
            dialog.setMessage("Please wait....");
            dialog.setCancelable(false);
            dialog.show();
        }


        @Override
        protected String doInBackground(String... params) {

            String response = ServiceHelper.DLDetails(dlno,Vehicle_Wallet_Login.usertype);

            if(!response.equalsIgnoreCase("NA")) {

                try {

                    JSONObject jsonObj = new JSONObject(response);
                    // Getting JSON Array node
                    JSONArray jsonArray = jsonObj.getJSONArray("DLDetails");
                    // looping through All Witness
                    for (int i = 0, size = jsonArray.length(); i < size; i++) {
                        JSONObject c = jsonArray.getJSONObject(i);

                        dldetailsPojos = new DLDetailsPojos();

                        dldetailsPojos.setLicense_No(c.getString("License_No"));
                        dldetailsPojos.setOffice_Code(c.getString("Office_Code"));
                        dldetailsPojos.setName(c.getString("Name"));
                        dldetailsPojos.setPG_Name(c.getString("PG_Name"));
                        dldetailsPojos.setDOB(c.getString("DOB"));
                        dldetailsPojos.setAddress(c.getString("Address"));
                        dldetailsPojos.setCity(c.getString("City"));
                        dldetailsPojos.setMandal(c.getString("Mandal"));
                        dldetailsPojos.setState(c.getString("State"));
                        dldetailsPojos.setGender(c.getString("Gender"));
                        dldetailsPojos.setBlood_Group(c.getString("Blood_Group"));
                        dldetailsPojos.setFirstIssue_Date(c.getString("FirstIssue_Date"));
                        dldetailsPojos.setNT_Validity(c.getString("NT_Validity"));
                        dldetailsPojos.setTR_Validity(c.getString("TR_Validity"));
                        dldetailsPojos.setHZRD_Validity(c.getString("HZRD_Validity"));
                        dldetailsPojos.setNT_COV(c.getString("NT_COV"));
                        dldetailsPojos.setTR_COV(c.getString("TR_COV"));
                        dldetailsPojos.setBadge_No(c.getString("Badge_No"));
                        dldetailsPojos.setMobile_Number(c.getString("Mobile_Number"));
                        dldetailsPojos.setApplicant_Photo(c.getString("Applicant_Photo"));
                    }




                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return response;

        }
        @Override
        protected void onPostExecute(String result) {
            dialog.dismiss();


            if(!result.equalsIgnoreCase("NA")) {
                Intent i = new Intent(DL_info.this, E_Driving_Track.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }else
            {
                showtoast("Service Validation","Something Went Wrong With Service Please try again later");
            }


        }

    }

//    void Register()
//    {
//        Tv_bloodgroup=(TextView)findViewById(R.id.Tv_bloodgroup);
//        Tv_dob=(TextView)findViewById(R.id.Tv_dob);
//        Tv_La=(TextView)findViewById(R.id.Tv_La);
//        Tv_refno=(TextView)findViewById(R.id.Tv_refno);
//        Tv_badgeno=(TextView)findViewById(R.id.Tv_badgeno);
//        Tv_firstissue=(TextView)findViewById(R.id.Tv_firstissue);
//        Tv_validitytans=(TextView)findViewById(R.id.Tv_validitytans);
//        Tv_trans=(TextView)findViewById(R.id.Tv_trans);
//        Tv_licenseauth=(TextView)findViewById(R.id.Tv_licenseauth);
//        Tv_issuedon=(TextView)findViewById(R.id.Tv_issuedon);
//        Tv_add=(TextView)findViewById(R.id.Tv_add);
//        Tv_fname=(TextView)findViewById(R.id.Tv_fname);
//        Tv_name=(TextView)findViewById(R.id.Tv_name);
//        Tv_rcno=(TextView)findViewById(R.id.Tv_rcno);
//    }


    void showtoast(String title ,String Message)
    {
        LayoutInflater inflator=getLayoutInflater();
        View toastlayout=inflator.inflate(R.layout.my_toast,(ViewGroup)findViewById(R.id.toast_root_view));
        TextView toast_header=(TextView)toastlayout.findViewById(R.id.toast_header);
        toast_header.setText(title);
        TextView toast_body=(TextView)toastlayout.findViewById(R.id.toast_body);
        toast_body.setText(Message);
        Toast toast=new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(toast.LENGTH_LONG);
        toast.setView(toastlayout);
        toast.show();
    }
}
