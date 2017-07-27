package com.nerdery.icoffiel.quest.points

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.github.kittinunf.result.getAs
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Rest Controller for Points.
 */
@RestController
@RequestMapping("/api/points")
class PointsController {

    @Value("\${apiKey}")
    lateinit private var apiKey: String
    private val jsonLog = LoggerFactory.getLogger("json")

    @GetMapping
    fun getPoints(): PointsResponse? {
        val (request, response, result) =
                "http://nerdquest.nerderylabs.com:1337/points"
                        .httpGet()
                        .header(mapOf("apiKey" to apiKey))
                        .responseObject(PointsResponse.Deserializer())

        jsonLog.debug(request.toString())
        jsonLog.debug(response.toString())

        return when(result) {
            is Result.Success -> result.getAs()
            is Result.Failure -> null
        }
    }
}