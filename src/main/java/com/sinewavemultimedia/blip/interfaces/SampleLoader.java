package com.sinewavemultimedia.blip.interfaces;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Command;

/**
 * A {@link SampleLoader} loads samples into the AudioContext so these can be used with. 
 * @author iago
 *
 */
public interface SampleLoader  {

	JavaScriptObject toJavaScriptObject();
	/**
	 * Configure the {@link SampleLoader} with a JSO instance with the samples to load.<br/>
	 * <code>
	 * private static final native JavaScriptObject createSamples()/*-{<br/>
		return {<br/>
				    'snare': './snare.wav',<br/>
					'hihat': './pedalhihat.wav',<br/>
					'kick' : './kick.wav'<br/>
				};<br/>
	}-<br/>
	</code>
	 * @param o the JSO instance used to configure the {@link SampleLoader} 
	 * @return the {@link SampleLoader} itself
	 */
	SampleLoader setSamples(JavaScriptObject o);
	/**
	 * Retrieve the current JSO instance that configures the loaded samples
	 * @return
	 */
	JavaScriptObject getSamples();
	/**
	 * Add an {@link Each} instance that will be called for each sample loaded, the method receives the name of the loaded sample.
	 * @param each the instance to use on each loaded sample
	 * @return the {@link SampleLoader} itself
	 */
	SampleLoader setEach(Each each);
	/**
	 * Add a JSO instance that will be executed on each sample loaded that is complete. To create a JSO instance for a native JS function
	 * you may use something like below:<br/>
	 * <code>
	 * private final native JavaScriptObject createFn()/*-{ <br/>
	 * &nbsp;&nbsp;&nbsp;return function(name){ ... };	<br/>
	 *  }... <br/>
	 * </code> 
	 * This will wrap a function into a JavaScriptObject instance that you may use with {@link #setDone(JavaScriptObject)}
	 * @param o the {@link JavaScriptObject} instance refering to a JS function
	 * @return the {@link SampleLoader} itself
	 */
	SampleLoader setEach(JavaScriptObject o);
	/**
	 * Retrieve the JSO instance that is called on each loaded sample
	 * @return
	 */
	JavaScriptObject getEach();
	/**
	 * Add a {@link Command} instance that will be executed when loading is complete
	 * @param cmd the Command instance
	 * @return the {@link SampleLoader} itself
	 */
	SampleLoader setDone(Command cmd);
	/**
	 * Add a JSO instance that will be executed when loading is complete. To create a JSO instance for a native JS function
	 * you may use something like below:<br/>
	 * <code>
	 * private final native JavaScriptObject createFn()/*-{ <br/>
	 * &nbsp;&nbsp;&nbsp;return function(){ ... };	<br/>
	 *  }... <br/>
	 * </code> 
	 * This will wrap a function into a JavaScriptObject instance that you may use with {@link #setDone(JavaScriptObject)}
	 * @param o the {@link JavaScriptObject} instance refering to a JS function
	 * @return the {@link SampleLoader} itself
	 */
	SampleLoader setDone(JavaScriptObject o);
	/**
	 * Get the JSO instance that is called when loading samples ends.
	 * @return the JSO instance 
	 */
	JavaScriptObject getDone();
	/**
	 * Initialize the sample loading
	 * @return the SampleLoader itself
	 */
	SampleLoader load();

}
