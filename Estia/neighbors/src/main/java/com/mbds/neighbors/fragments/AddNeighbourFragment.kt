package com.mbds.neighbors.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.mbds.neighbors.NavigationListener
import com.mbds.neighbors.R
import com.mbds.neighbors.data.NeighborRepository
import com.mbds.neighbors.models.Neighbor

class AddNeighbourFragment : Fragment() {

    private lateinit var enregistrerButton: Button

    private lateinit var nomTextEdit: EditText
    private lateinit var avatarUrlTextEdit: EditText
    private lateinit var telephoneTextEdit: EditText
    private lateinit var websiteTextEdit: EditText
    private lateinit var addressTextEdit: EditText
    private lateinit var aproposTextEdit: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_neighbours_fragment, container, false)
        enregistrerButton = view.findViewById(R.id.btn_enregistrer)
        nomTextEdit = view.findViewById(R.id.name)
        avatarUrlTextEdit = view.findViewById(R.id.avatarUrl)
        telephoneTextEdit = view.findViewById(R.id.telephone)
        websiteTextEdit = view.findViewById(R.id.website)
        addressTextEdit = view.findViewById(R.id.address)
        aproposTextEdit = view.findViewById(R.id.apropos)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         enregistrerButton.setOnClickListener {
             val nom = nomTextEdit.text.toString()
             val avatarUrl = avatarUrlTextEdit.text.toString()
             val address = addressTextEdit.text.toString()
             val phoneNumber = telephoneTextEdit.text.toString()
             val aboutMe = aproposTextEdit.text.toString()
             val webSite = websiteTextEdit.text.toString()
             val favorite = true
             val id = NeighborRepository.getInstance().getNeighbours().size +1

             val neighbor = Neighbor(
                 id = id,
                 name = nom,
                 avatarUrl = avatarUrl,
                 address = address,
                 phoneNumber = phoneNumber,
                 aboutMe = aboutMe,
                 favorite = favorite,
                 webSite = webSite
             )

             NeighborRepository.getInstance().createNeighbours(neighbor)

             (activity as? NavigationListener)?.let {
                 it.showFragment(ListNeighborsFragment())
             }

         }

    }


}