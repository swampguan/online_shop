package com.guanze.service;

import com.guanze.mapper.GoodsMapper;
import com.guanze.mapper.OrderMapper;
import com.guanze.pojo.goods;
import com.guanze.pojo.order;
import com.guanze.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class orderService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public  void purchase(order order_) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        OrderMapper orderMapper =sqlSession.getMapper(OrderMapper.class);
        orderMapper.purchase(order_);

        sqlSession.close();
    }

    public  void add(int usersid, int goodsid, int quantity, double price, String goodsname) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        OrderMapper orderMapper =sqlSession.getMapper(OrderMapper.class);
        order order_=orderMapper.selectByUGNP(usersid, goodsid,goodsname,price);
        if (order_==null)
            orderMapper.add(usersid,goodsid, price,  quantity,goodsname);
        else {
            quantity=quantity+order_.getQuantity();
            orderMapper.updateUG(usersid,goodsid, price,  quantity,goodsname);}
        sqlSession.close();
    }

    public List<order> showlist(int userId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper =sqlSession.getMapper(OrderMapper.class);
        List<order> orderList= orderMapper.selectByCondition(userId,0);
        sqlSession.close();

        return orderList;
    }

    public List<order> showhistory() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper =sqlSession.getMapper(OrderMapper.class);
        List<order> orderList= orderMapper.show_history();
        sqlSession.close();

        return orderList;
    }

    public List<order> showuserhistory(int i) {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper =sqlSession.getMapper(OrderMapper.class);
        List<order> orderList= orderMapper.show_user_history(i);
        sqlSession.close();

        return orderList;
    }

    public List<order> showgoodhistory() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper =sqlSession.getMapper(OrderMapper.class);
        List<order> orderList= orderMapper.show_goods_history();
        sqlSession.close();

        return orderList;
    }

    public int del_none_goods(goods goods_) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        OrderMapper orderMapper =sqlSession.getMapper(OrderMapper.class);
        try {
            orderMapper.del_none_goods(goods_.getGoods_id());
            sqlSession.close();
            return 1;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public order selectById( int i) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        OrderMapper orderMapper =sqlSession.getMapper(OrderMapper.class);
        order order_=orderMapper.selectById(i);
        sqlSession.close();
        return order_;
    }

    public void updateOrder( int id, int quantity) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        OrderMapper orderMapper =sqlSession.getMapper(OrderMapper.class);
        orderMapper.update(id,quantity);
        sqlSession.close();

    }

    public void del(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        OrderMapper orderMapper =sqlSession.getMapper(OrderMapper.class);
        orderMapper.del(id);
        sqlSession.close();
    }
}
