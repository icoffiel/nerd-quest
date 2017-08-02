package com.nerdery.icoffiel.quest.item

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/items")
class ItemController @Autowired constructor(val itemService: ItemService) {

    @GetMapping
    fun listAllItems() = itemService.listAll()

    @PostMapping("/{itemId}")
    fun useItem(@PathVariable itemId: String, @RequestParam(required = false) user: String?): UseItemResponse? {
        return itemService.useItem(itemId, user)
    }
}