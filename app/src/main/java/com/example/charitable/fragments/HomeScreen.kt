package com.example.charitable.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.charitable.R

class HomeScreen(acc:Int) : Fragment() {

    var currentUser = acc

    lateinit var donate: ImageView
    lateinit var participate: ImageView
    lateinit var establishment: ImageView
    lateinit var callUs: ImageView
    lateinit var donateT: TextView
    lateinit var participateT: TextView
    lateinit var establishmentT: TextView
    lateinit var callUsT: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        donate = view.findViewById<ImageView>(R.id.donateBtn)
        participate = view.findViewById<ImageView>(R.id.partBtn)
        establishment = view.findViewById<ImageView>(R.id.estBtn)
        callUs = view.findViewById<ImageView>(R.id.callBtn)
        donateT = view.findViewById(R.id.textView2)
        participateT = view.findViewById(R.id.textView3)
        establishmentT = view.findViewById(R.id.textView4)
        callUsT = view.findViewById(R.id.textView5)

        if (currentUser == 0)
            initAdmin()
        else
            initDoner()

    }

    fun initAdmin() {

        donate.setImageResource(R.drawable.ic_baseline_edit_slider_24)
        participate.setImageResource(R.drawable.ic_baseline_low_priority_24)
        establishment.setImageResource(R.drawable.ic_baseline_post_add_24)
        callUs.setImageResource(R.drawable.ic_baseline_receipt_long_24)
        donateT.setText("Edit Slider")
        participateT.setText("Needs")
        establishmentT.setText("Add Activity")
        callUsT.setText("Donations List")

        donate.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, Slider())
                addToBackStack(null)
                commit()
            }
        }
        participate.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, Needs())
                addToBackStack(null)
                commit()
            }
        }
        establishment.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, Addition())
                addToBackStack(null)
                commit()
            }
        }
        callUs.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, Receipt())
                addToBackStack(null)
                commit()
            }
        }
    }

    fun initDoner() {
        donate.setImageResource(R.drawable.ic_baseline_attach_money_24)
        participate.setImageResource(R.drawable.ic_baseline_query_builder_24)
        establishment.setImageResource(R.drawable.ic_baseline_house_24)
        callUs.setImageResource(R.drawable.ic_baseline_local_phone_24)

        donate.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, Donation())
                addToBackStack(null)
                commit()
            }
        }
        participate.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, Activity())
                addToBackStack(null)
                commit()
            }
        }
        establishment.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, Establishments())
                addToBackStack(null)
                commit()
            }
        }
    }
}
