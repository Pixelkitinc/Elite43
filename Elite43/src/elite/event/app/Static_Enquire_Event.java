package elite.event.app;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import elite.act.app.MainActivity;

public class Static_Enquire_Event implements OnClickListener {
	private static int b;
	
	public static void north_south(int a) {
		b = a;
	}
	
	//Controls switching of message when touch event is dispatched.
	@Override
	public void onClick(View arg0) {
		String NL = System.getProperty("line.separator");
		String msg = "";
		switch(b) {
			case 1:
					msg = "I would like to inquire about booking your spot at Nlex - Marilao Northbound."+NL+NL+"(Please add additional questions or information below if applicable)";
				break;
				
			case 2:
					msg = "I would like to inquire about booking your spot at Nlex - Marilao Southbound."+NL+NL+"(Please add additional questions or information below if applicable)";
				break;
		}
		//Executes the mail when touch event is dispatched on "Inquire on".
		Intent gmail = new Intent(Intent.ACTION_VIEW);
		gmail.setClassName("com.google.android.gm","com.google.android.gm.ComposeActivityGmail");
		gmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"shingo@elite43.com, edsliwanag@elite43.com"});
		gmail.putExtra(Intent.EXTRA_SUBJECT, "Inquiry on "+"");
		gmail.setType("plain/text");
		gmail.putExtra(Intent.EXTRA_TEXT, msg);
		MainActivity.context.startActivity(gmail); 
	}
}
