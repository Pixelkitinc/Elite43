package elite.act.app;

import android.R.color;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.VideoView;
import elite.event.app.About_Event;
import elite.event.app.About_Main_Menu_Event;
import elite.event.app.Led_Enquire_Greenhills_Event;
import elite.event.app.Led_Enquire_Naia_Event;
import elite.event.app.Led_Event;
import elite.event.app.Led_Logo_Event;
import elite.event.app.Led_Slide1_Event;
import elite.event.app.Led_Slide2_Event;
import elite.event.app.Proceed_Event;
import elite.event.app.Static_Enquire_Event;
import elite.event.app.Static_Event;
import elite.event.app.Static_Logo_Event;
import elite.event.app.Static_Slide1_Event;
import elite.event.app.Static_Slide2_Event;
import elite.event.app.Video_Event1;
import elite.event.app.Video_Event2;
import elite.view.app.MainVIew;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")
public class MainActivity extends Activity {
	public static Context context;
	public static RelativeLayout main_layout;
	public static RelativeLayout video_layout;
	public static VideoView video;
	public static RelativeLayout video_image_layout;
	public static ImageView video_image;
	public static TableLayout about_layout;
	public static TextView about_text;
	public static ImageButton about_button;
	public static TextView remark;
	
	public static LinearLayout network_layout;
	public static LinearLayout network_info_layout;
	public static TextView network_internet_wifi_text;
	public static TextView network_date_text;
	public static TextView network_time_text;
	public static RelativeLayout network_buttons_layout;
	public static ImageButton network_button1;
	public static ImageButton network_button2;
	
	public static LinearLayout menu_layout;
	public static RelativeLayout menu_static_layout;
	public static ImageButton menu_static_button;
	public static RelativeLayout menu_led_layout;
	public static ImageButton menu_led_button;
	public static RelativeLayout menu_about_layout;
	public static ImageButton menu_about_button;
	public static RelativeLayout menu_static_label_layout;
	public static TextView menu_static_label;
	public static RelativeLayout menu_led_label_layout;
	public static TextView menu_led_label;
	public static RelativeLayout menu_about_label_layout;
	public static TextView menu_about_label;
	
	
	public static ScrollView static_slide_layout;
	public static RelativeLayout static_slide_logo_layout;
	public static ImageButton static_slide_logo;
	public static RelativeLayout static_slide1;
	public static ImageView static_slide1_image1;
	public static ImageView static_slide1_image2;
	public static TextView static_label1;
	public static Button static_slide1_button;
	public static RelativeLayout static_slide2;
	public static ImageView static_slide2_image1;
	public static ImageView static_slide2_image2;
	public static TextView static_label2;
	public static Button static_slide2_button;
	
	public static RelativeLayout static_info_layout;
	public static ImageView static_info_image;
	public static LinearLayout static_info_list;
	public static TextView static_info_location;
	public static LinearLayout static_info_enquire;
	public static TextView static_avialability_status;
	public static Button static_info_enquire_button;
	
	public static ScrollView led_slide_layout;
	public static RelativeLayout led_slide_logo_layout;
	public static ImageButton led_slide_logo;
	public static RelativeLayout led_slide1;
	public static ImageView led_slide1_image1;
	public static ImageView led_slide1_image2;
	public static TextView led_label1;
	public static Button led_slide1_button;
	public static RelativeLayout led_slide2;
	public static ImageView led_slide2_image1;
	public static ImageView led_slide2_image2;
	public static TextView led_label2;
	public static Button led_slide2_button;
	
	public static RelativeLayout led_naia_info_layout;
	public static ImageView led_naia_info_image;
	public static LinearLayout led_naia_info_list_layout;
	public static LinearLayout led_naia_info_spots_holder_layout;
	public static ProgressBar led_naia_info_progressbar;
	public static Button led_naia_info_enquire_button;
	public static LinearLayout led_naia_information_holder_layout;
	
	public static RelativeLayout led_promenade_info_layout;
	public static ImageView led_promenade_info_image;
	public static LinearLayout led_promenade_info_list_layout;
	public static LinearLayout led_promenade_info_spots_holder_layout;
	public static ProgressBar led_promenade_info_progressbar;
	public static Button led_promenade_info_enquire_button;
	public static LinearLayout led_promenade_information_holder_layout;
	
