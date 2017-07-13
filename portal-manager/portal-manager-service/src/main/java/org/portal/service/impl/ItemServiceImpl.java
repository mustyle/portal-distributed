package org.portal.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.portal.common.pojo.DataGridResult;
import org.portal.mapper.ItemMapper;
import org.portal.pojo.Item;
import org.portal.pojo.ItemExample;
import org.portal.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public Item getItemById(long itemId) {
        //Item item = itemMapper.selectByPrimaryKey(itemId);

        ItemExample itemExample = new ItemExample();

        ItemExample.Criteria criteria = itemExample.createCriteria();

        criteria.andIdEqualTo(itemId);

        List<Item> items = itemMapper.selectByExample(itemExample);

        Item item = null;

        if (items != null && items.size() > 0) {
            item = items.get(0);
        }

        return item;
    }

    @Override
    public DataGridResult getItemList(int page, int rows) {
        // 分页处理
        PageHelper.startPage(page, rows);

        // 执行查询
        ItemExample example = new ItemExample();
        List<Item> itemList = itemMapper.selectByExample(example);

        PageInfo<Item> pageInfo = new PageInfo<>(itemList);

        DataGridResult dataGridResult = new DataGridResult();
        dataGridResult.setTotal(pageInfo.getTotal());
        dataGridResult.setRows(itemList);

        return dataGridResult;
    }
}
