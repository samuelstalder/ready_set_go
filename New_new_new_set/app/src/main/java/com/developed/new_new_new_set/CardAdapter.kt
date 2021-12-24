package com.developed.new_new_new_set

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView


class CardAdapter(
    private var cardList: List<Card>
    , private val listener: OnItemClickListener
    ): RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    private var selectedItemPosition: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return CardViewHolder(v)
    }

    public fun update(newcardList: List<Card>) {
        cardList = newcardList

    }

    public fun updateDataSet() {
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        var currentItem = cardList[position]
        holder.imageView.setImageResource(currentItem.imageResource)
        if(cardList[position].selected) {
            holder.imageView.setBackgroundColor(Color.GRAY)
        }
        else {
            holder.imageView.setBackgroundColor(Color.WHITE)
        }
    }

    override fun getItemCount() = cardList.size


    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        var imageView: ImageView
        init {
            imageView = itemView.findViewById(R.id.image_view)
            itemView.setOnClickListener(this)
        }
        override fun onClick(v:View?) {
            val position:Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                imageView.setBackgroundColor(Color.GRAY)
                listener.onItemClick(position)
            }
        }

    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }


}