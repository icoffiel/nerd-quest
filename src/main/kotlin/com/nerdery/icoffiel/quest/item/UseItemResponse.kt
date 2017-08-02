package com.nerdery.icoffiel.quest.item

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.github.kittinunf.fuel.core.ResponseDeserializable

data class UseItemResponse(
        @JsonProperty("Messages") val messages: List<String>,
        @JsonProperty("TargetName") val targetName: String,
        @JsonProperty("Points") val points: Int) {

    class Deserializer: ResponseDeserializable<UseItemResponse> {
        override fun deserialize(content: String): UseItemResponse? = jacksonObjectMapper().readValue<UseItemResponse>(content)
    }
}