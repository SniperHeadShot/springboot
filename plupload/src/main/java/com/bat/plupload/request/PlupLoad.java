package com.bat.plupload.request;

import lombok.Data;

/**
 * 分包上传辅助工具类
 *
 * @author ZhengYu
 * @version 1.0 2019/6/16 11:28
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
