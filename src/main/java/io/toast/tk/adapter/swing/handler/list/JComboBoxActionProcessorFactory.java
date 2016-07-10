package io.toast.tk.adapter.swing.handler.list;

import javax.swing.JComboBox;

import io.toast.tk.adapter.swing.handler.ActionProcessor;
import io.toast.tk.adapter.swing.handler.ActionProcessorFactory;
import io.toast.tk.core.net.request.CommandRequest;

public class JComboBoxActionProcessorFactory extends ActionProcessorFactory {

	@Override
	public ActionProcessor<JComboBox> getProcessor(
		CommandRequest command) {
		switch(command.action) {
			case SET :
				return new JComboBoxSetActionProcessor();
			case GET :
				return new JComboBoxGetActionProcessor();
			case SELECT :
				return new JComboBoxSelectActionProcessor();
			default :
				return null;
		}
	}
}
