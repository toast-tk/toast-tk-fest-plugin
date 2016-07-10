package io.toast.tk.adapter.swing.component;

import io.toast.tk.adapter.swing.SwingAutoElement;
import io.toast.tk.core.driver.IRemoteSwingAgentDriver;
import io.toast.tk.core.runtime.ISwingElementDescriptor;

/**
 * input element
 * 
 * @author skokaina
 * 
 */
public class SwingSynTimeLineElement extends SwingAutoElement {

	public SwingSynTimeLineElement(
		ISwingElementDescriptor element,
		IRemoteSwingAgentDriver driver) {
		super(element, driver);
	}

	public SwingSynTimeLineElement(
		ISwingElementDescriptor element) {
		super(element);
	}
}