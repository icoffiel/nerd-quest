package com.nerdery.icoffiel.quest.item

import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import com.github.kittinunf.result.getAs
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ItemService @Autowired constructor(val itemRepository: ItemRepository) {

    @Value("\${apiKey}")
    lateinit private var apiKey: String

    private val jsonLog = LoggerFactory.getLogger("json")
    private val url = "http://nerdquest.nerderylabs.com:1337/items"

    fun saveItem(item: Item): Item? = itemRepository.save(item)

    fun listAll(): MutableIterable<Item>? = itemRepository.findAll()

    fun delete(id: String): Unit = itemRepository.delete(id)

    fun findOne(id: String): Item? = itemRepository.findOne(id)

    fun useItem(itemDbId: String, user: String?): UseItemResponse? {
        return findOne(itemDbId)?.let { item ->
            val fullUrl = if (user != null) "$url/use/${item.itemId}?target=$user" else "$url/use/${item.itemId}"
            val (request, response, result) = fullUrl
                    .httpPost()
                    .header(mapOf("apiKey" to apiKey))
                    .responseObject(UseItemResponse.Deserializer())

            logJson(request, response)

            return when(result) {
                is Result.Success -> {
                    val useItemResponse = result.getAs<UseItemResponse>()
                    delete(itemDbId)
                    useItemResponse
                }
                is Result.Failure -> null
            }
        }
    }

    private fun logJson(request: Request, response: Response) {
        jsonLog.debug(request.toString())
        jsonLog.debug(response.toString())
    }
}