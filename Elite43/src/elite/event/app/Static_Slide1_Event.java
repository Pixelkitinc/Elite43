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
import elite.custom.app.Transform_Static_Phase3;
import elite.view.app.MainVIew;

public class Static_Slide1_Event implements OnTouchListener {
	
	/**
	 * <p/> 
	 * Invokes the context and executes the components.
	 * 
	 */
	
	@Override
	public boolean onTouch(View v, MotionEvent e) {
		if(e.getAction() == MotionEvent.ACTION_UP) {
			MainActivity.static_slide1_image2.setImageResource(R.drawable.site_nlexnorthbound_a);
			MainActivity.isFinish(false);
			Static_Enquire_Event.north_south(1);
			new Handler().postDelayed(new Runnable() {
				
				      
				@Override
				public void run() {
					MainActivity.static_slide1_button.setOnTouchListener(null);
					TranslateAnimation trans_slide1 = new TranslateAnimation(0,MainActivity.width,0,-((MainActivity.slide_z/2)+MainActivity.slide_z_val));
					trans_slide1.setDuration(700);
					
					TranslateAnimation trans_slide2 = new TranslateAnimation(0,-MainActivity.width,0,((MainActivity.slide_z/2)+MainActivity.slide_z_val));
					trans_slide2.setDuration(700);
					trans_slide2.setAnimationListener(new AnimationListener() {
						
						//Executes context and transform for  to animation ends.
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
							
							//Notified the end of event for animation.
							Transform_Static_Phase3 transform = new Transform_Static_Phase3(true);
							transform.setDuration(500);
							transform.setAnimationListener(new AnimationListener() {
								
								
								@Override
								public void onAnimationEnd(Animation animation) {
									MainActivity.static_info_layout.clearAnimation();
									
									Animation slide_down = AnimationUtils.loadAnimation(MainActivity.context,R.anim.slide_down);
									slide_down.setInterpolator(new DecelerateInterpolator());
									slide_down.setDuration(500);
									slide_down.setAnimationListener(new AnimationListener() {
										@Override
										public void onAnimationEnd(Animation animation) {
											MainActivity.static_info_list.clearAnimation();
											
											TranslateAnimation trans_lr = new TranslateAnimation(-MainActivity.width,0,0,0);
											trans_lr.setInterpolator(new DecelerateInterpolator());
											trans_lr.setDuration(500);
											trans_lr.setAnimationListener(new AnimationListener() {
												@Override
												public void onAnimationEnd(Animation animation) {
													MainActivity.static_info_enquire.clearAnimation();
													MainActivity.phaseInt(3);
													MainActivity.s_l_a_Int(1);
													MainActivity.isFinish(true);
													MainActivity.static_slide1_button.setOnTouchListener(new Static_Slide1_Event());
												}
												@Override
												public void onAnimationRepeat(Animation animation) {}@Override public void onAnimationStart(Animation animation) {}
											});
											
											MainActivity.static_info_enquire.setVisibility(View.VISIBLE);
											MainActivity.static_info_enquire.startAnimation(trans_lr);
										}
										@Override
										public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
									});
									
									MainActivity.static_info_list.setVisibility(View.VISIBLE);
									MainVIew.static_north_south_info(1);
									
									MainActivity.static_info_list.startAnimation(slide_down);
								}
								@Override
								public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
							});
							
							AlphaAnimation fadein = new AlphaAnimation(0.0f,1.0f);
							fadein.setInterpolator(new DecelerateInterpolator());
							fadein.setDuration(500);
							fadein.setAnimationListener(new AnimationListener() {
								@Override
								public void onAnimationEnd(Animation animation) {
									MainActivity.static_info_image.clearAnimation();
								}
								@Override
								public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
							});
							
							MainActivity.static_info_image.setImageResource(R.drawable.site_nlexnorthbound_a);
							MainActivity.static_info_location.setText("Nlex - Marilao Exit Northbound");
							MainActivity.static_info_layout.setVisibility(View.VISIBLE);
							MainActivity.static_info_layout.startAnimation(transform);
							MainActivity.static_info_image.startAnimation(fadein);
						}
						@Override
						public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
					});
					
					MainActivity.static_slide1.startAnimation(trans_slide1);
					MainActivity.static_slide2.startAnimation(trans_slide2);
				}
			},100);	
		}
		else if(e.getAction() == MotionEvent.ACTION_DOWN) {
			MainActivity.static_slide1_image2.setImageResource(R.drawable.site_nlexnorthbound_b);
		}
		return false;
	}
}
