package com.example.mvc_pattern

class Model {
    // true(LinearLayoutManager)/false(GridLayoutManager)
    var layoutMode = true
    var content = ""

    fun changeLayoutMode() {
        layoutMode = !layoutMode
    }
}