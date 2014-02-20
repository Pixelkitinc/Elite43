package elite.event.app;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import elite.act.app.MainActivity;
import elite.act.app.R;
import elite.custom.app.Transform_Led_Greenhills_Phase3;
import elite.view.app.MainVIew;

public class Led_Slide2_Event implements OnTouchListener {
	
	//Invokes the context when touch event is dispatch for Led_slide2.
	@Override
	public boolean onTouch(View v, MotionEvent e) {
		if(e.getAction() == MotionEvent.ACTION_UP) {
			MainActivity.led_slide2_image2.setImageResource(R.drawable.site_promenade_b);
			MainActivity.isFinish(false);
			MainActivity.led_naia_promenade(2);
			new Handler().postDelayed(new Runnable() {
				
				//Executes the layout and animation when touch event is dispatch to led_slide2_button. 
				@Override
				public void run() {
					MainActivity.led_slide2_button.setOnTouchListener(null);
					TranslateAnimation trans_slide1 = new TranslateAnimation(0,MainActivity.width,0,-((MainActivity.slide_z/2)+MainActivity.slide_z_val));
					trans_slide1.setDuration(700);
					
					TranslateAnimation trans_slide2 = new TranslateAnimation(0,-MainActivity.width,0,((MainActivity.slide_z/2)+MainActivity.slide_z_val));
					trans_slide2.setDuration(700);
					trans_slide2.setAnimationListener(new AnimationListener() {
						
						//Executes the animation for Led_Greenhills_Phase3
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
							
							Transform_Led_Greenhills_Phase3 transform = new Transform_Led_Greenhills_Phase3(true);
							transform.setDuration(500);
							transform.setAnimationListener(new AnimationListener() {
								
								///Executes layout and animation for led_promenade_info until it ends. 
								@Override
								public void onAnimationEnd(Animation animation) {
									MainActivity.led_promenade_info_layout.clearAnimation();
									
									Animation slide_down = AnimationUtils.loadAnimation(MainActivity.context,R.anim.slide_down);
									slide_down.setInterpolator(new DecelerateInterpolator());
									slide_down.setDuration(500);
									slide_down.setAnimationListener(new AnimationListener() {
										
										//Executes the animation and layout for
										@Override
										public void onAnimationEnd(Animation animation) {
											MainActivity.led_promenade_info_list_layout.clearAnimation();
											MainActivity.led_promenade_info_spots_holder_layout.clearAnimation();
											
											MainActivity.phaseInt(3);
											MainActivity.s_l_a_Int(2);
											MainActivity.isFinish(true);
											MainActivity.led_slide2_button.setOnTouchListener(new Led_Slide2_Event());
										}
										
										//Executes the layout and animation for led_promenade repeatedly when touch event is dispatched.
										@Override
										public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
									});
									
									MainActivity.led_promenade_info_list_layout.setVisibility(View.VISIBLE);
									MainActivity.led_promenade_info_spots_holder_layout.setVisibility(View.VISIBLE);
									MainVIew.greenhills_info();
									
									MainActivity.led_promenade_info_list_layout.setAnimation(slide_down);
									MainActivity.led_promenade_info_spots_holder_layout.startAnimation(slide_down);
								}
								
								//Executes a fade animation after touch event is dispatched.
								@Override
								public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
							});
							
							AlphaAnimation fadein = new AlphaAnimation(0.0f,1.0f);
							fadein.setInterpolator(new DecelerateInterpolator());
							fadein.setDuration(500);
							fadein.setAnimationListener(new AnimationListener() {
								@Override
								public void onAnimationEnd(Animation animation) {
									MainActivity.led_promenade_info_image.clearAnimation();
								}
								@Override
								public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
							});
							
							MainActivity.led_promenade_info_image.setImageResource(R.drawable.site_promenade_b);
							MainActivity.led_promenade_info_layout.setVisibility(View.VISIBLE);
							MainActivity.led_promenade_info_layout.startAnimation(transform);
							MainActivity.led_promenade_info_image.startAnimation(fadein);
						}
						@Override
						public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
					});
					
					MainActivity.led_slide1.startAnimation(trans_slide1);
					MainActivity.led_slide2.startAnimation(trans_slide2);
				}
			},100);
		}
		else if(e.getAction() == MotionEvent.ACTION_DOWN) {
			MainActivity.led_slide2_image2.setImageResource(R.drawable.site_promenade_a);
		}
		return false;
	}
}
