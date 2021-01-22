package co.tiagoaguiar.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.canytech.franzventura.TheoryItem
import com.canytech.franzventura.R
import kotlinx.android.synthetic.main.home_fragment.view.*
import kotlinx.android.synthetic.main.item_theory_music.view.*
import java.lang.ClassCastException

class TheoryListFragment : Fragment() {

    private lateinit var listener: OnListSelected

    private lateinit var names: Array<String>
    private lateinit var imageResIds: IntArray

    companion object {
        fun newInstance() = TheoryListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.home_fragment, container, false)

        val activity = activity as Context
        val recyclerView = view.rv_music_theory
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = CharacterListAdapter()

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val resources = context.resources
        names = resources.getStringArray(R.array.names)

        val typedArray = resources.obtainTypedArray(R.array.images)
        val imageCount = names.size
        imageResIds = IntArray(imageCount)
        for (i in 0 until imageCount) {
            imageResIds[i] = typedArray.getResourceId(i, 0)
        }
        typedArray.recycle()

        if (context is OnListSelected) {
            listener = context
        } else {
            throw ClassCastException("$context must implemented")
        }
    }

    internal inner class CharacterListAdapter : RecyclerView.Adapter<ViewHolder>() {

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) =
            ViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.item_theory_music, viewGroup, false
                )
            )

        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
            val character = TheoryItem(
                names[position],
                imageResIds[position]
            )
            viewHolder.bind(character)
            viewHolder.itemView.setOnClickListener {
                listener.onSelected(character)
            }
        }

        override fun getItemCount() = names.size
    }

    internal inner class ViewHolder constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(theoryItem: TheoryItem) {
            itemView.img_cover_theory.setImageResource(theoryItem.imageResId)
            itemView.title_class.text = theoryItem.name
        }
    }

    interface OnListSelected {
        fun onSelected(theoryItem: TheoryItem)
    }


}