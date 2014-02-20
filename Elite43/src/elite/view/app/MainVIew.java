package elite.view.app;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import elite.act.app.MainActivity;
import elite.act.app.R;
import elite.custom.app.Transform_Home_Menu;
import elite.custom.app.Transform_Led_Greenhills_Phase3;
import elite.custom.app.Transform_Led_Logo;
import elite.custom.app.Transform_Led_Naia_Phase3;
import elite.custom.app.Transform_Static_Logo;
import elite.custom.app.Transform_Static_Phase3;
import elite.db.app.elite43_dba;
import elite.event.app.About_Main_Menu_Event;

public class MainVIew extends MainActivity {
	private static void static_month_day_year(int m, int d, int y) {
    	String month = "";
    	String year = "";
    	
    	switch(m) {
    		case 1:
    				month = "Jan";
    			break;
    			
    		case 2:
    				month = "Feb";
    			break;
    			
    		case 3:
    				month = "Mar";
    			break;
    			
    		case 4:
    				month = "Apr";
    			break;
    			
    		case 5:
    				month = "May";
    			break;
    			
    		case 6:
    				month = "Jun";
    			break;
    			
    		case 7:
    				month = "Jul";
    			break;
    			
    		case 8:
    				month = "Aug";
    			break;
    			
    		case 9:
    				month = "Sep";
    			break;
    			
    		case 10:
    				month = "Oct";
    			break;
    			
    		case 11:
    				month = "Nov";
    			break;
    			
    		case 12:
    				month = "Dec";
    			break;
    	}//month
    	
    	switch(y) {
    		case 1:
    				year = "2015";
    			break;
    			
    		case 2:
    				year = "2014";
    			break;
    			
    		case 3:
    				year = "2013";
    			break;
    	}//year
    	
    	MainActivity.static_avialability_status.setText("Booked Until | "+month+" "+d+","+" "+year);
    }
	
