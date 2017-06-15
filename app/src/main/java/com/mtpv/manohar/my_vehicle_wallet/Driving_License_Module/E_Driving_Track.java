package com.mtpv.manohar.my_vehicle_wallet.Driving_License_Module;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.mtpv.manohar.my_vehicle_wallet.Contact_Module.Couselling_history_Contact;
import com.mtpv.manohar.my_vehicle_wallet.Vehcle_Module.Chargesheet_history_vehicle;
import com.mtpv.manohar.my_vehicle_wallet.Vehcle_Module.Couselling_history_vehicle;
import com.mtpv.manohar.my_vehicle_wallet.Vehcle_Module.Impressionement_history_vehicle;
import com.mtpv.manohar.my_vehicle_wallet.Vehcle_Module.MapsTrack_vehicle;
import com.mtpv.manohar.my_vehicle_wallet.R;
import com.mtpv.manohar.my_vehicle_wallet.Vehcle_Module.Vehicle_Track;

public class E_Driving_Track extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;
    public  static  String Tabflag=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e__driving__track);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_e__driving__track, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_e__driving__track, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

            @Override
            public Fragment getItem(int position){
                // getItem is called to instantiate the fragment for the given page.
                // Return a PlaceholderFragment (defined as a static inner class below).
                switch (position) {
                    case 0:
                        License_Track license_track = new License_Track();
                        Tabflag = "VT";
                        return license_track;
                    case 1:
                        MapsTrack_dl mapsTrack_dl = new MapsTrack_dl();
                        Tabflag = "MPT";

                        return mapsTrack_dl;
                    case 2:
                        Chargesheet_history_dl chargesheet_history_dl = new Chargesheet_history_dl();
                        Tabflag = "CSHT";
                        return chargesheet_history_dl;
                    case 3:
                        Couselling_history_dl couselling_history_dl = new Couselling_history_dl();
                        Tabflag = "COHT";
                        return couselling_history_dl;
                    case 4:
                        Impressionement_history_dl impressionement_history_dl = new Impressionement_history_dl();
                        Tabflag = "IMHT";
                        return impressionement_history_dl;

                }

                return null;

        }

        @Override
        public int getCount() {
            // Show 5 total pages.
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Driving License Details";
                case 1:
                    return "Maps";
                case 2:
                    return "Charge Sheet History";
                case 3:
                    return "Counselling History";
                case 4:
                    return "Impressionment History";
            }
            return null;
        }
    }
}
