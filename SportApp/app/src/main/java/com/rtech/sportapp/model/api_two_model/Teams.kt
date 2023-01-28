package com.rtech.sportapp.model.api_two_model

import com.google.gson.annotations.SerializedName
import com.rtech.sportapp.model.X4

data class Teams(
    @SerializedName("6")
    val third: X4?,
    @SerializedName("7")
    val fourt:X5
  /*  val `4`: X4,
    val `5`: X5*/
)