	private boolean isDeviceSupport = false;
	private boolean isBegin = false;
	private static boolean isFinish = true;
	private static int naia_promenade = 0;
	private static int phase = 0;
	private static int s_l_a = 0;
	public static int width;
	public static int height;
	public static float dpi;
	public static int slide_z;
	public static int slide_z_val;
	private String about_elite43;
	private String remarks;
	//private String we_are;
	
	
	public static int logo_w;
	public static int logo_h;
	public static int logo_m;
	public static int logo_text_m;
	public static int logo_text_size;
	public static int logo_holder_w;
	
	public static void phaseInt(int a) {
		phase = a;
	}
	
	public static void s_l_a_Int(int a) {
		s_l_a = a;
	}
	
	public static void isFinish(boolean b) {
		isFinish = b;
	}
	
	public static void led_naia_promenade(int a) {
		naia_promenade = a;
	}
	
	/**
	 * <p/>
	 * Controls the switching of the screens
	 */
	
	public static void logo_home() {
		if(isFinish) {
			switch(phase) {
			case 2:
					switch(s_l_a) {
					case 1:
							System.out.println("Logo Phase 2 Static");
							MainVIew.static_phase2_back_to_main_menu();
						break;
						
					case 2:
							System.out.println("Logo Phase 2 Led");
							MainVIew.led_phase2_back_to_main_menu();
						break;
					}
				break;
				
			case 3:
					switch(s_l_a) {
					case 1:
							System.out.println("Logo Phase 3 Static");
							MainVIew.static_home_phase3_back_to_main_menu();
						break;
						
					case 2:
							System.out.println("Logo Phase 3 Led");
							switch(naia_promenade) {
    						case 1:
    								MainVIew.led_home_naia_phase3_back_to_main_menu();
    							break;
    							
    						case 2:
    								MainVIew.led_home_promenade_phase3_back_to_main_menu();
    							break;
    						}
						break;
					}
				break;
			}
		}
	}
	
	/**
	 * <p/>
	 * Initializes UI components, sets the layout of the application and other UI components it needs 
	 */
	
