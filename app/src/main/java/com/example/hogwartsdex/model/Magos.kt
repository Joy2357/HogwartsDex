package com.example.hogwartsdex.model

import com.google.gson.annotations.SerializedName

data class Magos(
    @SerializedName("name")var name: String,
    @SerializedName("actor")var actor: String,
    @SerializedName("house")var house: String,
    @SerializedName("image")var imagen: String,
    @SerializedName("species")var species: String,
    @SerializedName("gender")var gender: String,
    @SerializedName("ancestry") var ancestry  : String,
    @SerializedName("dateOfBirth")var birth: String,
    @SerializedName("patronus")var patronus: String,
    @SerializedName("wand")var wand: Wand
)
data class Wand (
    @SerializedName("core")
    var core: String
)