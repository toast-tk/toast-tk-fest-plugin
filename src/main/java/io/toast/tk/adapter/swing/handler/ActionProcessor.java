package io.toast.tk.adapter.swing.handler;

import java.awt.Component;

import io.toast.tk.core.net.request.CommandRequest;

public interface ActionProcessor<C extends Component> {

	public String processCommandOnComponent(
		CommandRequest command,
		C target);
}
