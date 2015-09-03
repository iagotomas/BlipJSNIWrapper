package com.sinewavemultimedia.blip;

import com.google.gwt.core.client.JavaScriptObject;
import com.sinewavemultimedia.blip.interfaces.SampleLoader;

public class SampleLoaderJso extends JavaScriptObject implements SampleLoader {

	protected SampleLoaderJso(){
		
	}
	public static native SampleLoaderJso create()/*-{
		return $wnd.blip.sampleLoader();
	}-*/;
	public final JavaScriptObject toJavaScriptObject() {
		return this;
	}

	public final native SampleLoaderJso setSamples(JavaScriptObject o)/*-{
		return this.samples(o);
	}-*/;
	public final native JavaScriptObject getSamples() /*-{
		return this.samples();
	}-*/;

	public final native SampleLoaderJso setEach(JavaScriptObject o)/*-{
		return this.each(o);
	}-*/;
	public final native JavaScriptObject getEach() /*-{
		return this.each();
	}-*/;

	public final native SampleLoaderJso setDone(JavaScriptObject o)/*-{
		return this.done(o);
	}-*/;
	public final native JavaScriptObject getDone() /*-{
		return this.done();
	}-*/;

	public  final native SampleLoaderJso load()/*-{
		return this.load();
	}-*/;

}
