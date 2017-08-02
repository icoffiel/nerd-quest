package com.nerdery.icoffiel.quest.leaderboard

import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.github.kittinunf.result.getAs
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class LeaderboardService {

    private val jsonLog = LoggerFactory.getLogger("json")
    val url = "http://nerdquest.nerderylabs.com:1337/"

    fun getLeaderboard(): List<LeaderboardGetResponse> {
        val (request, response, result) = url
                .httpGet()
                .responseObject(LeaderboardGetResponse.Deserialize())

        logJson(request, response)

        return when(result) {
            is Result.Success -> result.getAs<List<LeaderboardGetResponse>>() ?: listOf<LeaderboardGetResponse>()
            is Result.Failure -> listOf<LeaderboardGetResponse>()
        }
    }

    private fun logJson(request: Request, response: Response) {
        jsonLog.debug(request.toString())
        jsonLog.debug(response.toString())
    }
}

