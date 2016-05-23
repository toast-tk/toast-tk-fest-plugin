package com.synaptix.toast.adapter.swing.handler.button;

import javax.swing.JCheckBox;

import com.synaptix.toast.adapter.swing.handler.ISwingWidgetActionHandler;
import com.synaptix.toast.core.net.request.CommandRequest;
import com.synaptix.toast.dao.domain.api.test.ITestResult.ResultKind;


public class JCheckBoxActionHandler implements ISwingWidgetActionHandler<JCheckBox, String, CommandRequest>{

	@Override
	public String handle(
		JCheckBox checkbox,
		CommandRequest command) {
		switch(command.action) {
			case SET :
				Boolean value = Boolean.valueOf(command.value);
				checkbox.setSelected(value);
				return ResultKind.SUCCESS.name();
			case GET :
				return String.valueOf(checkbox.isSelected());
			default :
				throw new IllegalArgumentException("Unsupported command for JCheckBox: " + command.action.name());
		}
	}
}
