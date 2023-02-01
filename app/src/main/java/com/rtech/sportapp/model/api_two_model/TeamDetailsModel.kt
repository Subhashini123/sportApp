package com.rtech.sportapp.model.api_two_model

data class TeamDetailsModel(
    val Innings: List<Inning>,
    val Matchdetail: Matchdetail,
    val Notes: Notes,
    val Nuggets: List<String>,
    val Teams: Teams
)