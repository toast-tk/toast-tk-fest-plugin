package io.toast.tk.adapter.swing.handler.menu;

import javax.swing.JMenu;

import io.toast.tk.adapter.swing.handler.ActionProcessor;
import io.toast.tk.adapter.swing.handler.ActionProcessorFactory;
import io.toast.tk.core.net.request.CommandRequest;

public class JMenuActionProcessorFactory extends ActionProcessorFactory {

	@Override
	public ActionProcessor<JMenu> getProcessor(
		CommandRequest command) {
		switch(command.action) {
			case CLICK :
				return new JMenuClickActionProcessor();
			case SELECT :
				return new JMenuSelectActionProcessor();
			default :
				return null;
		}
	}
}
