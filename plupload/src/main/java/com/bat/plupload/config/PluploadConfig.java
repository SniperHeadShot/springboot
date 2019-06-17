package com.bat.plupload.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * PlupLoad 配置属性
 *
 * @author ZhengYu
 * @version 1.0 2019/6/17 13:57
 **/
@Data
@Component
@ConfigurationProperties(prefix = "plupload")
public class PluploadConfig {

    /**
     * 最大重试次数
     */
    private Integer maxTryCount;

    /**
     * 重试间隔(毫秒)
     */
    private long tryInterval;

    /**
     * 文件暂存路径
     */
    private TempPath tempPath;

    /**
     * 数据在Redis中的持有时间(秒)
     */
    private Integer fileRedisTime;

    @Data
    public static class TempPath {

        /**
         * windows 下暂存路径
         */
        private String windows;

        /**
         * linux 下暂存路径
         */
        private String linux;
    }
}
