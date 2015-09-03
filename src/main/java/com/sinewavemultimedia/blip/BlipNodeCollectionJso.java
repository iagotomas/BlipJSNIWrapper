package com.sinewavemultimedia.blip;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.sinewavemultimedia.blip.interfaces.BlipNode;
import com.sinewavemultimedia.blip.interfaces.BlipNodeCollection;

public class BlipNodeCollectionJso extends JavaScriptObject implements BlipNodeCollection{

	protected BlipNodeCollectionJso() {
		
	}
	/**
	 * Wrap a {@link JavaScriptObject} into a {@link BlipNodeCollection}
	 * @param o the object to wrap
	 * @return the wrapped object
	 */
	public static BlipNodeCollectionJso wrap(JavaScriptObject o){
		return (BlipNodeCollectionJso) o;
	}
	/**
	 * Create an instance of {@link BlipNodeCollection} wrapping the array of nodes
	 * @param nodes the nodes to wrap into the collection
	 * @return the instance
	 */
	public static native BlipNodeCollectionJso create(JsArray<BlipNodeJso> nodes)/*-{
		return new $wnd.BlipNodeCollection(nodes);
	}-*/;
	/**
	 * Create an empty {@link BlipNodeCollection} instance
	 * @return the instance
	 */
	public static native BlipNodeCollectionJso create()/*-{
		return new $wnd.BlipNodeCollection();
	}-*/;
	public final JavaScriptObject toJavaScriptObject() {
		return this;
	}
	public final native int count()/*-{
		return this.count();
	}-*/;
	public final native void each(JavaScriptObject o)/*-{
		this.each(o);
	}-*/;
	public final boolean contains(BlipNode node) {
		return contains(node.toJavaScriptObject());
	}
	protected final native boolean contains(JavaScriptObject o)/*-{
		return this.contains(o);
	}-*/;
	public final void add(BlipNode node) {
		add(node.toJavaScriptObject());
	}
	protected final native void add(JavaScriptObject o)/*-{
		this.add(o);
	}-*/;
	public final void remove(BlipNode node) {
		remove(node.toJavaScriptObject());
	}
	protected final native void remove(JavaScriptObject o)/*-{
		this.remove(o);
	}-*/;
}
