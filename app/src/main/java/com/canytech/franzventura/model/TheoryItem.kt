package com.canytech.franzventura.model

import com.canytech.franzventura.R

data class TheoryItem(
    val title: String,
    val cover: Int
)

class TheoryItemBuilder {
    var title: String = ""
    var cover: Int = R.drawable.bg_item

    fun buid(): TheoryItem = TheoryItem(title, cover)
}

fun theoryItem(block: TheoryItemBuilder.() -> Unit): TheoryItem =
    TheoryItemBuilder().apply(block).buid()

fun fakeItems() = mutableListOf(
    theoryItem {
    title = "Pra que serve a da teoria musical?"
    cover = R.drawable.fake_cover
},
    theoryItem {
        title = "O que é música?"
        cover = R.drawable.fake_cover
    },
    theoryItem {
        title = "O que é nota musical?"
        cover = R.drawable.fake_cover
    },
    theoryItem {
        title = "Baixo como um sapo ou alto como uma seriema?"
        cover = R.drawable.fake_cover
    },
    theoryItem {
        title = "O caráter musical"
        cover = R.drawable.fake_cover
    },
    theoryItem {
        title = "O que é música?"
        cover = R.drawable.fake_cover
    },
    theoryItem {
        title = "O que é nota musical?"
        cover = R.drawable.fake_cover
    },
    theoryItem {
        title = "Baixo como um sapo ou alto como uma seriema?"
        cover = R.drawable.fake_cover
    },
    theoryItem {
        title = "O caráter musical"
        cover = R.drawable.fake_cover
    }
)