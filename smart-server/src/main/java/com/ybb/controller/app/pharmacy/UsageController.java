package com.ybb.controller.app.pharmacy;

import com.alibaba.druid.util.StringUtils;
import com.google.common.reflect.TypeToken;
import com.ybb.config.RedisUtil;
import com.ybb.constant.MessageConstant;
import com.ybb.constant.redis.RedisKeyConstant;
import com.ybb.dto.pharmacy.UsageDTO;
import com.ybb.dto.pharmacy.UsageUpdateDTO;
import com.ybb.json.GsonUtil;
import com.ybb.result.Result;
import com.ybb.service.IUsageService;
import com.ybb.vo.UsageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

/**
 * 用法控制器
 */
@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/api/usage")
public class UsageController {

    private IUsageService usageService;

    @Autowired
    public void setUsageService(IUsageService usageService) {
        this.usageService = usageService;
    }


    /**
     * 新增用法
     *
     * @param usageDTO 用法数据
     * @return {}
     */
    @PostMapping("/add")
    public String addNewUsage(@RequestBody UsageDTO usageDTO) {
        log.info("新增用法: {}", usageDTO);
        boolean result = usageService.addNewUsage(usageDTO);
        if (result) {
            return Result.success(MessageConstant.DATA_SAVE_SUCCESS);
        }
        return Result.error(MessageConstant.DATA_SAVE_FAILED);
    }

    /**
     * 查询分类下的所有用法
     *
     * @param category 分类
     * @return {}
     */
    @PostMapping("/query/{category}")
    public String queryUsageInfo(@PathVariable Integer category) {
        log.info("查询分类:{}下的用法", category);
        List<UsageVO> usageVOS = usageService.queryUsageByCategory(category);
        if (usageVOS.size() > 0) {
            return Result.success(usageVOS);
        }
        return Result.error(MessageConstant.DATA_EMPTY);
    }

    /**
     * 更新用法信息
     * @param usageUpdateDTO 更新的用法数据
     * @return {}
     */
    @PostMapping("/update")
    public String updateUsageInfo(@RequestBody UsageUpdateDTO usageUpdateDTO) {
        log.info("修改用法: {}", usageUpdateDTO);
        boolean result = usageService.updateUsageInfo(usageUpdateDTO);
        if (result) {
            return Result.success(MessageConstant.DATA_UPDATE_SUCCESS);
        }
        return Result.error(MessageConstant.DATA_UPDATE_FAILED);
    }

    /**
     * 删除用法
     * @param usageId 用法id
     * @return {}
     */
    @PostMapping("/delete/{usageId}")
    public String deleteUsage(@PathVariable Integer usageId) {
        log.info("删除用法: {}", usageId);
        boolean result = usageService.deleteUsageInfo(usageId);
        if (result) {
            return Result.success(MessageConstant.DATA_UPDATE_SUCCESS);
        }
        return Result.error(MessageConstant.DATA_UPDATE_FAILED);
    }


}
