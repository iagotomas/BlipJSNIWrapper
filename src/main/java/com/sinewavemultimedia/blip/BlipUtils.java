package com.sinewavemultimedia.blip;

import com.google.gwt.core.client.JavaScriptObject;

public class BlipUtils {

	public static native int mtof(int value) /*-{
		return $wnd.blip.mtof(value);
	}-*/;

	public static native String version() /*-{
		return $wnd.blip.version;
	}-*/;
	public static native JavaScriptObject getContext() /*-{
		return $wnd.blip.getContext();
	}-*/;
	
	public static native JavaScriptObject getLoadedSamples() /*-{
		return $wnd.blip.getLoadedSamples();
	}-*/;
	public static native JavaScriptObject sample(String name) /*-{
		return $wnd.blip.sample(name);
	}-*/;
}
