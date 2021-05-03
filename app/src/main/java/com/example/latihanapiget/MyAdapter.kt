package com.example.latihanapiget

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_item.view.*

class MyAdapter (val context: Context, var dataList : ArrayList<KodeposModel>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val llMain = view.llMain
        val tvKecamatan = view.tvKecamatan
        val tvKelurahan = view.tvKelurahan
        val tvKodepos = view.tvKodepos
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
       return  MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_item,parent,false))
    }

    override fun getItemCount(): Int {
        return dataList!!.size
    }
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val item = dataList?.get(position)

        holder.tvKecamatan.text = item?.kecamatan.toString()
        holder.tvKelurahan.text = item?.kelurahan.toString()
        holder.tvKodepos.text = item?.kodepos.toString()


        if(position % 2 == 0){
            holder.llMain.setBackgroundColor(ContextCompat.getColor(context,R.color.soft_pink))
        }else{
            holder.llMain.setBackgroundColor(ContextCompat.getColor(context,R.color.white))
        }

    }


}