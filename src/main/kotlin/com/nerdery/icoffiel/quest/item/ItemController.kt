package com.nerdery.icoffiel.quest.item

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/items")
class ItemController @Autowired constructor(val itemService: ItemService) {

    @GetMapping
    fun listAllItems() = itemService.listAll()
}