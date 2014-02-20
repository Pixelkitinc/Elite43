package elite.event.app;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import elite.act.app.MainActivity;
import elite.act.app.R;

public class Proceed_Event implements OnTouchListener {
	
	//Invokes the context for Proceed_Event after touch event is dispatched.
	@Override
	public boolean onTouch(View v, MotionEvent e) {
		if(e.getAction() == MotionEvent.ACTION_UP) {
			MainActivity.network_button2.setImageResource(R.drawable.button_proceed_nosync);
			final TranslateAnimation trans_rll = new TranslateAnimation(0,-MainActivity.width,0,0);
			trans_rll.setInterpolator(new DecelerateInterpolator());
			trans_rll.setDuration(300);
			
			final TranslateAnimation trans_lrr = new TranslateAnimation(0,MainActivity.width,0,0);
			trans_lrr.setInterpolator(new DecelerateInterpolator());
			trans_lrr.setDuration(300);
			trans_lrr.setAnimationListener(new AnimationListener() {
				
				//Will execute the context and the animation will end.
				@Override
				public void onAnimationEnd(Animation animation) {
					MainActivity.network_layout.setVisibility(View.GONE);
					MainActivity.network_info_layout.setVisibility(View.GONE);
					MainActivity.network_buttons_layout.setVisibility(View.GONE);
					MainActivity.network_info_layout.clearAnimation();
					MainActivity.network_buttons_layout.clearAnimation();
					
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
								//Executes the context and repeats animation.
								@Override
								public void onAnimationRepeat(Animation animation) {}@Override public void onAnimationStart(Animation animation) {}
							});
							
							MainActivity.menu_layout.setVisibility(View.VISIBLE);
							MainActivity.menu_layout.startAnimation(trans_rl);
						}
					},100);
				}
				@Override
				public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
			});
			
			new Handler().postDelayed(new Runnable() {
				
				//Executes the layout and animation				
				@Override
				public void run() {
					MainActivity.network_info_layout.startAnimation(trans_rll);
					MainActivity.network_buttons_layout.startAnimation(trans_lrr);
				}
			},100);
		}
		else if(e.getAction() == MotionEvent.ACTION_DOWN) {
			MainActivity.network_button2.setImageResource(R.drawable.button_proceed_nosync_active);
		}
		return false;
	}
}
