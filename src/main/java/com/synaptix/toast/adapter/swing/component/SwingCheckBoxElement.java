package com.synaptix.toast.adapter.swing.component;

import java.util.UUID;

import com.synaptix.toast.adapter.swing.SwingAutoElement;
import com.synaptix.toast.adapter.web.HasClickAction;
import com.synaptix.toast.adapter.web.HasInputBase;
import com.synaptix.toast.adapter.web.HasStringValue;
import com.synaptix.toast.core.driver.IRemoteSwingAgentDriver;
import com.synaptix.toast.core.net.request.CommandRequest;
import com.synaptix.toast.core.runtime.ISwingElementDescriptor;
import com.synaptix.toast.dao.domain.api.test.ITestResult;
import com.synaptix.toast.dao.domain.api.test.ITestResult.ResultKind;

public class SwingCheckBoxElement extends SwingAutoElement implements HasClickAction,  HasStringValue {

	public SwingCheckBoxElement(
		ISwingElementDescriptor element,
		IRemoteSwingAgentDriver driver) {
		super(element, driver);
	}

	public SwingCheckBoxElement(
		ISwingElementDescriptor element) {
		super(element);
	}

	public ITestResult select()
		throws Exception {
		boolean exists = exists();
		final String requestId = UUID.randomUUID().toString();
		ITestResult result = frontEndDriver.processAndWaitForValue(new CommandRequest.CommandRequestBuilder(requestId).with(wrappedElement.getLocator())
			.ofType(wrappedElement.getType().name()).sendKeys("true").build());
		result.setResultKind(exists && result.getMessage().equals(ResultKind.SUCCESS.name()) ? ResultKind.SUCCESS : ResultKind.ERROR);
		return result;
	}

	public ITestResult deselect()
		throws Exception {
		boolean exists = exists();
		final String requestId = UUID.randomUUID().toString();
		ITestResult result = frontEndDriver.processAndWaitForValue(new CommandRequest.CommandRequestBuilder(requestId).with(wrappedElement.getLocator())
			.ofType(wrappedElement.getType().name()).sendKeys("false").build());
		result.setResultKind(exists && result.getMessage().equals(ResultKind.SUCCESS.name()) ? ResultKind.SUCCESS : ResultKind.ERROR);
		return result;
	}

	@Override
	public ITestResult click()
		throws Exception{
		boolean exists = exists();
		final String requestId = UUID.randomUUID().toString();
		ITestResult result = frontEndDriver.processAndWaitForValue(new CommandRequest.CommandRequestBuilder(requestId).with(wrappedElement.getLocator())
				.ofType(wrappedElement.getType().name()).click().build());
		result.setResultKind(exists && result.getMessage().equals(ResultKind.SUCCESS.name()) ? ResultKind.SUCCESS : ResultKind.ERROR);
		return result;
	}

	@Override
	public void dbClick() {
	}

	@Override
	public String getValue()
		throws Exception{
		exists();
		final String requestId = UUID.randomUUID().toString();
		CommandRequest request = new CommandRequest.CommandRequestBuilder(requestId).with(wrappedElement.getLocator())
			.ofType(wrappedElement.getType().name()).getValue().build();
		return frontEndDriver.processAndWaitForValue(request).getMessage();
	}
}
