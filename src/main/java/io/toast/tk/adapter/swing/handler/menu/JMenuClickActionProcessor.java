package io.toast.tk.adapter.swing.handler.menu;

import javax.swing.JMenu;

import org.fest.swing.core.Robot;

import io.toast.tk.adapter.swing.handler.ActionProcessor;
import io.toast.tk.adapter.swing.utils.FestRobotInstance;
import io.toast.tk.core.net.request.CommandRequest;
import io.toast.tk.dao.domain.api.test.ITestResult;

/**
 * Click on a JMenu 
 * Select a sub menu item from there.
 *
 */
class JMenuClickActionProcessor implements ActionProcessor<JMenu> {

	@Override
	public String processCommandOnComponent(
		CommandRequest command,
		JMenu target) {
		Robot robot = FestRobotInstance.getRobot();
		robot.click(target);
		return ITestResult.ResultKind.SUCCESS.name();
	}
}
