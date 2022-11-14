package com.vnazarov.testandroid1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StartFragment : Fragment() {

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
        val view = inflater.inflate(R.layout.fragment_main_list, container, false)

        rv = view.findViewById(R.id.recycler_view) as RecyclerView
        rv.layoutManager = LinearLayoutManager(context)

        updateUI()

        return view
    }

    private inner class RvHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    private inner class RvAdapter() : RecyclerView.Adapter<RvHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvHolder {
            if (viewType == 0) {
                val startView = layoutInflater.inflate(R.layout.screen_name, parent, false)
                return RvHolder(startView)
            } else if (viewType == 1) {
                val secondView = layoutInflater.inflate(R.layout.location_name, parent, false)
                return RvHolder(secondView)
            } else if (viewType == 2) {
                val view1 = layoutInflater.inflate(R.layout.rv_package_background_1, parent, false)
                return RvHolder(view1)
            } else if (viewType == 3) {
                val view2 = layoutInflater.inflate(R.layout.rv_package_background_2, parent, false)
                return RvHolder(view2)
            } else if (viewType == 4) {
                val view3 = layoutInflater.inflate(R.layout.rv_package_background_3, parent, false)
                return RvHolder(view3)
            } else {
                val elseView =
                    layoutInflater.inflate(R.layout.rv_package_background_2, parent, false)
                return RvHolder(elseView)
            }
        }

        override fun onBindViewHolder(holder: RvHolder, position: Int) {

        }

        override fun getItemViewType(position: Int): Int {
            if (position == 0) {
                return 0
            } else if (position == 1) {
                return 1
            } else if (position == 2) {
                return 2
            } else if (position == 3) {
                return 3
            } else if (position == 4) {
                return 4
            } else return 5
        }

        override fun getItemCount(): Int {
            return 5
        }
    }

    private fun updateUI() {
        adapter = RvAdapter()
        rv.adapter = adapter
    }
}