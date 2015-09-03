package com.sinewavemultimedia.blip;

import com.sinewavemultimedia.blip.interfaces.Envelope;

public class EnvelopeJso extends BlipNodeJso implements Envelope {

	protected EnvelopeJso(){
		
	}
	public static native EnvelopeJso create()/*-{
		return $wnd.blip.envelope();
	}-*/;
	public final native EnvelopeJso setAttack(int seconds) /*-{
		return this.attack(seconds);
	}-*/;

	public final native int getAttack() /*-{
		return this.attack();
	}-*/;

	public final native EnvelopeJso setDecay(int seconds) /*-{
		return this.decay(seconds);
	}-*/;
	public final native int getDecay() /*-{
		return this.decay();
	}-*/;

	public final native EnvelopeJso setSustain(double value) /*-{
		return this.sustain(seconds);
	}-*/;
	public final native double getSustain() /*-{
		return this.sustain();
	}-*/;

	public final native EnvelopeJso setRelease(int seconds) /*-{
		return this.release(seconds);
	}-*/;
	public final native int getRelease() /*-{
		return this.release();
	}-*/;

	public final native EnvelopeJso noteOn()/*-{
		return this.noteOn();
	}-*/;

	public final native EnvelopeJso noteOn(int seconds)/*-{
		return this.noteOn(seconds);
	}-*/;
	public final native EnvelopeJso noteOff()/*-{
		return this.noteOff();
	}-*/;
	public final native EnvelopeJso noteOff(int seconds)/*-{
		return this.noteOff(seconds);
	}-*/;

	public final native EnvelopeJso play(int seconds, int duration)/*-{
		return this.play(seconds,duration);
	}-*/;

}
