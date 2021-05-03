package com.example.latihanapiget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupListofDataIntoRecyclerView()
    }

    fun setupListofDataIntoRecyclerView() {
        rvItemlist.layoutManager = LinearLayoutManager(this)

        var apiInterface:ApiInterface = ApiClient().getApiClient()!!.create(ApiInterface::class.java)
        apiInterface.getKodePos().enqueue(object : Callback<ArrayList<KodeposModel>> {
            override fun onResponse(call: Call<ArrayList<KodeposModel>>?, response: Response<ArrayList<KodeposModel>>?) {
                var kodeposData =response?.body()!!
                if(kodeposData.size > 0){
                    rvItemlist.visibility = View.VISIBLE
                    rvItemlist.adapter = MyAdapter(this@MainActivity,kodeposData)
                }else{
                    rvItemlist.visibility = View.GONE
                }
                Toast.makeText(baseContext,"Data downloading is success", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<ArrayList<KodeposModel>>?, t: Throwable) {
                Toast.makeText(baseContext,"Data downloading failure", Toast.LENGTH_LONG).show()
            }

        })

    }

    }
