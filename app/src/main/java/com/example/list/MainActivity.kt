package com.example.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.list.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = PlantAdapter()
    private val imageIdList = listOf(
        R.drawable.aloe,
        R.drawable.begonia,
        R.drawable.brovalia,
        R.drawable.campanula,
        R.drawable.heverija
    )

    private var index = 0
    private var plant: Plant? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }


    private fun init(){
        binding.apply {
        rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
        rcView.adapter = adapter
            buttonAdd.setOnClickListener {
                if(index > 4) index = 0
               plant = Plant(imageIdList[index], "plant $index")
                adapter.addPlant(plant!!)
                index++
            }

            buttonClean.setOnClickListener{
                if(plant != null){
                    adapter.clearPlant(plant!!)
                    index = 0
                }

            }
        }

    }

}
