package io.toast.tk.core.agent.inspection;

import java.awt.image.BufferedImage;
import java.awt.image.DirectColorModel;
import java.util.ArrayList;

import com.esotericsoftware.kryo.Kryo;

import io.toast.tk.core.agent.interpret.AWTCapturedEvent;
import io.toast.tk.core.agent.interpret.IEventInterpreter.EventType;
import io.toast.tk.core.agent.interpret.WebEventRecord;
import io.toast.tk.core.net.request.CommandRequest;
import io.toast.tk.core.net.request.CommandRequest.COMMAND_TYPE;
import io.toast.tk.core.net.request.HighLightRequest;
import io.toast.tk.core.net.request.IIdRequest;
import io.toast.tk.core.net.request.InitInspectionRequest;
import io.toast.tk.core.net.request.PoisonPill;
import io.toast.tk.core.net.request.RecordRequest;
import io.toast.tk.core.net.request.ScanRequest;
import io.toast.tk.core.net.request.TableCommandRequest;
import io.toast.tk.core.net.request.TableCommandRequestQuery;
import io.toast.tk.core.net.request.TableCommandRequestQueryCriteria;
import io.toast.tk.core.net.response.ErrorResponse;
import io.toast.tk.core.net.response.ExistsResponse;
import io.toast.tk.core.net.response.InitResponse;
import io.toast.tk.core.net.response.RecordResponse;
import io.toast.tk.core.net.response.ScanResponse;
import io.toast.tk.core.net.response.ValueResponse;
import io.toast.tk.core.net.response.WebRecordResponse;

public class CommonIOUtils {

	public static final int DRIVER_TCP_PORT = 1470;
	public static final int AGENT_TCP_PORT = 1471;

	public static void initSerialization(
		Kryo kryo) {
		kryo.register(ArrayList.class);
		kryo.register(DirectColorModel.class);
		kryo.register(BufferedImage.class);
		kryo.register(COMMAND_TYPE.class);
		kryo.register(InitInspectionRequest.class);
		kryo.register(CommandRequest.class);
		kryo.register(TableCommandRequestQueryCriteria.class);
		kryo.register(TableCommandRequestQuery.class);
		kryo.register(TableCommandRequest.class);
		kryo.register(EventType.class);
		kryo.register(AWTCapturedEvent.class);
		kryo.register(IIdRequest.class);
		kryo.register(ScanRequest.class);
		kryo.register(RecordRequest.class);
		kryo.register(HighLightRequest.class);
		kryo.register(ExistsResponse.class);
		kryo.register(ErrorResponse.class);
		kryo.register(ValueResponse.class);
		kryo.register(InitResponse.class);
		kryo.register(ScanResponse.class);
		kryo.register(RecordResponse.class);
		kryo.register(WebEventRecord.class);
		kryo.register(WebRecordResponse.class);
		kryo.register(PoisonPill.class);
	}
}
