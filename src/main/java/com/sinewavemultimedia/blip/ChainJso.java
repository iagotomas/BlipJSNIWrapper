package com.sinewavemultimedia.blip;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.sinewavemultimedia.blip.interfaces.BlipNode;
import com.sinewavemultimedia.blip.interfaces.Chain;

public class ChainJso extends JavaScriptObject implements Chain {


	protected ChainJso() {
	}
	/**
	 * Creates and returns a new chain with no nodes
	 * @return the {@link Chain} instance 
	 * @see https://github.com/jshanley/blip/wiki/Chains#blip_chain
	 */
	public static native ChainJso create()/*-{
		return new $wnd.blip.chain();
	}-*/;

	/**
	 * Creates and returns a new chain with the nodes specified which are initialized at the start of the chain, 
	 * in the order in which they are given.
	 * @param nodes the nodes to initialize with
	 * @return the {@link Chain} instance 
	 * @see https://github.com/jshanley/blip/wiki/Chains#blip_chain
	 */
	public static native ChainJso create(JsArray nodes)/*-{
		return new $wnd.blip.chain(nodes);
	}-*/;
	public final JavaScriptObject toJavaScriptObject() {
		return this;
	}

	public final void addNode(BlipNode node) {
		_addNode(node.toJavaScriptObject());
	}
	protected final native void _addNode(JavaScriptObject o)/*-{
		this.node(node);
	}-*/;

	public final native BlipNodeJso start()/*-{
		return this.start();
	}-*/;

	public final native BlipNodeJso end()/*-{
		return this.end();
	}-*/;

	public final BlipNode from(BlipNode node) {
		return _from(node.toJavaScriptObject());
	}
	protected final native BlipNodeJso _from(JavaScriptObject o)/*-{
		return this.from(o);
	}-*/;


	public final BlipNode to(BlipNode node) {
		return _to(node.toJavaScriptObject());
	}
	protected final native BlipNodeJso _to(JavaScriptObject o)/*-{
		return this.to(o);
	}-*/;
	/**
	 * Wrap a {@link JavaScriptObject} into a Chain Java object
	 * @param o the js object to wrap
	 * @return the wrapped object
	 */
	public static Chain wrap(JavaScriptObject o) {
		return (Chain) o;
	}

}
