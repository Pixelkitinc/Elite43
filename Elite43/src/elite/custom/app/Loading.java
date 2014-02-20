package elite.custom.app;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import elite.act.app.R;


/**
 * <p/>
 * Loads the layout of the window and the rotation of the 
 *
 */
public class Loading extends Dialog {
	
	
	//controls the rotation of the object
	private RotateAnimation rotation;
	
	//displays image of loading_whell
	private ImageView loading_wheel;
	
	// @stopLoading when image has loaded
	public void stopLoading() {
		loading_wheel.clearAnimation();
		rotation.cancel();
		dismiss();
	}
	
	
	
	public void startLoading() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				loading_wheel.startAnimation(rotation);
		  }
		},500);
	}
	
	/**
	 * <p/>
	 * Retrieving of current window
	 * 
	 * @param context {@link context}
	 * @param msg {@link String}
	 */
	public Loading(Context context, String msg) {
		super(context);
		
        Window window = this.getWindow();
        window.setLayout(android.view.ViewGroup.LayoutParams.MATCH_PARENT, android.view.ViewGroup.LayoutParams.MATCH_PARENT);
        window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.loading);
        setCancelable(false);
        
        //@image loading_wheel
        loading_wheel = (ImageView)findViewById(R.id.loading_wheel);
        TextView loading_label = (TextView)findViewById(R.id.loading_label);
        loading_label.setText(msg);
        
        rotation = new RotateAnimation(0f,360f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
		rotation.setDuration(1000);
		rotation.setInterpolator(new LinearInterpolator());
		rotation.setRepeatMode(Animation.RESTART);
		rotation.setRepeatCount(Animation.INFINITE);
	}
}
