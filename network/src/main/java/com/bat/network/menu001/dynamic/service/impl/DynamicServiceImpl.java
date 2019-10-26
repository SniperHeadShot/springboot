package com.bat.network.menu001.dynamic.service.impl;

import com.bat.network.menu001.BodyInfo;
import com.bat.network.menu001.dynamic.client.DynamicFeignClient;
import com.bat.network.menu001.dynamic.config.ServerUrlConfig;
import com.bat.network.menu001.dynamic.service.DynamicService;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * 服务层
 *
 * @author ZhengYu
 * @version 1.0 2019/10/26 17:51
 **/
@Slf4j
@Component
@Import(FeignClientsConfiguration.class)
public class DynamicServiceImpl implements DynamicService {

    private DynamicFeignClient dynamicFeignClient;

    public DynamicServiceImpl(Decoder decoder, Encoder encoder) {
        String serverUrl = ServerUrlConfig.getServerUrl();
        // 这里可以根据自己的逻辑获取请求的url
        dynamicFeignClient = Feign.builder()
                .decoder(decoder)
                .encoder(encoder)
                .contract(new SpringMvcContract())
                .requestInterceptor(requestTemplate -> {
                    // 这里可以设置请求的header
                    requestTemplate.header("header2", "header2");
                })
                .target(DynamicFeignClient.class, serverUrl);
    }

    /**
     * 发送请求
     *
     * @author ZhengYu
     */
    @Override
    public void sendHttpRequest() {
        BodyInfo bodyInfo = new BodyInfo();
        bodyInfo.setUsername("username");
        bodyInfo.setPassword("password");
        dynamicFeignClient.verity("param1", "param2", "header1", bodyInfo);
    }
}
