package com.rtech.sportapp

import com.rtech.sportapp.model.MatchDetailsModel
import com.rtech.sportapp.model.api_two_model.TeamDetailsModel

// SST
class SportRepository constructor(private val service: SportApiService) {
    suspend fun getMatchDetails(): MatchDetailsModel? {
        return service.matchDetailsApi().body()
    }

    suspend fun getTeamsDetails(): TeamDetailsModel? {
        return service.teamDetailsApi().body()
    }
}