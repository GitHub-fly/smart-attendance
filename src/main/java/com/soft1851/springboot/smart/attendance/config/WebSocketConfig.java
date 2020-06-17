package com.soft1851.springboot.smart.attendance.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
import org.springframework.messaging.handler.invocation.HandlerMethodReturnValueHandler;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.concurrent.DefaultManagedTaskScheduler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

import java.util.List;

/**
 * @author ke
 * @ClassName WebSocketConfig
 * @Description TOOD
 * @Date 2020/6/16
 * @Version 1.0
 **/
@Configuration
// 消息队列的服务端
@EnableWebSocketMessageBroker
@Slf4j
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //客户端连接端点
        registry.addEndpoint("/websocket")
                //跨域处理
                .setAllowedOrigins("*");
        //降级 解决浏览器兼容问题
//                .withSockJS();
    }

    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration webSocketTransportRegistration) {

    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration channelRegistration) {

    }

    @Override
    public void configureClientOutboundChannel(ChannelRegistration channelRegistration) {

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {

    }

    @Override
    public boolean configureMessageConverters(List<MessageConverter> list) {
        return false;
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableStompBrokerRelay("/topic/", "/queue/", "/exchange/")
                .setRelayHost("121.196.196.150")
                .setRelayPort(6379)
                .setClientLogin("guest")
                .setClientPasscode("guest")
                .setVirtualHost("/");

        registry.enableSimpleBroker("/topic", "/user")
                .setHeartbeatValue(new long[]{10000L, 10000L})
                .setTaskScheduler(new DefaultManagedTaskScheduler());
        // 这句话表示客户向服务器端发送时的主题上面需要加"/app"作为前缀。
        registry.setApplicationDestinationPrefixes("/app");
        // 这句话表示给指定用户发送一对一的主题前缀是"/user"。
        registry.setUserDestinationPrefix("/user");
    }

}

