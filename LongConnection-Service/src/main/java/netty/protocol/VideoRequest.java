package netty.protocol;

import netty.base.BaseMsg;
import netty.base.MsgType;

public class VideoRequest extends BaseMsg {
    private Object video;

    public VideoRequest() {
        super();
        setType(MsgType.VIDEO);
    }

    public Object getVideo() {
        return video;
    }

    public void setVideo(Object video) {
        this.video = video;
    }
}