package com.etycx;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 武海升
 * @description 接口测试
 * @date 2019/6/12 11:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class AuthTest {


    @Test
    public void index(){

        List<String> list=new ArrayList<String>();

        list.add("保护环境");  //向列表中添加数据

        list.add("爱护地球");  //向列表中添加数据

        list.add("从我做起");  //向列表中添加数据

        String ret=list.set(1,"少用塑料袋");

        System.out.println("获取索引位置1替换前的内容："+ret);

        //通过循环输出列表中的内容

        for(int i=0;i<list.size();i++){

            System.out.println(i+":"+list.get(i));

        }


    }

}