	private void initialize() {
		main_layout = (RelativeLayout)findViewById(R.id.main_layout);
			video_layout = (RelativeLayout)findViewById(R.id.video_layout);
				video = (VideoView)findViewById(R.id.video);
				video.setOnCompletionListener(new Video_Event1());
				video.setOnErrorListener(new Video_Event2());
				video_image_layout = (RelativeLayout)findViewById(R.id.video_image_layout);
				video_image = (ImageView)findViewById(R.id.video_image);
				
			about_layout = (TableLayout)findViewById(R.id.about_layout);
				about_text = (TextView)findViewById(R.id.about_text);
				//remark = (TextView)findViewById(R.id.remark);
				//remark.setTextColor(Color.RED);
				//remark.setText(remark);
				about_text.setText(about_elite43);	
				
				about_button = (ImageButton)findViewById(R.id.about_button);
					about_button.setOnTouchListener(new About_Main_Menu_Event());
			
			network_layout = (LinearLayout)findViewById(R.id.network_layout);
				network_info_layout = (LinearLayout)findViewById(R.id.network_info_layout);
					network_internet_wifi_text = (TextView)findViewById(R.id.network_internet_wifi_text);
					network_date_text = (TextView)findViewById(R.id.network_date_text);
					network_time_text = (TextView)findViewById(R.id.network_time_text);
			
				network_buttons_layout = (RelativeLayout)findViewById(R.id.network_buttons_layout);
					network_button1 = (ImageButton)findViewById(R.id.network_button1);
					network_button2 = (ImageButton)findViewById(R.id.network_button2);
						network_button2.setOnTouchListener(new Proceed_Event());
						
			menu_layout = (LinearLayout)findViewById(R.id.menu_layout);
				menu_static_layout = (RelativeLayout)findViewById(R.id.menu_static_layout);
					menu_static_button = (ImageButton)findViewById(R.id.menu_static_button);
						menu_static_button.setOnClickListener(new Static_Event());
					
				menu_led_layout = (RelativeLayout)findViewById(R.id.menu_led_layout);
					menu_led_button = (ImageButton)findViewById(R.id.menu_led_button);
						menu_led_button.setOnClickListener(new Led_Event());
					
				menu_about_layout = (RelativeLayout)findViewById(R.id.menu_about_layout);
					menu_about_button = (ImageButton)findViewById(R.id.menu_about_button);
						menu_about_button.setOnClickListener(new About_Event());
						
				menu_static_label_layout = (RelativeLayout)findViewById(R.id.menu_static_label_layout);
					menu_static_label = (TextView)findViewById(R.id.menu_static_label);
			
				menu_led_label_layout = (RelativeLayout)findViewById(R.id.menu_led_label_layout);
					menu_led_label = (TextView)findViewById(R.id.menu_led_label);
			
				menu_about_label_layout = (RelativeLayout)findViewById(R.id.menu_about_label_layout);
					menu_about_label = (TextView)findViewById(R.id.menu_about_label);
					
			static_slide_layout = (ScrollView)findViewById(R.id.static_slide_layout);
				static_slide_logo_layout = (RelativeLayout)findViewById(R.id.static_slide_logo_layout);
					static_slide_logo = (ImageButton)findViewById(R.id.static_slide_logo);
					static_slide_logo.setOnClickListener(new Static_Logo_Event());
			
			static_slide1 = (RelativeLayout)findViewById(R.id.static_slide1);
				static_slide1_image1 = (ImageView)findViewById(R.id.static_slide1_image1);
				static_slide1_image2 = (ImageView)findViewById(R.id.static_slide1_image2);
				static_label1 = (TextView)findViewById(R.id.static_label1);
				static_slide1_button = (Button)findViewById(R.id.static_slide1_button);
					static_slide1_button.setOnTouchListener(new Static_Slide1_Event());
			
			static_slide2 = (RelativeLayout)findViewById(R.id.static_slide2);
				static_slide2_image1 = (ImageView)findViewById(R.id.static_slide2_image1);
				static_slide2_image2 = (ImageView)findViewById(R.id.static_slide2_image2);
				static_label2 = (TextView)findViewById(R.id.static_label2);
				static_slide2_button = (Button)findViewById(R.id.static_slide2_button);
					static_slide2_button.setOnTouchListener(new Static_Slide2_Event());
					
			static_info_layout = (RelativeLayout)findViewById(R.id.static_info_layout);
				static_info_image = (ImageView)findViewById(R.id.static_info_image);
				static_info_list = (LinearLayout)findViewById(R.id.static_info_list);
				static_info_location = (TextView)findViewById(R.id.static_info_location);
				static_info_enquire = (LinearLayout)findViewById(R.id.static_info_enquire);
				static_avialability_status = (TextView)findViewById(R.id.static_avialability_status);	
				static_info_enquire_button = (Button)findViewById(R.id.static_info_enquire_button);
					static_info_enquire_button.setOnClickListener(new Static_Enquire_Event());
				
			led_slide_layout = (ScrollView)findViewById(R.id.led_slide_layout);
				led_slide_logo_layout = (RelativeLayout)findViewById(R.id.led_slide_logo_layout);
					led_slide_logo = (ImageButton)findViewById(R.id.led_slide_logo);
						led_slide_logo.setOnClickListener(new Led_Logo_Event());
			
				led_slide1 = (RelativeLayout)findViewById(R.id.led_slide1);
					led_slide1_image1 = (ImageView)findViewById(R.id.led_slide1_image1);
					led_slide1_image2 = (ImageView)findViewById(R.id.led_slide1_image2);
					led_label1 = (TextView)findViewById(R.id.led_label1);
					led_slide1_button = (Button)findViewById(R.id.led_slide1_button);
						led_slide1_button.setOnTouchListener(new Led_Slide1_Event());
			
				led_slide2 = (RelativeLayout)findViewById(R.id.led_slide2);
					led_slide2_image1 = (ImageView)findViewById(R.id.led_slide2_image1);
					led_slide2_image2 = (ImageView)findViewById(R.id.led_slide2_image2);
					led_label2 = (TextView)findViewById(R.id.led_label2);
					led_slide2_button = (Button)findViewById(R.id.led_slide2_button);
						led_slide2_button.setOnTouchListener(new Led_Slide2_Event());
						
			led_naia_info_layout = (RelativeLayout)findViewById(R.id.led_naia_info_layout);
				led_naia_info_image = (ImageView)findViewById(R.id.led_naia_info_image);
				led_naia_info_list_layout = (LinearLayout)findViewById(R.id.led_naia_info_list_layout);
			
			led_naia_info_spots_holder_layout = (LinearLayout)findViewById(R.id.led_naia_info_spots_holder_layout);
				led_naia_info_progressbar = (ProgressBar)findViewById(R.id.led_naia_info_progressbar);
				led_naia_info_progressbar.setMax(57600);
				
				led_naia_info_enquire_button = (Button)findViewById(R.id.led_naia_info_enquire_button);
					led_naia_info_enquire_button.setOnClickListener(new Led_Enquire_Naia_Event());
				led_naia_information_holder_layout = (LinearLayout)findViewById(R.id.led_naia_information_holder_layout);
					
			led_promenade_info_layout = (RelativeLayout)findViewById(R.id.led_promenade_info_layout);
				led_promenade_info_image = (ImageView)findViewById(R.id.led_promenade_info_image);
				led_promenade_info_list_layout = (LinearLayout)findViewById(R.id.led_promenade_info_list_layout);
				
			led_promenade_info_spots_holder_layout = (LinearLayout)findViewById(R.id.led_promenade_info_spots_holder_layout);
				led_promenade_info_progressbar = (ProgressBar)findViewById(R.id.led_promenade_info_progressbar);
				led_promenade_info_progressbar.setMax(50400);
					
				led_promenade_info_enquire_button = (Button)findViewById(R.id.led_promenade_info_enquire_button);
					led_promenade_info_enquire_button.setOnClickListener(new Led_Enquire_Greenhills_Event());
				led_promenade_information_holder_layout = (LinearLayout)findViewById(R.id.led_promenade_information_holder_layout);
	}
	
