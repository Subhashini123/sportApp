package com.rtech.sportapp

import com.rtech.sportapp.model.MatchDetailsModel
import com.rtech.sportapp.model.api_two_model.TeamDetailsModel
import retrofit2.Response
import retrofit2.http.GET

interface SportApiService {

    @GET("/nzin01312019187360.json")
    suspend fun matchDetailsApi(): Response<MatchDetailsModel>

    @GET("/sapk01222019186652.json")
    suspend fun teamDetailsApi(): Response<TeamDetailsModel>
}
