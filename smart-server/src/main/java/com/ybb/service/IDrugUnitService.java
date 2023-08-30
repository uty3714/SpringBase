package com.ybb.service;

import com.ybb.dto.pharmacy.DrugUnitDTO;
import com.ybb.dto.pharmacy.DrugUnitUpdateDTO;
import com.ybb.vo.DrugUnitVO;

import java.util.List;

public interface IDrugUnitService {

    /**
     * 新增药品单位
     *
     * @param drugUnitDTO 单位信息
     * @return int
     */
    boolean addNewDrugUnit(DrugUnitDTO drugUnitDTO);

    /**
     * 根据单位分类查询所有的药品单位
     *
     * @param category 单位分类
     */
    List<DrugUnitVO> queryUnitByCategory(Integer category);

    /**
     * 修改药品实体
     *
     * @param drugUnitUpdateDTO 修改的单位信息
     * @return bool
     */
    boolean updateDrugUnitInfo(DrugUnitUpdateDTO drugUnitUpdateDTO);

    /**
     * 根据单位id删除单位信息
     * @param unitId 单位id
     * @return bool
     */
    boolean deleteDrugUnitInfo(Integer unitId);

}
