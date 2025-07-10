package com.sky.mapper;

import java.util.List;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SetmealDishMapper {
    List<Long> getSetMealDishByDishId(List<Long> ids);
    void insertBatch(List<SetmealDish> setmealDish);
    void deleteBySetmealIds(List<Long> ids);
    List<SetmealDish> getBySetmealId(Long id);
    void update(SetmealDish setmealDish);
    @Delete("delete from setmeal_dish where setmeal_id = #{id}")
    void deleteBySetmealId(Long id);
}
