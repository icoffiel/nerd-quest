package com.nerdery.icoffiel.quest.badge

import com.fasterxml.jackson.annotation.JsonProperty

data class BadgeResponse(@JsonProperty("BadgeName") val badgeName: String)