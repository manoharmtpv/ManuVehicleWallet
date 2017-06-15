package com.mtpv.manohar.my_vehicle_wallet;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mtpv.manohar.my_vehicle_wallet.Aadhar_Module.E_Aadhar_Track;
import com.mtpv.manohar.my_vehicle_wallet.Driving_License_Module.E_Driving_Track;
import com.mtpv.manohar.my_vehicle_wallet.RecyclerAdapters.WalletDisplay;
import com.mtpv.manohar.my_vehicle_wallet.Vehcle_Module.E_Vehicle_track_Tab;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

public class DashboardActivity extends AppCompatActivity {


    public int currentimageindex=0;
    ImageView slidingimage;
 //   String usertype=null,Username=null;
    private int[] IMAGE_IDS = {
            R.drawable.fir, R.drawable.sec, R.drawable.fir};
    TextView Tv_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        Tv_user=(TextView)findViewById(R.id.Tv_user);

        Tv_user.setText("Welcome"+" "+Vehicle_Wallet_Login.username);

        Button Btn_RC=(Button)findViewById(R.id.Btn_RC);

        Btn_RC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(DashboardActivity.this,Rc_info.class);
                startActivity(i);
            }
        });

        Button Btn_complaints=(Button)findViewById(R.id.Btn_complaints);

        Btn_complaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(DashboardActivity.this,ComplaintsSystemMenu.class);
                startActivity(i);



            }
        });

        Button Btn_aadhar=(Button)findViewById(R.id.Btn_aadhar);

        Btn_aadhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent i=new Intent(DashboardActivity.this,Aadhar_info.class);
                Intent i=new Intent(DashboardActivity.this,Aadhar_info.class);

                //  Intent i=new Intent(DashboardActivity.this,WalletDisplay.class);

                startActivity(i);
            }
        });


        Button Btn_DL=(Button)findViewById(R.id.Btn_DL);

        Btn_DL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Intent i=new Intent(DashboardActivity.this,DL_info.class);
                Intent i=new Intent(DashboardActivity.this,DL_info.class);

                // i.putExtra("usertypeKEY",usertype);
                startActivity(i);
               // finish();
            }
        });

        Button Btn_feedback=(Button)findViewById(R.id.Btn_feedback);

        Btn_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DashboardActivity.this,Feedback.class);
                startActivity(i);

            }
        });

        Button Btn_Pending=(Button)findViewById(R.id.Btn_Pending);

        Btn_Pending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(DashboardActivity.this,Pendindchallans_withTab.class);
//                i.putExtra("usertypeKEY",usertype);
//                i.putExtra("UsernameKEY",Username);

                startActivity(i);
            }
        });

        final Handler mHandler = new Handler();

        // Create runnable for posting
        final Runnable mUpdateResults = new Runnable() {
            public void run() {

                try
                {
                    AnimateandSlideShow();
                }catch(Exception e)
                {
                    e.printStackTrace();
                }

            }
        };

        try
        {
            int delay = 100; // delay for 1 sec.

            int period = 2500; // repeat every 2.5 sec.

            Timer timer = new Timer();

            timer.scheduleAtFixedRate(new TimerTask() {

                public void run() {

                    mHandler.post(mUpdateResults);

                }

            }, delay, period);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void AnimateandSlideShow() {


        try
        {
            slidingimage = (ImageView)findViewById(R.id.ImageView3_Left);
            slidingimage.setImageResource(IMAGE_IDS[currentimageindex%IMAGE_IDS.length]);

            currentimageindex++;

            Animation rotateimage = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);


            slidingimage.startAnimation(rotateimage);
        }catch(Exception e)
        {
            e.printStackTrace();
        }


    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {

                        Intent i=new Intent(DashboardActivity.this,Vehicle_Wallet_Login.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        startActivity(i);
                        finish();
                    }
                }).create().show();
    }

}
