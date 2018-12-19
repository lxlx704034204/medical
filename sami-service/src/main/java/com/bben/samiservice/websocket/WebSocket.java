package com.bben.samiservice.websocket;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * WebSocket服务端示例
 */
//使该类可以通过Spring注入。 ,configurator = SpringConfigurator.class 该写法适用于java-websocket
@ServerEndpoint(value = "/websocket")
@Component
public class WebSocket {

    private static Logger log = LoggerFactory.getLogger(WebSocket.class);
    private static final AtomicInteger OnlineCount = new AtomicInteger(0);
    // concurrent包的线程安全Set，用来存放每个客户端对应的Session对象。
//    private static CopyOnWriteArraySet<Session> SessionSet = new CopyOnWriteArraySet<Session>();
    private static ConcurrentHashMap<String,CopyOnWriteArraySet<Session>> sessionHashMap = new ConcurrentHashMap<String,CopyOnWriteArraySet<Session>>();

    public ConcurrentHashMap<String,CopyOnWriteArraySet<Session>> getSessionHashMap(){
        return sessionHashMap;
    }

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) throws IOException {
        /**
         *   在线数加1
         */
        int cnt = OnlineCount.incrementAndGet();
        log.info("有连接加入，当前连接数为：{}", cnt);
        log.info("链接的session为"+session);
        SendMessage(session, "连接成功");
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
//        SessionSet.remove(session);
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
        SendMessage(session,"已接收到消息");
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