	public static void static_north_south_info(int a) {
		elite43_dba elite43_db = new elite43_dba(MainActivity.context);
   		SQLiteDatabase db = elite43_db.getReadableDatabase();
   		Cursor c1 = db.rawQuery("select static_year from elite43_static where static_location = '"+a+"' and static_year = '1' ", null);
   		Cursor c2 = db.rawQuery("select static_year from elite43_static where static_location = '"+a+"' and static_year = '2' ", null);
   		Cursor c3 = db.rawQuery("select static_year from elite43_static where static_location = '"+a+"' and static_year = '3' ", null);
   		
   		if(c1.getCount() > 0) {
   			int val = 12;
   			int valx = 31;
   			
   			if(c1 != null) {
   				if(c1.moveToFirst()) {
   					int year = c1.getInt(c1.getColumnIndex("static_year"));
   					
   					while(val != 0) {
   						elite43_dba elite43_db2 = new elite43_dba(MainActivity.context);
   		   	   	   		SQLiteDatabase db2 = elite43_db2.getReadableDatabase();
   		   	   	   		Cursor cm = db2.rawQuery("select static_month from elite43_static where static_location = '"+a+"' and static_month = '"+val+"' ", null);
   		   	   	   		
   		   	   	   		if(cm.getCount() > 0) {
   		   	   	   			if(cm != null) {
   		   	   	   				if(cm.moveToFirst()) {
   		   	   	   					int month = cm.getInt(cm.getColumnIndex("static_month"));
   		   	   	   					
   		   	   	   					while(valx != 0) {
   		   	   	   						elite43_dba elite43_db3 = new elite43_dba(MainActivity.context);
   		   	   	   						SQLiteDatabase db3 = elite43_db3.getReadableDatabase();
   		   	   	   						Cursor cd = db3.rawQuery("select static_day from elite43_static where static_location = '"+a+"' and static_month = '"+val+"' and static_day = '"+valx+"' ", null);
   		   	   	   						
   		   	   	   						if(cd.getCount() > 0) {
   		   	   	   							if(cd != null) {
   		   	   	   								if(cd.moveToFirst()) {	
   		   	   	   									int day = cd.getInt(cd.getColumnIndex("static_day"));
   		   	   	   									static_month_day_year(month,day,year);
   		   	   	   								}
   		   	   	   							}
  	   	   								
   		   	   	   							break;
   		   	   	   						}
  	   	   							
   		   	   	   						valx--;
   		   	   	   					}
   		   	   	   				}
   		   	   	   			}
   		   	   	   			
   		   	   	   			break;
   		   	   	   		}
   						
   						val--;
   					}	
   				}
   			}
		}
   		else if(c2.getCount() > 0) {
   			int val = 12;
   			int valx = 31;
   			
   			if(c2 != null) {
   				if(c2.moveToFirst()) {
   					int year = c2.getInt(c2.getColumnIndex("static_year"));
   					
   					while(val != 0) {
   						elite43_dba elite43_db2 = new elite43_dba(MainActivity.context);
   		   	   	   		SQLiteDatabase db2 = elite43_db2.getReadableDatabase();
   		   	   	   		Cursor cm = db2.rawQuery("select static_month from elite43_static where static_location = '"+a+"' and static_month = '"+val+"' ", null);
   		   	   	   		
   		   	   	   		if(cm.getCount() > 0) {
   		   	   	   			if(cm != null) {
   		   	   	   				if(cm.moveToFirst()) {
   		   	   	   					int month = cm.getInt(cm.getColumnIndex("static_month"));
   		   	   	   					
   		   	   	   					while(valx != 0) {
   		   	   	   						elite43_dba elite43_db3 = new elite43_dba(MainActivity.context);
   		   	   	   						SQLiteDatabase db3 = elite43_db3.getReadableDatabase();
   		   	   	   						Cursor cd = db3.rawQuery("select static_day from elite43_static where static_location = '"+a+"' and static_month = '"+val+"' and static_day = '"+valx+"' ", null);
   		   	   	   						
   		   	   	   						if(cd.getCount() > 0) {
   		   	   	   							if(cd != null) {
   		   	   	   								if(cd.moveToFirst()) {	
   		   	   	   									int day = cd.getInt(cd.getColumnIndex("static_day"));
   		   	   	   									static_month_day_year(month,day,year);
   		   	   	   								}
   		   	   	   							}
  	   	   								
   		   	   	   							break;
   		   	   	   						}
  	   	   							
   		   	   	   						valx--;
   		   	   	   					}
   		   	   	   				}
   		   	   	   			}
   		   	   	   			
   		   	   	   			break;
   		   	   	   		}
   						
   						val--;
   					}
   				}
   			}
		}
   		else if(c3.getCount() > 0) {
   			int val = 12;
   			int valx = 31;
   			
   			if(c3 != null) {
   				if(c3.moveToFirst()) {
   					int year = c3.getInt(c3.getColumnIndex("static_year"));
   					
   					while(val != 0) {
   						elite43_dba elite43_db2 = new elite43_dba(MainActivity.context);
   		   	   	   		SQLiteDatabase db2 = elite43_db2.getReadableDatabase();
   		   	   	   		Cursor cm = db2.rawQuery("select static_month from elite43_static where static_location = '"+a+"' and static_month = '"+val+"' ", null);
   		   	   	   		
   		   	   	   		if(cm.getCount() > 0) {
   		   	   	   			if(cm != null) {
   		   	   	   				if(cm.moveToFirst()) {
   		   	   	   					int month = cm.getInt(cm.getColumnIndex("static_month"));
   		   	   	   					
   		   	   	   					while(valx != 0) {
   		   	   	   						elite43_dba elite43_db3 = new elite43_dba(MainActivity.context);
   		   	   	   						SQLiteDatabase db3 = elite43_db3.getReadableDatabase();
   		   	   	   						Cursor cd = db3.rawQuery("select static_day from elite43_static where static_location = '"+a+"' and static_month = '"+val+"' and static_day = '"+valx+"' ", null);
   		   	   	   						
   		   	   	   						if(cd.getCount() > 0) {
   		   	   	   							if(cd != null) {
   		   	   	   								if(cd.moveToFirst()) {	
   		   	   	   									int day = cd.getInt(cd.getColumnIndex("static_day"));
   		   	   	   									static_month_day_year(month,day,year);
   		   	   	   								}
   		   	   	   							}
  	   	   								
   		   	   	   							break;
   		   	   	   						}
  	   	   							
   		   	   	   						valx--;
   		   	   	   					}
   		   	   	   				}
   		   	   	   			}
   		   	   	   			
   		   	   	   			break;
   		   	   	   		}
   						
   						val--;
   					}	
   				}
   			}
		}	
	}
	
	public static void greenhills_info() {
		elite43_dba elite43_db = new elite43_dba(MainActivity.context);
   		SQLiteDatabase db = elite43_db.getReadableDatabase();
   		Cursor c = db.rawQuery("select * from elite43_led where led_location = '2' ", null);
   		int val4 = 0;
   		
   		if(c != null) {
   			if(c.moveToFirst()) {
   				do {
   					byte[] led_logo = c.getBlob(3);
   					String led_spots = c.getString(5);
   					
   					int val1 = c.getInt(4);
   					int val2 = c.getInt(5);
   					int val3 = val2 * val1;
   					val4 = val4 + val3;
   					
   					Bitmap decodedByte = BitmapFactory.decodeByteArray(led_logo, 0, led_logo.length);
   		    		SpannableString spots = new SpannableString(led_spots+" spots");
   		    		spots.setSpan(new StyleSpan(Typeface.BOLD), 0, spots.length(), 0);
   		    		
   		    		RelativeLayout.LayoutParams naia_info_layout = new RelativeLayout.LayoutParams(MainActivity.logo_holder_w,MainActivity.logo_m);
   		    		naia_info_layout.addRule(RelativeLayout.CENTER_HORIZONTAL);
   		    		
   		    		RelativeLayout naia_info = new RelativeLayout(MainActivity.context);
   		    		naia_info.setLayoutParams(naia_info_layout);
   		    		
   		    		ImageView led_naia_info_logo = new ImageView(MainActivity.context);
   		    		led_naia_info_logo.setLayoutParams(new LayoutParams(MainActivity.logo_w,MainActivity.logo_h));
   		    		led_naia_info_logo.setImageBitmap(decodedByte);
   		    		led_naia_info_logo.setScaleType(ScaleType.FIT_XY);
   		    		naia_info.addView(led_naia_info_logo);
   		    		
   		    		RelativeLayout.LayoutParams led_naia_info_text_layout = new RelativeLayout.LayoutParams(android.view.ViewGroup.LayoutParams.WRAP_CONTENT,android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
   		    		led_naia_info_text_layout.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
   		    		led_naia_info_text_layout.setMargins(0, MainActivity.logo_text_m, 0, 0);
   		    		
   		    		TextView led_naia_info_text = new TextView(MainActivity.context);
   		    		led_naia_info_text.setLayoutParams(led_naia_info_text_layout);
   		    		led_naia_info_text.setTextSize(TypedValue.COMPLEX_UNIT_DIP, MainActivity.logo_text_size);
   		    		led_naia_info_text.setText(spots);
   		    		naia_info.addView(led_naia_info_text);
   		    		
   		    		RelativeLayout rel = new RelativeLayout(MainActivity.context);
   		    		rel.setLayoutParams(new LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT,android.view.ViewGroup.LayoutParams.WRAP_CONTENT));
   		    		rel.addView(naia_info);
   		    		
   		    		MainActivity.led_promenade_info_progressbar.setProgress(val4);
   		    		MainActivity.led_promenade_information_holder_layout.addView(rel);
   				}
   				while(c.moveToNext());
   			}
   		}
   		db.close();
	}
	
