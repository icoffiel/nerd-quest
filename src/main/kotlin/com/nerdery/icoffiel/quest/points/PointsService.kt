package com.nerdery.icoffiel.quest.points

import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

/**
 * Points Service
 */
@Service
class PointsService {
    private val jsonLog = LoggerFactory.getLogger("json")
    private val url = "http://nerdquest.nerderylabs.com:1337/points"

    @Value("\${apiKey}")
    lateinit private var apiKey: String

    fun callGetPoints(): Result<PointsGetResponse, FuelError> {
        val (request, response, result) = url
                .httpGet()
                .header(mapOf("apiKey" to apiKey))
                .responseObject(PointsGetResponse.Deserializer())

        jsonLog.debug(request.toString())
        jsonLog.debug(response.toString())

        return result
    }
}