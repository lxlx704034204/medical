package netty.protocol;

import netty.base.BaseMsg;
import netty.base.MsgType;

public class VoiceRequest extends BaseMsg {
    private Object voice;

    public VoiceRequest() {
        super();
        setType(MsgType.VOICE);
    }

    public Object getVoice() {
        return voice;
    }

    public void setVoice(Object voice) {
        this.voice = voice;
    }
}