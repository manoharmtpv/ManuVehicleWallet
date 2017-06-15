package com.mtpv.manohar.my_vehicle_wallet.Aadhar_Module;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.mtpv.manohar.my_vehicle_wallet.Aadhar_info;
import com.mtpv.manohar.my_vehicle_wallet.R;
import com.mtpv.manohar.my_vehicle_wallet.Services.ServiceHelper;
import com.mtpv.manohar.my_vehicle_wallet.Vehicle_Wallet_Login;
import com.mtpv.manohar.my_vehicle_wallet.model.AadharDetailsPojo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by MANOHAR on 6/13/2017.
 */

public class Aadhar_Track extends Fragment {

    EditText Ed_Aadharno;
    // String usertype=null;
    String aadharno=null;
    TextView tv_adhar_no,tv_name,tv_dob,tv_gender,tv_f_name,tv_address1,tv_address2,tv_address3,tv_address4,
            tv_address5,tv_address6;
    ImageView img_canditate,img_qr_code;
    LinearLayout layout_zoom;
    public final static int QRcodeWidth = 500 ;
    Bitmap bitmap ;
    Thread thread ;

    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.aadhar_details_tab, container, false);

      //  layout_zoom.setVisibility(View.VISIBLE);
        Register();


        try {

            tv_name.setText(Aadhar_info.aadharDetailsPojo.getName());
            tv_adhar_no.setText(Aadhar_info.aadharDetailsPojo.getUID());
            tv_dob.setText(Aadhar_info.aadharDetailsPojo.getDOB());
            tv_f_name.setText(Aadhar_info.aadharDetailsPojo.getCareOf());
            tv_address1.setText(Aadhar_info.aadharDetailsPojo.getStreet());
            tv_address2.setText(Aadhar_info.aadharDetailsPojo.getBildingName());
            tv_address3.setText(Aadhar_info.aadharDetailsPojo.getVillage());
            tv_address4.setText(Aadhar_info.aadharDetailsPojo.getMandal());
            tv_address5.setText(Aadhar_info.aadharDetailsPojo.getDistrict());
            tv_address6.setText(Aadhar_info.aadharDetailsPojo.getPinCode());


            try {
                if(!Aadhar_info.aadhardetails.equalsIgnoreCase("")||!Aadhar_info.aadhardetails.equalsIgnoreCase("NA")) {
                    bitmap = TextToImageEncode(Aadhar_info.aadhardetails);
                    img_qr_code.setImageBitmap(bitmap);
                }

            } catch (WriterException e) {
                e.printStackTrace();
            }

            if (!Aadhar_info.aadharDetailsPojo.getAadhaarPhoto().equalsIgnoreCase("NA")) {

                byte[] decodestring = Base64.decode("" + Aadhar_info.aadharDetailsPojo.getAadhaarPhoto().toString().trim(), Base64.DEFAULT);
                Bitmap decocebyte = BitmapFactory.decodeByteArray(decodestring, 0, decodestring.length);
                img_canditate.setImageBitmap(decocebyte);
            } else {
                img_canditate.setImageResource(R.drawable.photo);

            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return rootView;
    }


    void showtoast(String title ,String Message)
    {
        LayoutInflater inflator=getActivity().getLayoutInflater();
        View toastlayout=inflator.inflate(R.layout.my_toast,(ViewGroup)rootView.findViewById(R.id.toast_root_view));
        TextView toast_header=(TextView)toastlayout.findViewById(R.id.toast_header);
        toast_header.setText(title);
        TextView toast_body=(TextView)toastlayout.findViewById(R.id.toast_body);
        toast_body.setText(Message);
        Toast toast=new Toast(getActivity());
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


    void Register() {
        tv_adhar_no = (TextView) rootView.findViewById(R.id.tv_adhar_no);
        tv_name = (TextView) rootView.findViewById(R.id.tv_name);
        tv_dob = (TextView) rootView.findViewById(R.id.tv_dob);
        tv_gender = (TextView) rootView.findViewById(R.id.tv_gender);
        tv_f_name = (TextView) rootView.findViewById(R.id.tv_f_name);
        tv_address1 = (TextView) rootView.findViewById(R.id.tv_address1);
        tv_address2 = (TextView) rootView.findViewById(R.id.tv_address2);
        tv_address3 = (TextView) rootView.findViewById(R.id.tv_address3);
        tv_address4 = (TextView) rootView.findViewById(R.id.tv_address4);
        tv_address5 = (TextView) rootView.findViewById(R.id.tv_address5);
        tv_address6 = (TextView) rootView.findViewById(R.id.tv_address6);
    }


}
