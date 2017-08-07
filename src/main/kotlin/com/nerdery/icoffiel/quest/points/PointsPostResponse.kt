package com.nerdery.icoffiel.quest.points

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.nerdery.icoffiel.quest.badge.BadgeResponse
import com.nerdery.icoffiel.quest.item.Item

data class PointsPostResponse(
        @JsonProperty("Messages") val messages: List<String>,
        @JsonProperty("Item") val item: Item?,
        @JsonProperty("Points") val points: Int,
        @JsonProperty("Effects") val effects: List<String>,
        @JsonProperty("Badges") val badges: List<BadgeResponse>) {

    class Deserializer: ResponseDeserializable<PointsPostResponse> {
        override fun deserialize(content: String): PointsPostResponse? = jacksonObjectMapper().readValue<PointsPostResponse>(content)
    }
}