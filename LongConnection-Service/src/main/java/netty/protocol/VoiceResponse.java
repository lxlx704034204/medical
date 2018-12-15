package netty.protocol;

import netty.base.BaseMsg;
import netty.base.MsgType;

public class VoiceResponse extends BaseMsg {
    private Integer status;

    public VoiceResponse() {
        super();
        setType(MsgType.VOICE);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}