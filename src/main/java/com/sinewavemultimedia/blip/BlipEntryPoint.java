package com.sinewavemultimedia.blip;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayUtils;
import com.google.gwt.user.client.Window;
import com.sinewavemultimedia.blip.SampleLoaderJso;
import com.sinewavemultimedia.blip.interfaces.Tick;

public class BlipEntryPoint implements EntryPoint{

	private final static int TEMPO = 80;
	private ClipJso hihatClip;
	private ClipJso snareClip;
	private ClipJso kickClip;

	/*
	 * Wrap a native array into a generic JsArray 
	 */
	private final native JsArray data1()/*-{
		return [1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0];
	}-*/;
	/*
	 * Another way to do it
	 */
	private static native JsArray jsArrayIntegertoJsArray(JsArrayInteger values)/*-{
		return values;
	}-*/;
	/*
	 * Wrap the previous method for easy usage in a helper method
	 */
	private static JsArray toJsArray(int[] data){
		return jsArrayIntegertoJsArray(JsArrayUtils.readOnlyJsArray(data));
	}
	/**
	 * Transform the input JavaScriptObject into a boolean
	 * @param o the input javascriptobject, should be a Number instance
	 * @return whether is true or false
	 */
	public final static native boolean toBoolean(JavaScriptObject o)/*-{
		return o==1;
	}-*/;
	/*
	 * Create a native javascript object to configure the SampleLoader 
	 */
	private static final native JavaScriptObject createSamples()/*-{
		return {
				    'snare': './snare.wav',
					'hihat': './pedalhihat.wav',
					'kick' : './kick.wav'
				};
	}-*/;
	@Override
	public void onModuleLoad() {
		GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {
			
			@Override
			public void onUncaughtException(Throwable e) {
				Window.alert(e.getMessage());
			}
		});
		SampleLoaderJso.create()
		.setSamples(createSamples())
		.setDone(_loaded())
		.load();
	}
	/*
	 * wrap the Java method into a JSNI call to convert into JavaScriptObject, remember the last () aren't needed otherwise the loaded method will be called immediately
	 */
	private final native JavaScriptObject _loaded()/*-{
		return this.@com.sinewavemultimedia.blip.BlipEntryPoint::loaded();
	}-*/;

	private void loaded(){

		hihatClip = ClipJso.create().setSample("hihat");
		
		LoopJso grooveLoop = LoopJso.create()
		.setTempo(TEMPO)
		.setData(data1())
		.setTick(new Tick() {
			
			@Override
			public void onTick(int t, JavaScriptObject o, int index) {
				// Use JSNI to cast a JavaScriptObject to its known type
				boolean value = toBoolean(o);
				if(value){
					hihatClip.play();
				}
			}
		});
		
		snareClip = ClipJso.create().setSample("snare");
		LoopJso snareLoop = LoopJso.create()
		.setTempo(TEMPO)
		.setData(jsArrayIntegertoJsArray(JsArrayUtils.readOnlyJsArray(new int[]{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0})))
		.setTick(new Tick() {
			
			@Override
			public void onTick(int t, JavaScriptObject o, int index) {
				boolean value = toBoolean(o);
				if(value){
					snareClip.play();
				}
			}
		});
		
		kickClip = ClipJso.create().setSample("kick");
		LoopJso kickLoop = LoopJso.create()
		.setTempo(TEMPO)
		.setData(toJsArray(new int[]{1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0}))
		.setTick(new Tick() {
			
			@Override
			public void onTick(int t, JavaScriptObject o, int index) {
				boolean value = toBoolean(o);
				if(value){
					kickClip.play();
				}
			}
		});
		grooveLoop.start();
		snareLoop.start();
		kickLoop.start();
	}
}
