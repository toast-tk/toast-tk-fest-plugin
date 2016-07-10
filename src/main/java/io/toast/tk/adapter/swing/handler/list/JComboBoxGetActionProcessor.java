package io.toast.tk.adapter.swing.handler.list;

import javax.swing.JComboBox;

import org.fest.swing.fixture.JComboBoxFixture;

import io.toast.tk.adapter.swing.handler.ActionProcessor;
import io.toast.tk.adapter.swing.utils.FestRobotInstance;
import io.toast.tk.core.net.request.CommandRequest;

class JComboBoxGetActionProcessor implements ActionProcessor<JComboBox> {

	@Override
	public String processCommandOnComponent(
		CommandRequest command,
		JComboBox target) {
		JComboBoxFixture fixture = new JComboBoxFixture(FestRobotInstance.getRobot(), target);
		int selectedIndex = fixture.component().getSelectedIndex();
		return fixture.selectItem(selectedIndex).toString();
	}
}
