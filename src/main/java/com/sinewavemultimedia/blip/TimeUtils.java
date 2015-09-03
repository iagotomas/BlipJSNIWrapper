package com.sinewavemultimedia.blip;


public class TimeUtils {


	public static native int now() /*-{
		var t = new $wnd.blip.time();
		return t.now();
	}-*/;

//	This method is commented because GWT compiler complains about the usage of the "in" method name
//	public static native int in(int seconds) /*-{
//		var t = new $wnd.blip.time(); 
//		return t.in(seconds);
//	}-*/;
	

	public static native int ms(int ms) /*-{
		var t = new $wnd.blip.time();
		return t.ms(ms);
	}-*/;

	public static native int samp(int t) /*-{
		var t = new $wnd.blip.time();
		return t.samp(t);
	}-*/;


}
