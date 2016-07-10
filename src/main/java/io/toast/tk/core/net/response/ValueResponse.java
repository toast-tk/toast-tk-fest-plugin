package io.toast.tk.core.net.response;

import io.toast.tk.core.net.request.IIdRequest;

public class ValueResponse implements IIdRequest {

	private String id;

	public String value;

	public String b64ScreenShot;
	/**
	 * serialization only
	 */
	public ValueResponse() {
	}

	public ValueResponse(
		String id,
		String value,
		String b64ScreenShot) {
		this.id = id;
		this.value = value;
		this.b64ScreenShot = b64ScreenShot;
	}
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getBase64ScreenShot() {
		return b64ScreenShot;
	}
}
