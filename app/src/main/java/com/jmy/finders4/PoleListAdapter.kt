package com.jmy.finders4

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.jmy.finders4.databinding.ItemPoleListBinding

class PoleListAdapter: RecyclerView.Adapter<PoleListAdapter.Holder>() {
    var listData = mutableListOf<Pole>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemPoleListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        var pole = listData.get(position)

        holder.binding.textPoleAddress.setOnClickListener {
            val intent = Intent(holder.binding.root.context, MapsActivity::class.java)
            intent.putExtra("poleParcelable", pole)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            ContextCompat.startActivity(holder.binding.root.context, intent, null)
        }
        holder.setPole(pole)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    inner class Holder(val binding: ItemPoleListBinding): RecyclerView.ViewHolder(binding.root){

        fun setPole(pole: Pole){
            binding.imagePole.setImageResource(pole.poleImage)
            binding.textPoleName.text = "${pole.poleName}"
            binding.textPoleAddress.text = "${pole.poleAddress}"
            binding.textPoleIntroduction.text = "${pole.poleIntroduction}"
            binding.textPoleDistance.text = "${pole.poleDistance}"
        }
    }
}

