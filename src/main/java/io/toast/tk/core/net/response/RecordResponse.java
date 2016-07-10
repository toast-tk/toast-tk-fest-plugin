package io.toast.tk.core.net.response;

import io.toast.tk.core.agent.interpret.AWTCapturedEvent;
import io.toast.tk.core.net.request.IIdRequest;

public class RecordResponse implements IIdRequest {

	private String id;

	public AWTCapturedEvent value;

	private String sentence;

	public String b64ScreenShot;

	/**
	 * serialization only
	 */
	public RecordResponse() {
	}

	public RecordResponse(
		AWTCapturedEvent eventObject) {
		this.value = eventObject;
	}

	public RecordResponse(
		String sentence) {
		this.sentence = sentence;
	}

	@Override
	public String getId() {
		return id;
	}

	public AWTCapturedEvent getEvent() {
		return value;
	}

	public String getSentence() {
		return sentence;
	}

	@Override
	public String getBase64ScreenShot() {
		return b64ScreenShot;
	}
}
