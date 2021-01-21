package com.canytech.franzventura

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.canytech.franzventura.model.fakeItems
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment  : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rv_music_theory.adapter = TheoryItemAdapter(fakeItems())
        rv_music_theory.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        return inflater.inflate(R.layout.home_fragment, container, false)



    }


}