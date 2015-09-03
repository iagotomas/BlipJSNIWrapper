package com.sinewavemultimedia.blip.interfaces;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A node-collection is an array-like structure used to easily search or manipulate a group of
 * nodes. Node-collections currently cannot be created directly (future versions will probably allow
 * this), but they are returned from several blip methods, so they deserve their own documentation.
 * 
 * A BlipNodeCollection is a function that wraps an array of nodes. The underlying array is
 * available as the .nodes property of the collection.
 * 
 * @author iago
 *
 */
public interface BlipNodeCollection {

	/**
	 * Returns the number of nodes in the collection.
	 * 
	 * @return the number of nodes in the collection
	 */
	int count();

	JavaScriptObject toJavaScriptObject();

	/**
	 * Iterates through the collection, calling the specified function once for each node. The
	 * function is passed the current node, the index in the underlying array, and the array itself
	 * as arguments.
	 * 
	 * @param o the function to call
	 */
	void each(JavaScriptObject o);

	/**
	 * Returns a boolean representing whether or not the specified node is contained in the
	 * collection.
	 * 
	 * @param node the node to check
	 */
	boolean contains(BlipNode node);

	/**
	 * Adds the specified node to the collection.
	 * 
	 * NOTE: In the case of a node's inputs or outputs node-collection, you should not directly add
	 * a node, since no connection will be made between the two nodes. Instead use node.connect().
	 * 
	 * 
	 * @param node the node to add
	 */
	void add(BlipNode node);

	/**
	 * Removes the specified node from the collection.
	 * 
	 * NOTE: In the case of a node's inputs or outputs node-collection, you should not directly
	 * remove a node, since no connections will be altered. Instead use node.disconnect().
	 * 
	 * @param node the node to remove
	 */
	void remove(BlipNode node);
}
