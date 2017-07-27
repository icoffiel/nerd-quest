package com.nerdery.icoffiel.quest.points

import com.github.kittinunf.result.Result
import com.github.kittinunf.result.getAs
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Rest Controller for Points.
 */
@RestController
@RequestMapping("/api/points")
class PointsController @Autowired constructor(val pointsService: PointsService) {

    @GetMapping
    fun getPoints(): PointsGetResponse? {
        val result = pointsService.callGetPoints()

        return when(result) {
            is Result.Success -> result.getAs()
            is Result.Failure -> null
        }
    }

    @PostMapping
    fun postPoints(): PointsPostResponse? = pointsService.postPoints()

    @Scheduled(fixedDelay = 1500)
    fun pointsPostPoller() = pointsService.postPoints()
}