package io.toast.tk.adapter.swing.handler;

import java.awt.Component;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.toast.tk.core.guice.ICustomRequestHandler;
import io.toast.tk.core.net.request.CommandRequest;
import io.toast.tk.core.net.request.IIdRequest;
import io.toast.tk.core.net.request.TableCommandRequest;

public class DefaultSwingCustomWidgetHandler implements ICustomRequestHandler {

	private static final Logger LOG = LogManager.getLogger(DefaultSwingCustomWidgetHandler.class);

	@Override
	public String hanldeFixtureCall(
		Component component,
		IIdRequest request) throws IllegalAccessException {
		CommandRequest command = (CommandRequest) request;
		ISwingWidgetActionHandler handler = SwingWidgetActionHandlerFactory.getInstance().getHandler(component);
		if(handler != null){
			return (String) handler.handle(component, command);
		}
		throw new IllegalAccessException("No Handler for swing component: "
				+ ToStringBuilder.reflectionToString(component, ToStringStyle.SHORT_PREFIX_STYLE));
	}

	@Override
	public Component locateComponentTarget(
		String item,
		String itemType,
		Component value) {
		return value;
	}

	@Override
	public String processCustomCall(
		IIdRequest command) {
		return null;
	}

	@Override
	public String getName() {
		return "Toast-DefaultSwingWidgetHandler";
	}

	@Override
	public boolean isInterestedIn(
		Component component) {
		return SwingWidgetActionHandlerFactory.getInstance().hasHandlerFor(component.getClass());
	}

	static List<String> list = Collections.unmodifiableList(Arrays.asList(
		CommandRequest.class.getName(),
		TableCommandRequest.class.getName()));

	@Override
	public List<String> getCommandRequestWhiteList() {
		return list;
	}

	@Override
	public Set<Class<?>> getComponentsWhiteList() {
		// TODO Auto-generated method stub
		return null;
	}
}