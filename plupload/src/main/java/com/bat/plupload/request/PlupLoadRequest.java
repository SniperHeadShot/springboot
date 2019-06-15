package com.bat.plupload.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

/**
 * @ClassName PlupLoadRequest
 * @Description PlupLoad 请求实体
 * @Author ZhengYu
 * @Version: 1.0
 * @Create: 2019/6/14 15:54
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class PlupLoadRequest extends PlupLoad {

    private String projectUuid;

    private String userUuid;

    /**
     * 任务类型 device:revert[数据还原]
     */
    private String taskType;

    /**
     * 获取 RedisKey 值
     *
     * @param
     * @return java.lang.String
     * @author ZhengYu
     * @date 2019/6/15
     */
    public String getRedisKey() {
        return "file:upload:" + getTaskType() + ":" + getProjectUuid() + ":" + getUserUuid() + ":" + getChunk();
    }

    /**
     * 获取文件上传路径
     *
     * @param
     * @return java.lang.String
     * @author ZhengYu
     * @date 2019/6/15
     */
    public String getFileUploadDir() throws FileNotFoundException {
        return ResourceUtils.getURL("classpath:").getPath() + System.getProperty("file.separator") + getProjectUuid() + System.getProperty("file.separator") + getUserUuid();
    }
}