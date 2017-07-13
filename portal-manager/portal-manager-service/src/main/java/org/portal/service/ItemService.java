package org.portal.service;

import org.portal.common.pojo.DataGridResult;
import org.portal.pojo.Item;

public interface ItemService {
    Item getItemById(long itemId);

    DataGridResult getItemList(int page, int rows);
}
