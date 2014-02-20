package elite.event.app;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import elite.act.app.MainActivity;
import elite.act.app.R;

public class About_Event implements OnClickListener {
	
	
	/**
	 * <p/>
	 * Called when a view has been clicked. Executes the active subclasses 
	 * and transform animation.
	 *  
	 */
	@Override
	public void onClick(View v) {
		new Handler().postDelayed(new Runnable() {
			
			//Execution of layout and animation for menu_about_button when touch event is dispatched.
			@Override
			public void run() {
				MainActivity.menu_about_button.setOnClickListener(null);
				MainActivity.isFinish(false);
				Animation zoom_out = AnimationUtils.loadAnimation(MainActivity.context,R.anim.zoom_out);
				zoom_out.setInterpolator(new DecelerateInterpolator());
				
				final TranslateAnimation trans_rll = new TranslateAnimation(0,-MainActivity.width,0,0);
				trans_rll.setInterpolator(new DecelerateInterpolator());
				trans_rll.setDuration(300);
				trans_rll.setAnimationListener(new AnimationListener() {
					
					
					//Runs the layout animation for menu when touch event is dispatch until the animation end.
					@Override
					public void onAnimationEnd(Animation animation) {
						MainActivity.menu_layout.setVisibility(View.GONE);
						MainActivity.menu_layout.clearAnimation();
					
						AlphaAnimation fadein = new AlphaAnimation(0.0f,1.0f);
						fadein.setFillAfter(true);
						fadein.setDuration(300);
						fadein.setAnimationListener(new AnimationListener() {
							
							//Runs the layout animation for about when clicked and stops when the animation end.
							@Override
							public void onAnimationEnd(Animation animation) {
								MainActivity.about_layout.clearAnimation();
								MainActivity.phaseInt(2);
								MainActivity.s_l_a_Int(3);
								MainActivity.isFinish(true);
								MainActivity.menu_about_button.setOnClickListener(new About_Event());
							}
							
							//Runs the animation for components repeatedly whenever clicked.
							@Override
							public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
						});
						MainActivity.about_layout.setVisibility(View.VISIBLE);
						MainActivity.about_layout.startAnimation(fadein);
					}
					//Executes animation repeatedly when touch event is dispatched.
					@Override
					public void onAnimationRepeat(Animation animation) {} @Override public void onAnimationStart(Animation animation) {}
				});
				MainActivity.video_image_layout.startAnimation(zoom_out);
				MainActivity.menu_layout.startAnimation(trans_rll);
			}
		},100);
	}
}
