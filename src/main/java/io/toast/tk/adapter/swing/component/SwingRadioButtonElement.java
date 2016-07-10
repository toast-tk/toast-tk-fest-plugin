package io.toast.tk.adapter.swing.component;

import java.util.UUID;

import io.toast.tk.adapter.swing.SwingAutoElement;
import io.toast.tk.adapter.web.HasClickAction;
import io.toast.tk.core.driver.IRemoteSwingAgentDriver;
import io.toast.tk.core.net.request.CommandRequest;
import io.toast.tk.core.runtime.ISwingElementDescriptor;
import io.toast.tk.dao.domain.api.test.ITestResult;
import io.toast.tk.dao.domain.api.test.ITestResult.ResultKind;

public class SwingRadioButtonElement extends SwingAutoElement implements HasClickAction {

	public SwingRadioButtonElement(
		ISwingElementDescriptor element,
		IRemoteSwingAgentDriver driver) {
		super(element, driver);
	}

	public SwingRadioButtonElement(
		ISwingElementDescriptor element) {
		super(element);
	}

	@Override
	public ITestResult click()
		throws Exception {
		boolean res = exists();
		final String requestId = UUID.randomUUID().toString();
		ITestResult result = frontEndDriver.processAndWaitForValue(new CommandRequest.CommandRequestBuilder(requestId).with(wrappedElement.getLocator())
			.ofType(wrappedElement.getType().name()).click().build());
		result.setResultKind(res && result.getMessage().equals(ResultKind.SUCCESS.name()) ? ResultKind.SUCCESS : ResultKind.ERROR);
		return result;
	}

	public static CommandRequest buildClickRequest(
		String locator,
		String type,
		final String requestId) {
		return new CommandRequest.CommandRequestBuilder(requestId).with(locator).ofType(type).click().build();
	}
	
	@Override
	public void dbClick() {
	}
}
