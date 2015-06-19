package de.fastr.phonegap.plugins;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.location.LocationManager;
import android.content.Context;

import android.content.Intent;
import android.provider.Settings;

/*
 * thx to http://stackoverflow.com/questions/843675/how-do-i-find-out-if-the-gps-of-an-android-device-is-enabled
 */
public class CheckGPS extends CordovaPlugin{
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (action.equals("check")){
			this.check(callbackContext);
			return true;
		}
		if (action.equals("open")) {
			this.open(callbackContext);
			return true;
		}
		return false;
	}

	private void check(CallbackContext callbackContext){
		Context context = this.cordova.getActivity().getApplicationContext();
		final LocationManager manager = (LocationManager) context.getSystemService( Context.LOCATION_SERVICE );
		if ( manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
			callbackContext.success();
		}else{
			callbackContext.error(0);
		}
	}
	
	 private void open(CallbackContext callbackContext) {
		try {
			this.cordova.getActivity().startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), 0);		
			callbackContext.success();
		}
		catch (Exception e){
			callbackContext.error(0);
		}
	} 
  
}