	/**
	 * <p/>
	 * Initializes the android applications where the main layout is usually called on setContentView method.
	 * <p/>
	 * 
	 * @param savedInstanceState {@link Bundle}
	 */
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		context = this;
		
		//@print about elite43		
		String NL = System.getProperty("line.separator");
		about_elite43 = 
				
				NL+NL+
				"elite 43 advertising inc. is a young and vibrant Out-of-Home service provider. We offer companies the best suited avenues to adventure their in order to efficiently reach their target market, by providing our clients a comprehensive package covering strategically located sites, conceptualization, art direction and special executions. Tailor fitting the needs of individual clients in our utmost prerogative."+NL+NL+
				"Backed by a highly specialised team of graphic designers, photographers and artists both in-house and Australia based, most of which are graduates from the prestigious Royal Melbourne Institute of Technology giving us utmost confidence in our capacity to provide your advertising needs and desires that will surely exceed your expectations."+NL+NL+
				"elite 43 has established credibility for being more than just a below-the-line service provider. Our LED screens are specifically designed for us straight from the factory, backed by a local team of technicians on standby 24/7 should any problem arise from our LED billboards. Constantly evolving and setting the trend in outdoor advertising is our mission."+NL+NL+
				"We are here to give you a better perspective.";
		
		remarks = "nowhere.nowHere " +NL+ "changing your perspective";
		/*
		 *Checks the android version to enable the android strict mode API.
		 * 
		 */
		