	public static void naia_info() {
		elite43_dba elite43_db = new elite43_dba(MainActivity.context);
   		SQLiteDatabase db = elite43_db.getReadableDatabase();
   		Cursor c = db.rawQuery("select * from elite43_led where led_location = '1' ", null);
   		int val4 = 0;
   		
   		if(c != null) {
   			if(c.moveToFirst()) {
   				do {
   					byte[] led_logo = c.getBlob(3);
   					String led_spots = c.getString(5);
   					
   					int val1 = c.getInt(4);
   					int val2 = c.getInt(5);
   					int val3 = val2 * val1;
   					val4 = val4 + val3;
   					
   					Bitmap decodedByte = BitmapFactory.decodeByteArray(led_logo, 0, led_logo.length);
   		    		SpannableString spots = new SpannableString(led_spots+" spots");
   		    		spots.setSpan(new StyleSpan(Typeface.BOLD), 0, spots.length(), 0);
   		    		
   		    		RelativeLayout.LayoutParams naia_info_layout = new RelativeLayout.LayoutParams(MainActivity.logo_holder_w,MainActivity.logo_m);
   		    		naia_info_layout.addRule(RelativeLayout.CENTER_HORIZONTAL);
   		    		
   		    		RelativeLayout naia_info = new RelativeLayout(MainActivity.context);
   		    		naia_info.setLayoutParams(naia_info_layout);
   		    		
   		    		ImageView led_naia_info_logo = new ImageView(MainActivity.context);
   		    		led_naia_info_logo.setLayoutParams(new LayoutParams(MainActivity.logo_w,MainActivity.logo_h));
   		    		led_naia_info_logo.setImageBitmap(decodedByte);
   		    		led_naia_info_logo.setScaleType(ScaleType.FIT_XY);
   		    		naia_info.addView(led_naia_info_logo);
   		    		
   		    		RelativeLayout.LayoutParams led_naia_info_text_layout = new RelativeLayout.LayoutParams(android.view.ViewGroup.LayoutParams.WRAP_CONTENT,android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
   		    		led_naia_info_text_layout.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
   		    		led_naia_info_text_layout.setMargins(0, MainActivity.logo_text_m, 0, 0);
   		    		
   		    		TextView led_naia_info_text = new TextView(MainActivity.context);
   		    		led_naia_info_text.setLayoutParams(led_naia_info_text_layout);
   		    		led_naia_info_text.setTextSize(TypedValue.COMPLEX_UNIT_DIP, MainActivity.logo_text_size);
   		    		led_naia_info_text.setText(spots);
   		    		naia_info.addView(led_naia_info_text);
   		    		
   		    		RelativeLayout rel = new RelativeLayout(MainActivity.context);
   		    		rel.setLayoutParams(new LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT,android.view.ViewGroup.LayoutParams.WRAP_CONTENT));
   		    		rel.addView(naia_info);
   		    		
   		    		MainActivity.led_naia_info_progressbar.setProgress(val4);
   		    		MainActivity.led_naia_information_holder_layout.addView(rel);
   				}
   				while(c.moveToNext());
   			}
   		}
   		db.close();
	}
	
