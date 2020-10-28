package com.mbds.neighbors.fragments


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import com.mbds.neighbors.NavigationListener
import com.mbds.neighbors.R
import com.mbds.neighbors.data.NeighborRepository
import com.mbds.neighbors.models.Neighbor

class AddNeighbourFragment : Fragment(), TextWatcher {

    private lateinit var enregistrerButton: Button

    private lateinit var nomTextEdit: EditText
    private lateinit var avatarUrlTextEdit: EditText
    private lateinit var telephoneTextEdit: EditText
    private lateinit var websiteTextEdit: EditText
    private lateinit var addressTextEdit: EditText
    private lateinit var aproposTextEdit: EditText
    private lateinit var telephoneLayout: TextInputLayout

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
        telephoneLayout = view.findViewById(R.id.telephoneLyt)

        nomTextEdit.addTextChangedListener(this)
        avatarUrlTextEdit.addTextChangedListener(this)
        telephoneTextEdit.addTextChangedListener(this)
        websiteTextEdit.addTextChangedListener(this)
        addressTextEdit.addTextChangedListener(this)
        aproposTextEdit.addTextChangedListener(this)



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? NavigationListener)?.let {
            it.updateTitle(R.string.add_neighbors_fragment)
        }
        enregistrerButton.setOnClickListener {
            val nom = nomTextEdit.text.toString()
            val avatarUrl = avatarUrlTextEdit.text.toString()
            val address = addressTextEdit.text.toString()
            val phoneNumber = telephoneTextEdit.text.toString()
            val aboutMe = aproposTextEdit.text.toString()
            val webSite = websiteTextEdit.text.toString()
            val favorite = false
            val id = NeighborRepository.getInstance().getNeighbours().size + 1

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

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    // Le bouton reste grisé tant que tous les champs ne sont pas validés
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        enregistrerButton.isEnabled =
            nomTextEdit.text.isNotBlank() && avatarUrlTextEdit.text.isNotEmpty() && addressTextEdit.text.isNotEmpty() && websiteTextEdit.text.isNotEmpty() && telephoneTextEdit.text.isNotEmpty() && aproposTextEdit.text.isNotEmpty()
    }

    override fun afterTextChanged(s: Editable?) {
        with(telephoneTextEdit.text.toString()) {
            if ((startsWith("06") || startsWith("07")) && length == 10) {
                telephoneLayout.error = null
            } else {
                telephoneLayout.error = getString(R.string.error_telephone)
            }
        }

    }


}