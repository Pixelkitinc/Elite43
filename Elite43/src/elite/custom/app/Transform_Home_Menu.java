package elite.custom.app;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;
import elite.act.app.MainActivity;

public class Transform_Home_Menu extends Animation {
	private int video_image_w_new;
	private int video_image_h_new;
	private int video_image_w;
	private int video_image_h;
	private int static_w_new;
	private int static_h_new;
	private int static_w;
	private int static_h;
	private int led_w_new;
	private int led_h_new;
	private int led_w;
	private int led_h;
	private int about_w_new;
	private int about_h_new;
	private int about_w;
	private int about_h;
	private boolean bg;

	private int static_label_w_new;
	private int static_label_h_new;
	private int static_label_w;
	private int static_label_h;
	
	private int led_label_w_new;
	private int led_label_h_new;
	private int led_label_w;
	private int led_label_h;
	
	private int about_label_w_new;
	private int about_label_h_new;
	private int about_label_w;
	private int about_label_h;
	
	
	/**
	 * <p/>
	 * Transform_Home_Menu
	 * 
	 * @param bool
	 */
	public Transform_Home_Menu(boolean bool) {
		bg = bool;
	}
		
	/**
	 * 
	 * <p/>
	 * Helper for getTransformation. Subclasses should implement this to apply
	 * their transforms given an interpolation value. Implementations of this
	 * method should always replace the specified Transformation or document
	 * they are doing otherwise.
	 * 
	 * @param interpolatedTime
	 *            The value of the normalized time (0.0 to 1.0) after it has
	 *            been run through the interpolation function.
	 * @param t
	 *            The Transformation object to fill in with the current
	 *            transforms.
	 * 
	 * 
	 * */ 
	@Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
		if(bg) {
			video_image_w_new = (int)(video_image_w * interpolatedTime);
			video_image_h_new =(int)(video_image_h * interpolatedTime);
			static_w_new = (int)(static_w * interpolatedTime);
			static_h_new = (int)(static_h * interpolatedTime);
			led_w_new = (int)(led_w * interpolatedTime);
			led_h_new = (int)(led_h * interpolatedTime);
			about_w_new = (int)(about_w * interpolatedTime);
			about_h_new = (int)(about_h * interpolatedTime);
			
			static_label_w_new = (int)(static_label_w * interpolatedTime);
			static_label_h_new = (int)(static_label_h * interpolatedTime);
			led_label_w_new = (int)(led_label_w * interpolatedTime);
			led_label_h_new = (int)(led_label_h * interpolatedTime);
			about_label_w_new = (int)(about_label_w * interpolatedTime);
			about_label_h_new = (int)(about_label_h * interpolatedTime);
		}
		else {
			video_image_w_new = (int)(video_image_w * (1 - interpolatedTime));
			video_image_h_new =(int)(video_image_h *(1 - interpolatedTime));
			static_w_new = (int)(static_w * (1 - interpolatedTime));
			static_h_new = (int)(static_h * (1 - interpolatedTime));
			led_w_new = (int)(led_w * (1 - interpolatedTime));
			led_h_new = (int)(led_h * (1 - interpolatedTime));
			about_w_new = (int)(about_w * (1 - interpolatedTime));
			about_h_new = (int)(about_h * (1 - interpolatedTime));
			
			static_label_w_new = (int)(static_label_w * (1 - interpolatedTime));
			static_label_h_new = (int)(static_label_h * (1 - interpolatedTime));
			led_label_w_new = (int)(led_label_w * (1 - interpolatedTime));
			led_label_h_new = (int)(led_label_h * (1 - interpolatedTime));
			about_label_w_new = (int)(about_label_w * (1 - interpolatedTime));
			about_label_h_new = (int)(about_label_h * (1 - interpolatedTime));
		}
		
        RelativeLayout.LayoutParams layout_video_image = new RelativeLayout.LayoutParams(video_image_w_new, video_image_h_new);
		layout_video_image.addRule(RelativeLayout.CENTER_HORIZONTAL);
		layout_video_image.addRule(RelativeLayout.CENTER_VERTICAL);
		MainActivity.video_image.setLayoutParams(layout_video_image);
		MainActivity.video_image.requestLayout();
		
		RelativeLayout.LayoutParams layout_static = new RelativeLayout.LayoutParams(static_w_new, static_h_new);
		layout_static.addRule(RelativeLayout.CENTER_HORIZONTAL);
		layout_static.addRule(RelativeLayout.CENTER_VERTICAL);
		MainActivity.menu_static_button.setLayoutParams(layout_static);
		MainActivity.menu_static_button.requestLayout();
		
