package elite.custom.app;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;
import elite.act.app.MainActivity;

public class Transform_Led_Greenhills_Phase3 extends Animation {
	private int initialWidth;
	private int newWidth;
	private boolean bg;
	
	/**
	 * Transform_Led_Greenhills_Phase3
	 * 
	 * @param bool
	 * 
	 * */
	
	public Transform_Led_Greenhills_Phase3(boolean bool) {
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
			newWidth = (int)(initialWidth * interpolatedTime);
		}
		else {
			newWidth = (int)(initialWidth * (1 - interpolatedTime));
		}
        
        RelativeLayout.LayoutParams layout_main = new RelativeLayout.LayoutParams(newWidth,android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
		layout_main.addRule(RelativeLayout.CENTER_HORIZONTAL);
		
		MainActivity.led_promenade_info_layout.setLayoutParams(layout_main);
		MainActivity.led_promenade_info_layout.requestLayout();
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
        initialWidth = MainActivity.led_slide_layout.getWidth();
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
