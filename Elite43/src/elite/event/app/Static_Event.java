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
import elite.custom.app.Transform_Static_Logo;

public class Static_Event implements OnClickListener {
	//Invokes the context for Static_Event
	@Override
	public void onClick(View v) {
		new Handler().postDelayed(new Runnable() {
			
			//Execution of layout and animation for menu_led_button when touch event is dispatched.
			@Override
			public void run() {
				MainActivity.menu_static_button.setOnClickListener(null);
				MainActivity.isFinish(false);
				Transform_Home_Menu transform = new Transform_Home_Menu(false);
				transform.setDuration(500);
				transform.setAnimationListener(new AnimationListener() {
					
					
					//Runs the context when touch event is dispatched and animation ends.
					public void onAnimationEnd(Animation animation) {
						MainActivity.video_image_layout.setVisibility(View.GONE);
						MainActivity.menu_layout.setVisibility(View.GONE);
						MainActivity.menu_static_button.clearAnimation();
						MainActivity.static_slide_layout.setVisibility(View.VISIBLE);
						MainActivity.static_slide_logo_layout.setVisibility(View.VISIBLE);
						
						Transform_Static_Logo trans_logo = new Transform_Static_Logo(true);
						trans_logo.setDuration(500);
						trans_logo.setAnimationListener(new AnimationListener() {
							
							//Executes the animation and layout for Static_Event and animation ends.
							@Override
							public void onAnimationEnd(Animation animation) {
								MainActivity.static_slide1.setVisibility(View.VISIBLE);
								MainActivity.static_slide2.setVisibility(View.VISIBLE);
								MainActivity.static_slide_logo.clearAnimation();
								
								TranslateAnimation trans_slide1 = new TranslateAnimation(MainActivity.width,0,-((MainActivity.slide_z/2)+MainActivity.slide_z_val),0);
								trans_slide1.setDuration(700);
								
								TranslateAnimation trans_slide2 = new TranslateAnimation(-MainActivity.width,0,((MainActivity.slide_z/2)+MainActivity.slide_z_val),0);
								trans_slide2.setDuration(700);
								trans_slide2.setAnimationListener(new AnimationListener() {
									
									//Executes the animation and layout for components and animation ends.
									@Override
									public void onAnimationEnd(Animation animation) {
										MainActivity.static_slide1.clearAnimation();
										MainActivity.static_slide2.clearAnimation();
										
										// Fades when touch event is dispatched on components.
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
												MainActivity.menu_static_button.setOnClickListener(new Static_Event());
											}
											
											//Executes the context animation repeatedly when touch event is dispatched.
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
								
								MainActivity.static_slide1.startAnimation(trans_slide1);
								MainActivity.static_slide2.startAnimation(trans_slide2);
							}
							@Override
							public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
						});
						MainActivity.static_slide_logo.startAnimation(trans_logo);
					}
					@Override
					public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
				});
				MainActivity.menu_static_button.startAnimation(transform);
			}
		},100);
	}
}
