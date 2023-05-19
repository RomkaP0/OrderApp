package com.romka_po.orderapp.model

import com.google.gson.annotations.SerializedName

data class Product(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("category_id") var categoryId: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("price_current") var priceCurrent: Int? = null,
    @SerializedName("price_old") var priceOld: String? = null,
    @SerializedName("measure") var measure: Int? = null,
    @SerializedName("measure_unit") var measureUnit: String? = null,
    @SerializedName("energy_per_100_grams") var energyPer100Grams: Double? = null,
    @SerializedName("proteins_per_100_grams") var proteinsPer100Grams: Double? = null,
    @SerializedName("fats_per_100_grams") var fatsPer100Grams: Double? = null,
    @SerializedName("carbohydrates_per_100_grams") var carbohydratesPer100Grams: Double? = null,
    @SerializedName("tag_ids") var tagIds: ArrayList<String> = arrayListOf()
)
