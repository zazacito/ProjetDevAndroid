package com.mbds.estia

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Afficher une web Page
        //showWebPage()
        callMe()
    }

    // Fonction permettant d'afficher une page web
    fun showWebPage(){
        val chemin: Uri  = Uri.parse("http://www.google.fr")
        val naviguer = Intent(Intent.ACTION_VIEW, chemin)
        startActivity(naviguer)
    }

    // Fonction permettant d'appeler un numéro de téléphone
    fun callMe(){
        val numero = Uri.parse("tel:0675044287")
        val appeler = Intent(Intent.ACTION_VIEW, numero)
        startActivity(appeler)
    }
}