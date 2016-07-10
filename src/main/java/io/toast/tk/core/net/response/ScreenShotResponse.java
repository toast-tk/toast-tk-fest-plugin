package io.toast.tk.core.net.response;

import io.toast.tk.core.net.request.IIdRequest;

public class ScreenShotResponse implements IIdRequest {

	private String id;
	private String screenshot;

	/**
	 * for serialization purpose only
	 */
	public ScreenShotResponse() {
	}

	public ScreenShotResponse(
		String id, String screenshot) {
		this.id = id;
		this.screenshot = screenshot;
	}


	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getBase64ScreenShot() {
		return screenshot;
	}
}
