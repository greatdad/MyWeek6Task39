package com.example.myweek6task39

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.myweek6task39.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    private lateinit var myContactAdapter: ContactAdapter
    private lateinit var myContactList: MutableList<ContactModel>
    private lateinit var viewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ContactViewModel::class.java]

        myContactList = mutableListOf()

        myContactAdapter = ContactAdapter(myContactList){
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("Contact", it.contactName)
            startActivity(intent)
        }
            binding.recyclerView.adapter = myContactAdapter

        binding.recyclerView.adapter = myContactAdapter


        val db = Room.databaseBuilder(
            applicationContext,
            ContactDatabase::class.java, "contact-database"
        ).allowMainThreadQueries().build()

        viewModel.getAllContactItems(db).observe(this, {
         myContactAdapter = ContactAdapter(it   )
         binding.recyclerView.adapter=myContactAdapter
         myContactAdapter.notifyDataSetChanged()
        }        )

        binding.button.setOnClickListener {
            val contactName : String = binding.contactNameText.text.toString()
            val phoneNumber : String = binding.phoneText.text.toString()

            val contactItem = ContactModel(contactName, phoneNumber)
            viewModel.addContactItem(contactItem, db)

            myContactAdapter.notifyDataSetChanged()
        }
    }
}
