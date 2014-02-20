package elite.event.app;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import elite.act.app.MainActivity;
import elite.act.app.R;
import elite.view.app.MainVIew;

/**
 * Initialize the layout for main menu 
 * 
 */
public class About_Main_Menu_Event implements OnTouchListener {
	@Override
		//When touch event is dispatched, interface happens for about_button in main menu.
		public boolean onTouch(View v, MotionEvent e) {
		if(e.getAction() == MotionEvent.ACTION_UP) {
			MainActivity.about_button.setImageResource(R.drawable.button_mainmenu);
			new Handler().postDelayed(new Runnable() {
				
				//Execution of context for about_button when touch event is dispatched. 
				@Override
				public void run() {
					MainActivity.about_button.setOnTouchListener(null);
					MainVIew.about_phase2_back_to_main_menu();
				}
			},100);
		}
		else if(e.getAction() == MotionEvent.ACTION_DOWN) {
			MainActivity.about_button.setImageResource(R.drawable.button_mainmenu_active);
		}
		return false;
	}
}
