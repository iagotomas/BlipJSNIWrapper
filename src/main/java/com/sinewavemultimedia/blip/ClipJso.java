package com.sinewavemultimedia.blip;

import com.google.gwt.core.client.JavaScriptObject;
import com.sinewavemultimedia.blip.interfaces.Chain;
import com.sinewavemultimedia.blip.interfaces.Clip;

public class ClipJso extends JavaScriptObject implements Clip {

	
	protected ClipJso() {
	}
	public static native ClipJso create()/*-{
		return $wnd.blip.clip();
	}-*/;
	public final JavaScriptObject toJavaScriptObject() {
		return this;
	}

	public final native ClipJso setSample(String name) /*-{
		return this.sample(name);
	}-*/;

	public final native String getSample() /*-{
		return this.sample();
	}-*/;

	public final native ChainJso getChain() /*-{
		return this.chain();
	}-*/;
	

	public final Clip setChain(Chain chain) {
		return _setChain(chain.toJavaScriptObject());
	}
	protected final native ClipJso _setChain(JavaScriptObject o)/*-{
		return this.chain(o);
	}-*/;

	public final native ClipJso play() /*-{
		return this.play();
	}-*/;

	public final native ClipJso play(int time) /*-{
		return this.play(time);
	}-*/;

	public final native ClipJso play(JavaScriptObject params) /*-{
		return this.play(o);
	}-*/;

	public final native ClipJso play(int time,JavaScriptObject o) /*-{
		return this.play(t,o);
	}-*/;

	public final native double getRate() /*-{
		return this.rate();
	}-*/;

	public final native ClipJso setRate(double value) /*-{
		return this.rate(value);
	}-*/;

	public final native double getGain() /*-{
		return this.gain();
	}-*/;

	public final native ClipJso setGain(double value) /*-{
		return this.gain(value);
	}-*/;

}
