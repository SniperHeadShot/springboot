package com.bat.plupload.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.FileNotFoundException;

/**
 * PlupLoad 请求实体
 *
 * @author ZhengYu
 * @version 1.0 2019/6/16 11:28
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class PlupLoadRequest extends PlupLoad {

    private final String tempUploadPath = "D:\\temp";

    private String projectUuid;

    private String userUuid;

    /**
     * 任务类型 device:revert[数据还原]
     */
    private String taskType;

    /**
     * 获取 RedisKey 值
     *
     * @author ZhengYu
     */
    public String getRedisKey() {
        // return "file:upload:" + getTaskType() + ":" + getProjectUuid() + ":" + getUserUuid() + ":" + getChunk();
        return "file:upload:" + getProjectUuid() + ":";
    }

    /**
     * 获取文件上传路径
     *
     * @return java.lang.String
     * @author ZhengYu
     */
    public String getFileUploadDir() throws FileNotFoundException {
        // return ResourceUtils.getURL("classpath:").getPath() + System.getProperty("file.separator") + getProjectUuid() + System.getProperty("file.separator") + getUserUuid();
        //return ResourceUtils.getURL("classpath:").getPath() + System.getProperty("file.separator") + "static" + System.getProperty("file.separator") + "upload" + System.getProperty("file.separator") + getProjectUuid();
        return tempUploadPath;
    }

    /**
     * 校验请求参数是否为空
     *
     * @author ZhengYu
     */
    public boolean checkParam() {
        return !(StringUtils.isEmpty(projectUuid) || StringUtils.isEmpty(userUuid) || StringUtils.isEmpty(taskType));
    }

    /**
     * 判断是否为第一个包
     *
     * @author ZhengYu
     */
    public boolean isFirstPackage() {
        return getChunk() == 0;
    }
}