package com.bat.plupload.request;

import lombok.Data;

/**
 * @ClassName PlupLoad
 * @Description 大文件上传辅助工具类
 * @Author ZhengYu
 * @Version: 1.0
 * @Create: 2019/6/13 14:52
 **/
@Data
public class PlupLoad {

    /**
     * 文件名
     */
    private String name;

    /**
     * 用户上传资料被分解总块数
     */
    private Integer chunks;

    /**
     * 当前块数（从0开始计数）
     */
    private Integer chunk;
}
