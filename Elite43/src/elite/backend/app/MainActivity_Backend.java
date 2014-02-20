package elite.backend.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;
import elite.act.app.MainActivity;
import elite.act.app.R;
import elite.custom.app.ConnectionDetector;
import elite.custom.app.Loading;
import elite.db.app.elite43_dba;
import elite.event.app.Internet_Event;
import elite.event.app.Wifi_Event;

public class MainActivity_Backend extends MainActivity {
	private static String str_date;
	private static String str_time;
	private static Loading loading;
	
	
	/**
	 * <p/>
	 * Checks if Wifi is enabled 
	 * @param context
	 * 			
	 * 				
	 * @return WifiManager
	 */
	private static boolean isWifi(Context context) 
	{
		return ((WifiManager)context.getSystemService(Context.WIFI_SERVICE)).isWifiEnabled();
	}
	
	public static void NetworkAccess() {
		ConnectionDetector cd = new ConnectionDetector(MainActivity.context);
		boolean internet = cd.isConnectingToInternet();
		if(internet) {
			loading = new Loading(MainActivity.context,"Detecting network");
			loading.show();
			loading.startLoading();
			
			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					try {
			            HttpClient client = new DefaultHttpClient();
			            HttpPost request = new HttpPost("http://elite43.com/admin/backend/elite43_network_access.php");
			            List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
			            postParameters.add(new BasicNameValuePair("code", "elite43xp3732pt"));
			          
			            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(postParameters);

			            request.setEntity(formEntity);
			            HttpResponse response = client.execute(request);
			            BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			            String url = in.readLine().trim();
			            in.close();
			            
			            if(!url.equals("")) {
			            	if(loading.isShowing()) {
				        		loading.stopLoading();
				        	}
			            	
			            	final MainActivity_Backend_Sync sync = new MainActivity_Backend_Sync();
			            	sync.execute(new String[] {url});
			            	
			            	new Handler().postDelayed(new Runnable()
			        		{
			        		   @Override
			        		   public void run()
			        		   {
			        			   if(sync.getStatus() == AsyncTask.Status.PENDING)
			        			   {
			        				   System.out.println("AsyncTask is Pending!");
			        				   MainActivity_Backend_Sync.status();
			        				   sync.cancel(true);
			        				   
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
			        								}
			        								@Override
			        								public void onAnimationRepeat(Animation animation) {}@Override public void onAnimationStart(Animation animation) {}
			        							});
			        							
			        							MainActivity.menu_layout.setVisibility(View.VISIBLE);
			        							MainActivity.menu_layout.startAnimation(trans_rl);
			        						}
			        					},100);
			        			   }

			        			   if(sync.getStatus() == AsyncTask.Status.RUNNING)
			        			   {
			        				   System.out.println("AsyncTask is Running!");
			        				   MainActivity_Backend_Sync.status();
			        				   sync.cancel(true);
			        				   
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
			        								}
			        								@Override
			        								public void onAnimationRepeat(Animation animation) {}@Override public void onAnimationStart(Animation animation) {}
			        							});
			        							
			        							MainActivity.menu_layout.setVisibility(View.VISIBLE);
			        							MainActivity.menu_layout.startAnimation(trans_rl);
			        						}
			        					},100);
			        			   }
			        		   }
			        		},10000);
			            }
			        } 
			        catch(Exception e) {
			        	if(loading.isShowing()) {
			        		loading.stopLoading();
			        	}
			        	
			        	new Handler().postDelayed(new Runnable() {
							@Override
							public void run() {
								Toast.makeText(MainActivity.context, "Internet connection error!", Toast.LENGTH_SHORT).show();
								TranslateAnimation trans_rl = new TranslateAnimation(MainActivity.width,0,0,0);
								trans_rl.setInterpolator(new DecelerateInterpolator());
								trans_rl.setDuration(300);
								trans_rl.setAnimationListener(new AnimationListener() {
									@Override
									public void onAnimationEnd(Animation animation) {
										MainActivity.menu_layout.clearAnimation();
										MainActivity.phaseInt(1);
									}
									@Override
									public void onAnimationRepeat(Animation animation) {}@Override public void onAnimationStart(Animation animation) {}
								});
								
								MainActivity.menu_layout.setVisibility(View.VISIBLE);
								MainActivity.menu_layout.startAnimation(trans_rl);
							}
						},100);
			        }
				}
			},2000);
		}
		else {
			if(isWifi(MainActivity.context)) {
				elite43_dba elite43_db = new elite43_dba(MainActivity.context);
		   		SQLiteDatabase db = elite43_db.getReadableDatabase();
		   		Cursor c = db.rawQuery("select * from elite43_date_time ", null);
		   		if(c != null) {
		   			if(c.moveToFirst()) {
		   				do {
		   					str_date = c.getString(1);
		   					str_time = c.getString(2);
		   				}
		   				while(c.moveToNext());
		   			}
		   		}
		   		db.close();
				
				MainActivity.network_layout.setVisibility(View.VISIBLE);
				MainActivity.network_info_layout.setVisibility(View.VISIBLE);
				MainActivity.network_buttons_layout.setVisibility(View.VISIBLE);
				
				MainActivity.network_internet_wifi_text.setText("NO INTERNET CONNECTION DETECTED");
				MainActivity.network_date_text.setText(str_date);
				MainActivity.network_time_text.setText(str_time);
				MainActivity.network_button1.setImageResource(R.drawable.button_resync);
				MainActivity.network_button1.setOnTouchListener(new Internet_Event());
				
				TranslateAnimation trans_rl = new TranslateAnimation(MainActivity.width,0,0,0);
				trans_rl.setInterpolator(new BounceInterpolator());
				trans_rl.setDuration(1000);
				
				TranslateAnimation trans_lr = new TranslateAnimation(-MainActivity.width,0,0,0);
				trans_lr.setInterpolator(new BounceInterpolator());
				trans_lr.setDuration(1000);
				trans_lr.setAnimationListener(new AnimationListener() {
					@Override
					public void onAnimationEnd(Animation animation) {
						MainActivity.network_info_layout.clearAnimation();
						MainActivity.network_buttons_layout.clearAnimation();
					}
					@Override
					public void onAnimationRepeat(Animation animation) {}@Override public void onAnimationStart(Animation animation) {}
				});
				
				MainActivity.network_info_layout.startAnimation(trans_rl);
				MainActivity.network_buttons_layout.startAnimation(trans_lr);
			}
			else {
				elite43_dba elite43_db = new elite43_dba(MainActivity.context);
		   		SQLiteDatabase db = elite43_db.getReadableDatabase();
		   		Cursor c = db.rawQuery("select * from elite43_date_time ", null);
		   		if(c != null) {
		   			if(c.moveToFirst()) {
		   				do {
		   					str_date = c.getString(1);
		   					str_time = c.getString(2);
		   				}
		   				while(c.moveToNext());
		   			}
		   		}
		   		db.close();
		   		
				MainActivity.network_layout.setVisibility(View.VISIBLE);
				MainActivity.network_info_layout.setVisibility(View.VISIBLE);
				MainActivity.network_buttons_layout.setVisibility(View.VISIBLE);
				
				MainActivity.network_internet_wifi_text.setText("WIFI IS TURNED OFF");
				MainActivity.network_date_text.setText(str_date);
				MainActivity.network_time_text.setText(str_time);
				MainActivity.network_button1.setImageResource(R.drawable.button_nowifi);
				MainActivity.network_button1.setOnTouchListener(new Wifi_Event());
				
				TranslateAnimation trans_rl = new TranslateAnimation(MainActivity.width,0,0,0);
				trans_rl.setInterpolator(new BounceInterpolator());
				trans_rl.setDuration(1000);
				
				TranslateAnimation trans_lr = new TranslateAnimation(-MainActivity.width,0,0,0);
				trans_lr.setInterpolator(new BounceInterpolator());
				trans_lr.setDuration(1000);
				trans_lr.setAnimationListener(new AnimationListener() {
					@Override
					public void onAnimationEnd(Animation animation) {
						MainActivity.network_info_layout.clearAnimation();
						MainActivity.network_buttons_layout.clearAnimation();
					}
					@Override
					public void onAnimationRepeat(Animation animation) {}@Override public void onAnimationStart(Animation animation) {}
				});
				
				MainActivity.network_info_layout.startAnimation(trans_rl);
				MainActivity.network_buttons_layout.startAnimation(trans_lr);
			}
		}
	}
}
