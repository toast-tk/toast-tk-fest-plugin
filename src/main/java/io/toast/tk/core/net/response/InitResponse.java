package io.toast.tk.core.net.response;

import java.util.ArrayList;
import java.util.List;

import io.toast.tk.core.net.request.IIdRequest;

public class InitResponse implements IIdRequest {

	private String id;

	public String text;

	public String b64ScreenShot;

	public List<String> items = new ArrayList<String>();
	
	public InitResponse(){
		
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
