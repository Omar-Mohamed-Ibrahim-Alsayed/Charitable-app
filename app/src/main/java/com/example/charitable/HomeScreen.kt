package com.example.charitable

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class HomeScreen : Fragment() {

    lateinit var donate: View
    lateinit var participate: View
    lateinit var establishment: View
    lateinit var callUs: View

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

        donate.setOnClickListener{
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, Donation())
                addToBackStack(null)
                commit()
            }
        }
        participate.setOnClickListener{
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, Activity())
                addToBackStack(null)
                commit()
            }
        }
        establishment.setOnClickListener{
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, Establishments())
                addToBackStack(null)
                commit()
            }
        }

    }

}