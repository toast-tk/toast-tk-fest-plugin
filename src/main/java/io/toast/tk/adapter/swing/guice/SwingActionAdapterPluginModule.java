package io.toast.tk.adapter.swing.guice;

import io.toast.tk.adapter.swing.handler.DefaultSwingCustomWidgetHandler;
import io.toast.tk.core.guice.AbstractComponentAdapterModule;

public class SwingActionAdapterPluginModule extends AbstractComponentAdapterModule {

	@Override
	protected void configureModule() {
		addTypeHandler(DefaultSwingCustomWidgetHandler.class);
	}
}
