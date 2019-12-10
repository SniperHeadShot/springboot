package com.bat.druid.dao;

import com.bat.commoncode.entity.CustomStructure;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 数据中心
 *
 * @author ZhengYu
 * @version 1.0 2019/12/10 11:46
 **/
@Mapper
public interface CustomStructureDao {

    /**
     * 获取所有数据
     *
     * @return java.util.List<com.bat.commoncode.entity.CustomStructure>
     * @author ZhengYu
     */
    List<CustomStructure> getCustomStructureList();

    /**
     * 新增一条数据
     *
     * @param customStructure 数据
     * @return boolean
     * @author ZhengYu
     */
    int insertCustomStructure(CustomStructure customStructure);
}
