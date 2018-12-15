package netty.protocol;

import netty.base.BaseMsg;
import netty.base.MsgType;

public class CancelVoiceResponse extends BaseMsg {
    private Integer status;

    public CancelVoiceResponse() {
        super();
        setType(MsgType.CANCEL_VOICE);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}