		if(android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
		
		dpi = this.getResources().getDisplayMetrics().density;
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		width = metrics.widthPixels;
		height = metrics.heightPixels;
		
		int screenSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
		int screenDensity = getResources().getDisplayMetrics().densityDpi;
		
		
		/*
		 * Condition to set density of the application
		 * 
		 */
	    switch(screenSize) {
	    case Configuration.SCREENLAYOUT_SIZE_NORMAL:
	        	switch(screenDensity) {
	    	    case DisplayMetrics.DENSITY_XHIGH:
	    	    	setContentView(R.layout.main_activity);
	    	    	isDeviceSupport = true;
	    	    	isBegin = true;
	    	    	initialize();
	    	    	slide_z = (int)(260 * dpi);
	    	    	slide_z_val = (int)(14 * dpi);
	    	    		
	    	    	logo_w = (int)(65 * dpi);
	    	    	logo_h = (int)(65 * dpi);
	    	    	logo_m = (int)(85 * dpi);
	    	    	logo_text_m = (int)(18 * dpi); 
	    	    	logo_text_size = (int)(10 * dpi);
	    	    	logo_holder_w = (int)(250 * dpi);
	    	    	
	    	    		switch(width) {
	    	    		case 768:
	    	    			int rt1_768 = (int)(350 * dpi);
	    	    			int rt1_768_pad_top = (int)(2 * dpi);
	    	    				
	    	    			int rt2_768 = (int)(350 * dpi);
	    	    			int rt2_768_pad_top = (int)(1 * dpi);
	    	    			
	    	    			static_label1.setRotation(rt1_768);
	    	    			static_label2.setRotation(rt1_768);
	    	    			led_label1.setRotation(rt2_768);
	    	    			led_label2.setRotation(rt2_768);
	    	    				
	    	    			static_label1.setPadding(0, rt1_768_pad_top, 0, 0);
	    	    			static_label2.setPadding(0, rt1_768_pad_top, 0, 0);
	    	    			led_label1.setPadding(0, rt2_768_pad_top, 0, 0);
	    	    			led_label2.setPadding(0, rt2_768_pad_top, 0, 0);
	    	    			break;
	    	    		}
	    	    	break;
	    	        
	    	    case DisplayMetrics.DENSITY_XXHIGH:
	    	    	setContentView(R.layout.main_activity);
	    	    	isDeviceSupport = true;
	    	    	isBegin = true;
	    	    	initialize();
	    	    	slide_z = (int)(260 * dpi);
	    	    	slide_z_val = (int)(14 * dpi);
    	    		
	    	    	logo_w = (int)(65 * dpi);
	    	    	logo_h = (int)(65 * dpi);
	    	    	logo_m = (int)(85 * dpi);
	    	    	logo_text_m = (int)(18 * dpi);
	    	    	logo_text_size = (int)(6.5 * dpi);
	    	    	logo_holder_w = (int)(250 * dpi);
	    	    	break;
	    	    }
	        break;
	            
	    case Configuration.SCREENLAYOUT_SIZE_LARGE:
	        	switch(screenDensity) {	
	    	    case DisplayMetrics.DENSITY_TV:
	    	    	setContentView(R.layout.main_activity);
	    	    	isDeviceSupport = true;
	    	    	isBegin = true;
	    	    	initialize();
	    	    	slide_z = (int)(360 * dpi);
	    	    	slide_z_val = (int)(19 * dpi);
	    	    		
	    	    	logo_w = (int)(95 * dpi);
	    	    	logo_h = (int)(95 * dpi);
	    	    	logo_m = (int)(120 * dpi);
	    	    	logo_text_m = (int)(30 * dpi);
	    	    	logo_text_size = (int)(21 * dpi);
	    	    	logo_holder_w = (int)(350 * dpi);
	    	    	break;
	    	    }
	        break;  
	    }
	}
	
	/**
	 * <p/>
	 * Starts the application and sets the flag isBegin to false indicating it already started.
	 */
	@Override
	protected void onStart() {
		super.onStart();
		if(isDeviceSupport) {
			if(isBegin) {
				isBegin = false;
				new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						MainVIew.begin(getApplication());
					}
				},1000);
			}
		}
	}
	
	/**
	 * <p/>
	 * Key event listener for application screen transition.
	 * 
	 * @param keyCode {@link Integer}
	 * @param event {@link KeyEvent}
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_HOME)) { 
        	return true;
        }
        
        if((keyCode == KeyEvent.KEYCODE_BACK)) {
        	if(isFinish) {
        		switch(phase) {
            	case 1:
            			finish();
            		break;
            		
            	case 2:
            			switch(s_l_a) {
            			case 1:
            					System.out.println("Phase 2 Static");
            					MainVIew.static_phase2_back_to_main_menu();
            				break;
            				
            			case 2:
            					System.out.println("Phase 2 Led");
            					MainVIew.led_phase2_back_to_main_menu();
            				break;
            				
            			case 3:
            					System.out.println("Phase 2 About");
            					MainVIew.about_phase2_back_to_main_menu();
            				break;
            			}
            		break;
            		
            	case 3:
            			switch(s_l_a) {
            			case 1:
        						System.out.println("Phase 3 Static");
        						MainVIew.static_phase3_back_to_main_menu();
        					break;
        				
            			case 2:
        						System.out.println("Phase 3 Led");
        						switch(naia_promenade) {
        						case 1:
        								MainVIew.led_naia_phase3_back_to_main_menu();
        							break;
        							
        						case 2:
        								MainVIew.led_promenade_phase3_back_to_main_menu();
        							break;
        						}
        					break;
            			}
            		break;
            	}
        	}
        	return true;
        }
        
        if((keyCode == KeyEvent.KEYCODE_MENU)) {
        	return true;
        }
        return false;
    }
}
