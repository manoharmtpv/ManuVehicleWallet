package com.mtpv.manohar.my_vehicle_wallet.Driving_License_Module;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mtpv.manohar.my_vehicle_wallet.R;

/**
 * Created by MANOHAR on 6/13/2017.
 */

public class MapsTrack_dl extends Fragment {

    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.pendinghistory_vehicle, container, false);

        return rootView;
    }
}
