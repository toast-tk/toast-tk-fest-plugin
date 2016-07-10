package io.toast.tk.adapter.swing;

import java.util.UUID;

import io.toast.tk.core.driver.IRemoteSwingAgentDriver;
import io.toast.tk.core.net.request.CommandRequest;
import io.toast.tk.core.runtime.ISwingAutoElement;
import io.toast.tk.core.runtime.ISwingElementDescriptor;

public class SwingAutoElement implements ISwingAutoElement {

	protected ISwingElementDescriptor wrappedElement;

	protected IRemoteSwingAgentDriver frontEndDriver;

	protected void setWrappedElement(
		ISwingElementDescriptor wrappedElement) {
		this.wrappedElement = wrappedElement;
	}

	protected IRemoteSwingAgentDriver getFrontEndDriver() {
		return frontEndDriver;
	}

	@Override
	public void setFrontEndDriver(
		IRemoteSwingAgentDriver frontEndDriver) {
		this.frontEndDriver = frontEndDriver;
	}

	public SwingAutoElement(
		ISwingElementDescriptor element,
		IRemoteSwingAgentDriver driver) {
		this.wrappedElement = element;
		this.frontEndDriver = driver;
	}

	public SwingAutoElement(
		ISwingElementDescriptor element) {
		this.wrappedElement = element;
	}

	public SwingAutoElement() {
	}

	public boolean exists()
		throws Exception {
		final String requestId = UUID.randomUUID().toString();
		final CommandRequest command = new CommandRequest.CommandRequestBuilder(requestId)
			.with(wrappedElement.getLocator())
			.ofType(wrappedElement.getType().name())
			.exists()
			.build();
		frontEndDriver.process(command);
		return frontEndDriver.waitForExist(requestId);
	}

	public ISwingElementDescriptor getWrappedElement() {
		return wrappedElement;
	}
}
