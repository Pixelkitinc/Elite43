package elite.db.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class elite43_dba extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "elite43_dba.db";
	public final String STATIC_LOCATION = "static_location";
	public final String STATIC_MONTH = "static_month";
	public final String STATIC_DAY = "static_day";
	public final String STATIC_YEAR = "static_year";
	public final String LED_LOCATIOIN = "led_location";
	public final String LED_CLIENT = "led_client";
	public final String LED_LOGO = "led_logo";
	public final String LED_SPOTS_LENGTH = "led_spots_length";
	public final String LED_SPOTS = "led_spots";
	public final String DATE = "date";
	public final String TIME = "time";
	public final String PHASE_STATE = "phase_state";
	public final String MENU_STATE = "menu_state";
	
	
	/*
	 * 
	 */
	public elite43_dba(Context context) {
		super(context, DATABASE_NAME, null, 1);
	}
	
	/**
	 *Initialize the creation of the data tables
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE elite43_status (_id INTEGER PRIMARY KEY AUTOINCREMENT, phase_state text, menu_state text);");
		db.execSQL("CREATE TABLE elite43_date_time (_id INTEGER PRIMARY KEY AUTOINCREMENT, date text, time text);");
		db.execSQL("CREATE TABLE elite43_static (_id INTEGER PRIMARY KEY AUTOINCREMENT, static_location text, static_month text, static_day text, static_year text);");
		db.execSQL("CREATE TABLE elite43_led (_id INTEGER PRIMARY KEY AUTOINCREMENT, led_location text, led_client text, led_logo blob, led_spots_length text, led_spots text);");
	}
	/**
	 * initiation for Drop Table to Database.
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE " + DATABASE_NAME + ";");
	    onCreate(db);
	}
}
