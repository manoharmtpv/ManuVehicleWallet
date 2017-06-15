package com.mtpv.manohar.my_vehicle_wallet.Vehcle_Module;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mtpv.manohar.my_vehicle_wallet.R;

/**
 * Created by MANOHAR on 6/13/2017.
 */

public class Chargesheet_history_vehicle extends Fragment {

    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.pendinghistory_vehicle, container, false);

        return rootView;
    }
}
