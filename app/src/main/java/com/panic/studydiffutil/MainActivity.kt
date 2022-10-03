package com.panic.studydiffutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.panic.studydiffutil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    val carLists = listOf<Car>(
        Car("ev6", "kia"),
        Car("ev9", "kia"),
        Car("ioniq5", "kia"),
        Car("ioniq6", "hyundai"),
    )

    val carList = ArrayList<Car>()
    var carAdapter : CarAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this
        carAdapter = CarAdapter(carList)
        carList.addAll(carLists)
        binding.rvList.adapter = carAdapter
    }



    fun clickFix(){
        val newCarList = ArrayList<Car>()
        newCarList.addAll(carLists)
        newCarList[2] = Car("ioniq5", "hyundai")
        carAdapter?.updateEmployeeListItems(newCarList)
    }
}

