package com.sinewavemultimedia.blip.interfaces;

import com.google.gwt.core.client.JavaScriptObject;

public interface SampleLoader  {

	JavaScriptObject toJavaScriptObject();
	
	SampleLoader setSamples(JavaScriptObject o);
	JavaScriptObject getSamples();
	SampleLoader setEach(JavaScriptObject o);
	JavaScriptObject getEach();
	SampleLoader setDone(JavaScriptObject o);
	JavaScriptObject getDone();
	SampleLoader load();

}
