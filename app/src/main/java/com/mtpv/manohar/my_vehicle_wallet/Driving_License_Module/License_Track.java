package com.mtpv.manohar.my_vehicle_wallet.Driving_License_Module;

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

import com.mtpv.manohar.my_vehicle_wallet.DL_info;
import com.mtpv.manohar.my_vehicle_wallet.R;
import com.mtpv.manohar.my_vehicle_wallet.Services.ServiceHelper;
import com.mtpv.manohar.my_vehicle_wallet.Vehicle_Wallet_Login;
import com.mtpv.manohar.my_vehicle_wallet.model.DLDetailsPojos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by MANOHAR on 6/13/2017.
 */

public class License_Track extends Fragment {


    View rootView;
    TextView Tv_bloodgroup,Tv_dob,Tv_firstissue,Tv_La,Tv_refno,Tv_badgeno,Tv_validitytans,Tv_trans,Tv_licenseauth,Tv_issuedon,
            Tv_add,Tv_fname,Tv_name,Tv_rcno;
    LinearLayout LinearLayout2;
    ImageView Img_dlimage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.dl_details_tab, container, false);

        Register();


        try {
            Tv_add.setText(DL_info.dldetailsPojos.getAddress());
            Tv_badgeno.setText(DL_info.dldetailsPojos.getBadge_No());
            Tv_bloodgroup.setText(DL_info.dldetailsPojos.getBlood_Group());
            Tv_dob.setText(DL_info.dldetailsPojos.getDOB());
            Tv_firstissue.setText(DL_info.dldetailsPojos.getFirstIssue_Date());
            Tv_fname.setText(DL_info.dldetailsPojos.getPG_Name());
            Tv_issuedon.setText(DL_info.dldetailsPojos.getNT_Validity());
            Tv_La.setText(DL_info.dldetailsPojos.getState());
            Tv_licenseauth.setText(DL_info.dldetailsPojos.getState());
            Tv_name.setText(DL_info.dldetailsPojos.getName());
            Tv_rcno.setText(DL_info.dldetailsPojos.getLicense_No());
            Tv_refno.setText(DL_info.dldetailsPojos.getOffice_Code());
            Tv_trans.setText(DL_info.dldetailsPojos.getNT_COV());
            Tv_validitytans.setText(DL_info.dldetailsPojos.getNT_Validity());

            /******* start driving license image display ******/
            if (!DL_info.dldetailsPojos.getApplicant_Photo().equalsIgnoreCase("NA")) {

                byte[] decodestring = Base64.decode("" + DL_info.dldetailsPojos.getApplicant_Photo().toString().trim(), Base64.DEFAULT);
                Bitmap decocebyte = BitmapFactory.decodeByteArray(decodestring, 0, decodestring.length);
                Img_dlimage.setImageBitmap(decocebyte);
            } else {
                Img_dlimage.setImageResource(R.drawable.photo);

            }
            /******* end driving license image display ******/


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



    void Register()
    {
        Tv_bloodgroup=(TextView)rootView.findViewById(R.id.Tv_bloodgroup);
        Tv_dob=(TextView)rootView.findViewById(R.id.Tv_dob);
        Tv_La=(TextView)rootView.findViewById(R.id.Tv_La);
        Tv_refno=(TextView)rootView.findViewById(R.id.Tv_refno);
        Tv_badgeno=(TextView)rootView.findViewById(R.id.Tv_badgeno);
        Tv_firstissue=(TextView)rootView.findViewById(R.id.Tv_firstissue);
        Tv_validitytans=(TextView)rootView.findViewById(R.id.Tv_validitytans);
        Tv_trans=(TextView)rootView.findViewById(R.id.Tv_trans);
        Tv_licenseauth=(TextView)rootView.findViewById(R.id.Tv_licenseauth);
        Tv_issuedon=(TextView)rootView.findViewById(R.id.Tv_issuedon);
        Tv_add=(TextView)rootView.findViewById(R.id.Tv_add);
        Tv_fname=(TextView)rootView.findViewById(R.id.Tv_fname);
        Tv_name=(TextView)rootView.findViewById(R.id.Tv_name);
        Tv_rcno=(TextView)rootView.findViewById(R.id.Tv_rcno);
    }

}
