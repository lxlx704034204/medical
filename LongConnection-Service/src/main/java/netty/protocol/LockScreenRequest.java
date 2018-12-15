package netty.protocol;

import netty.base.BaseMsg;
import netty.base.MsgType;

public class LockScreenRequest extends BaseMsg {

    public LockScreenRequest() {
        super();
        setType(MsgType.LOCK_SCREEN);
    }
}