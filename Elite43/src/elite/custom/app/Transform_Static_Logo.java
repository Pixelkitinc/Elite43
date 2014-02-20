package elite.custom.app;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;
import elite.act.app.MainActivity;

public class Transform_Static_Logo extends Animation {
	private int logo_w_new;
	private int logo_h_new;
	private int logo_w;
	private int logo_h;
	private boolean bg;
	
	/**
	 * Transform_Static_Logo
	 * 
	 * @param bool
	 * 
	 * */	
	public Transform_Static_Logo(boolean bool) {
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
			logo_w_new = (int)(logo_w * interpolatedTime);
			logo_h_new =(int)(logo_h * interpolatedTime);
		}
		else {
			logo_w_new = (int)(logo_w * (1 - interpolatedTime));
			logo_h_new =(int)(logo_h *(1 - interpolatedTime));
		}
		
        RelativeLayout.LayoutParams layout_video_image = new RelativeLayout.LayoutParams(logo_w_new, logo_h_new);
		layout_video_image.addRule(RelativeLayout.CENTER_HORIZONTAL);
		layout_video_image.addRule(RelativeLayout.CENTER_VERTICAL);
		MainActivity.static_slide_logo.setLayoutParams(layout_video_image);
		MainActivity.static_slide_logo.requestLayout();
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
		logo_w = MainActivity.static_slide_logo_layout.getWidth();
		logo_h = MainActivity.static_slide_logo_layout.getHeight();
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
