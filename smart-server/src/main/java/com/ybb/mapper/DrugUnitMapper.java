package com.ybb.mapper;

import com.ybb.dto.pharmacy.DrugUnitUpdateDTO;
import com.ybb.entity.TabDrugUnitEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DrugUnitMapper {

    /**
     * 新增新药品
     *
     * @param tabDrugUnitEntity 药品信息
     * @return int
     */
    int addNewDrugUnit(TabDrugUnitEntity tabDrugUnitEntity);

    /**
     * 根据分类查询分类下的单位信息
     * @param category 分类
     * @return list
     */
    List<TabDrugUnitEntity> queryUnitByCategory(String clinicId,Integer category);

    /**
     * 更新药品单位信息
     * @param drugUnitUpdateDTO 要更新的信息
     * @return int
     */
    int updateDrugUnitInfo(DrugUnitUpdateDTO drugUnitUpdateDTO);
}
