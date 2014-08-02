package com.coolcomputerpctricks.tutorialgame;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
/** 
 *  www.coolcomputerpctricks.com
 *  Android Game development tutorial * 
 */

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView( new ViewGamePlay(this)); 
	}


}
