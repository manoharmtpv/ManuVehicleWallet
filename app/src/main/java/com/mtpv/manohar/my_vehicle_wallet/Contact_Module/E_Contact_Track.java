package com.mtpv.manohar.my_vehicle_wallet.Contact_Module;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

import com.mtpv.manohar.my_vehicle_wallet.Aadhar_Module.Aadhar_Track;
import com.mtpv.manohar.my_vehicle_wallet.Aadhar_Module.Chargesheet_history_Aadhar;
import com.mtpv.manohar.my_vehicle_wallet.Aadhar_Module.Couselling_history_Aadhar;
import com.mtpv.manohar.my_vehicle_wallet.Aadhar_Module.Ghmc402_history_Aadhar;
import com.mtpv.manohar.my_vehicle_wallet.Aadhar_Module.Impressionement_history_Aadhar;
import com.mtpv.manohar.my_vehicle_wallet.Aadhar_Module.MapsTrack_Aadhar;
import com.mtpv.manohar.my_vehicle_wallet.Aadhar_Module.Pettycase_history_Aadhar;
import com.mtpv.manohar.my_vehicle_wallet.Aadhar_Module.Seizure_history_Aadhar;
import com.mtpv.manohar.my_vehicle_wallet.R;

public class E_Contact_Track extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;


    private ViewPager mViewPager;
    public  static  String Tabflag=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e__contact__track);

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
        getMenuInflater().inflate(R.menu.menu_e__contact__track, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_e__contact__track, container, false);
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
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position) {
                case 0:
                    Contact_Track contact_track = new Contact_Track();
                    Tabflag = "CT";
                    return contact_track;
                case 1:
                    MapsTrack_Contact mapsTrack_contact = new MapsTrack_Contact();
                    Tabflag = "MPT";

                    return mapsTrack_contact;
                case 2:
                    Chargesheet_history_Contact chargesheet_history_contact = new Chargesheet_history_Contact();
                    Tabflag = "CSHT";
                    return chargesheet_history_contact;
                case 3:
                    Couselling_history_Contact couselling_history_contact = new Couselling_history_Contact();
                    Tabflag = "COHT";
                    return couselling_history_contact;
                case 4:
                    Impressionement_history_Contact impressionement_history_contact = new Impressionement_history_Contact();
                    Tabflag = "IMHT";
                    return impressionement_history_contact;

                case 5:
                    Seizure_history_Contact seizure_history_contact = new Seizure_history_Contact();
                    Tabflag = "SEIHT";
                    return seizure_history_contact;
                case 6:
                    Pettycase_history_Contact pettycase_history_contact = new Pettycase_history_Contact();
                    Tabflag = "PTHT";
                    return pettycase_history_contact;
                case 7:
                    Ghmc402_history_Contact ghmc402_history_contact = new Ghmc402_history_Contact();
                    Tabflag = "GHMCHT";
                    return ghmc402_history_contact;

            }

            return null;
        }
        @Override
        public int getCount() {
            // Show 8 total pages.
            return 8;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Contact Details";
                case 1:
                    return "Maps";
                case 2:
                    return "Charge Sheet History";
                case 3:
                    return "Counselling History";
                case 4:
                    return "Impressionment History";
                case 5:
                    return "Seizure History";
                case 6:
                    return "PettyCase History";
                case 7:
                    return "GHMC402 History";


            }
            return null;
        }
    }
}
