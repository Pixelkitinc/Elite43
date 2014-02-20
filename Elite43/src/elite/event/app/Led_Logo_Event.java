package elite.event.app;

import android.view.View;
import android.view.View.OnClickListener;
import elite.act.app.MainActivity;

public class Led_Logo_Event implements OnClickListener {
	
	//Executes logo_home when touch event is dispatched.
	@Override
	public void onClick(View v) {
		MainActivity.logo_home();
	}
}