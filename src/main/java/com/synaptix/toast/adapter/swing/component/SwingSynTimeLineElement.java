package com.synaptix.toast.adapter.swing.component;

import com.synaptix.toast.adapter.swing.SwingAutoElement;
import com.synaptix.toast.core.driver.IRemoteSwingAgentDriver;
import com.synaptix.toast.core.runtime.ISwingElementDescriptor;

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