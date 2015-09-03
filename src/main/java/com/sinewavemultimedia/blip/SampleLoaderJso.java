package com.sinewavemultimedia.blip;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Command;
import com.sinewavemultimedia.blip.interfaces.Each;
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

	@Override
	public final native SampleLoader setEach(Each e) /*-{
		return this.each(function(n){ e.@com.sinewavemultimedia.blip.interfaces.Each::onEach(Ljava/lang/String;)(n); });
	}-*/;
	public final native SampleLoaderJso setEach(JavaScriptObject o)/*-{
		return this.each(o);
	}-*/;
	public final native JavaScriptObject getEach() /*-{
		return this.each();
	}-*/;
	public final native SampleLoaderJso setDone(Command o) /*-{
		return this.done(function(){ o.@com.google.gwt.user.client.Command::execute()(); });
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
