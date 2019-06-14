package com.bat.plupload.request;

import com.bat.plupload.entity.PlupLoad;
import lombok.Data;
import lombok.EqualsAndHashCode;

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

    private String classpath;
}