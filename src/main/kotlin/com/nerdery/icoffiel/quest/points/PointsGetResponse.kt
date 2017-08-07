package com.nerdery.icoffiel.quest.points

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.nerdery.icoffiel.quest.badge.BadgeResponse

@JsonIgnoreProperties(ignoreUnknown = true)
data class PointsGetResponse(
        @JsonProperty("PlayerName") val playerName: String,
        @JsonProperty("AvatarUrl") val avatarUrl: String,
        @JsonProperty("Badges") val badges: List<BadgeResponse>,
        @JsonProperty("Effects") val effects: List<String>,
        @JsonProperty("Title") val title: String,
        @JsonProperty("Points") val points: Int,
        @JsonProperty("ItemsGained") val itemsGained: Int,
        @JsonProperty("ItemsUsed") val itemsUsed: Int,
        @JsonProperty("HasActiveQuest") val hasActiveQuest: Boolean,
        @JsonProperty("Crystals") val crystals: Int,
        @JsonProperty("ClassName") val className: String?,
        @JsonProperty("ClassLevel") val classLevel: String?) {

    class Deserializer: ResponseDeserializable<PointsGetResponse> {
        override fun deserialize(content: String): PointsGetResponse? = jacksonObjectMapper().readValue<PointsGetResponse>(content)
    }
}