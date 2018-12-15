package com.bben.infusion.transmission;

import com.alibaba.fastjson.JSON;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.A;
import com.bben.common.util.U;
import com.bben.infusion.model.infusion.*;
import com.bben.infusion.service.TPatientCallService;
import com.bben.infusion.service.TPatientService;
import com.bben.infusion.service.TWardService;
import com.bben.infusion.util.ApplicationContextRegister;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * WebSocket 病人呼叫服务端示例
 */
@ServerEndpoint(value = "/wsCall/{twid}")
@Component
public class CallWebSocket {

    private static Logger log = LoggerFactory.getLogger(CallWebSocket.class);
    private static final AtomicInteger OnlineCount = new AtomicInteger(0);
    private static ConcurrentHashMap<String,CopyOnWriteArraySet<Session>> sessionHashMap = new ConcurrentHashMap<String,CopyOnWriteArraySet<Session>>();
    public ConcurrentHashMap<String,CopyOnWriteArraySet<Session>> getSessionHashMap(){
        return sessionHashMap;
    }

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(@PathParam("twid") String twid, Session session) throws IOException {
        if (U.isBlank(twid)) {
            BroadCastInfoSet(twid,sessionHashMap.get(twid),JSON.toJSONString(Result.success("无病区数据")));
            return;
        }
        CopyOnWriteArraySet<Session> SessiSet = new CopyOnWriteArraySet<>();
        CopyOnWriteArraySet<Session> sessions =  sessionHashMap.get(twid);
        if (A.isEmpty(sessions)) {
            log.info("sessionHashMap.get(twid) is null");
            SessiSet.add(session);
            sessionHashMap.put(twid,SessiSet);
        }else {
            log.info("by twid get SessionSet -> {} {} ",sessions.size(),sessions);
            sessions.add(session);
            sessionHashMap.put(twid,sessions);
        }

        int cnt = OnlineCount.incrementAndGet(); // 在线数加1
        log.info("有连接加入，当前连接数为：{}", cnt);
        SendMessage(session, "连接成功");

        //第一次连接成功给客户端推送数据
        ApplicationContext act = ApplicationContextRegister.getApplicationContext();
        TPatientCallService tPatientCallService = act.getBean(TPatientCallService.class);
        TWardService tWardService = act.getBean(TWardService.class);
        //查找病区的信息
        TWard tWard = tWardService.selectByPrimaryKey(Integer.parseInt(twid));

        if (U.isBlank(tWard)) {
            BroadCastInfoSet(twid,sessionHashMap.get(twid),JSON.toJSONString(Result.success("无病区数据")));
            return;
        }

        //查找病人呼叫信息
        TPatientCall tPatientCall = new TPatientCall();
        tPatientCall.setWardId(twid);
        tPatientCall.setCreateTime(new Date());
        JSONArray jsonArray = tPatientCallService.selectByCondition(tPatientCall);

        if (A.isEmpty(jsonArray)){
            BroadCastInfoSet(twid,sessionHashMap.get(twid), JSON.toJSONString(Result.success("无病人呼叫数据")));
            return;
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("wId",twid);
        jsonObject.put("name",tWard.getName());
        jsonObject.put("callInfo",jsonArray);
        BroadCastInfoSet(twid,sessionHashMap.get(twid),JSON.toJSONString(Result.success("获取病区病人呼叫信息成功",jsonObject)));
    }


    /**
     * 指定SessionSet群发消息
     * @param message
     * @throws IOException
     */
    public void BroadCastInfoSet(String twid,CopyOnWriteArraySet<Session> SessionSet,String message) throws IOException {
        for (Session session : SessionSet) {
            if (session.isOpen()) {
                SendMessage(session, message);
            }else {
                SessionSet.remove(session);
            }
        }
        sessionHashMap.put(twid,SessionSet);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) throws IOException {
        session.close();
        int cnt = OnlineCount.decrementAndGet();
        log.info("有连接关闭，当前连接数为：{}", cnt);
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        log.info("来自客户端的消息：{}", message);
        SendMessage(session,message);
    }

    /**
     * 出现错误
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误：{}，Session ID： {}", error.getMessage(), session.getId());
        error.printStackTrace();
    }

    /**
     * 发送消息，实践表明，每次浏览器刷新，session会发生变化。
     *
     * @param session
     * @param message
     */
    public void SendMessage(Session session, String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            log.error("发送消息出错：{}", e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 群发消息
     * @param message
     * @throws IOException
     */
    public void BroadCastInfo(CopyOnWriteArraySet<Session> SessionSet, String message) throws IOException {
        for (Session session : SessionSet) {
            if (session.isOpen()) {
                SendMessage(session, message);
            }
        }
    }


    /**
     * 指定Session发送消息
     *
     * @param sessionId
     * @param message
     * @throws IOException
     */
    public void SendMessage(CopyOnWriteArraySet<Session> SessionSet,String sessionId, String message) throws IOException {
        Session session = null;
        for (Session s : SessionSet) {
            if (s.getId().equals(sessionId)) {
                session = s;
                break;
            }
        }
        if (session != null) {
            SendMessage(session, message);
        } else {
            log.warn("没有找到你指定ID的会话：{}", sessionId);
        }
    }
}