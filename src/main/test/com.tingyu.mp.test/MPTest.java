package com.tingyu.mp.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.tingyu.mp.entity.Goods;
import com.tingyu.mp.mapper.GoodsMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @author Essionshy
 * @create 2019/11/25-16:49
 */
public class MPTest {

    private ApplicationContext ioc=null;

    private GoodsMapper goodsMapper;



    @Before
    public void init(){
        ioc=new  ClassPathXmlApplicationContext("applicationContext.xml");
        goodsMapper=ioc.getBean("goodsMapper",GoodsMapper.class);
    }

    @Test
    public void testCommonInsert(){

      /*  Goods goods=new Goods();
        goods.setLast_name("计算器")
                .setDescription("小型家用办公计算器")
                .setLocation("电脑桌")
                .setGmtCreate(new Date())
                .setGmtModified(new Date());
        Integer count = goodsMapper.insert(goods);
        System.out.println("count:"+count);*/

    }
    @Test
    public void testSelect(){
        Goods goods = goodsMapper.selectById(1);
        System.out.println("货物信息："+goods);

    }

    @Test
    public void testDataSource()throws Exception{
        DruidDataSource dataSource = ioc.getBean("dataSource",DruidDataSource.class);
        System.out.println("Druid 数据源："+dataSource);
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println("数据连接："+connection);
    }
}
