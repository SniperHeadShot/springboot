package com.bat.easyexcel.util;

import com.bat.easyexcel.entity.ExportDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 测试数据生产器
 *
 * @author ZhengYu
 * @version 1.0 2019/6/19 12:38
 **/
public class TempExcelDataUtil {

    public static List<ExportDTO> getExportTestData(int dataSize) {
        List<ExportDTO> exportDTOList = new ArrayList<>(dataSize);
        IntStream.range(0, dataSize).forEach(index -> {
            exportDTOList.add(new ExportDTO(index, "name" + index, "man", "2019-08-08", "10086", "上海静安"));
        });
        return exportDTOList;
    }
}
