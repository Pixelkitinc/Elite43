package elite.event.app;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import elite.act.app.MainActivity;
import elite.custom.app.Transform_Home_Menu;
import elite.custom.app.Transform_Led_Logo;

public class Led_Event implements OnClickListener {
	
	/**
	 *  Invokes context for components when touch event is dispatched.
	 */
	@Override
	public void onClick(View v) {
		new Handler().postDelayed(new Runnable() {
			//Execution of layout and animation for menu_led_button when clicked
			@Override
			public void run() {
				MainActivity.menu_led_button.setOnClickListener(null);
				MainActivity.isFinish(false);
				Transform_Home_Menu transform = new Transform_Home_Menu(false);
				transform.setDuration(500);
				transform.setAnimationListener(new AnimationListener() {
					
					//Runs the layout and animation for Led_slide when clicked until the animation end.
					@Override
					public void onAnimationEnd(Animation animation) {
						MainActivity.video_image_layout.setVisibility(View.GONE);
						MainActivity.menu_layout.setVisibility(View.GONE);
						MainActivity.menu_static_button.clearAnimation();
						MainActivity.led_slide_layout.setVisibility(View.VISIBLE);
						MainActivity.led_slide_logo_layout.setVisibility(View.VISIBLE);
						
						Transform_Led_Logo trans_logo = new Transform_Led_Logo(true);
						trans_logo.setDuration(500);
						trans_logo.setAnimationListener(new AnimationListener() {
							
							//Executes the animation and layout for Led_slide until it ends.
							@Override
							public void onAnimationEnd(Animation animation) {
								MainActivity.led_slide1.setVisibility(View.VISIBLE);
								MainActivity.led_slide2.setVisibility(View.VISIBLE);
								MainActivity.led_slide_logo.clearAnimation();
								
								TranslateAnimation trans_slide1 = new TranslateAnimation(MainActivity.width,0,-((MainActivity.slide_z/2)+MainActivity.slide_z_val),0);
								trans_slide1.setDuration(700);
								
								TranslateAnimation trans_slide2 = new TranslateAnimation(-MainActivity.width,0,((MainActivity.slide_z/2)+MainActivity.slide_z_val),0);
								trans_slide2.setDuration(700);
								trans_slide2.setAnimationListener(new AnimationListener() {
									
									//Executes the animation and layout for components.
									@Override
									public void onAnimationEnd(Animation animation) {
										MainActivity.led_slide1.clearAnimation();
										MainActivity.led_slide2.clearAnimation();
										
										// Fades when touch event is dispatched on components.
										AlphaAnimation fadein = new AlphaAnimation(0.0f,1.0f);
										fadein.setDuration(500);
										fadein.setAnimationListener(new AnimationListener() {
											
											//Executes the context for Led_event and animation ends.
											@Override
											public void onAnimationEnd(Animation animation) {
												MainActivity.led_slide1_image1.setVisibility(View.GONE);
												MainActivity.led_slide2_image1.setVisibility(View.GONE);
												MainActivity.led_slide1_image2.clearAnimation();
												MainActivity.led_slide2_image2.clearAnimation();
												
												MainActivity.phaseInt(2);
												MainActivity.s_l_a_Int(2);
												MainActivity.isFinish(true);
												MainActivity.menu_led_button.setOnClickListener(new Led_Event());
											}
											
											//Executes the components and animation repeatedly when touch event is dispatched.
											@Override
											public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
										});
										
										MainActivity.led_slide1_image2.setVisibility(View.VISIBLE);
										MainActivity.led_slide2_image2.setVisibility(View.VISIBLE);
										MainActivity.led_slide1_image2.setAnimation(fadein);
										MainActivity.led_slide2_image2.startAnimation(fadein);
									}
									
									//Executes all layout and animation for 
									@Override
									public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
								});
								
								MainActivity.led_slide1.startAnimation(trans_slide1);
								MainActivity.led_slide2.startAnimation(trans_slide2);
							}
							@Override
							public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
						});
						MainActivity.led_slide_logo.startAnimation(trans_logo);
					}
					
					//Executes layout and animation for menu_static_button
					@Override
					public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
				});
				MainActivity.menu_static_button.startAnimation(transform);
			}
		},100);
	}
}
