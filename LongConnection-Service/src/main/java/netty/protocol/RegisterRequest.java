package netty.protocol;

import netty.base.BaseMsg;
import netty.base.MsgType;

/**
 * @author 陈旭东
 * @version 1.0
 * @date 2018年11月10日
 */
public class RegisterRequest extends BaseMsg {
    public RegisterRequest() {
        super();
        setType(MsgType.REGISTER);
    }
}