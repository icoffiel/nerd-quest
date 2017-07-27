package com.nerdery.icoffiel.quest.item

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "items")
class Item(
        @Id @JsonProperty("key") var key: String?,
        @JsonProperty("Name") val name: String,
        @JsonProperty("Id") val itemId: UUID,
        @JsonProperty("Rarity") val rarity: Int,
        @JsonProperty("Description") val description: String
)