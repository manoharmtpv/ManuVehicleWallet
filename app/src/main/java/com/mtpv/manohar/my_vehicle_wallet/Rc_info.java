package com.mtpv.manohar.my_vehicle_wallet;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mtpv.manohar.my_vehicle_wallet.Driving_License_Module.E_Driving_Track;
import com.mtpv.manohar.my_vehicle_wallet.Services.ServiceHelper;
import com.mtpv.manohar.my_vehicle_wallet.Vehcle_Module.E_Vehicle_track_Tab;
import com.mtpv.manohar.my_vehicle_wallet.model.Rc_Details_Pojo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Rc_info extends AppCompatActivity {

    EditText Ed_regno,Ed_chasis;
    String regno=null,chasis=null;
   // String usertype=null;
    TextView Tv_signofauthority,Tv_sign,Tv_hypo,Tv_tax,Tv_regvalidity,Tv_dateofreg,Tv_color,Tv_weight,Tv_seatingcapacity,Tv_wheelbase,Tv_cubiccapacity,Tv_engineno,Tv_chasisnum,
            Tv_fuel,Tv_manufacturedate,Tv_vehicleclass,Tv_makersclass,Tv_address,Tv_fathername,Tv_ownername,Tv_regnum;

    LinearLayout LinearLayout1;
    public static Rc_Details_Pojo rc_details_pojo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcinfo);
      //  usertype=getIntent().getStringExtra("usertypeKEY");



        Ed_regno=(EditText)findViewById(R.id.Ed_regno);
        Ed_chasis=(EditText)findViewById(R.id.Ed_chasis);

         LinearLayout1=(LinearLayout)findViewById(R.id.LinearLayout1);

        LinearLayout1.setVisibility(View.INVISIBLE);

        Button Btn_rcdetails=(Button)findViewById(R.id.Btn_rcdetails);

        Btn_rcdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Ed_regno.getText().toString().trim().equals("")) {
//                    edit_id.setError(Html.fromHtml("<font color='red'>Please Enter Id!</font>"));

                    showtoast("Validation","Please fill the Field to continue");
                    Ed_regno.requestFocus();
                }

                else {
                    regno=Ed_regno.getText().toString();
                    chasis=Ed_chasis.getText().toString();

                    Rcdetails rc=new Rcdetails();
                    rc.execute();

                }
            }
        });


    }


    public class Rcdetails extends AsyncTask<String, Void, String> {

        ProgressDialog dialog;

        protected void onPreExecute() {
            dialog = new ProgressDialog(Rc_info.this);
            dialog.setTitle("Getting RC Details");
            dialog.setMessage("Please wait....");
            dialog.setCancelable(false);
            dialog.show();
        }


        @Override
        protected String doInBackground(String... params) {

            String response = ServiceHelper.vehicleDetails(regno,Vehicle_Wallet_Login.usertype);

            if(!response.equalsIgnoreCase("NA")) {

                try {

                    JSONObject jsonObj = new JSONObject(response);
                    // Getting JSON Array node
                    JSONArray jsonArray = jsonObj.getJSONArray("RTAddress");
                    // looping through All Witness
                    for (int i = 0, size = jsonArray.length(); i < size; i++) {
                        JSONObject c = jsonArray.getJSONObject(i);

                         rc_details_pojo=new Rc_Details_Pojo();

                        rc_details_pojo.setAadharNo(c.getString("AadharNo"));
                        rc_details_pojo.setAddress(c.getString("Address"));
                        rc_details_pojo.setApproved_Date(c.getString("Approved_Date"));
                        rc_details_pojo.setBody_Type(c.getString("Body_Type"));
                        rc_details_pojo.setCC(c.getString("CC"));
                        rc_details_pojo.setChassis_No(c.getString("Chassis_No"));
                        rc_details_pojo.setCity(c.getString("City"));
                        rc_details_pojo.setColor(c.getString("Color"));
                        rc_details_pojo.setCylinder(c.getString("Cylinder"));
                        rc_details_pojo.setDistrict(c.getString("District"));
                        rc_details_pojo.setAddress(c.getString("Address"));
                        rc_details_pojo.setDOB(c.getString("DOB"));
                        rc_details_pojo.setEmailId(c.getString("EmailId"));
                        rc_details_pojo.setEngine_No(c.getString("Engine_No"));
                        rc_details_pojo.setFC_NUMBER(c.getString("FC_NUMBER"));
                        rc_details_pojo.setFC_Validity(c.getString("FC_Validity"));
                        rc_details_pojo.setFinancer_City(c.getString("Financer_City"));
                        rc_details_pojo.setFinancer_FrDate(c.getString("Financer_FrDate"));
                        rc_details_pojo.setFinancer_State(c.getString("Financer_State"));
                        rc_details_pojo.setFinancerAddress(c.getString("FinancerAddress"));
                        rc_details_pojo.setFinancerName(c.getString("FinancerName"));
                        rc_details_pojo.setFirst_Issue_Date(c.getString("First_Issue_Date"));
                        rc_details_pojo.setFuel(c.getString("Fuel"));
                        rc_details_pojo.setVehicleType(c.getString("VehicleType"));
                        rc_details_pojo.setVehicle_Class(c.getString("Vehicle_Class"));
                        rc_details_pojo.setVehicle_ClassID(c.getString("Vehicle_ClassID"));
                        rc_details_pojo.setValid_Upto(c.getString("Valid_Upto"));
                        rc_details_pojo.setTR_Number(c.getString("TR_Number"));
                        rc_details_pojo.setTheftFlag(c.getString("TheftFlag"));
                        rc_details_pojo.setTax_Validity(c.getString("Tax_Validity"));
                        rc_details_pojo.setSuspension_To(c.getString("Suspension_To"));
                        rc_details_pojo.setVehicleType(c.getString("VehicleType"));
                        rc_details_pojo.setSuspension_From(c.getString("Suspension_From"));
                        rc_details_pojo.setValid_Upto(c.getString("Valid_Upto"));
                        rc_details_pojo.setInsurance_Cmpy_Name(c.getString("Insurance_Cmpy_Name"));
                        rc_details_pojo.setInsurance_No(c.getString("Insurance_No"));
                        rc_details_pojo.setInsurance_Validity(c.getString("Insurance_Validity"));
                        rc_details_pojo.setIsFinanced(c.getString("IsFinanced"));
                        rc_details_pojo.setIssuePlace(c.getString("IssuePlace"));
                        rc_details_pojo.setMake_Yr(c.getString("Make_Yr"));
                        rc_details_pojo.setMaker_Name(c.getString("Maker_Name"));
                        rc_details_pojo.setMandal(c.getString("Mandal"));
                        rc_details_pojo.setModel_Desc(c.getString("Model_Desc"));
                        rc_details_pojo.setOwner_FrDate(c.getString("Owner_FrDate"));
                        rc_details_pojo.setOwner_Name(c.getString("Owner_Name"));
                        rc_details_pojo.setOffice_Code(c.getString("Office_Code"));
                        rc_details_pojo.setOwner_Photo(c.getString("Owner_Photo"));
                        rc_details_pojo.setOld_Regn_No(c.getString("Old_Regn_No"));
                        rc_details_pojo.setOwner_Thumb(c.getString("Owner_Thumb"));
                        rc_details_pojo.setPG_Name(c.getString("PG_Name"));
                        rc_details_pojo.setTheftFlag(c.getString("TheftFlag"));
                        rc_details_pojo.setPERMITNO(c.getString("PERMITNO"));
                        rc_details_pojo.setPIN(c.getString("PIN"));
                        rc_details_pojo.setSeat_Capacity(c.getString("Seat_Capacity"));
                        rc_details_pojo.setRegn_No(c.getString("Regn_No"));



                    }
                    Log.i("RC--->", "" + rc_details_pojo.toString());


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return response;

        }
        @Override
        protected void onPostExecute(String result) {
            dialog.dismiss();

//            LinearLayout1.setVisibility(View.VISIBLE);
//            Register();
//
//            try {
//
//                Tv_ownername.setText(rc_details_pojo.getOwner_Name());
//                Tv_fathername.setText(rc_details_pojo.getPG_Name());
//                Tv_address.setText(rc_details_pojo.getAddress());
//                Tv_chasisnum.setText(rc_details_pojo.getChassis_No());
//                Tv_color.setText(rc_details_pojo.getColor());
//                Tv_cubiccapacity.setText(rc_details_pojo.getCC());
//                Tv_dateofreg.setText(rc_details_pojo.getFirst_Issue_Date());
//                Tv_engineno.setText(rc_details_pojo.getEngine_No());
//                Tv_fuel.setText(rc_details_pojo.getFuel());
//                Tv_hypo.setText(rc_details_pojo.getMaker_Name());
//                Tv_makersclass.setText(rc_details_pojo.getVehicle_Class());
//                Tv_manufacturedate.setText(rc_details_pojo.getMake_Yr());
//                Tv_regnum.setText(rc_details_pojo.getRegn_No());
//                Tv_regvalidity.setText(rc_details_pojo.getValid_Upto());
//                Tv_seatingcapacity.setText(rc_details_pojo.getSeat_Capacity());
//                Tv_tax.setText(rc_details_pojo.getTax_Validity());
//                Tv_vehicleclass.setText(rc_details_pojo.getVehicle_Class());
//                Tv_weight.setText(rc_details_pojo.getSeat_Capacity());
//                Tv_engineno.setText(rc_details_pojo.getEngine_No());
//                Tv_fuel.setText(rc_details_pojo.getFuel());
//                Tv_wheelbase.setText(rc_details_pojo.getVehicleType());
//
//
//
//            }catch (Exception e)
//            {
//                e.printStackTrace();
//            }


            if(!result.equalsIgnoreCase("NA")) {
                Intent i = new Intent(Rc_info.this, E_Vehicle_track_Tab.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }else
            {
                showtoast("Service Validation","Something Went Wrong With Service Please try again later");
            }

        }

    }

    void Register()
    {
        Tv_signofauthority=(TextView)findViewById(R.id.Tv_signofauthority);
        Tv_sign=(TextView)findViewById(R.id.Tv_sign);
        Tv_hypo=(TextView)findViewById(R.id.Tv_hypo);
        Tv_tax=(TextView)findViewById(R.id.Tv_tax);
        Tv_regvalidity=(TextView)findViewById(R.id.Tv_regvalidity);
        Tv_dateofreg=(TextView)findViewById(R.id.Tv_dateofreg);
        Tv_color=(TextView)findViewById(R.id.Tv_color);
        Tv_weight=(TextView)findViewById(R.id.Tv_weight);
        Tv_seatingcapacity=(TextView)findViewById(R.id.Tv_seatingcapacity);
        Tv_wheelbase=(TextView)findViewById(R.id.Tv_wheelbase);
        Tv_cubiccapacity=(TextView)findViewById(R.id.Tv_cubiccapacity);
        Tv_engineno=(TextView)findViewById(R.id.Tv_engineno);
        Tv_chasisnum=(TextView)findViewById(R.id.Tv_chasisnum);
        Tv_fuel=(TextView)findViewById(R.id.Tv_fuel);
        Tv_manufacturedate=(TextView)findViewById(R.id.Tv_manufacturedate);
        Tv_vehicleclass=(TextView)findViewById(R.id.Tv_vehicleclass);
        Tv_makersclass=(TextView)findViewById(R.id.Tv_makersclass);
        Tv_address=(TextView)findViewById(R.id.Tv_address);
        Tv_fathername=(TextView)findViewById(R.id.Tv_fathername);
        Tv_ownername=(TextView)findViewById(R.id.Tv_ownername);
        Tv_regnum=(TextView)findViewById(R.id.Tv_regnum);
    }

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
