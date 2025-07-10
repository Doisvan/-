package com.sky.controller.admin;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetmealService;
import java.util.List;

import com.sky.vo.SetmealVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/setmeal")
@Api("套餐管理")
@Slf4j
public class SetmealController {
    @Autowired
    private SetmealService setmealService;
    @RequestMapping("/page")
    @ApiOperation("套餐分页查询")
    public Result<PageResult> page(SetmealPageQueryDTO setmealPageQueryDTO){
        log.info("套餐分页查询：{}", setmealPageQueryDTO);
        PageResult pageResult = setmealService.page(setmealPageQueryDTO);
        return Result.success(pageResult);
    }
    @PostMapping()
    @ApiOperation("套餐添加")
    public Result save(@RequestBody SetmealDTO setmealDTO){
        log.info("套餐添加：{}", setmealDTO);
        setmealService.save(setmealDTO);
        return Result.success();
    }
    @DeleteMapping
    @ApiOperation("套餐批量删除")
    public Result delete(@RequestParam List<Long> ids){
        log.info("批量删除：{}", ids);
        setmealService.deleteBatch(ids);
        return Result.success();
    }
    @GetMapping("/{id}")
    @ApiOperation("根据id套餐查询")
    public Result<SetmealVO> getById(@PathVariable Long id){
        log.info("根据id查询：{}", id);
        SetmealVO setmealVO = setmealService.getById(id);
        return Result.success(setmealVO);
    }
    @PutMapping
    @ApiOperation("套餐修改")
    public Result update(@RequestBody SetmealDTO setmealDTO){
        log.info("套餐修改：{}", setmealDTO);
        setmealService.update(setmealDTO);
        return Result.success();
    }
    @PostMapping("/status/{status}")
    @ApiOperation("套餐起售、停售")
    public Result startOrStop(@PathVariable Integer status, Long id){
        log.info("套餐起售、停售：{}", id);
        setmealService.startOrStop(status, id);
        return Result.success();
    }
}
