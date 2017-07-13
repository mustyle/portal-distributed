package org.portal.controller;

import org.portal.common.pojo.DataGridResult;
import org.portal.pojo.Item;
import org.portal.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/item/{itemId}")
    @ResponseBody
    private Item getItemById(@PathVariable long itemId) {
        return itemService.getItemById(itemId);
    }

    /*
     * e.g
     * http://localhost:8080/item/list?page=1&rows=3
     */
    @GetMapping("/item/list")
    @ResponseBody
    public DataGridResult getItemList(Integer page, Integer rows) {
        return itemService.getItemList(page, rows);
    }
}
