package io.toast.tk.adapter.swing.handler.input;

import javax.swing.JLabel;

import io.toast.tk.adapter.swing.handler.ISwingWidgetActionHandler;
import io.toast.tk.core.net.request.CommandRequest;


public class JLabelActionHandler implements ISwingWidgetActionHandler<JLabel, String, CommandRequest>{

	@Override
	public String handle(
		JLabel component,
		CommandRequest command) {
		switch(command.action) {
			case SET :
				component.setText(command.value);
				break;
			case GET :
				return component.getText();
			default :
				throw new IllegalArgumentException("Unsupported command for JLabel: " + command.action.name());
		}
		return null;
	}
}
