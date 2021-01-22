package com.canytech.franzventura

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_theory_music.view.*

class CourseFragment : Fragment() {

    companion object {
        fun newInstance() = CourseFragment()
    }

    class TheoryItemAdapter(val theoryItems: MutableList<TheoryItem>) :
        RecyclerView.Adapter<TheoryItemAdapter.TheoryItemViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheoryItemViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_theory_music, parent, false)
            return TheoryItemViewHolder(view)
        }

        override fun onBindViewHolder(holder: TheoryItemViewHolder, position: Int) {
            holder.bind(theoryItems[position])
        }

        override fun getItemCount(): Int = theoryItems.size

        class TheoryItemViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
            fun bind(theoryItem: TheoryItem) {
                with(theoryItem) {
                    itemView.title_class.text = name
                    itemView.img_cover_theory.id = imageResId

                }
            }
        }

    }
}