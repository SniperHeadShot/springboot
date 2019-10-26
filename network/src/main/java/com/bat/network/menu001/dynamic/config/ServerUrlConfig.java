package com.bat.network.menu001.dynamic.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 请求路径配置
 *
 * @author ZhengYu
 * @version 1.0 2019/10/26 18:08
 **/
@Component
public class ServerUrlConfig {

    private static String serverUrl;

    public static String getServerUrl() {
        return serverUrl;
    }

    @Value("${custom.serverUrl}")
    public void setServerUrl(String serverUrl) {
        ServerUrlConfig.serverUrl = serverUrl;
    }
}
