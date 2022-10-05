package com.panic.studydiffutil

import androidx.recyclerview.widget.DiffUtil

class CarDiffCallback(private val mOldEmployeeList: List<Car>, private val mNewEmployeeList: List<Car>) : DiffUtil.Callback() {


    override fun getOldListSize(): Int = mOldEmployeeList.size

    override fun getNewListSize(): Int = mNewEmployeeList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldEmployeeList[oldItemPosition].name == mNewEmployeeList[newItemPosition].name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldEmployeeList[oldItemPosition].brand == mNewEmployeeList[newItemPosition].brand
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}