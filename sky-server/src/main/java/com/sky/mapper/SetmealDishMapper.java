package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {
    /**
     * 根据菜品id查询对应的套餐id
     * @return
     */
    List<Long> getSetMealIdsByDishIds(List<Long> dishIds);

    /**
     * 新增套餐菜品关系数据
     * @param setmealDishes
     */
    void insert(List<SetmealDish> setmealDishes);

    /**
     * 根据套餐id查询套餐菜品关系数据
     * @param setmealId
     * @return
     */
    @Select("select * from setmeal_dish where setmeal_id = #{setmealId}")
    List<SetmealDish> selectBySetMealId(Long setmealId);

    /**
     * 根据套餐id删除套餐菜品关系数据
     * @param setmealIds
     */
    void deleteBySetmealIds(List<Long> setmealIds);
}
