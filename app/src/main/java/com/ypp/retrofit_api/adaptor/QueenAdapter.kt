package com.ypp.retrofit_api.adaptor

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.ypp.retrofit_api.R
import com.ypp.retrofit_api.model.QueenItem
import kotlinx.android.synthetic.main.item.view.*

class QueenAdapter(var queenArrayList: ArrayList<QueenItem>) :
    RecyclerView.Adapter<QueenAdapter.PostViewHolder>() {
    inner  class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindPost(queen: QueenItem) {
            Log.d("name",queen.name)
            itemView.txtclass.text = queen.`class`
            itemView.txtid.text = queen.id
            Picasso.get().load(queen.img_url).into(itemView.txtImg)
            itemView.txtname.text = queen.name
            itemView.txtvoteCounnt.text = queen.vote_count.toString()
            itemView.txttime.text = queen.vote_time_status.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("size", queenArrayList.size.toString())
        return queenArrayList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindPost(queenArrayList[position])
    }
}