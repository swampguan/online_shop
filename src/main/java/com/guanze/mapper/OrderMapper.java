package com.guanze.mapper;

import com.guanze.pojo.goods;
import com.guanze.pojo.order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {

    List<order> selectAll();

    order selectById(@Param("id") int id);

    int add(@Param("usersid")int usersid,@Param("goodsid")int goodsid,@Param("price")double price,@Param("quantity")int quantity,@Param("goodsname") String goodsname);


    List<order> selectByCondition(@Param("user_id") int id,@Param("status") int status);

    order selectByUGNP(@Param("user_id") int user_id,@Param("goods_id") int goods_id, @Param("goods_name") String goodsname,@Param("price")double price );

    void updateUG(@Param("user_id") int user_id,@Param("goods_id") int goods_id,@Param("price")double price,@Param("quantity")int quantity,@Param("goods_name") String goodsname);

    void update(@Param("id")int id,@Param("quantity")int quantity) ;

    void del(@Param("order_id")int id);

    void purchase(order order_);

    List<order> show_history();

    List<order> show_user_history(@Param("user_id")int user_id);

    List<order> show_goods_history();

    void del_none_goods(@Param("goods_id") int id);
}
