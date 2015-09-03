package com.sinewavemultimedia.blip.interfaces;

/**
 * A blip envelope inherits the prototype of a BlipNode, which means it can be connected to and from
 * other blip nodes using the .connect method.
 */
public interface Envelope extends BlipNode {
	/**
	 * Sets the length (in seconds) of the attack phase of the envelope.
	 * @param seconds the length (in seconds) of the attack phase of the envelope.
	 * @return the envelope itself
	 */
	Envelope setAttack(int seconds);
	/**
	 * Returns the current attack value
	 * @return the current attack value
	 */
	int getAttack();
	/**
	 * Sets the length (in seconds) of the decay phase of the envelope.
	 * @param seconds the length (in seconds) of the decay phase of the envelope
	 * @return the envelope itself
	 */
	Envelope setDecay(int seconds);
	
	/**
	 * returns the current decay value
	 * @return the current decay value
	 */
	int getDecay();
	
	/**
	 * Sets the relative volume for the sustain phase of the envelope. This
	 * assumes that the peak volume at the top of the attack phase is 1.0
	 * @param value the relative volume for the sustain phase of the envelope
	 * @return the envelope itself
	 */
	Envelope setSustain(double value);
	/**
	 * Returns the current sustain value (default is 0.8).
	 * @return the current sustain value
	 */
	double getSustain();
	/**
	 * sets the length (in seconds) of the release phase of the envelope.
	 * @param seconds the length (in seconds) of the release phase of the envelope.
	 * @return the envelope itself
	 */
	Envelope setRelease(int seconds);
	/**
	 * returns the current release value.
	 * @return the current release value.
	 */
	int getRelease();
	
	/**
	 * Triggers the attack phase of the envelope inmediately
	 * 
	 * @return the envelope itself
	 */
	Envelope noteOn();
	/**
	 * Triggers a delayed attack phase of the envelope with the parameter as time at which the
	 * attack will be triggered, otherwise it is triggered immediately. This causes the envelope to
	 * proceed through the attack and decay phases, and remain in the sustain phase until
	 * @param seconds the delay in seconds
	 * @return the envelope itself
	 */
	Envelope noteOn(int seconds);
	/**
	 * Triggers the release phase of the envelope. If time is specified, sets the time at which the
	 * release will be triggered, otherwise it is triggered immediately.
	 * @return the envelope itself
	 */
	Envelope noteOff();
	/**
	 * Triggers the release phase of the envelope. If time is specified, sets the time at which the
	 * release will be triggered, otherwise it is triggered immediately.
	 * @param seconds
	 * @return the envelope itself
	 */
	Envelope noteOff(int seconds);
	/**
	 * Triggers the envelope sequence at the specified time. The envelope will proceed through the
	 * attack and decay phases, and sustain until the specified duration after the given time, at
	 * which point the release phase is triggered. This is just a shortcut for calling
	 * envelope.noteOn(t) and envelope.noteOff(t + d) where t is time and d is duration
	 * @param seconds the time at which start playing
	 * @param duration the duration to play
	 * @return the envelope itself
	 */
	Envelope play(int seconds, int duration);
}
