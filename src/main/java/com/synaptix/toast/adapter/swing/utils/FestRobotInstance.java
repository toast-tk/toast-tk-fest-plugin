package com.synaptix.toast.adapter.swing.utils;

import java.awt.Point;
import java.util.concurrent.CountDownLatch;

import org.fest.swing.core.BasicRobot;
import org.fest.swing.core.MouseButton;
import org.fest.swing.core.Robot;

public final class FestRobotInstance {

	private static class FestRobotHolder {

		static final FestRobotInstance INSTANCE = new FestRobotInstance();
	}

	public static Robot getRobot() {
		return FestRobotHolder.INSTANCE.rbt;
	}

	private final Robot rbt;

	FestRobotInstance() {
		this.rbt = BasicRobot.robotWithCurrentAwtHierarchy();
		rbt.cleanUpWithoutDisposingWindows();
	}
	
	public static void runOutsideEDT(Runnable runnable){
		new Thread(runnable).start();
	}
	
	public static void runOutsideEDTSync(Runnable runnable){
		CountDownLatch l = new CountDownLatch(1);
		new Thread(new Runnable() {
			@Override
			public void run() {
				runnable.run();
				l.countDown();
			}
		}).start();
		try {
			l.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doubleClick(
		final Point where) {
		rbt.click(where, MouseButton.LEFT_BUTTON, 2);
	}

	public void rightClick(
		final Point where) {
		rbt.click(where, MouseButton.RIGHT_BUTTON, 1);
	}

	public void leftClick(
		final Point where) {
		rbt.click(where, MouseButton.LEFT_BUTTON, 1);
	}
}