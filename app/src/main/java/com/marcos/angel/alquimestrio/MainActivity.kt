package com.marcos.angel.alquimestrio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val animals: ArrayList<Compounds> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myAdapter = AnimalAdapter(animals, this)
        loadAnimals()

        val btnclick = findViewById<Button>(R.id.button)

        btnclick.setOnClickListener {
            Log.d("BOTONAZO", "MIRA MAMA SOY UN BOTONAZO")
            animals.add(Compounds("MINUEVOCOMPONENTAZO", "http://148.204.168.11:8080/molecule/COC(%3DO)%5BC%40H%5D1%5BC%40H%5D(CC2CCC1N2C)OC(%3DO)c3ccccc3", "ola"))
            myAdapter.notifyDataSetChanged()
        }

        rv_animal_list.layoutManager = LinearLayoutManager(this)

        rv_animal_list.adapter = myAdapter
    }

    fun loadAnimals() {
        for(i in 1..2) {
            animals.add(Compounds("Compound $i", "http://148.204.168.11:8080/molecule/Cn1cnc2N(C)C(%3DO)N(C)C(%3DO)c12", "Stuff $i"))
        }
        Log.d("Animalitos", "Animal ${animals.size}")
    }
}
