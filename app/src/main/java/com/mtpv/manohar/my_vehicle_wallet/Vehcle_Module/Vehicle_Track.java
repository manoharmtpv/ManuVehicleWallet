package com.mtpv.manohar.my_vehicle_wallet.Vehcle_Module;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mtpv.manohar.my_vehicle_wallet.R;
import com.mtpv.manohar.my_vehicle_wallet.Rc_info;


/**
 * Created by MANOHAR on 6/13/2017.
 */

public class Vehicle_Track extends Fragment {

    TextView Tv_signofauthority,Tv_sign,Tv_hypo,Tv_tax,Tv_regvalidity,Tv_dateofreg,Tv_color,Tv_weight,Tv_seatingcapacity,Tv_wheelbase,Tv_cubiccapacity,Tv_engineno,Tv_chasisnum,
            Tv_fuel,Tv_manufacturedate,Tv_vehicleclass,Tv_makersclass,Tv_address,Tv_fathername,Tv_ownername,Tv_regnum;

    LinearLayout LinearLayout1;

    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.vehicle_details_tab, container, false);


      //  LinearLayout1.setVisibility(View.VISIBLE);
        Register();

        try {

            Tv_ownername.setText(Rc_info.rc_details_pojo.getOwner_Name());
            Tv_fathername.setText(Rc_info.rc_details_pojo.getPG_Name());
            Tv_address.setText(Rc_info.rc_details_pojo.getAddress());
            Tv_chasisnum.setText(Rc_info.rc_details_pojo.getChassis_No());
            Tv_color.setText(Rc_info.rc_details_pojo.getColor());
            Tv_cubiccapacity.setText(Rc_info.rc_details_pojo.getCC());
            Tv_dateofreg.setText(Rc_info.rc_details_pojo.getFirst_Issue_Date());
            Tv_engineno.setText(Rc_info.rc_details_pojo.getEngine_No());
            Tv_fuel.setText(Rc_info.rc_details_pojo.getFuel());
            Tv_hypo.setText(Rc_info.rc_details_pojo.getMaker_Name());
            Tv_makersclass.setText(Rc_info.rc_details_pojo.getVehicle_Class());
            Tv_manufacturedate.setText(Rc_info.rc_details_pojo.getMake_Yr());
            Tv_regnum.setText(Rc_info.rc_details_pojo.getRegn_No());
            Tv_regvalidity.setText(Rc_info.rc_details_pojo.getValid_Upto());
            Tv_seatingcapacity.setText(Rc_info.rc_details_pojo.getSeat_Capacity());
            Tv_tax.setText(Rc_info.rc_details_pojo.getTax_Validity());
            Tv_vehicleclass.setText(Rc_info.rc_details_pojo.getVehicle_Class());
            Tv_weight.setText(Rc_info.rc_details_pojo.getSeat_Capacity());
            Tv_engineno.setText(Rc_info.rc_details_pojo.getEngine_No());
            Tv_fuel.setText(Rc_info.rc_details_pojo.getFuel());
            Tv_wheelbase.setText(Rc_info.rc_details_pojo.getVehicleType());

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return rootView;
    }

    void Register()
    {
        Tv_signofauthority=(TextView)rootView.findViewById(R.id.Tv_signofauthority);
        Tv_sign=(TextView)rootView.findViewById(R.id.Tv_sign);
        Tv_hypo=(TextView)rootView.findViewById(R.id.Tv_hypo);
        Tv_tax=(TextView)rootView.findViewById(R.id.Tv_tax);
        Tv_regvalidity=(TextView)rootView.findViewById(R.id.Tv_regvalidity);
        Tv_dateofreg=(TextView)rootView.findViewById(R.id.Tv_dateofreg);
        Tv_color=(TextView)rootView.findViewById(R.id.Tv_color);
        Tv_weight=(TextView)rootView.findViewById(R.id.Tv_weight);
        Tv_seatingcapacity=(TextView)rootView.findViewById(R.id.Tv_seatingcapacity);
        Tv_wheelbase=(TextView)rootView.findViewById(R.id.Tv_wheelbase);
        Tv_cubiccapacity=(TextView)rootView.findViewById(R.id.Tv_cubiccapacity);
        Tv_engineno=(TextView)rootView.findViewById(R.id.Tv_engineno);
        Tv_chasisnum=(TextView)rootView.findViewById(R.id.Tv_chasisnum);
        Tv_fuel=(TextView)rootView.findViewById(R.id.Tv_fuel);
        Tv_manufacturedate=(TextView)rootView.findViewById(R.id.Tv_manufacturedate);
        Tv_vehicleclass=(TextView)rootView.findViewById(R.id.Tv_vehicleclass);
        Tv_makersclass=(TextView)rootView.findViewById(R.id.Tv_makersclass);
        Tv_address=(TextView)rootView.findViewById(R.id.Tv_address);
        Tv_fathername=(TextView)rootView.findViewById(R.id.Tv_fathername);
        Tv_ownername=(TextView)rootView.findViewById(R.id.Tv_ownername);
        Tv_regnum=(TextView)rootView.findViewById(R.id.Tv_regnum);
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
}
