package com.ybb.controller.app.pharmacy;

import com.alibaba.druid.util.StringUtils;
import com.ybb.constant.MessageConstant;
import com.ybb.context.BaseContext;
import com.ybb.dto.pharmacy.DrugUnitDTO;
import com.ybb.dto.pharmacy.DrugUnitUpdateDTO;
import com.ybb.result.Result;
import com.ybb.service.IDrugUnitService;
import com.ybb.utils.PinyinUtil;
import com.ybb.vo.DrugUnitVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 药房管理-药品单位管理
 */
@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/api/pharmacy")
public class DrugUnitController {

    private IDrugUnitService drugUnitService;

    @Autowired
    public void setDrugUnitService(IDrugUnitService drugUnitService) {
        this.drugUnitService = drugUnitService;
    }

    /**
     * 添加一个新的药品单位
     *
     * @param drugUnitDTO 单位信息
     * @return {}
     */
    @PostMapping("/add")
    public String addNewDrugUnit(@RequestBody DrugUnitDTO drugUnitDTO) {
        log.info("添加药品单位: {}", drugUnitDTO);
        if (StringUtils.isEmpty(drugUnitDTO.getClinicId())) {
            drugUnitDTO.setClinicId(BaseContext.getCurrentData().getClinicId());
        }
        boolean result = drugUnitService.addNewDrugUnit(drugUnitDTO);
        if (result) {
            return Result.success(MessageConstant.DATA_SAVE_SUCCESS);
        }
        return Result.error(MessageConstant.DATA_SAVE_FAILED);
    }

    /**
     * 查询分类下的药品单位信息
     * @param category 单位分类
     * @return {}
     */
    @PostMapping("/query/{category}")
    public String queryUnitByCategory(@PathVariable Integer category) {
        log.info("查询分类:{} 的单位信息", category);
        List<DrugUnitVO> drugUnitVOS = drugUnitService.queryUnitByCategory(category);
        if (drugUnitVOS.size() > 0) {
            return Result.success(drugUnitVOS);
        }
        return Result.error(MessageConstant.DATA_EXCEPTION);
    }

    /**
     * 更新药品单位信息
     * @param drugUnitUpdateDTO 要更新的单位信息
     * @return {}
     */
    @PostMapping("/update")
    public String updateDrugUnit(@RequestBody DrugUnitUpdateDTO drugUnitUpdateDTO) {
        log.info("修改药品单位信息: {}", drugUnitUpdateDTO);
        boolean result = drugUnitService.updateDrugUnitInfo(drugUnitUpdateDTO);
        if(result){
            return Result.success(MessageConstant.DATA_UPDATE_SUCCESS);
        }
        return Result.error(MessageConstant.DATA_UPDATE_FAILED);
    }


    /**
     * 根据单位id删除单位信息
     * @param unitId 单位id
     * @return {}
     */
    @PostMapping("/delete/{unitId}")
    public String deleteDrugUnit(@PathVariable Integer unitId){
        log.info("删除药品单位信息: {}", unitId);
        boolean result = drugUnitService.deleteDrugUnitInfo(unitId);
        if(result){
            return Result.success(MessageConstant.DATA_UPDATE_SUCCESS);
        }
        return Result.error(MessageConstant.DATA_UPDATE_FAILED);
    }
}
