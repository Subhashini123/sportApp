package com.rtech.sportapp.model

import com.google.gson.annotations.SerializedName

data class Teams(
    @SerializedName("4")
    val third: X4?,
    @SerializedName("5")
    val fourth: X5?
//    val `4`: X4,
//    val `5`: X5
)