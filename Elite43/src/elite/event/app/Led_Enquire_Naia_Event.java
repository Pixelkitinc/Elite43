package elite.event.app;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import elite.act.app.MainActivity;

/**
 * <p/>
 * 
 * Initialize the layout for Led_Enquire_Naia when touch event is dispatched.	
 */
public class Led_Enquire_Naia_Event implements OnClickListener {
	@Override
	public void onClick(View v) {
		
		//Displays the String msg when touch event is dispatched on "Inquire on".
		String NL = System.getProperty("line.separator");
		String msg = "I would like to inquire about booking your spot at Naia Residence."+NL+NL+"(Please add additional questions or information below if applicable)";
		
		//Executes the mail when touch event is dispatched.
		Intent gmail = new Intent(Intent.ACTION_VIEW);
		gmail.setClassName("com.google.android.gm","com.google.android.gm.ComposeActivityGmail");
		gmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"shingo@elite43.com, edsliwanag@elite43.com"});
		gmail.putExtra(Intent.EXTRA_SUBJECT, "Inquiry on "+"");
		gmail.setType("plain/text");
		gmail.putExtra(Intent.EXTRA_TEXT, msg);
		MainActivity.context.startActivity(gmail);
	}
}
