package com.nerdery.icoffiel.quest.leaderboard

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/leaderboard")
class LeaderboardController @Autowired constructor(val leaderboardService: LeaderboardService) {

    @GetMapping
    fun getLeaderboard(): List<LeaderboardGetResponse> = leaderboardService.getLeaderboard()
}