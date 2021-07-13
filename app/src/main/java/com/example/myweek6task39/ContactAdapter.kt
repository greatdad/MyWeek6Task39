package com.example.myweek6task39

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myweek6task39.databinding.ContactItemBinding

class ContactAdapter(

    val contactItems: List<ContactModel>,
    val clickFnx: (ContactModel) -> Unit
    ) : RecyclerView.Adapter<ContactAdapter.ViewHolder>(){

    inner class  ViewHolder(val binding: ContactItemBinding)
        : RecyclerView.ViewHolder(binding.root){

        fun bind(contactItem : ContactModel){
            binding.contactName.text = contactItem.contactName
            binding.phoneNumber.text = contactItem.phoneNumber
            binding.root.setOnClickListener{
            clickFnx(contactItem)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding: ContactItemBinding =
            ContactItemBinding.inflate(LayoutInflater.from(parent.context))

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int): Unit {
        holder.bind(contactItems.get(position))
    }

    override fun getItemCount() = contactItems.size
}
