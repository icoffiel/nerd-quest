package com.nerdery.icoffiel.quest.leaderboard

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.nerdery.icoffiel.quest.badge.BadgeResponse

@JsonIgnoreProperties(ignoreUnknown = true)
data class LeaderboardGetResponse(
        @JsonProperty("PlayerName") val playerName: String,
        @JsonProperty("AvatarUrl") val avatarUrl: String,
        @JsonProperty("Points") val points: Int,
        @JsonProperty("Title") val title: String,
        @JsonProperty("Effects") val effects: List<String>,
        @JsonProperty("Badges") val badges: List<BadgeResponse>,
        @JsonProperty("HasActiveQuest") val hasActiveQuest: Boolean,
        @JsonProperty("ClassName") val className: String?,
        @JsonProperty("ClassLevel") val classLevel: Int?
        ) {
    class Deserialize: ResponseDeserializable<List<LeaderboardGetResponse>> {
        override fun deserialize(content: String): List<LeaderboardGetResponse> = jacksonObjectMapper().readValue(content)
    }
}