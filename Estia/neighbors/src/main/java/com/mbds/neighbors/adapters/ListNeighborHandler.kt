package com.mbds.neighbors.adapters


import com.mbds.neighbors.models.Neighbor


interface ListNeighborHandler {

    fun onDeleteNeighbor(neighbor: Neighbor)
}