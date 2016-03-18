package com.synaptix.toast.adapter.swing.handler.button;

import java.util.concurrent.CountDownLatch;

import javax.swing.JRadioButton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.synaptix.toast.adapter.swing.handler.ISwingWidgetActionHandler;
import com.synaptix.toast.adapter.swing.utils.FestRobotInstance;
import com.synaptix.toast.core.net.request.CommandRequest;
import com.synaptix.toast.dao.domain.api.test.ITestResult.ResultKind;

public class JRadioButtonActionHandler implements
			ISwingWidgetActionHandler<JRadioButton, String, CommandRequest> {
	

	private static final Logger LOG = LogManager.getLogger(JRadioButtonActionHandler.class);

	@Override
	public String handle(final JRadioButton button, CommandRequest command) {
		switch (command.action) {
		case CLICK:
			final CountDownLatch latch = new CountDownLatch(1);
			FestRobotInstance.runOutsideEDT(new Runnable() {
				@Override
				public void run() {
					button.doClick();
					latch.countDown();
				}
			});
			try {
				latch.await();
				return ResultKind.SUCCESS.name();
			} catch (InterruptedException e) {
				LOG.error(e.getMessage(), e);
				return ResultKind.ERROR.name();
			}
		default:
			throw new IllegalArgumentException("Unsupported command for JRadioButton: " + command.action.name());
		}
	}
}
