package com.example.charitable.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.charitable.R
import java.util.*

class SignUp : Fragment() {

    lateinit var signUp: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        signUp = view.findViewById(R.id.startButton)


        val userName = requireView().findViewById<EditText>(R.id.nameField)
        val password = requireView().findViewById<EditText>(R.id.editTextTextPassword2)

        val usersSharedPreferences =
            requireContext().getSharedPreferences(
                "com.example.charitable.users",
                Context.MODE_PRIVATE
            )
        val adminsSharedPreferences =
            requireContext().getSharedPreferences(
                "com.example.charitable.admin",
                Context.MODE_PRIVATE
            )

        signUp.setOnClickListener {
            val name = userName.text.toString()
            val pass = password.text.toString()
            var available = true
            var savedString: String = usersSharedPreferences.getString("string", "").toString()
            var st = StringTokenizer(savedString, ",")
            var names = mutableListOf<String>()
            while (st.hasMoreTokens()) {
                names.add(st.nextToken())
            }
            names.forEach {
                if (name == it) {
                    Toast.makeText(view.context, "Username Taken", Toast.LENGTH_SHORT).show()
                    available = false
                }
            }

            savedString = adminsSharedPreferences.getString("string", "").toString()
            st = StringTokenizer(savedString, ",")
            names = mutableListOf<String>()
            while (st.hasMoreTokens()) {
                names.add(st.nextToken())
            }
            names.forEach {
                if (name == it) {
                    Toast.makeText(view.context, "Username Taken", Toast.LENGTH_SHORT).show()
                    available = false
                }

            }
            if(available){

                names.add(name)

                val str = StringBuilder()

                names.forEach { str.append(it).append(",") }

                usersSharedPreferences.edit().putString("string",str.toString()).apply()

            }
        }

    }


}

