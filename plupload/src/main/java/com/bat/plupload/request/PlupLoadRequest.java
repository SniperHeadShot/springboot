package com.bat.plupload.request;

import com.bat.plupload.config.PluploadConfig;
import com.bat.plupload.util.CommonUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.util.StringUtils;

/**
 * PlupLoad 请求实体
 *
 * @author ZhengYu
 * @version 1.0 2019/6/16 11:28
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
     * @author ZhengYu
     */
    public String getRedisKey() {
        return "file:upload:" + getTaskType() + ":" + getProjectUuid() + ":" + getUserUuid() + ":";
    }

    /**
     * 获取文件上传路径
     *
     * @return java.lang.String
     * @author ZhengYu
     */
    public String getFileUploadDir(PluploadConfig pluploadConfig) {
        String runSystem = CommonUtils.getRunSystem();
        String fileUploadDirPrefix = null;
        switch (runSystem) {
            case "mac":
            case "windows":
                fileUploadDirPrefix = pluploadConfig.getTempPath().getWindows();
                break;
            case "linux":
                fileUploadDirPrefix = pluploadConfig.getTempPath().getLinux();
                break;
            default:
        }
        return fileUploadDirPrefix + System.getProperty("file.separator") + getProjectUuid() + System.getProperty("file.separator") + getTaskType() + System.getProperty("file.separator") + getUserUuid();
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