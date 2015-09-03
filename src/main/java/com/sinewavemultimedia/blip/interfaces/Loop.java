package com.sinewavemultimedia.blip.interfaces;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public interface Loop  {

	JavaScriptObject toJavaScriptObject();
	/**
	 * Sets the lookAhead value
	 * @param ms the lookAhead value in ms
	 * @return the Loop itself
	 */
	Loop setLookAhead(double ms);
	/**
	 * the current lookAhead value
	 * @return the current lookAhead value
	 */
	double getLookAhead();
	/**
	 * Sets the schedule ahead time
	 * @param ms the scheduled ahead time 
	 * @return the Loop itself
	 */
	Loop setScheduleAheadTime(double ms);
	/**
	 * the current ahead scheduled time
	 * @return a double value with the time
	 */
	double getScheduleAheadTime();
	/***
	 * Sets the tempo of the loop. The tempo is in ticks-per-minute. Setting the tempo also updates
	 * the value of the loop's .tickInterval accordingly.
	 * 
	 * @param value the tempo of the loop
	 */
	Loop setTempo(int value);

	/**
	 * Returns the current tempo.
	 * 
	 * @return the current tempo
	 */
	int getTempo();

	/**
	 * Sets the loop's tick interval, which is the length of time between ticks (in seconds).
	 * Setting the tick interval also updates the value of the loop's .tempo accordingly.
	 * 
	 * @param value the loop's tick interval
	 */
	Loop setTickInterval(int value);

	/**
	 * Returns the current tick interval.
	 * 
	 * @return the current tick interval in seconds
	 */
	int getTickInterval();

	/**
	 * Defines a block of code to be run on each tick of the loop. The time between ticks is
	 * determined by the current tempo. The function accepts up to 3 arguments: (time, datum, index)
	 * which represent the time of the tick (in seconds since the AudioContext was created), the
	 * current datum from the data array passed to the loop, and the current index of the data array
	 * passed to the loop. Within the specified function, the this context is a reference to the
	 * loop, so you may also adjust the loop's settings while it is running. For example: <br/>
	 * <br/>
	 * <code>
	 * 	// a loop that speeds up a little on each tick<br/>
	 * 	var loop = blip.loop() <br/>
	 * 	  .tempo(110) <br/>
	 * 	  .tick(function(t) { <br/>
	 * 	    clip.play(t); <br/>
	 * 	    this.tempo(this.tempo() + 2); <br/>
	 * 	  })
	 * 	</code>
	 * 
	 * @param o a function to be run on each tick of the loop
	 * @see https://github.com/jshanley/blip/wiki/Loops#loop_tick
	 */
	Loop setTick(Tick tick);

	/**
	 * returns the current "tick" function. This may be useful for reusing the same tick function in
	 * multiple loops.
	 * 
	 * @return the javascript object referencing the function that is executed on each tick of the
	 *         loop
	 */
	JavaScriptObject getTick();

	/**
	 * Defines a block of code to be run on the first tick of each iteration of the loop. The
	 * function accepts up to two arguments: (time, iteration) which represent the time of the tick
	 * (in seconds since the blip AudioContext was created), and the iteration number, which is
	 * zero-based, meaning it represents the number of iterations that have already occurred by the
	 * time of the current iteration.
	 * 
	 * @param o the object referencing the function
	 */
	Loop setEach(JavaScriptObject o);

	/**
	 * Returns the current "each" function.
	 * 
	 * @return the current "each" function
	 */
	JavaScriptObject getEach();

	/**
	 * Assigns the array to the loop. The loop will then... loop through this data in a circular
	 * fashion, passing one element at a time to the tick function.
	 * 
	 * @param array the array of values to pass to the tick function
	 */
	Loop setData(JsArray array);

	/**
	 * Returns the current data array.
	 * 
	 * @return the current data array
	 */
	JsArray getData();

	/**
	 * Sets the number of iterations a loop will perform before stopping. The loop is then reset, so
	 * calling .start() on it will play the loop from the beginning, stopping again when the limit
	 * is reached.
	 * 
	 * @param value the number of iterations a loop will perform before stopping
	 */
	Loop setLimit(int value);

	/**
	 * Returns the current limit.
	 * 
	 * @return the current limit
	 */
	int getLimit();

	/**
	 * Starts the loop, the loop starts at the specified time.
	 * 
	 * @param value the time to start the loop
	 */
	Loop start(int value);

	/**
	 * Starts immediately the loop
	 */
	Loop start();

	/**
	 * Stops the loop. This does not reset the loop to the beginning, it simply stops scheduling new
	 * ticks. This means that calling .start() again will resume the loop from where it left off.
	 */
	Loop stop();

	/**
	 * Resets the loop back to its initial state. If the loop is running, this does not stop the
	 * loop. Ticks will continue to be scheduled at the correct times, but starting from the first
	 * tick.
	 */
	Loop reset();
}
