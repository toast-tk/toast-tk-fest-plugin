package io.toast.tk.adapter.swing.component;

import java.util.List;
import java.util.UUID;

import io.toast.tk.adapter.swing.SwingAutoElement;
import io.toast.tk.adapter.web.HasClickAction;
import io.toast.tk.core.driver.IRemoteSwingAgentDriver;
import io.toast.tk.core.net.request.CommandRequest;
import io.toast.tk.core.net.request.TableCommandRequest;
import io.toast.tk.core.net.request.TableCommandRequestQueryCriteria;
import io.toast.tk.core.runtime.ISwingElementDescriptor;
import io.toast.tk.dao.domain.api.test.ITestResult;
import io.toast.tk.dao.domain.api.test.ITestResult.ResultKind;


public class SwingTableElement extends SwingAutoElement implements HasClickAction {

	public SwingTableElement(
		ISwingElementDescriptor element,
		IRemoteSwingAgentDriver driver) {
		super(element, driver);
	}

	public SwingTableElement(
		ISwingElementDescriptor element) {
		super(element);
	}

	public ITestResult find(
		List<TableCommandRequestQueryCriteria> criteria)
		throws Exception {
		exists();
		final String requestId = UUID.randomUUID().toString();
		CommandRequest request = new TableCommandRequest.TableCommandRequestBuilder(requestId)
			.find(criteria)
			.with(wrappedElement.getLocator())
			.ofType(wrappedElement.getType().name()).build();
		return frontEndDriver.processAndWaitForValue(request);
	}

	public ITestResult find(
		String lookUpColumn,
		String lookUpValue,
		String outputColumn)
		throws Exception {
		outputColumn = outputColumn == null ? lookUpColumn : outputColumn;
		exists();
		final String requestId = UUID.randomUUID().toString();
		CommandRequest request = new TableCommandRequest.TableCommandRequestBuilder(requestId)
			.find(lookUpColumn, lookUpValue, outputColumn)
			.with(wrappedElement.getLocator())
			.ofType(wrappedElement.getType().name()).build();
		frontEndDriver.process(request);
		return frontEndDriver.processAndWaitForValue(request);
	}

	public ITestResult count()
		throws Exception {
		exists();
		final String requestId = UUID.randomUUID().toString();
		CommandRequest request = new TableCommandRequest.TableCommandRequestBuilder(requestId)
			.count().with(wrappedElement.getLocator())
			.ofType(wrappedElement.getType().name()).build();
		frontEndDriver.process(request);
		return frontEndDriver.processAndWaitForValue(request);
	}

	@Override
	public ITestResult click()
		throws Exception {
		boolean res = exists();
		final String requestId = UUID.randomUUID().toString();
		ITestResult result = frontEndDriver.processAndWaitForValue(new TableCommandRequest.TableCommandRequestBuilder(requestId)
			.with(wrappedElement.getLocator())
			.ofType(wrappedElement.getType().name())
			.click().build());
		result.setResultKind(res && result.getMessage().equals(ResultKind.SUCCESS.name()) ? ResultKind.SUCCESS : ResultKind.ERROR);
		return result;
	}

	@Override
	public void dbClick() {
		throw new IllegalAccessError("Method not implemented !");
	}

	public String doubleClick(
		String column,
		String value)
		throws Exception {
		exists();
		final String requestId = UUID.randomUUID().toString();
		frontEndDriver.process(new TableCommandRequest.TableCommandRequestBuilder(requestId)
			.doubleClick(column, value).with(wrappedElement.getLocator())
			.ofType(wrappedElement.getType().name()).build());
		return null;
	}

	public ITestResult selectMenu(
		String menu,
		String column,
		String value)
		throws Exception {
		exists();
		final String requestId = UUID.randomUUID().toString();
		CommandRequest request = new TableCommandRequest.TableCommandRequestBuilder(requestId)
			.selectMenu(menu, column, value).with(wrappedElement.getLocator())
			.ofType(wrappedElement.getType().name()).build();
		return frontEndDriver.processAndWaitForValue(request);
	}
}
