package com.romka_po.orderapp.ui.screen.category

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.romka_po.orderapp.R
import dagger.hilt.android.lifecycle.HiltViewModel
import java.nio.charset.Charset
import javax.inject.Inject


@HiltViewModel
class CategoryViewModel @Inject constructor() :ViewModel(){

    var dishes:LiveData<List<Map<String, String>>> = MutableLiveData()


    var json: String? = null
    val charset: Charset = Charsets.UTF_8


    fun getDishes(context: Context): String {
        val myFile = context.resources.openRawResource(R.raw.categories)
        val size = myFile.available()
        val buffer = ByteArray(size)
        myFile.read()
        myFile.close()
        val json = String(buffer, charset)
        return json
    }


}