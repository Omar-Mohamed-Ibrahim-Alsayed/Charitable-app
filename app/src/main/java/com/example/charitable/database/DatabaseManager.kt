package com.example.charitable.database


import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import java.sql.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class DatabaseManager {


    fun connect(): String? {


        try {

            val c = DriverManager.getConnection(
                "jdbc:mysql://MYSQL_SERVER_ADDRESS:3306/users?serverTimezone=UTC",
                "Omar",
                "omar123"
            )
            val s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
            val r = s.executeQuery("SELECT * FROM `users` WHERE 1")

            r.next()
            return ("done")


        } catch (e: SQLException) {
            e.printStackTrace()
            //to return
            return "error2"
        }

        return "error1"
    }

    fun c2() {
        val handler = Handler(Looper.getMainLooper())

        val executor: ExecutorService = Executors.newSingleThreadExecutor()
        executor.execute() {
            try {

                val c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/charitable?serverTimezone=UTC",
                    "Omar",
                    "omar123"
                )
                val s =
                    c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                val r = s.executeQuery("SELECT `u_id`, `f_id` FROM `role`")

                r.next()
                Log.d("ay 7aga", "${r.getString("u_id")}")


            } catch (e: SQLException) {
                e.printStackTrace()
                Log.d("ay 7aga", "failed")

            }



            handler.post {

            }
        }
    }


}