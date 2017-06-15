package com.mtpv.manohar.my_vehicle_wallet;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
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

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.mtpv.manohar.my_vehicle_wallet.Aadhar_Module.E_Aadhar_Track;
import com.mtpv.manohar.my_vehicle_wallet.Services.ServiceHelper;
import com.mtpv.manohar.my_vehicle_wallet.Vehcle_Module.E_Vehicle_track_Tab;
import com.mtpv.manohar.my_vehicle_wallet.model.AadharDetailsPojo;
import com.mtpv.manohar.my_vehicle_wallet.model.DLDetailsPojos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Aadhar_info extends AppCompatActivity {

    EditText Ed_Aadharno;
   // String usertype=null;
    String aadharno=null;
    public static AadharDetailsPojo aadharDetailsPojo;
    TextView tv_adhar_no,tv_name,tv_dob,tv_gender,tv_f_name,tv_address1,tv_address2,tv_address3,tv_address4,
            tv_address5,tv_address6;
    ImageView img_canditate,img_qr_code;
    LinearLayout layout_zoom;
    public final static int QRcodeWidth = 500 ;
    Bitmap bitmap ;
    Thread thread ;

    public static String aadhardetails=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aadhar_info);

       // usertype=getIntent().getStringExtra("usertypeKEY");

        Ed_Aadharno=(EditText)findViewById(R.id.Ed_Aadharno);

        Ed_Aadharno.setText("781245417157");

        img_canditate=(ImageView)findViewById(R.id.img_canditate);
        img_qr_code=(ImageView)findViewById(R.id.img_qr_code);


        layout_zoom=(LinearLayout)findViewById(R.id.layout_zoom);
        layout_zoom.setVisibility(View.INVISIBLE);


        Button Btn_aadhardetails=(Button)findViewById(R.id.Btn_aadhardetails);

        Btn_aadhardetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                   if (Ed_Aadharno.getText().toString().trim().equals("")) {

                    showtoast("Validation","Please fill the Field to continue");
                    Ed_Aadharno.requestFocus();
                }

                else {
                       aadharno = Ed_Aadharno.getText().toString();
                       AADHARdetails aadhaRdetails = new AADHARdetails();
                       aadhaRdetails.execute();

                   }
            }
        });


    }


    public class AADHARdetails extends AsyncTask<String, Void, String> {

        ProgressDialog dialog;

        protected void onPreExecute() {
            dialog = new ProgressDialog(Aadhar_info.this);
            dialog.setTitle("Getting Aadhar Details");
            dialog.setMessage("Please wait....");
            dialog.setCancelable(false);
            dialog.show();
        }


        @Override
        protected String doInBackground(String... params) {

            String response = ServiceHelper.AAdharDetails(aadharno,Vehicle_Wallet_Login.usertype);

            if(!response.equalsIgnoreCase("NA")) {

                try {

                    JSONObject jsonObj = new JSONObject(response);
                    // Getting JSON Array node
                    JSONArray jsonArray = jsonObj.getJSONArray("AadhaarDetails");
                    int size = jsonArray.length();
                    // looping through All Witness
                    //for (int i = 0;i <size; i++) {

                        int i = 0;
                        while(i<size) {


                            JSONObject c = jsonArray.getJSONObject(i);

                            aadharDetailsPojo = new AadharDetailsPojo();

                            aadharDetailsPojo.setBildingName(c.getString("BildingName"));
                            aadharDetailsPojo.setCareOf(c.getString("CareOf"));
                            aadharDetailsPojo.setDistrict(c.getString("District"));
                            aadharDetailsPojo.setDOB(c.getString("DOB"));
                            aadharDetailsPojo.setEID(c.getString("EID"));
                            aadharDetailsPojo.setGender(c.getString("Gender"));
                            aadharDetailsPojo.setMandal(c.getString("Mandal"));
                            aadharDetailsPojo.setMobileNo(c.getString("MobileNo"));
                            aadharDetailsPojo.setName(c.getString("Name"));
                            aadharDetailsPojo.setStreet(c.getString("Street"));
                            aadharDetailsPojo.setUID(c.getString("UID"));
                            aadharDetailsPojo.setVillage(c.getString("Village"));
                            aadharDetailsPojo.setPinCode(c.getString("pinCode"));
                            aadharDetailsPojo.setAadhaarPhoto(c.getString("AadhaarPhoto"));


                            i++;
                            //  }
                        }

                    Log.d("Adhar......", aadharDetailsPojo.toString());


                } catch (JSONException e) {

                    e.getLocalizedMessage();
                    Log.i("aadhar--->", "" + e.toString());


                }
            }
            return response;

        }
        @Override
        protected void onPostExecute(String result) {
            dialog.dismiss();


            if(!result.equalsIgnoreCase("NA")) {

                aadhardetails=result;

                Intent i = new Intent(Aadhar_info.this, E_Aadhar_Track.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }else
            {
                showtoast("Service Validation","Something Went Wrong With Service Please try again later");
            }

        }

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

    Bitmap TextToImageEncode(String Value) throws WriterException {
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(
                    Value,
                    BarcodeFormat.DATA_MATRIX.QR_CODE,
                    QRcodeWidth, QRcodeWidth, null
            );

        } catch (IllegalArgumentException Illegalargumentexception) {

            return null;
        }
        int bitMatrixWidth = bitMatrix.getWidth();

        int bitMatrixHeight = bitMatrix.getHeight();

        int[] pixels = new int[bitMatrixWidth * bitMatrixHeight];

        for (int y = 0; y < bitMatrixHeight; y++) {
            int offset = y * bitMatrixWidth;

            for (int x = 0; x < bitMatrixWidth; x++) {

                pixels[offset + x] = bitMatrix.get(x, y) ?
                        getResources().getColor(R.color.navigationBarColor):getResources().getColor(R.color.textColorPrimary);
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);

        bitmap.setPixels(pixels, 0, 500, 0, 0, bitMatrixWidth, bitMatrixHeight);
        return bitmap;
    }

}
