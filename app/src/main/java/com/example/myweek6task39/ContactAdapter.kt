package com.example.myweek6task39

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myweek6task39.databinding.ContactItemBinding

class ContactAdapter(

    val contactItem: List<ContactModel>
) : RecyclerView.Adapter<ContactAdapter.ViewHolder>(){

    inner class  ViewHolder(val binding: ContactItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(contactItems : ContactModel){
            binding.contactName.text = contactItems.contactName
            binding.phoneNumber.text = contactItems.phoneNumber
            binding.root.setOnClickListener{
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding: ContactItemBinding =
            ContactItemBinding.inflate(LayoutInflater.from(parent.context))

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contactItem.get(position))
    }

    override fun getItemCount() = contactItem.size
}