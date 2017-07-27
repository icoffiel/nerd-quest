package com.nerdery.icoffiel.quest.item

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ItemService @Autowired constructor(val itemRepository: ItemRepository) {

    fun saveItem(item: Item) {
        itemRepository.save(item)
    }
}