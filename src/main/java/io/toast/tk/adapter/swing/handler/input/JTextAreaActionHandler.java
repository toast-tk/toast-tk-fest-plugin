package io.toast.tk.adapter.swing.handler.input;

import javax.swing.JTextArea;

import org.fest.swing.fixture.JTextComponentFixture;

import io.toast.tk.adapter.swing.handler.ISwingWidgetActionHandler;
import io.toast.tk.adapter.swing.utils.FestRobotInstance;
import io.toast.tk.core.net.request.CommandRequest;


public class JTextAreaActionHandler implements ISwingWidgetActionHandler<JTextArea, String, CommandRequest>{

	@Override
	public String handle(
		JTextArea component,
		CommandRequest command) {
		JTextComponentFixture tFixture = new JTextComponentFixture(FestRobotInstance.getRobot(), component);
		switch(command.action) {
			case SET :
				component.setText(command.value);
				component.revalidate();
				break;
			case GET :
				return component.getText();
			case CLICK :
				FestRobotInstance.getRobot().click(component);
				break;
			case CLEAR :
				tFixture.setText("");
			default :
				throw new IllegalArgumentException("Unsupported command for JTextArea: " + command.action.name());
		}
		return null;
	}
}
