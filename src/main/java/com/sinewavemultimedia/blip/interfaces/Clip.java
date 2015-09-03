package com.sinewavemultimedia.blip.interfaces;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Clips are wrappers for individual sound samples. They allow a sound to be played multiple times
 * without having to manually create and wire up a buffer source each time.
 * 
 * @author iago
 *
 */
public interface Clip {

	JavaScriptObject toJavaScriptObject();
	/**
	 * Assigns a sample to the clip. The name must match the name of a sample loaded using
	 * blip.sampleLoader. Only one sample can be assigned to a clip at once. Assigning a new sample
	 * to a clip is allowed, but in most cases it is easier to just create a new clip for each
	 * separate sample.
	 * 
	 * @param name the name of the sample to load
	 * @return the Clip instance
	 */
	Clip setSample(String name);

	/**
	 * Returns the name of the sample currently assigned to the clip.
	 * 
	 * @return
	 */
	String getSample();

	/**
	 * Returns the current chain.
	 * 
	 * @return the current chain
	 */
	Chain getChain();

	/**
	 * Connects the clip to the specified chain. In the current version of blip, chain must be an
	 * instance of blip.chain. Future versions may allow an array of nodes to be passed instead,
	 * generating the blip chain from the array.
	 * 
	 * @param chain the {@link Chain} to connect with
	 * @return the Clip instance
	 * @see https://github.com/jshanley/blip/wiki/Clips#clip_chain
	 */
	Clip setChain(Chain chain);

	/**
	 * Plays the clip. If time is specified, the clip will be played at the specified time, which
	 * represents the time (in seconds) since the blip context was created. If time is not
	 * specified, or if time is less than the current blip time, the clip is played immediately. See
	 * the Time page for more info about how time is handled in blip. In addition to the playback
	 * time, an optional params object may also be passed. This is used to set parameters on the
	 * clip at the time it is played. Normally in blip, a node's AudioParams may be set directly,
	 * however the clip is unique because it must internally create an AudioBufferSourceNode each
	 * time the clip is played. This means that all AudioParams attached to the source node are
	 * unavailable until play-time. Currently, the valid parameters are "rate" and "gain", which
	 * affect the playbackRate parameter of the AudioBufferSourceNode which is created at play-time,
	 * and the gain parameter of the clip's output GainNode, respectively. Passing a numeric value
	 * as a parameter sets the value at the time the clip is played, using AudioParam.setValueAtTime
	 * under the hood.
	 * 
	 * @return the Clip instance
	 * @see https://github.com/jshanley/blip/wiki/Clips
	 */
	Clip play();

	/**
	 * Plays the clip. If time is specified, the clip will be played at the specified time, which
	 * represents the time (in seconds) since the blip context was created. If time is not
	 * specified, or if time is less than the current blip time, the clip is played immediately. See
	 * the Time page for more info about how time is handled in blip. In addition to the playback
	 * time, an optional params object may also be passed. This is used to set parameters on the
	 * clip at the time it is played. Normally in blip, a node's AudioParams may be set directly,
	 * however the clip is unique because it must internally create an AudioBufferSourceNode each
	 * time the clip is played. This means that all AudioParams attached to the source node are
	 * unavailable until play-time. Currently, the valid parameters are "rate" and "gain", which
	 * affect the playbackRate parameter of the AudioBufferSourceNode which is created at play-time,
	 * and the gain parameter of the clip's output GainNode, respectively. Passing a numeric value
	 * as a parameter sets the value at the time the clip is played, using AudioParam.setValueAtTime
	 * under the hood.
	 * 
	 * @param seconds the time at which the clip will be played
	 * @return the Clip instance
	 * @see https://github.com/jshanley/blip/wiki/Clips
	 */
	Clip play(int seconds);

	/**
	 * Plays the clip. If time is specified, the clip will be played at the specified time, which
	 * represents the time (in seconds) since the blip context was created. If time is not
	 * specified, or if time is less than the current blip time, the clip is played immediately. See
	 * the Time page for more info about how time is handled in blip. In addition to the playback
	 * time, an optional params object may also be passed. This is used to set parameters on the
	 * clip at the time it is played. Normally in blip, a node's AudioParams may be set directly,
	 * however the clip is unique because it must internally create an AudioBufferSourceNode each
	 * time the clip is played. This means that all AudioParams attached to the source node are
	 * unavailable until play-time. Currently, the valid parameters are "rate" and "gain", which
	 * affect the playbackRate parameter of the AudioBufferSourceNode which is created at play-time,
	 * and the gain parameter of the clip's output GainNode, respectively. Passing a numeric value
	 * as a parameter sets the value at the time the clip is played, using AudioParam.setValueAtTime
	 * under the hood.
	 * 
	 * @param params used to set parameters on the clip at the time it is played
	 * @return the Clip instance
	 * @see https://github.com/jshanley/blip/wiki/Clips
	 */
	Clip play(JavaScriptObject params);

	/**
	 * Plays the clip. If time is specified, the clip will be played at the specified time, which
	 * represents the time (in seconds) since the blip context was created. If time is not
	 * specified, or if time is less than the current blip time, the clip is played immediately. See
	 * the Time page for more info about how time is handled in blip. In addition to the playback
	 * time, an optional params object may also be passed. This is used to set parameters on the
	 * clip at the time it is played. Normally in blip, a node's AudioParams may be set directly,
	 * however the clip is unique because it must internally create an AudioBufferSourceNode each
	 * time the clip is played. This means that all AudioParams attached to the source node are
	 * unavailable until play-time. Currently, the valid parameters are "rate" and "gain", which
	 * affect the playbackRate parameter of the AudioBufferSourceNode which is created at play-time,
	 * and the gain parameter of the clip's output GainNode, respectively. Passing a numeric value
	 * as a parameter sets the value at the time the clip is played, using AudioParam.setValueAtTime
	 * under the hood.
	 * 
	 * @param seconds the time at which the clip will be played
	 * @param params used to set parameters on the clip at the time it is played
	 * @return the Clip instance
	 * @see https://github.com/jshanley/blip/wiki/Clips
	 */
	Clip play(int seconds, JavaScriptObject params);

	/**
	 * Gets the default playback rate of the clip. Defaults to 1.0 if it has not previously been
	 * set.
	 * 
	 * @return the playback rate of the clip
	 */
	double getRate();

	/**
	 * Sets the default playback rate of the clip. This is the rate that will be used if no 'rate'
	 * parameter is passed to the clip's .play function
	 * 
	 * @param value
	 * @return the Clip instance
	 */
	Clip setRate(double value);

	/**
	 * Gets the default gain value of the clip's output GainNode. This defaults to 1.0 if it has not
	 * previously been set.
	 * 
	 * @return the gain value of the clip's output GainNode
	 */
	double getGain();

	/**
	 * Sets the default value of the gain parameter of the clip's output GainNode. This is the gain
	 * value that will be used if no 'gain' parameter is passed to the clip's .play function.
	 * 
	 * @param value value of the gain parameter of the clip's output GainNode
	 * @return the Clip instance
	 */
	Clip setGain(double value);

}
