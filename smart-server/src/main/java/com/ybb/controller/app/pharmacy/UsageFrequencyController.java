package com.ybb.controller.app.pharmacy;

import com.ybb.constant.MessageConstant;
import com.ybb.dto.pharmacy.UsageFrequencyDTO;
import com.ybb.result.Result;
import com.ybb.service.IUsageFrequencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usageFrequency")
@CrossOrigin
@Slf4j
public class UsageFrequencyController {

    private IUsageFrequencyService usageFrequencyService;

    @Autowired
    public void setUsageFrequencyService(IUsageFrequencyService usageFrequencyService) {
        this.usageFrequencyService = usageFrequencyService;
    }

    /**
     * 新增用法频次
     *
     * @param usageFrequencyDTO 新增数据
     * @return {}
     */
    @PostMapping("/add")
    public String addNewUsageFrequency(@RequestBody UsageFrequencyDTO usageFrequencyDTO) {
        log.info("新增用法频次: {}", usageFrequencyDTO);
        boolean result = usageFrequencyService.addNewUsageFrequency(usageFrequencyDTO);
        if (result) {
            return Result.success(MessageConstant.DATA_SAVE_SUCCESS);
        }
        return Result.error(MessageConstant.DATA_SAVE_FAILED);
    }

    /**
     * 查询用法频次
     * @param category 分类
     * @return {}
     */
    @PostMapping("/query/{category}")
    public String queryUsageFrequencyInfo(@PathVariable Integer category) {
        log.info("查询用法频次: {}", category);

        return Result.error(MessageConstant.DATA_EMPTY);
    }


}


