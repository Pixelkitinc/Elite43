package elite.backend.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Base64;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import elite.act.app.MainActivity;
import elite.custom.app.Loading;
import elite.db.app.elite43_dba;

@SuppressLint("SimpleDateFormat")
public class MainActivity_Backend_Sync extends AsyncTask<String, Void, String> {
	private static ArrayList<String> list_staticLocation;
	private static ArrayList<String> list_staticMonth;
	private static ArrayList<String> list_staticDay;
	private static ArrayList<String> list_staticYear;
	
	private static ArrayList<String> list_ledLocation;
	private static ArrayList<String> list_ledClient;
	private static ArrayList<String> list_ledLogo;
	private static ArrayList<String> list_ledSpotsLength;
	private static ArrayList<String> list_ledSpots;
	
	private Loading load_update;
	private String jsonResult;
	private static Loading loading;
	
	public static void status() {
		if(loading.isShowing()) {
			loading.stopLoading();
		}
	}
	
	/**
	 * <p/>
	 * Initializes list for data counter
	 */
	@Override
	protected void onPreExecute() {
		list_staticLocation = new ArrayList<String>();
		list_staticMonth = new ArrayList<String>();
		list_staticDay = new ArrayList<String>();
		list_staticYear = new ArrayList<String>();

		list_ledLocation = new ArrayList<String>();
		list_ledClient = new ArrayList<String>();
		list_ledLogo = new ArrayList<String>();
		list_ledSpotsLength = new ArrayList<String>();
		list_ledSpots = new ArrayList<String>();
		
		loading = new Loading(MainActivity.context,"Synching...");
		loading.show();
		loading.startLoading();
    }
	
	/**
	 * <p/>
	 * Executes the connection through HTTP and retrieves the JSON object
	 * 
	 */
	
	@Override
	protected String doInBackground(String... params) {
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(params[0]);
		
		try {
			HttpResponse response = httpclient.execute(httppost);
			jsonResult = inputStreamToString(response.getEntity().getContent()).toString();
		}
		catch(ClientProtocolException e) {
			e.printStackTrace();
		} 
		catch(IOException e) {
			e.printStackTrace();
		}	
		return null;
	
		
	}
	