		RelativeLayout.LayoutParams layout_led = new RelativeLayout.LayoutParams(led_w_new, led_h_new);
		layout_led.addRule(RelativeLayout.CENTER_HORIZONTAL);
		layout_led.addRule(RelativeLayout.CENTER_VERTICAL);
		MainActivity.menu_led_button.setLayoutParams(layout_led);
		MainActivity.menu_led_button.requestLayout();
		
		RelativeLayout.LayoutParams layout_about = new RelativeLayout.LayoutParams(about_w_new, about_h_new);
		layout_about.addRule(RelativeLayout.CENTER_HORIZONTAL);
		layout_about.addRule(RelativeLayout.CENTER_VERTICAL);
		MainActivity.menu_about_button.setLayoutParams(layout_about);
		MainActivity.menu_about_button.requestLayout();
		
		RelativeLayout.LayoutParams layout_static_label = new RelativeLayout.LayoutParams(static_label_w_new, static_label_h_new);
		layout_static_label.addRule(RelativeLayout.CENTER_HORIZONTAL);
		layout_static_label.addRule(RelativeLayout.CENTER_VERTICAL);
		MainActivity.menu_static_label.setLayoutParams(layout_static_label);
		MainActivity.menu_static_label.requestLayout();
		
		RelativeLayout.LayoutParams layout_led_label = new RelativeLayout.LayoutParams(led_label_w_new, led_label_h_new);
		layout_led_label.addRule(RelativeLayout.CENTER_HORIZONTAL);
		layout_led_label.addRule(RelativeLayout.CENTER_VERTICAL);
		MainActivity.menu_led_label.setLayoutParams(layout_led_label);
		MainActivity.menu_led_label.requestLayout();
		
	
		RelativeLayout.LayoutParams layout_about_label = new RelativeLayout.LayoutParams(about_label_w_new, about_label_h_new);
		layout_about_label.addRule(RelativeLayout.CENTER_HORIZONTAL);
		layout_about_label.addRule(RelativeLayout.CENTER_VERTICAL);
		MainActivity.menu_about_label.setLayoutParams(layout_about_label);
		MainActivity.menu_about_label.requestLayout();
	}
	/**
	 * <p/>
	 * Initialize this animation with the dimensions of the object being
	 * animated as well as the objects parents. (This is to support animation
	 * sizes being specified relative to these dimensions.) Objects that
	 * interpret a Animations should call this method when the sizes of the
	 * object being animated and its parent are known, and before calling
	 * getTransformation(long,android.view.animation.Transformation).
	 * Parameters:
	 * 
	 * @param width
	 *            Width of the object being animated
	 * @param height
	 *            Height of the object being animated
	 * @param parentWidth
	 *            Width of the animated object's parent
	 * @param parentHeight
	 *            Height of the animated object's parent
	 * 
	 * 
	 * 
	 * */	
	@Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
		super.initialize(width, height, parentWidth, parentHeight);
		video_image_w = MainActivity.video_image_layout.getWidth();
		video_image_h = MainActivity.video_image_layout.getHeight();
		static_w = MainActivity.menu_static_layout.getWidth();
		static_h = MainActivity.menu_static_layout.getHeight();
		led_w = MainActivity.menu_led_layout.getWidth();
		led_h = MainActivity.menu_led_layout.getHeight();
		about_w = MainActivity.menu_about_layout.getWidth();
		about_h = MainActivity.menu_about_layout.getHeight();
		
		static_label_w = MainActivity.menu_static_label_layout.getWidth();
		static_label_h = MainActivity.menu_static_label_layout.getHeight();
		led_label_w = MainActivity.menu_led_label_layout.getWidth();
		led_label_h = MainActivity.menu_led_label_layout.getHeight();
		about_label_w = MainActivity.menu_about_label_layout.getWidth();
		about_label_h = MainActivity.menu_about_label_layout.getHeight();
	}
	/**
	 * <p/>
	 * Indicates whether or not this animation will affect the bounds of the
	 * animated view. For instance, a fade animation will not affect the bounds
	 * whereas a 200% scale animation will.
	 * 
	 * @return true if this animation will change the view's bounds
	 * 
	 * 
	 * 
	 * */ 
	@Override
    public boolean willChangeBounds() {
		return true;
	}
}
