package com.guanze.mapper;

import com.guanze.pojo.goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    List<goods> selectAll();

    goods selectById(@Param("id")int id);

    List<goods> selectByName(@Param("name") String name);

    List<goods> selectByCondition(@Param("name") String name, @Param("id") int id);

    void update(goods goods);

    void del(goods goods_);

    int dels(int[] arr);

    void add(goods goods_);

    void updateGQ(@Param("goods_id") int goodsId, @Param("quantity") int quantity);

}
