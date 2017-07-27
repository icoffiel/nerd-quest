package com.nerdery.icoffiel.quest.points

import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import com.github.kittinunf.result.getAs
import com.nerdery.icoffiel.quest.item.ItemService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

/**
 * Points Service
 */
@Service
class PointsService @Autowired constructor(val itemService: ItemService) {
    private val jsonLog = LoggerFactory.getLogger("json")
    private val url = "http://nerdquest.nerderylabs.com:1337/points"

    @Value("\${apiKey}")
    lateinit private var apiKey: String

    fun callGetPoints(): Result<PointsGetResponse, FuelError> {
        val (request, response, result) = url
                .httpGet()
                .header(mapOf("apiKey" to apiKey))
                .responseObject(PointsGetResponse.Deserializer())

        logJson(request, response)

        return result
    }

    private fun logJson(request: Request, response: Response) {
        jsonLog.debug(request.toString())
        jsonLog.debug(response.toString())
    }

    fun postPoints(): PointsPostResponse? {
        val (request, response, result) = url
                .httpPost()
                .header(mapOf("apiKey" to apiKey))
                .responseObject(PointsPostResponse.Deserializer())

        logJson(request, response)

        return when(result) {
            is Result.Success -> {
                val pointsPostResponse = result.getAs<PointsPostResponse>()
                pointsPostResponse?.item?.let { item -> itemService.saveItem(item) }
                pointsPostResponse
            }
            is Result.Failure -> null
        }
    }
}