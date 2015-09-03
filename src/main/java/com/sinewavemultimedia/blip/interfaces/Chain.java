package com.sinewavemultimedia.blip.interfaces;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * One of the most difficult parts of the Web Audio API is keeping track of the current audio graph.
 * Blip allows you to create and store groups of chained nodes easily, and allows you to inspect
 * individual nodes as well as whole chains to determine what connections exist in the current
 * graph.
 * 
 * @author iago
 *
 */
public interface Chain{

	/**
	 * Adds the specified node to the end of the chain. The node must be an instance of blip.node.
	 * 
	 * @param node the node to add to the end of the chain
	 */
	void addNode(BlipNode node);

	JavaScriptObject toJavaScriptObject();

	/**
	 * Returns the node at the start of the chain. This will be the first node that was added to the
	 * chain.
	 * 
	 * @return the node at the start of the chain
	 */
	BlipNode start();

	/**
	 * Returns the node at the end of the chain. This will be the last node that was added to the
	 * chain.
	 * 
	 * @return the node at the end of the chain
	 */
	BlipNode end();

	/**
	 * Connects the specified node to the start of the chain. This does not add the node to the
	 * chain, it simply connects the output of the node to the input of the first node in the chain
	 * 
	 * @param node the node to connect with
	 * @return the chained node
	 */
	BlipNode from(BlipNode node);

	/**
	 * Connects the end of the chain to the specified node. This does not add the node to the chain,
	 * it simply connects the output of the last node in the chain to the input of the node.
	 * 
	 * @param node the node to connect the chain with
	 * @return the chained node
	 */
	BlipNode to(BlipNode node);
}
