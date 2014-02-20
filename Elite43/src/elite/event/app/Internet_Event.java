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
import elite.backend.app.MainActivity_Backend;
import elite.custom.app.Loading;

public class Internet_Event implements OnTouchListener {
	
	/**
	 * Initialize interface for network_button1 when touch event is dispatched.
	 */
	@Override
	public boolean onTouch(View v, MotionEvent e) {
		if(e.getAction() == MotionEvent.ACTION_UP) {
			MainActivity.network_button1.setImageResource(R.drawable.button_resync);
			final TranslateAnimation trans_rll = new TranslateAnimation(0,-MainActivity.width,0,0);
			trans_rll.setInterpolator(new DecelerateInterpolator());
			trans_rll.setDuration(300);
			
			final TranslateAnimation trans_lrr = new TranslateAnimation(0,MainActivity.width,0,0);
			trans_lrr.setInterpolator(new DecelerateInterpolator());
			trans_lrr.setDuration(300);
			trans_lrr.setAnimationListener(new AnimationListener() {
				
				//Run the layout animation for network_layout when clicked until the animation ends.
				@Override
				public void onAnimationEnd(Animation animation) {
					MainActivity.network_layout.setVisibility(View.GONE);
					MainActivity.network_info_layout.setVisibility(View.GONE);
					MainActivity.network_buttons_layout.setVisibility(View.GONE);
					MainActivity.network_info_layout.clearAnimation();
					MainActivity.network_buttons_layout.clearAnimation();
				
					final Loading loading = new Loading(MainActivity.context,"Connecting to Network...");
					loading.show();
					loading.startLoading();
					
					new Handler().postDelayed(new Runnable() {
						@Override
						public void run() {
							loading.stopLoading();
							MainActivity_Backend.NetworkAccess();
						}
					},4000);
				}
				
				//Run the animation for components repeatedly whenever clicked.
				@Override
				public void onAnimationRepeat(Animation animation) {
					
				} 
				
				@Override public void onAnimationStart(Animation animation) {
					
				}
			});
			
			new Handler().postDelayed(new Runnable() {
				
				//Execution of context.
				@Override
				public void run() {
					MainActivity.network_info_layout.startAnimation(trans_rll);
					MainActivity.network_buttons_layout.startAnimation(trans_lrr);
				}
			},100);
		}
		else if(e.getAction() == MotionEvent.ACTION_DOWN) {
			MainActivity.network_button1.setImageResource(R.drawable.button_resync_active);
		}
		return false;
	}
}
