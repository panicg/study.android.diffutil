package com.panic.studydiffutil

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.panic.studydiffutil.databinding.ItemCarBinding

class CarAdapter(private val carList: ArrayList<Car>) :
    RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        return CarViewHolder(ItemCarBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false)))
//        return CarViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false))
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.bindCar(carList[position])
    }

    override fun getItemCount(): Int = carList.size

    fun updateEmployeeListItems(newCarList: List<Car>) {
        val diffCallback = CarDiffCallback(this.carList, newCarList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.carList.clear()
        this.carList.addAll(newCarList)
        diffResult.dispatchUpdatesTo(this)
    }

    inner class CarViewHolder(private val binding: ItemCarBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {

        }

        fun bindCar(car: Car) {
            binding.car = car
            //binding view update
            binding.executePendingBindings()
        }
    }

//    inner class CarViewHolder(view : View) :
//        RecyclerView.ViewHolder(view) {
//
//        val binding = ItemCarBinding.bind(view)
//        init {
//        }
//
//        fun bindCar(car: Car) {
//            binding.car = car
//            //binding view update
//            binding.executePendingBindings()
//
////
////            binding.run {
////                tvTitle.text = car.name
////                tvContent.text = car.brand
////
////            }
//        }
//    }
}

