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
import com.example.charitable.database.DatabaseManager
import java.util.*

class Login : Fragment() {

    lateinit var signIn: Button
    lateinit var signUp: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        signIn = view.findViewById(R.id.startButton)
        signUp = view.findViewById(R.id.registerButton)

        DatabaseManager().connect()
        DatabaseManager().c2()


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





        signIn.setOnClickListener {
            val name = userName.text.toString()
            val pass = password.text.toString()
            var savedString: String = usersSharedPreferences.getString("string", "").toString()
            var st = StringTokenizer(savedString, ",")
            var names = mutableListOf<String>()
            while (st.hasMoreTokens()) {
                names.add(st.nextToken())
            }
            names.forEach {
                if (name == it) {
                        parentFragmentManager.beginTransaction().apply {
                            replace(R.id.flFragment, HomeScreen(1))
                            addToBackStack(null)
                            commit()
                        }
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
                        parentFragmentManager.beginTransaction().apply {
                            replace(R.id.flFragment, HomeScreen(0))
                            addToBackStack(null)
                            commit()
                        }

                }
            }

        }
        signUp.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, SignUp())
                addToBackStack(null)
                commit()
            }
        }

    }


}



