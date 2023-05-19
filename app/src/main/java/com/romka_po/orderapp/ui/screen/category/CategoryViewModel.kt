package com.romka_po.orderapp.ui.screen.category

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.romka_po.orderapp.App
import com.romka_po.orderapp.model.Category
import com.romka_po.orderapp.model.Product
import com.romka_po.orderapp.utils.getJsonDataFromAsset
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CategoryViewModel @Inject constructor(private val app: App) : ViewModel() {

    var products: MutableLiveData<List<Product>> = MutableLiveData()
    var categories: MutableLiveData<List<Category>> = MutableLiveData()
    var selectedProducts: MutableLiveData<Map<Int, Int>> = MutableLiveData(mapOf())
    var cost:MutableLiveData<Float> = MutableLiveData(0f)


    init {
        MainScope().launch {
            products.postValue(getProduct())
            categories.postValue(getCategory())
        }

    }

    suspend fun getProduct(): List<Product>? {
        val jsonFileString = getJsonDataFromAsset(app, "products.json")
        jsonFileString?.let {
        }
        val gson = Gson()
        val listPersonType = object : TypeToken<List<Product>>() {}.type

        return gson.fromJson(jsonFileString, listPersonType)

    }

    suspend fun getCategory(): List<Category>? {
        val jsonFileString = getJsonDataFromAsset(app, "categories.json")
        jsonFileString?.let {
        }
        val gson = Gson()
        val listPersonType = object : TypeToken<List<Category>>() {}.type

        return gson.fromJson(jsonFileString, listPersonType)

    }

    fun changeValue(id: Int, cost:Int, isPlus: Boolean) {
        selectedProducts.postValue(selectedProducts.value?.toMutableMap().apply {
            when (this?.get(id)) {
                null, 0 -> {
                    if (isPlus) {
                        this?.set(id, 1)
                        changeCost(cost)
                    }
                }
                else ->{
                    if (isPlus){
                        this[id] = this[id]!!+1

                    }
                    else{
                        if (this[id]==1)
                            this.remove(id)
                        else
                            this[id] = this[id]!!-1
                    }
                    changeCost(cost*-1)
                }
            }
        })
    }
    fun changeCost(sCost: Int){
        cost.postValue((cost.value?.plus(sCost) ?: sCost) as Float?)
    }


}