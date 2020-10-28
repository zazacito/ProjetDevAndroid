package com.mbds.neighbors.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mbds.neighbors.NavigationListener
import com.mbds.neighbors.R
import com.mbds.neighbors.adapters.ListNeighborHandler
import com.mbds.neighbors.adapters.ListNeighborsAdapter
import com.mbds.neighbors.data.NeighborRepository
import com.mbds.neighbors.models.Neighbor


class ListNeighborsFragment : Fragment(),ListNeighborHandler {

    private lateinit var recyclerView: RecyclerView
    private lateinit var addButton: FloatingActionButton

    // Fonction permettant de définir une vue à attacher à un fragment
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_neighbors_fragment, container, false)
        recyclerView = view.findViewById(R.id.neighbors_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        addButton = view.findViewById(R.id.btn_add)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val neighbors = NeighborRepository.getInstance().getNeighbours()
        val adapter = ListNeighborsAdapter(neighbors, this)
        recyclerView.adapter = adapter

        (activity as? NavigationListener)?.let {
            it.updateTitle(R.string.list_neighbors_fragment)
        }
        addButton.setOnClickListener {
            (activity as? NavigationListener)?.let {
                it.showFragment(AddNeighbourFragment())
            }
        }
    }

    override fun onDeleteNeighbor(neighbor: Neighbor) {
        AlertDialog.Builder(context)
            .setTitle("Delete entry")
            .setMessage("Are you sure you want to delete this entry?")
            .setPositiveButton(android.R.string.yes,
                DialogInterface.OnClickListener { dialog, which ->
                    NeighborRepository.getInstance().deleteNeighbours(neighbor)
                    recyclerView.adapter?.notifyDataSetChanged()
                }) // A null listener allows the button to dismiss the dialog and take no further action.
            .setNegativeButton(android.R.string.no, null)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .show()
    }
}