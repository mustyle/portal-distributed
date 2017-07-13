package org.portal.pagehelper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.portal.mapper.ItemMapper;
import org.portal.pojo.Item;
import org.portal.pojo.ItemExample;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestPageHelper {
    @Test
    public void testPageHelper() throws Exception {
        // 获得mapper代理对象
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        ItemMapper itemMapper = context.getBean(ItemMapper.class);

        // 设置分页
        PageHelper.startPage(1, 20);

        // 执行查询
        ItemExample example = new ItemExample();
        List<Item> itemList = itemMapper.selectByExample(example);

        // 取分页后的结果
        PageInfo<Item> pageInfo = new PageInfo<>(itemList);
        long total = pageInfo.getTotal();
        int pages = pageInfo.getPages();
        int pageSize = pageInfo.getPageSize();

        System.out.println("total: " + total);
        System.out.println("page: " + pages);
        System.out.println("pageSize: " + pageSize);

        context.close();
    }
}