	public static void about_phase2_back_to_main_menu() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				MainActivity.isFinish(false);
				AlphaAnimation fadein = new AlphaAnimation(1.0f,0.0f);
				fadein.setFillAfter(true);
				fadein.setDuration(300);
				fadein.setAnimationListener(new AnimationListener() {
					@Override
					public void onAnimationEnd(Animation animation) {
						MainActivity.about_layout.setVisibility(View.GONE);
						MainActivity.about_layout.clearAnimation();
						
						Animation zoom_in = AnimationUtils.loadAnimation(MainActivity.context,R.anim.zoom_in);
						zoom_in.setInterpolator(new DecelerateInterpolator());
						
						final TranslateAnimation trans_lr = new TranslateAnimation(-MainActivity.width,0,0,0);
						trans_lr.setInterpolator(new DecelerateInterpolator());
						trans_lr.setDuration(300);
						trans_lr.setAnimationListener(new AnimationListener() {
							@Override
							public void onAnimationEnd(Animation animation) {
								MainActivity.menu_layout.clearAnimation();
								MainActivity.video_image_layout.clearAnimation();
								
								MainActivity.phaseInt(1);
								MainActivity.s_l_a_Int(0);
								MainActivity.isFinish(true);
								MainActivity.about_button.setOnTouchListener(new About_Main_Menu_Event());
							}
							@Override
							public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
						});
						MainActivity.menu_layout.setVisibility(View.VISIBLE);
						MainActivity.video_image_layout.startAnimation(zoom_in);
						MainActivity.menu_layout.startAnimation(trans_lr);
					}
					@Override
					public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
				});
		
