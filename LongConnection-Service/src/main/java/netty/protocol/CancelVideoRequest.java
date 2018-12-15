package netty.protocol;

import netty.base.BaseMsg;
import netty.base.MsgType;

public class CancelVideoRequest extends BaseMsg {
    public CancelVideoRequest() {
        super();
        setType(MsgType.CANCEL_VIDEO);
    }
}