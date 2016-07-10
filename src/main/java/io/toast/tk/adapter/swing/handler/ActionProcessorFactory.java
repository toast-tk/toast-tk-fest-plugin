package io.toast.tk.adapter.swing.handler;

import io.toast.tk.core.net.request.CommandRequest;

public abstract class ActionProcessorFactory {

	public abstract ActionProcessor getProcessor(
		CommandRequest command);
}
