package com.vnazarov.testandroid1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StartFragment: Fragment() {

    private lateinit var rv: RecyclerView
    private var adapter: RvAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_of_locations, container, false)

        rv = view.findViewById(R.id.list_recycler_view) as RecyclerView
        rv.layoutManager = LinearLayoutManager(context)

        updateUI()

        return view
    }

    private inner class RvHolder(view: View): RecyclerView.ViewHolder(view){

        init {
            itemView.setOnClickListener {
                Navigation.findNavController(requireView()).navigate(R.id.action_startFragment_to_secondFragment)
            }
        }
    }

    private inner class RvAdapter(var listOfLocations: List<String>): RecyclerView.Adapter<RvHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvHolder {
            if (viewType == 0) {
                val view = layoutInflater.inflate(R.layout.screen_name, parent, false)
                return RvHolder(view)
            } else {
                val view = layoutInflater.inflate(R.layout.location_name, parent, false)
                return RvHolder(view)
            }
        }

        override fun onBindViewHolder(holder: RvHolder, position: Int) {

        }

        override fun getItemViewType(position: Int): Int {
            return if (position == 0) 0
            else 1
        }

        override fun getItemCount(): Int {
            return listOfLocations.size + 1
        }
    }

    private fun updateUI(){
        val list = listOf<String>("name")
        adapter = RvAdapter(list)
        rv.adapter = adapter
    }
}