	/**
	 * <p/>
	 * Builds the JSON format string
	 * @param is
	 * 			InputStream for the JSON result
	 * 
	 * @return StringBuilder
	 * 
	 */
	private StringBuilder inputStreamToString(InputStream is) {
  		String rLine = "";
		StringBuilder answer = new StringBuilder();
		BufferedReader rd = new BufferedReader(new InputStreamReader(is));
				
		try {
			while((rLine = rd.readLine()) != null) {
 				answer.append(rLine);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return answer;	
  	}
	
	/**
	 * <p/>
	 * Process the JSON response object.
	 * 
	 */
	@Override
  	protected void onPostExecute(String result) {
		try {
			JSONObject jsonResponse = new JSONObject(jsonResult);
			JSONArray staticNode = jsonResponse.optJSONArray("elite43_static");
			for(int i = 0; i < staticNode.length(); i++) {
		    	JSONObject staticChildNode = staticNode.getJSONObject(i);
		    	String staticLocation = staticChildNode.optString("location");
		    	String staticMonth = staticChildNode.optString("month");
		    	String staticDay = staticChildNode.optString("day");
		    	String staticYear = staticChildNode.optString("year");
		    			
		    	list_staticLocation.add(staticLocation);
		    	list_staticMonth.add(staticMonth);
		    	list_staticDay.add(staticDay);
		    	list_staticYear.add(staticYear);
		   	}
		}
		catch(Exception e) {}

		try {
			JSONObject jsonResponse = new JSONObject(jsonResult);
			JSONArray ledNode = jsonResponse.optJSONArray("elite43_led");
			for(int i = 0; i < ledNode.length(); i++) {
		   		JSONObject ledChildNode = ledNode.getJSONObject(i);
		   		String ledLocation = ledChildNode.optString("location");
		   		String ledClient = ledChildNode.optString("client");
		   		String ledLogo = ledChildNode.optString("logo");
		   		String ledSpotsLength = ledChildNode.optString("ad_spot_length");
		   		String ledSpots = ledChildNode.optString("spots");
		   			
		   		list_ledLocation.add(ledLocation);
		   		list_ledClient.add(ledClient);
		   		list_ledLogo.add(ledLogo);
		   		list_ledSpotsLength.add(ledSpotsLength);
		   		list_ledSpots.add(ledSpots);
		   	}
		}
		catch(Exception e) {}
		
		loading.stopLoading();
		
		/*
		 * Runs the AsyncTask inside the Handler thread.
		 */
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				TranslateAnimation trans_rl = new TranslateAnimation(MainActivity.width,0,0,0);
				trans_rl.setInterpolator(new DecelerateInterpolator());
				trans_rl.setDuration(300);
				trans_rl.setAnimationListener(new AnimationListener() {
					@Override
					public void onAnimationEnd(Animation animation) {
						MainActivity.menu_layout.clearAnimation();
						MainActivity.phaseInt(1);
						
						new Handler().postDelayed(new Runnable() {
							@Override
							public void run() {
								updateEntree update = new updateEntree();
								update.execute();
							}
						},100);
					}
					@Override
					public void onAnimationRepeat(Animation animation) {}@Override public void onAnimationStart(Animation animation) {}
				});
				
				MainActivity.menu_layout.setVisibility(View.VISIBLE);
				MainActivity.menu_layout.startAnimation(trans_rl);
			}
		},100);
    }
	
	/**
	 * <p/>
	 * Updates entry on database
	 *
	 */
	private class updateEntree extends AsyncTask<Void, Void, Void> {
		@Override
		protected void onPreExecute() {
			load_update = new Loading(MainActivity.context,"Updating Database...");
			load_update.show();
			load_update.startLoading();
	    }
		
		/**
		 * <p/>
		 * Gets the readable DB and process entry on background.
		 * 
		 */
		@SuppressLint("SimpleDateFormat")
		@Override
		protected Void doInBackground(Void... arg0) {
			elite43_dba elite43_db = new elite43_dba(MainActivity.context);
			SQLiteDatabase dbd = elite43_db.getReadableDatabase();
				
			dbd.execSQL("delete from elite43_static");
			dbd.execSQL("delete from elite43_led");
			dbd.execSQL("delete from elite43_date_time");
			dbd.close();
			   
			String[] staticLocationList = new String[list_staticLocation.size()];
			staticLocationList = list_staticLocation.toArray(staticLocationList);
			   
			String[] staticMonthList = new String[list_staticMonth.size()];
			staticMonthList = list_staticMonth.toArray(staticMonthList);
			   
			String[] staticDayList = new String[list_staticDay.size()];
			staticDayList = list_staticDay.toArray(staticDayList);
			   
			String[] staticYearList = new String[list_staticYear.size()];
			staticYearList = list_staticYear.toArray(staticYearList);
			   
			for(int i = 0; i < staticLocationList.length; i++) {
				elite43_dba static_table = new elite43_dba(MainActivity.context);
				SQLiteDatabase db = static_table.getWritableDatabase();
				ContentValues cv = new ContentValues();
	   				
				cv.put(static_table.STATIC_LOCATION, staticLocationList[i]);
				cv.put(static_table.STATIC_MONTH, staticMonthList[i]);
				cv.put(static_table.STATIC_DAY, staticDayList[i]);
				cv.put(static_table.STATIC_YEAR, staticYearList[i]);
	   				
				db.insert("elite43_static", static_table.STATIC_LOCATION, cv);
				db.close();
			}
			   
			String[] ledLocationList = new String[list_ledLocation.size()];
			ledLocationList = list_ledLocation.toArray(ledLocationList);
			   
			String[] ledClientList = new String[list_ledClient.size()];
			ledClientList = list_ledClient.toArray(ledClientList);
			  
			String[] ledLogoList = new String[list_ledLogo.size()];
			ledLogoList = list_ledLogo.toArray(ledLogoList);
			   
			String[] ledSpotsLengthList = new String[list_ledSpotsLength.size()];
			ledSpotsLengthList = list_ledSpotsLength.toArray(ledSpotsLengthList);
			   
			String[] ledSpotsList = new String[list_ledSpots.size()];
			ledSpotsList = list_ledSpots.toArray(ledSpotsList);
			   
			for(int i = 0; i < ledLocationList.length; i++) {
				byte[] decodedString = Base64.decode(ledLogoList[i], Base64.DEFAULT);   
				elite43_dba led_table = new elite43_dba(MainActivity.context);
				SQLiteDatabase db = led_table.getWritableDatabase();
				ContentValues cv = new ContentValues();
	   				
				cv.put(led_table.LED_LOCATIOIN, ledLocationList[i]);
				cv.put(led_table.LED_CLIENT, ledClientList[i]);
				cv.put(led_table.LED_LOGO, decodedString);
				cv.put(led_table.LED_SPOTS_LENGTH, ledSpotsLengthList[i]);
				cv.put(led_table.LED_SPOTS, ledSpotsList[i]);
	   				
				db.insert("elite43_led", led_table.LED_LOCATIOIN, cv);
				db.close(); 
			}
			   
			Calendar cal = Calendar.getInstance();
			String date = new SimpleDateFormat("MMM/dd/yyyy").format(cal.getTime());
			String time = new SimpleDateFormat("hh:mm a").format(cal.getTime());
				
			elite43_dba date_time_table = new elite43_dba(MainActivity.context);
			SQLiteDatabase db = date_time_table.getWritableDatabase();
			ContentValues cv = new ContentValues();	
			cv.put(date_time_table.DATE, date);
			cv.put(date_time_table.TIME, time);	
			
			db.insert("elite43_date_time", date_time_table.DATE, cv);
			db.close();
			return null;
		}
		
		
		/**
		 * <p/>
		 * Stops loader after update on entry and clear list.
		 *
		 */		
		@Override
		protected void onPostExecute(Void result) {
			load_update.stopLoading();
			list_staticLocation.clear();
			list_staticMonth.clear();
			list_staticDay.clear();
			list_staticYear.clear();
			list_ledLocation.clear();
			list_ledClient.clear();
			list_ledLogo.clear();
			list_ledSpotsLength.clear();
			list_ledSpots.clear();
		}
	}
}