package io.toast.tk.adapter.swing.component;

import java.util.UUID;

import io.toast.tk.adapter.swing.SwingAutoElement;
import io.toast.tk.adapter.web.HasInputBase;
import io.toast.tk.adapter.web.HasValueBase;
import io.toast.tk.core.driver.IRemoteSwingAgentDriver;
import io.toast.tk.core.net.request.CommandRequest;
import io.toast.tk.core.runtime.ISwingElementDescriptor;
import io.toast.tk.dao.domain.api.test.ITestResult;

public class SwingInputElement extends SwingAutoElement implements HasInputBase<String>, HasValueBase<ITestResult> {

	public SwingInputElement(
		ISwingElementDescriptor element,
		IRemoteSwingAgentDriver driver) {
		super(element, driver);
	}

	public SwingInputElement(
		ISwingElementDescriptor element) {
		super(element);
	}

	@Override
	public ITestResult setInput(
		String e)
		throws Exception {
		exists();
		final String requestId = UUID.randomUUID().toString();
		ITestResult res = frontEndDriver.processAndWaitForValue(new CommandRequest.CommandRequestBuilder(requestId).with(wrappedElement.getLocator())
			.ofType(wrappedElement.getType().name()).sendKeys(e).build());
		return res;
	}

	@Override
	public ITestResult getValue()
		throws Exception {
		exists();
		final String requestId = UUID.randomUUID().toString();
		CommandRequest request = buildGetInputValueRequest(
			wrappedElement.getLocator(),
			wrappedElement.getType().name(),
			requestId);
		return frontEndDriver.processAndWaitForValue(request);
	}

	public static CommandRequest buildGetInputValueRequest(
		String locator,
		String type,
		final String requestId) {
		return new CommandRequest.CommandRequestBuilder(requestId).with(locator).ofType(type).getValue().build();
	}

	public void clear()
		throws Exception {
		exists();
		frontEndDriver.process(new CommandRequest.CommandRequestBuilder(null).with(wrappedElement.getLocator())
			.ofType(wrappedElement.getType().name()).clear().build());
	}
}