				MainActivity.about_layout.startAnimation(fadein);
			}
		},100);
	}
	
	public static void led_home_promenade_phase3_back_to_main_menu() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				MainActivity.isFinish(false);
				Animation slide_up = AnimationUtils.loadAnimation(MainActivity.context,R.anim.slide_up);
				slide_up.setInterpolator(new DecelerateInterpolator());
				slide_up.setDuration(500);
				slide_up.setAnimationListener(new AnimationListener() {
					@Override
					public void onAnimationEnd(Animation animation) {
						MainActivity.led_promenade_info_list_layout.setVisibility(View.GONE);
						MainActivity.led_promenade_info_spots_holder_layout.setVisibility(View.GONE);
						MainActivity.led_promenade_info_list_layout.clearAnimation();
						MainActivity.led_promenade_info_spots_holder_layout.clearAnimation();
						MainActivity.led_promenade_information_holder_layout.removeAllViews();
						
						Transform_Led_Greenhills_Phase3 transform = new Transform_Led_Greenhills_Phase3(false);
						transform.setDuration(500);
						transform.setAnimationListener(new AnimationListener() {
							@Override
							public void onAnimationEnd(Animation animation) {
								MainActivity.led_promenade_info_layout.setVisibility(View.GONE);
								MainActivity.led_promenade_info_layout.clearAnimation();
								
								Transform_Led_Logo trans_logo = new Transform_Led_Logo(false);
								trans_logo.setDuration(500);
								trans_logo.setAnimationListener(new AnimationListener() {
									@Override
									public void onAnimationEnd(Animation animation) {
										MainActivity.led_slide_logo_layout.setVisibility(View.GONE);
										MainActivity.led_slide_layout.setVisibility(View.GONE);
										MainActivity.led_slide_logo.clearAnimation();
										
										Transform_Home_Menu transform = new Transform_Home_Menu(true);
										transform.setDuration(500);
										transform.setAnimationListener(new AnimationListener() {
											@Override
											public void onAnimationEnd(Animation animation) {
												MainActivity.video_image.clearAnimation();
												MainActivity.phaseInt(1);
												MainActivity.s_l_a_Int(0);
												MainActivity.isFinish(true);
											}
											@Override
											public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
										});
										MainActivity.video_image_layout.setVisibility(View.VISIBLE);
										MainActivity.menu_layout.setVisibility(View.VISIBLE);
										MainActivity.video_image.startAnimation(transform);
									}
									@Override
									public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
								});
								MainActivity.led_slide_logo.startAnimation(trans_logo);
							}
							@Override
							public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
						});
						MainActivity.led_promenade_info_layout.startAnimation(transform);
					}
					@Override
					public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
				});
				MainActivity.led_promenade_info_list_layout.setAnimation(slide_up);
				MainActivity.led_promenade_info_spots_holder_layout.startAnimation(slide_up);
			}
		},100);
	}
	
	public static void led_home_naia_phase3_back_to_main_menu() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				MainActivity.isFinish(false);
				Animation slide_up = AnimationUtils.loadAnimation(MainActivity.context,R.anim.slide_up);
				slide_up.setInterpolator(new DecelerateInterpolator());
				slide_up.setDuration(500);
				slide_up.setAnimationListener(new AnimationListener() {
					@Override
					public void onAnimationEnd(Animation animation) {
						MainActivity.led_naia_info_list_layout.setVisibility(View.GONE);
						MainActivity.led_naia_info_spots_holder_layout.setVisibility(View.GONE);
						MainActivity.led_naia_info_list_layout.clearAnimation();
						MainActivity.led_naia_info_spots_holder_layout.clearAnimation();
						MainActivity.led_naia_information_holder_layout.removeAllViews();
						
						Transform_Led_Naia_Phase3 transform = new Transform_Led_Naia_Phase3(false);
						transform.setDuration(500);
						transform.setAnimationListener(new AnimationListener() {
							@Override
							public void onAnimationEnd(Animation animation) {
								MainActivity.led_naia_info_layout.setVisibility(View.GONE);
								MainActivity.led_naia_info_layout.clearAnimation();
								
								Transform_Led_Logo trans_logo = new Transform_Led_Logo(false);
								trans_logo.setDuration(500);
								trans_logo.setAnimationListener(new AnimationListener() {
									@Override
									public void onAnimationEnd(Animation animation) {
										MainActivity.led_slide_logo_layout.setVisibility(View.GONE);
										MainActivity.led_slide_layout.setVisibility(View.GONE);
										MainActivity.led_slide_logo.clearAnimation();
										
										Transform_Home_Menu transform = new Transform_Home_Menu(true);
										transform.setDuration(500);
										transform.setAnimationListener(new AnimationListener() {
											@Override
											public void onAnimationEnd(Animation animation) {
												MainActivity.video_image.clearAnimation();
												MainActivity.phaseInt(1);
												MainActivity.s_l_a_Int(0);
												MainActivity.isFinish(true);
											}
											@Override
											public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
										});
										MainActivity.video_image_layout.setVisibility(View.VISIBLE);
										MainActivity.menu_layout.setVisibility(View.VISIBLE);
										MainActivity.video_image.startAnimation(transform);
									}
									@Override
									public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
								});
								MainActivity.led_slide_logo.startAnimation(trans_logo);
							}
							@Override
							public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
						});
						MainActivity.led_naia_info_layout.startAnimation(transform);
					}
					@Override
					public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
				});
				MainActivity.led_naia_info_list_layout.setAnimation(slide_up);
				MainActivity.led_naia_info_spots_holder_layout.startAnimation(slide_up);
			}
		},100);
	}
	
	public static void led_promenade_phase3_back_to_main_menu() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				MainActivity.isFinish(false);
				Animation slide_up = AnimationUtils.loadAnimation(MainActivity.context,R.anim.slide_up);
				slide_up.setInterpolator(new DecelerateInterpolator());
				slide_up.setDuration(500);
				slide_up.setAnimationListener(new AnimationListener() {
					@Override
					public void onAnimationEnd(Animation animation) {
						MainActivity.led_promenade_info_list_layout.setVisibility(View.GONE);
						MainActivity.led_promenade_info_spots_holder_layout.setVisibility(View.GONE);
						MainActivity.led_promenade_info_list_layout.clearAnimation();
						MainActivity.led_promenade_info_spots_holder_layout.clearAnimation();
						MainActivity.led_promenade_information_holder_layout.removeAllViews();
						
						Transform_Led_Greenhills_Phase3 transform = new Transform_Led_Greenhills_Phase3(false);
						transform.setDuration(500);
						transform.setAnimationListener(new AnimationListener() {
							@Override
							public void onAnimationEnd(Animation animation) {
								MainActivity.led_promenade_info_layout.setVisibility(View.GONE);
								MainActivity.led_promenade_info_layout.clearAnimation();
								
								TranslateAnimation trans_slide1 = new TranslateAnimation(MainActivity.width,0,-((MainActivity.slide_z/2)+MainActivity.slide_z_val),0);
								trans_slide1.setDuration(700);
								
								TranslateAnimation trans_slide2 = new TranslateAnimation(-MainActivity.width,0,((MainActivity.slide_z/2)+MainActivity.slide_z_val),0);
								trans_slide2.setDuration(700);
								trans_slide2.setAnimationListener(new AnimationListener() {
									@Override
									public void onAnimationEnd(Animation animation) {
										MainActivity.led_slide1.clearAnimation();
										MainActivity.led_slide2.clearAnimation();
										
										AlphaAnimation fadein = new AlphaAnimation(0.0f,1.0f);
										fadein.setDuration(500);
										fadein.setAnimationListener(new AnimationListener() {
											@Override
											public void onAnimationEnd(Animation animation) {
												MainActivity.led_slide1_image1.setVisibility(View.GONE);
												MainActivity.led_slide2_image1.setVisibility(View.GONE);
												MainActivity.led_slide1_image2.clearAnimation();
												MainActivity.led_slide2_image2.clearAnimation();
												
												MainActivity.phaseInt(2);
												MainActivity.s_l_a_Int(2);
												MainActivity.isFinish(true);
											}
											@Override
											public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
										});
										
										MainActivity.led_slide1_image2.setVisibility(View.VISIBLE);
										MainActivity.led_slide2_image2.setVisibility(View.VISIBLE);
										MainActivity.led_slide1_image2.setAnimation(fadein);
										MainActivity.led_slide2_image2.startAnimation(fadein);
									}
									@Override
									public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
								});
								
								MainActivity.led_slide1.setVisibility(View.VISIBLE);
								MainActivity.led_slide2.setVisibility(View.VISIBLE);
								MainActivity.led_slide1.startAnimation(trans_slide1);
								MainActivity.led_slide2.startAnimation(trans_slide2);
							}
							@Override
							public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
						});
						MainActivity.led_promenade_info_layout.startAnimation(transform);
					}
					@Override
					public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
				});
				MainActivity.led_promenade_info_list_layout.setAnimation(slide_up);
				MainActivity.led_promenade_info_spots_holder_layout.startAnimation(slide_up);
			}
		},100);
	}
	
	public static void led_naia_phase3_back_to_main_menu() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				MainActivity.isFinish(false);
				Animation slide_up = AnimationUtils.loadAnimation(MainActivity.context,R.anim.slide_up);
				slide_up.setInterpolator(new DecelerateInterpolator());
				slide_up.setDuration(500);
				slide_up.setAnimationListener(new AnimationListener() {
					@Override
					public void onAnimationEnd(Animation animation) {
						MainActivity.led_naia_info_list_layout.setVisibility(View.GONE);
						MainActivity.led_naia_info_spots_holder_layout.setVisibility(View.GONE);
						MainActivity.led_naia_info_list_layout.clearAnimation();
						MainActivity.led_naia_info_spots_holder_layout.clearAnimation();
						
						Transform_Led_Naia_Phase3 transform = new Transform_Led_Naia_Phase3(false);
						transform.setDuration(500);
						transform.setAnimationListener(new AnimationListener() {
							@Override
							public void onAnimationEnd(Animation animation) {
								MainActivity.led_naia_info_layout.setVisibility(View.GONE);
								MainActivity.led_naia_info_layout.clearAnimation();
								
								TranslateAnimation trans_slide1 = new TranslateAnimation(MainActivity.width,0,-((MainActivity.slide_z/2)+MainActivity.slide_z_val),0);
								trans_slide1.setDuration(700);
								
								TranslateAnimation trans_slide2 = new TranslateAnimation(-MainActivity.width,0,((MainActivity.slide_z/2)+MainActivity.slide_z_val),0);
								trans_slide2.setDuration(700);
								trans_slide2.setAnimationListener(new AnimationListener() {
									@Override
									public void onAnimationEnd(Animation animation) {
										MainActivity.led_slide1.clearAnimation();
										MainActivity.led_slide2.clearAnimation();
										
										AlphaAnimation fadein = new AlphaAnimation(0.0f,1.0f);
										fadein.setDuration(500);
										fadein.setAnimationListener(new AnimationListener() {
											@Override
											public void onAnimationEnd(Animation animation) {
												MainActivity.led_slide1_image1.setVisibility(View.GONE);
												MainActivity.led_slide2_image1.setVisibility(View.GONE);
												MainActivity.led_slide1_image2.clearAnimation();
												MainActivity.led_slide2_image2.clearAnimation();
												MainActivity.led_naia_information_holder_layout.removeAllViews();
												
												MainActivity.phaseInt(2);
												MainActivity.s_l_a_Int(2);
												MainActivity.isFinish(true);
											}
											@Override
											public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
										});
										
										MainActivity.led_slide1_image2.setVisibility(View.VISIBLE);
										MainActivity.led_slide2_image2.setVisibility(View.VISIBLE);
										MainActivity.led_slide1_image2.setAnimation(fadein);
										MainActivity.led_slide2_image2.startAnimation(fadein);
									}
									@Override
									public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
								});
								
								MainActivity.led_slide1.setVisibility(View.VISIBLE);
								MainActivity.led_slide2.setVisibility(View.VISIBLE);
								MainActivity.led_slide1.startAnimation(trans_slide1);
								MainActivity.led_slide2.startAnimation(trans_slide2);
							}
							@Override
							public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
						});
						MainActivity.led_naia_info_layout.startAnimation(transform);
					}
					@Override
					public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
				});
				MainActivity.led_naia_info_list_layout.setAnimation(slide_up);
				MainActivity.led_naia_info_spots_holder_layout.startAnimation(slide_up);
			}
		},100);
	}
	
	public static void led_phase2_back_to_main_menu() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				MainActivity.isFinish(false);
				TranslateAnimation trans_slide1 = new TranslateAnimation(0,MainActivity.width,0,-((MainActivity.slide_z/2)+MainActivity.slide_z_val));
				trans_slide1.setDuration(700);
				
				TranslateAnimation trans_slide2 = new TranslateAnimation(0,-MainActivity.width,0,((MainActivity.slide_z/2)+MainActivity.slide_z_val));
				trans_slide2.setDuration(700);
				trans_slide2.setAnimationListener(new AnimationListener() {
					@Override
					public void onAnimationEnd(Animation animation) {
						MainActivity.led_slide1_image1.setVisibility(View.VISIBLE);
						MainActivity.led_slide2_image1.setVisibility(View.VISIBLE);
						MainActivity.led_slide1_image2.setVisibility(View.GONE);
						MainActivity.led_slide2_image2.setVisibility(View.GONE);
						MainActivity.led_slide1.setVisibility(View.GONE);
						MainActivity.led_slide2.setVisibility(View.GONE);
						MainActivity.led_slide1.clearAnimation();
						MainActivity.led_slide2.clearAnimation();
						
						Transform_Led_Logo trans_logo = new Transform_Led_Logo(false);
						trans_logo.setDuration(500);
						trans_logo.setAnimationListener(new AnimationListener() {
							@Override
							public void onAnimationEnd(Animation animation) {
								MainActivity.led_slide_logo_layout.setVisibility(View.GONE);
								MainActivity.led_slide_layout.setVisibility(View.GONE);
								MainActivity.led_slide_logo.clearAnimation();
								
								Transform_Home_Menu transform = new Transform_Home_Menu(true);
								transform.setDuration(500);
								transform.setAnimationListener(new AnimationListener() {
									@Override
									public void onAnimationEnd(Animation animation) {
										MainActivity.video_image.clearAnimation();
										MainActivity.phaseInt(1);
										MainActivity.s_l_a_Int(0);
										MainActivity.isFinish(true);
									}
									@Override
									public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
								});
								MainActivity.video_image_layout.setVisibility(View.VISIBLE);
								MainActivity.menu_layout.setVisibility(View.VISIBLE);
								MainActivity.video_image.startAnimation(transform);
							}
							@Override
							public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
						});
						MainActivity.led_slide_logo.startAnimation(trans_logo);
					}
					@Override
					public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
				});
				MainActivity.led_slide1.startAnimation(trans_slide1);
				MainActivity.led_slide2.startAnimation(trans_slide2);	
			}
		},100);
	}
	
	public static void static_home_phase3_back_to_main_menu() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				MainActivity.isFinish(false);
				TranslateAnimation trans_lr = new TranslateAnimation(0,-MainActivity.width,0,0);
				trans_lr.setInterpolator(new DecelerateInterpolator());
				trans_lr.setDuration(500);
				trans_lr.setAnimationListener(new AnimationListener() {
					@Override
					public void onAnimationEnd(Animation animation) {
						MainActivity.static_info_enquire.setVisibility(View.GONE);
						MainActivity.static_info_enquire.clearAnimation();
						//MainActivity.static_avialability_status.setText("");
						
						Animation slide_up = AnimationUtils.loadAnimation(MainActivity.context,R.anim.slide_up);
						slide_up.setInterpolator(new DecelerateInterpolator());
						slide_up.setDuration(500);
						slide_up.setAnimationListener(new AnimationListener() {
							@Override
							public void onAnimationEnd(Animation animation) {
								MainActivity.static_info_list.setVisibility(View.GONE);
								MainActivity.static_info_list.clearAnimation();
							}
							@Override
							public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
						});
						MainActivity.static_info_list.startAnimation(slide_up);
						
						Transform_Static_Phase3 transform = new Transform_Static_Phase3(false);
						transform.setDuration(500);
						transform.setAnimationListener(new AnimationListener() {
							@Override
							public void onAnimationEnd(Animation animation) {
								MainActivity.static_info_layout.setVisibility(View.GONE);
								MainActivity.static_info_layout.clearAnimation();
								
								Transform_Static_Logo trans_logo = new Transform_Static_Logo(false);
								trans_logo.setDuration(500);
								trans_logo.setAnimationListener(new AnimationListener() {
									@Override
									public void onAnimationEnd(Animation animation) {
										MainActivity.static_slide_logo_layout.setVisibility(View.GONE);
										MainActivity.static_slide_layout.setVisibility(View.GONE);
										MainActivity.static_slide_logo.clearAnimation();
										
										Transform_Home_Menu transform = new Transform_Home_Menu(true);
										transform.setDuration(500);
										transform.setAnimationListener(new AnimationListener() {
											@Override
											public void onAnimationEnd(Animation animation) {
												MainActivity.video_image.clearAnimation();
												MainActivity.phaseInt(1);
												MainActivity.s_l_a_Int(0);
												MainActivity.isFinish(true);
											}
											@Override
											public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
										});
										MainActivity.video_image_layout.setVisibility(View.VISIBLE);
										MainActivity.menu_layout.setVisibility(View.VISIBLE);
										MainActivity.video_image.startAnimation(transform);
									}
									@Override
									public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
								});
								MainActivity.static_slide_logo.startAnimation(trans_logo);
							}
							@Override
							public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
						});
						MainActivity.static_info_layout.startAnimation(transform);
					}
					@Override
					public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
				});
				MainActivity.static_info_enquire.startAnimation(trans_lr);
			}
		},100);
	}
	
	public static void static_phase3_back_to_main_menu() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				MainActivity.isFinish(false);
				TranslateAnimation trans_lr = new TranslateAnimation(0,-MainActivity.width,0,0);
				trans_lr.setInterpolator(new DecelerateInterpolator());
				trans_lr.setDuration(500);
				trans_lr.setAnimationListener(new AnimationListener() {
					@Override
					public void onAnimationEnd(Animation animation) {
						MainActivity.static_info_enquire.setVisibility(View.GONE);
						MainActivity.static_info_enquire.clearAnimation();
						//MainActivity.static_avialability_status.setText("");
						
						Animation slide_up = AnimationUtils.loadAnimation(MainActivity.context,R.anim.slide_up);
						slide_up.setInterpolator(new DecelerateInterpolator());
						slide_up.setDuration(500);
						slide_up.setAnimationListener(new AnimationListener() {
							@Override
							public void onAnimationEnd(Animation animation) {
								MainActivity.static_info_list.setVisibility(View.GONE);
								MainActivity.static_info_list.clearAnimation();
							}
							@Override
							public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
						});
						MainActivity.static_info_list.startAnimation(slide_up);
						
						Transform_Static_Phase3 transform = new Transform_Static_Phase3(false);
						transform.setDuration(500);
						transform.setAnimationListener(new AnimationListener() {
							@Override
							public void onAnimationEnd(Animation animation) {
								MainActivity.static_info_layout.setVisibility(View.GONE);
								MainActivity.static_info_layout.clearAnimation();
								
								TranslateAnimation trans_slide1 = new TranslateAnimation(MainActivity.width,0,-((MainActivity.slide_z/2)+MainActivity.slide_z_val),0);
								trans_slide1.setDuration(700);
								
								TranslateAnimation trans_slide2 = new TranslateAnimation(-MainActivity.width,0,((MainActivity.slide_z/2)+MainActivity.slide_z_val),0);
								trans_slide2.setDuration(700);
								trans_slide2.setAnimationListener(new AnimationListener() {
									@Override
									public void onAnimationEnd(Animation animation) {
										MainActivity.static_slide1.clearAnimation();
										MainActivity.static_slide2.clearAnimation();
										
										AlphaAnimation fadein = new AlphaAnimation(0.0f,1.0f);
										fadein.setDuration(500);
										fadein.setAnimationListener(new AnimationListener() {
											@Override
											public void onAnimationEnd(Animation animation) {
												MainActivity.static_slide1_image1.setVisibility(View.GONE);
												MainActivity.static_slide2_image1.setVisibility(View.GONE);
												MainActivity.static_slide1_image2.clearAnimation();
												MainActivity.static_slide2_image2.clearAnimation();
												
												MainActivity.phaseInt(2);
												MainActivity.s_l_a_Int(1);
												MainActivity.isFinish(true);
											}
											@Override
											public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
										});
										
										MainActivity.static_slide1_image2.setVisibility(View.VISIBLE);
										MainActivity.static_slide2_image2.setVisibility(View.VISIBLE);
										MainActivity.static_slide1_image2.setAnimation(fadein);
										MainActivity.static_slide2_image2.startAnimation(fadein);
									}
									@Override
									public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
								});
								MainActivity.static_slide1.setVisibility(View.VISIBLE);
								MainActivity.static_slide2.setVisibility(View.VISIBLE);
								MainActivity.static_slide1.startAnimation(trans_slide1);
								MainActivity.static_slide2.startAnimation(trans_slide2);
							}
							@Override
							public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
						});
						MainActivity.static_info_layout.startAnimation(transform);
					}
					@Override
					public void onAnimationRepeat(Animation animation) {}@Override public void onAnimationStart(Animation animation) {}
				});
				MainActivity.static_info_enquire.startAnimation(trans_lr);
			}
		},100);
	}
	
	public static void static_phase2_back_to_main_menu() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				MainActivity.isFinish(false);
				TranslateAnimation trans_slide1 = new TranslateAnimation(0,MainActivity.width,0,-((MainActivity.slide_z/2)+MainActivity.slide_z_val));
				trans_slide1.setDuration(700);
				
				TranslateAnimation trans_slide2 = new TranslateAnimation(0,-MainActivity.width,0,((MainActivity.slide_z/2)+MainActivity.slide_z_val));
				trans_slide2.setDuration(700);
				trans_slide2.setAnimationListener(new AnimationListener() {
					@Override
					public void onAnimationEnd(Animation animation) {
						MainActivity.static_slide1_image1.setVisibility(View.VISIBLE);
						MainActivity.static_slide2_image1.setVisibility(View.VISIBLE);
						MainActivity.static_slide1_image2.setVisibility(View.GONE);
						MainActivity.static_slide2_image2.setVisibility(View.GONE);
						MainActivity.static_slide1.setVisibility(View.GONE);
						MainActivity.static_slide2.setVisibility(View.GONE);
						MainActivity.static_slide1.clearAnimation();
						MainActivity.static_slide2.clearAnimation();
						
						Transform_Static_Logo trans_logo = new Transform_Static_Logo(false);
						trans_logo.setDuration(500);
						trans_logo.setAnimationListener(new AnimationListener() {
							@Override
							public void onAnimationEnd(Animation animation) {
								MainActivity.static_slide_logo_layout.setVisibility(View.GONE);
								MainActivity.static_slide_layout.setVisibility(View.GONE);
								MainActivity.static_slide_logo.clearAnimation();
								
								Transform_Home_Menu transform = new Transform_Home_Menu(true);
								transform.setDuration(500);
								transform.setAnimationListener(new AnimationListener() {
									@Override
									public void onAnimationEnd(Animation animation) {
										MainActivity.video_image.clearAnimation();
										MainActivity.phaseInt(1);
										MainActivity.s_l_a_Int(0);
										MainActivity.isFinish(true);
									}
									@Override
									public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
								});
								MainActivity.video_image_layout.setVisibility(View.VISIBLE);
								MainActivity.menu_layout.setVisibility(View.VISIBLE);
								MainActivity.video_image.startAnimation(transform);
							} 
							@Override
							public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
						});
						MainActivity.static_slide_logo.startAnimation(trans_logo);
					}
					@Override
					public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
				});
				MainActivity.static_slide1.startAnimation(trans_slide1);
				MainActivity.static_slide2.startAnimation(trans_slide2);
			}
		},100);
	}
	
	public static void begin(Context context) {
		final String path = "android.resource://" + context.getPackageName() + "/" + R.drawable.logo_build;
		video_layout.setVisibility(View.VISIBLE);
		video.setVideoURI(Uri.parse(path));
		video.start();	
	}
}
