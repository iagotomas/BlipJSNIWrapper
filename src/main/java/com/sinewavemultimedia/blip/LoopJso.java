package com.sinewavemultimedia.blip;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.sinewavemultimedia.blip.interfaces.Loop;
import com.sinewavemultimedia.blip.interfaces.Tick;

public class LoopJso extends JavaScriptObject implements Loop {


	protected LoopJso() {
	}
	/**
	 * Create a new {@link Loop} instance with native javascript
	 * @return the new instance
	 */
	public static native LoopJso create()/*-{
		return $wnd.blip.loop();
	}-*/;

	/**
	 * Wrap a {@link JavaScriptObject} into a {@link LoopJso} class instance
	 * @param o the object to wrap
	 * @return the wrapped object
	 */
	public static LoopJso wrap(JavaScriptObject o){
		return (LoopJso) o;
	}
	public final JavaScriptObject toJavaScriptObject() {
		return this;
	}

	public final native LoopJso setTempo(int value)/*-{
		return this.tempo(value);
	}-*/;

	public final native int getTempo()/*-{
		return this.tempo();
	}-*/;

	public final native int getTickInterval() /*-{
		return this.tickInterval();
	}-*/;

	public final native LoopJso setTickInterval(int value)/*-{
		return this.tickInterval(value);
	}-*/;
	
	private native JavaScriptObject createTickFunction(Tick tick) /*-{
		return function(t,d,i){
			tick.@com.sinewavemultimedia.blip.interfaces.Tick::onTick(ILcom/google/gwt/core/client/JavaScriptObject;I)(t,d,i);
		}
	}-*/;
	public final LoopJso setTick(Tick tick){
		return setTick(createTickFunction(tick));
	}
	private final native LoopJso setTick(JavaScriptObject o)/*-{
		return this.tick(o);
	}-*/;

	public final native JavaScriptObject getTick()/*-{
		return this.tick();
	}-*/;


	public final native JavaScriptObject getEach() /*-{
		return this.each();
	}-*/;

	public final native JsArray getData()/*-{
		return this.data();
	}-*/;

	public final native LoopJso setLimit(int value)/*-{
		return this.limit(value);
	}-*/;

	public final native int getLimit() /*-{
		return this.limit();
	}-*/;

	public final native LoopJso setLookAhead(double value)/*-{
		return this.lookahead(value);
	}-*/;
	public final native double getLookAhead() /*-{
		return this.lookahead();
	}-*/;
	public final native LoopJso setScheduleAheadTime(double value)/*-{
		return this.scheduleAheadTime(value);
	}-*/;
	public final native double getScheduleAheadTime() /*-{
		return this.scheduleAheadTime();
	}-*/;
	public final native LoopJso setEach(JavaScriptObject o)/*-{
		return this.each(o);
	}-*/;
	public final native LoopJso setData(JsArray o)/*-{
		return this.data(o);
	}-*/;
	public final native LoopJso start(int value)/*-{
		return this.start(value);
	}-*/;
	public final native LoopJso start()/*-{
		return this.start();
	}-*/;
	public final native LoopJso stop()/*-{
		return this.stop();
	}-*/;
	public final native LoopJso reset()/*-{
		return this.reset();
	}-*/;

}
