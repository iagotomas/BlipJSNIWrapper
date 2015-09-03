package com.sinewavemultimedia.blip;

import com.google.gwt.core.client.JavaScriptObject;
import com.sinewavemultimedia.blip.interfaces.BlipNode;

public class BlipNodeJso extends JavaScriptObject implements BlipNode {
	
	protected BlipNodeJso() {
	}
	/**
	 * Wrap a {@link JavaScriptObject} into a {@link BlipNode}
	 * @param o the object to wrap
	 * @return the wrapped object
	 */
	public static BlipNodeJso wrap(JavaScriptObject o){
		return (BlipNodeJso) o;
	}
	/**
	 * Create an instance of a {@link BlipNode} using javascript
	 * @return the new instance
	 */
	public static native BlipNodeJso create() /*-{
		return new $wnd.BlipNode();
	}-*/;
	public final JavaScriptObject toJavaScriptObject() {
		return this;
	}
	public final native String id() /*-{
		return this.id();
	}-*/;
	
	public final native BlipNodeCollectionJso inputs() /*-{
		return this.inputs();
	}-*/;
	public final native BlipNodeCollectionJso outputs() /*-{
		return this.outputs();
	}-*/;
	public final native JavaScriptObject node() /*-{
		return this.node();
	}-*/;
	public final BlipNode connect(BlipNode node){
		return _connect(node.toJavaScriptObject());
	}
	protected final native BlipNodeJso _connect(JavaScriptObject node) /*-{
		return this.connect(node);
	}-*/;
	public final BlipNode disconnect(BlipNode node){
		return _disconnect(node.toJavaScriptObject());
	}
	protected final native BlipNodeJso _disconnect(JavaScriptObject node) /*-{
		return this.disconnect(node);
	}-*/;
	public final native BlipNodeJso disconnectAll() /*-{
		return this.disconnect();
	}-*/;
	public final native BlipNodeJso setParam(String name,JavaScriptObject o) /*-{
		return this.param(name,o);
	}-*/;
	public final native JavaScriptObject getParam(String name) /*-{
		return this.param(name);
	}-*/;
	public final native BlipNodeJso setProp(String name,JavaScriptObject o) /*-{
		return this.prop(name,o);
	}-*/;
	public final native JavaScriptObject getProp(String name) /*-{
		return this.prop(name);
	}-*/;
	public final native void start(JavaScriptObject o) /*-{
		this.start(o);
	}-*/;
	public final native void stop(JavaScriptObject o) /*-{
		this.stop(o);
	}-*/;
	public final native String valueOf() /*-{
		return this.valueOf();
	}-*/;
	

}
