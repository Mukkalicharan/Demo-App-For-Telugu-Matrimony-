package com.my.repo

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ViewModels : ViewModel() {

    var navHost = mutableStateOf("Start")
        private set
    var items = mutableStateListOf<Types>()
        private set

    fun updateItems(it2: Types) {
        items.replaceAll {
            it.copy(selected = it == it2)
        }
    }

    init {
        items.add(Types("Myself"))
        items.add(Types("Son"))
        items.add(Types("Daughter"))
        items.add(Types("Brother"))
        items.add(Types("Sister"))
        items.add(Types("Friend"))
        items.add(Types("Relative"))
    }

    data class Types(
        val item: String,
        var selected: Boolean = false
    )

}

