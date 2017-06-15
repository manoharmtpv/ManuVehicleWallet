package com.mtpv.manohar.my_vehicle_wallet;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mtpv.manohar.my_vehicle_wallet.Services.ServiceHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


@SuppressLint("DefaultLocale")
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class OTP extends Activity {
	
	final int PROGRESS_DIALOG = 0;
	final int OTP_CNFRMTN_DIALOG = 7;
	
	EditText otp_input ;
	Button otp_cancel, ok_dialog ;
	
	public static String otp_number ="", reg_No, email_id, Mobile_No, OTP_date, pass_word, OTP_No, Verify_status , close_Decision = "" , UserName="";

	@SuppressLint("InlinedApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_otp);
		this.setFinishOnTouchOutside(false);
		
		otp_input = (EditText)findViewById(R.id.otp_input);
		ok_dialog = (Button)findViewById(R.id.ok_dialog);
		otp_cancel = (Button)findViewById(R.id.cancel_dialog);
		
		 reg_No = RegisterActivity.vehicleNo.getText().toString() ;
		 email_id = RegisterActivity.email.getText().toString();
		 pass_word = RegisterActivity.password.getText().toString();
		 Mobile_No = RegisterActivity.mobile.getText().toString();
		 OTP_date = RegisterActivity.present_date_toSend;
		 OTP_No = RegisterActivity.otpValue;
		 UserName = RegisterActivity.name.getText().toString().trim();
		 Verify_status = "";
		 
		 Log.i("reg_No ::::", ""+reg_No);
		 Log.i("Mobile_No", ""+Mobile_No);
		 Log.i("OTP_date", ""+OTP_date);
		 Log.i("OTP_No", ""+OTP_No);
		 Log.i("Verify_status", ""+Verify_status);
		
		 otp_cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TextView title = new TextView(OTP.this);
				title.setText("Telangana E-Challan");
				title.setBackgroundColor(Color.parseColor("#0E244D"));
				title.setGravity(Gravity.CENTER);
				title.setTextColor(Color.WHITE);
				title.setTextSize(10);
				title.setTypeface(title.getTypeface(), Typeface.BOLD);
				title.setCompoundDrawablesWithIntrinsicBounds(R.drawable.dialog_logo, 0, R.drawable.dialog_logo, 0);
				title.setPadding(20, 0, 20, 0);//l t r b
				title.setHeight(150);
				
				String otp_message = "Are you sure, Without Verifying OTP you can't Register ???" ;
				
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(OTP.this, AlertDialog.THEME_HOLO_LIGHT);
				alertDialogBuilder.setCustomTitle(title);
				alertDialogBuilder.setIcon(R.drawable.dialog_logo);
				alertDialogBuilder.setMessage(otp_message);
				alertDialogBuilder.setCancelable(false);
				alertDialogBuilder.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								 close_Decision = "Y" ;
								 finish();
							}
						});

				alertDialogBuilder.setNegativeButton("No",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								close_Decision = "N" ;
							}
						});
				
			        AlertDialog alertDialog = alertDialogBuilder.create();
			        alertDialog.show();
			      
			        alertDialog.getWindow().getAttributes();

			        TextView textView = (TextView) alertDialog.findViewById(android.R.id.message);
			        title.setTextSize(getResources().getDimension(R.dimen.text_size));
			        textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
			        textView.setGravity(Gravity.CENTER);
			        
			        Button btn1 = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
			        title.setTextSize(getResources().getDimension(R.dimen.text_size));
			        btn1.setTextColor(Color.WHITE);
			        btn1.setTypeface(btn1.getTypeface(), Typeface.BOLD);
			        btn1.setBackgroundColor(Color.parseColor("#0E244D"));  
		      
			        Button btn2 = alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
			        title.setTextSize(getResources().getDimension(R.dimen.text_size));
			        btn2.setTextColor(Color.WHITE);
			        btn2.setTypeface(btn2.getTypeface(), Typeface.BOLD);
			        btn2.setBackgroundColor(Color.parseColor("#0E244D")); 
			
			        
			        if (close_Decision.equals("N")) {
						
					}else if(close_Decision.equals("Y")){
						finish();
					}
			}
		});
		 
		ok_dialog.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (otp_input.getText().toString().trim().equals(OTP_No)) {
					Verify_status = "Y";
					if (isOnline()) {
						//Log.i("***OTP CONFIRMATION STATUS", ""	+ Verify_status);
						//SpotChallan.otp_status = "verify";
						//new Async_otpverify().execute();
						new Async_Register().execute();
					} else {
						showToast("Please check your network connection!");
					}
				}else{
					Verify_status = "N";
					otp_input.setError(Html.fromHtml("<font color='red'>Please Enter Valid OTP!</font>"));
					otp_input.requestFocus();
					//showToast("Entered Wrong OTP");
					otp_input.setText("");
				}
			}
		});
		
	}
	
	public Boolean isOnline() {
		ConnectivityManager conManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo nwInfo = conManager.getActiveNetworkInfo();
		return nwInfo != null;
	}
	
	class Async_otpverify extends AsyncTask<Void, Void, String>{

		@SuppressWarnings("deprecation")
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			showDialog(PROGRESS_DIALOG);
		}
		
		@Override
		protected String doInBackground(Void... params) {
			// TODO Auto-generated method stub
			otp_number = otp_input.getText().toString().trim();
		//	ServiceHelper.verifyOTP(reg_No , Mobile_No,OTP_date, ""+ OTP_No, Verify_status);//33
			
			return null;
		}
		
		@SuppressWarnings("deprecation")
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			removeDialog(PROGRESS_DIALOG);
		//	Log.i("ServiceHelper.otp_verify_resp :::::", ""+ServiceHelper.otp_verify_resp);
			if (ServiceHelper.otp_verify_resp.equals("0")) {
				showToast("Entered Wrong OTP");
				otp_input.setText("");
			}else{
				showToast("OTP Verified Successfully");
				new Async_Register().execute();
			}
			
		}
	}
	
	class Async_Register extends AsyncTask<Void, Void, String>
	{
		@SuppressWarnings("deprecation")
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			showDialog(PROGRESS_DIALOG);
		}
		
		@Override
		protected String doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			/*public String registerUser(String userName, String regn_no,String mobileNo,
		            String emailId,String password,String imeie,String key,
		            String date, String otp,String verify_status);*/
			ServiceHelper.registration(""+UserName, ""+reg_No, ""+ Mobile_No, ""+email_id, ""+pass_word, ""+RegisterActivity.IMEI, "", OTP_date, OTP_No,Verify_status);
			return null;
		}

		@SuppressWarnings("deprecation")
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			removeDialog(PROGRESS_DIALOG);

			try {
				String regresponse=null;
				JSONObject jsonObj = new JSONObject(ServiceHelper.Opdata_Chalana);
				// Getting JSON Array node
				JSONArray jsonArray = jsonObj.getJSONArray("Registration Details");
				// looping through All Witness
				for (int i = 0, size = jsonArray.length(); i < size; i++){
					JSONObject c = jsonArray.getJSONObject(i);
					//witness_id_code
					regresponse=c.getString("Registration Response");
				}


				if(regresponse.equalsIgnoreCase("Registration Successfull"))
				{

					showToast(regresponse);

					Intent i=new Intent(OTP.this,Vehicle_Wallet_Login.class);
					startActivity(i);
					finish();

				}
				else
				{
					showToast(regresponse);

				//	finish();
				}

			}catch (JSONException e)
			{
				e.printStackTrace();
			}


