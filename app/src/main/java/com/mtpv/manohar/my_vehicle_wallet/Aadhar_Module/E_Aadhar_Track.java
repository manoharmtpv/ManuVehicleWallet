package com.mtpv.manohar.my_vehicle_wallet.Aadhar_Module;

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

import com.mtpv.manohar.my_vehicle_wallet.R;

public class E_Aadhar_Track extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    public  static  String Tabflag=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aadhar__track);


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
        getMenuInflater().inflate(R.menu.menu_aadhar__track, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_aadhar__track, container, false);
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
                    Aadhar_Track license_track = new Aadhar_Track();
                    Tabflag = "LT";
                    return license_track;
                case 1:
                    MapsTrack_Aadhar mapsTrack_aadhar = new MapsTrack_Aadhar();
                    Tabflag = "MPT";

                    return mapsTrack_aadhar;
                case 2:
                    Chargesheet_history_Aadhar chargesheet_history_aadhar = new Chargesheet_history_Aadhar();
                    Tabflag = "CSHT";
                    return chargesheet_history_aadhar;
                case 3:
                    Couselling_history_Aadhar couselling_history_aadhar = new Couselling_history_Aadhar();
                    Tabflag = "COHT";
                    return couselling_history_aadhar;
                case 4:
                    Impressionement_history_Aadhar impressionement_history_aadhar = new Impressionement_history_Aadhar();
                    Tabflag = "IMHT";
                    return impressionement_history_aadhar;

                case 5:
                    Seizure_history_Aadhar seizure_history_aadhar = new Seizure_history_Aadhar();
                    Tabflag = "SEIHT";
                    return seizure_history_aadhar;
                case 6:
                    Pettycase_history_Aadhar pettycase_history_aadhar = new Pettycase_history_Aadhar();
                    Tabflag = "PTHT";
                    return pettycase_history_aadhar;
                case 7:
                    Ghmc402_history_Aadhar ghmc402_history_aadhar = new Ghmc402_history_Aadhar();
                    Tabflag = "GHMCHT";
                    return ghmc402_history_aadhar;

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
                    return "Aadhar Details";
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
