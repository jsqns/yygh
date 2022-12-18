package com.js.summary.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.js.summary.common.Result;
import com.js.summary.common.utils.ResultUtils;
import com.js.summary.entity.Summary;
import com.js.summary.service.SummaryService;
import com.js.summary.mapper.SummaryMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author qns
* @description 针对表【summary】的数据库操作Service实现
* @createDate 2022-12-01 21:43:21
*/
@Service
public class SummaryServiceImpl extends ServiceImpl<SummaryMapper, Summary>
    implements SummaryService{

    @Override
    public Result<List<Long>> get() {
        QueryWrapper<Summary> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("id");
        wrapper.last("limit 1");
        Summary one = this.getOne(wrapper);
        List<Long> summaryList = one.getSummary();
        Long num = 100L;
        if (summaryList.contains(num)) {
            System.out.println(111);
        }
        return ResultUtils.createSuccessRes(summaryList);
    }

    @Override
    public Result<Summary> saveOne(Summary summary) {
        this.save(summary);
        return ResultUtils.createSuccessRes();
    }
}




