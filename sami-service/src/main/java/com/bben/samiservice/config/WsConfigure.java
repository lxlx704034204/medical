/*

package com.bben.samiservice.config;
import com.bben.samiservice.Handler.WsHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

*/
/**
 * websocket的第二种方法
 *//*

@Configuration
@EnableWebSocket
public class WsConfigure implements WebSocketConfigurer
{
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry)
    {
        System.out.println("==========================");
        registry.addHandler(myHandler(), "/websocket").setAllowedOrigins("*");
    }

    @Bean
    public WsHandler myHandler()
    {
        return new WsHandler();
    }
}

*/
