package netty.protocol;

import netty.base.BaseMsg;
import netty.base.MsgType;

public class CancelVideoResponse extends BaseMsg {
    private Integer status;

    public CancelVideoResponse() {
        super();
        setType(MsgType.CANCEL_VIDEO);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}