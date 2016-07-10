package io.toast.tk.adapter.swing.component;

import java.util.UUID;

import io.toast.tk.adapter.swing.SwingAutoElement;
import io.toast.tk.adapter.web.HasTextInput;
import io.toast.tk.adapter.web.HasValueBase;
import io.toast.tk.core.driver.IRemoteSwingAgentDriver;
import io.toast.tk.core.net.request.CommandRequest;
import io.toast.tk.core.runtime.ISwingElementDescriptor;
import io.toast.tk.dao.domain.api.test.ITestResult;

public class SwingDateElement extends SwingAutoElement implements HasTextInput, HasValueBase<ITestResult> {

	public SwingDateElement(
		ISwingElementDescriptor element,
		IRemoteSwingAgentDriver driver) {
		super(element, driver);
	}

	public SwingDateElement(
		ISwingElementDescriptor element) {
		super(element);
	}

	@Override
	public ITestResult setInput(
		String e)
		throws Exception {
		exists();
		final String requestId = UUID.randomUUID().toString();
		ITestResult res = frontEndDriver.processAndWaitForValue(new CommandRequest.CommandRequestBuilder(requestId)
				.with(wrappedElement.getLocator())
				.ofType(wrappedElement.getType().name()).sendKeys(e).build());
		return res;
	}

	public ITestResult setDateText(
		String e)
		throws Exception {
		exists();
		final String requestId = UUID.randomUUID().toString();
		ITestResult res = frontEndDriver.processAndWaitForValue(new CommandRequest.CommandRequestBuilder(requestId)
			.with(wrappedElement.getLocator())
			.ofType("date_text").sendKeys(e).build());
		return res;
	}

	@Override
	public ITestResult getValue()
		throws Exception {
		exists();
		final String requestId = UUID.randomUUID().toString();
		CommandRequest request = new CommandRequest.CommandRequestBuilder(requestId).with(wrappedElement.getLocator())
			.ofType(wrappedElement.getType().name()).getValue().build();
		return frontEndDriver.processAndWaitForValue(request);
	}
}
