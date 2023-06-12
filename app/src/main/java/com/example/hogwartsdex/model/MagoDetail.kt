package com.example.hogwartsdex.model

import com.google.gson.annotations.SerializedName

data class MagoDetail(
    @SerializedName("name"     ) var name     : String,
    @SerializedName("image"    ) var image    : String,
    @SerializedName("actor"    ) var actor    : String,
    @SerializedName("species"  ) var species  : String,
    @SerializedName("gender"   ) var gender   : String,
    @SerializedName("house"    ) var house    : String,
    @SerializedName("dateOfBirth") var dateOfBirth : String,
    @SerializedName("ancestry") var ancestry  : String,
    @SerializedName("patronus") var patronus  : String,
    )


