package com.raywenderlich.listmaker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListDetailFragment : Fragment() {
    lateinit var list: TaskList
    lateinit var listItemsRecyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            list = it.getParcelable(MainActivity.INTENT_LIST_KEY)!!
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?, savedInstanceState: Bundle?): View? {
// Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_list_detail, container,
            false)
        view?.let {
            listItemsRecyclerView =
                it.findViewById<RecyclerView>(R.id.list_items_reyclerview)
            listItemsRecyclerView.adapter = ListItemsRecyclerViewAdapter(list)
            listItemsRecyclerView.layoutManager = LinearLayoutManager(context)
        }
        return view
    }
    companion object {
        private const val ARG_LIST = "list"
        fun newInstance(list: TaskList): ListDetailFragment {
            val fragment = ListDetailFragment()
            val args = Bundle()
            args.putParcelable(ARG_LIST, list)
            fragment.arguments = args
            return fragment
        }
    }
    fun addTask(item: String) {
        list.tasks.add(item)
        val listRecyclerAdapter = listItemsRecyclerView.adapter as
                ListItemsRecyclerViewAdapter
        listRecyclerAdapter.list = list
        listRecyclerAdapter.notifyDataSetChanged()
    }
}
