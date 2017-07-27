package com.nerdery.icoffiel.quest.points

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.github.kittinunf.fuel.core.ResponseDeserializable

@JsonIgnoreProperties(ignoreUnknown = true)
data class PointsResponse(
        @JsonProperty("PlayerName") val playerName: String,
        @JsonProperty("AvatarUrl") val avatarUrl: String?) {

    class Deserializer: ResponseDeserializable<PointsResponse> {
        override fun deserialize(content: String): PointsResponse? = jacksonObjectMapper().readValue<PointsResponse>(content)
    }
}