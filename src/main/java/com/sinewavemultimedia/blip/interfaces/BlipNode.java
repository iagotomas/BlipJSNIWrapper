package com.sinewavemultimedia.blip.interfaces;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Blip provides an elegant syntax for creating new AudioNodes, and provides additional helper
 * methods for identifying individual nodes, and keeping track of collections of nodes.
 * 
 * @author iago
 *
 */
public interface BlipNode{
	String id();

	JavaScriptObject toJavaScriptObject();

	/**
	 * Returns a BlipNodeCollection containing all nodes that are connected to the current node's
	 * input(s).
	 * 
	 * @return a BlipNodeCollection containing all nodes
	 */
	BlipNodeCollection inputs();

	/**
	 * Returns a BlipNodeCollection containing all nodes connected from the current node's
	 * output(s).
	 * 
	 * @return a BlipNodeCollection containing all nodes
	 */
	BlipNodeCollection outputs();

	/**
	 * Returns a reference to the underlying AudioNode
	 * 
	 * @return the underlying AudioNode
	 */
	JavaScriptObject node();

	/*
	 * Once created, the following methods are available to a node. Unless otherwise specified, all
	 * methods return the node itself, allowing method calls to be chained.
	 */
	/**
	 * Connects the current node's output to the input of the specified node. Adds the specified
	 * node to the current node's outputs collection.
	 * 
	 * @param node the node to connect to this one
	 * @return the node itself
	 */
	BlipNode connect(BlipNode node);

	/**
	 * Disconnects the current node's output from the specified node's input. If the current node is
	 * connected to other nodes, these connections are left intact.
	 * 
	 * @param node the node to disconnect from
	 * @return the node itself
	 */
	BlipNode disconnect(BlipNode node);

	/**
	 * disconnects all existing connections from the current node's output.
	 * 
	 * @return the node itself
	 */
	BlipNode disconnectAll();

	/**
	 * 
	 * Sets the value of the AudioParam. If value is a function, it is
	 * invoked with the this context being the AudioParam. For example:
	 * <br/>
	 * <code>
	 * var gain = blip.node('gain');<br/>
	 * gain.param('gain', function() {<br/>
	 * this.exponentialRampToValueAtTime(0.8, blip.time.now() + 5);<br/> 
	 * });<br/>
	 * </code> 
	 * 
	 * @param name the parameter name to set
	 * @param o the object to set the AudioParam value to
	 * @return the node itself
	 */
	BlipNode setParam(String name, JavaScriptObject o);

	/**
	 * returns the current value of the AudioParam
	 * @param name
	 * @return
	 */
	JavaScriptObject getParam(String name);
	/**
	 * Sets the named property name on the underlying AudioNode to the specified value.
	 * 
	 * 
	 * @param name the name of the property
	 * @param value the object to set the property value to
	 * @return the node itseld
	 */
	BlipNode setProp(String name, JavaScriptObject value);

	/**
	 * Returns the current value of the property.
	 * 
	 * @param the name of the property
	 * @return the current value of the property
	 */
	JavaScriptObject getProp(String name);

	void start(JavaScriptObject o);

	void stop(JavaScriptObject o);

	String toString();

	String valueOf();

}
