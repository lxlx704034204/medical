package netty.protocol;

import netty.base.BaseMsg;
import netty.base.MsgType;

public class CancelVoiceRequest extends BaseMsg {
    public CancelVoiceRequest() {
        super();
        setType(MsgType.CANCEL_VOICE);
    }
}