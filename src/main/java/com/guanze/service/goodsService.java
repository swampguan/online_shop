package com.guanze.service;

import com.guanze.mapper.GoodsMapper;
import com.guanze.pojo.goods;
import com.guanze.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class goodsService {

    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public int delete(goods goods) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        GoodsMapper goodsMapper =sqlSession.getMapper(GoodsMapper.class);
        try {
            goodsMapper.del(goods);
            sqlSession.close();
            return 1;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public List<goods> showlist()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper goodsMapper =sqlSession.getMapper(GoodsMapper.class);
        List<goods> goodsList= goodsMapper.selectAll();
        sqlSession.close();

        return goodsList;
    }

    public goods selectbyid(int id)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper goodsMapper =sqlSession.getMapper(GoodsMapper.class);
        goods goods_= goodsMapper.selectById(id);
        sqlSession.close();
        return goods_;
    }

    public void updateGQ(int goodsId, int quantity) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper goodsMapper =sqlSession.getMapper(GoodsMapper.class);
        goodsMapper.updateGQ(goodsId, quantity);
        sqlSession.close();

    }

    public int add(String name, double price, String description,int quantity) {
        goods goods_ = new goods();
        goods_.setGoods_name(name);
        goods_.setPrice(price);
        goods_.setDescription(description);
        goods_.setQuantity(quantity);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper goodsMapper =sqlSession.getMapper(GoodsMapper.class);
        goodsMapper.add(goods_);
        System.out.println(goods_);
        sqlSession.commit();
        sqlSession.close();
        return goods_.getGoods_id();
    }

    public List<goods> showlistBySearch(String goodsName, int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper goodsMapper =sqlSession.getMapper(GoodsMapper.class);
        List<goods> goodsList_ = goodsMapper.selectByCondition(goodsName,id);
         sqlSession.close();
         return goodsList_;
    }

    public List<goods> selectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper goodsMapper =sqlSession.getMapper(GoodsMapper.class);
        List<goods> goodsList_ = goodsMapper.selectAll();
        sqlSession.close();
        return goodsList_;
    }

    public int update(goods goods_) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        GoodsMapper goodsMapper =sqlSession.getMapper(GoodsMapper.class);
        try {
            goodsMapper.update(goods_);
            sqlSession.close();
            return 1;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }
}