//			if (ServiceHelper.Opdata_Chalana.contains("Successfully Registered")) {
//				showToast(""+ServiceHelper.Opdata_Chalana);
//				finish();
//
//				// need to add Class here
//
////				Intent pubView = new Intent(getApplicationContext(), Public_Acitivity.class);
////				startActivity(pubView);
////            	overridePendingTransition(R.anim.fade_enter,R.anim.fade_leave);
//			}else {
//				showToast("Already Registrated With This Vehicle...!");
//				finish();
//			}
			
		}
	}
	
	@SuppressWarnings("unused")
	private void showToast(String msg) {
		// TODO Auto-generated method stub
		Toast toast = Toast.makeText(getApplicationContext(), "" + msg, Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		View toastView = toast.getView();
		
		ViewGroup group = (ViewGroup) toast.getView();
	    TextView messageTextView = (TextView) group.getChildAt(0);
		
    	toastView.setBackgroundResource(R.drawable.toast_background);
	    toast.show();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		switch (id) {
		case PROGRESS_DIALOG:
			ProgressDialog pd = ProgressDialog.show(this, "", "",	true);
			pd.setContentView(R.layout.custom_progress_dialog);
			pd.setCancelable(false); 
			
			return pd;

		default:
			break;
		}
		return super.onCreateDialog(id);
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		showToast("Please Click on Cancel Button to go Back ..!");
	}
}
