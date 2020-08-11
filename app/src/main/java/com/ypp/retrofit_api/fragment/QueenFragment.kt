package com.ypp.retrofit_api.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ypp.retrofit_api.API.QueenClient
import com.ypp.retrofit_api.R
import com.ypp.retrofit_api.adaptor.QueenAdapter
import com.ypp.retrofit_api.model.QueenItem
import kotlinx.android.synthetic.main.fragment_queen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QueenFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_queen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getPosts()
    }

    private fun getPosts() {
        val apiClient= QueenClient()
        val apiCall=apiClient.postApiservice.getPost()
        apiCall.enqueue(object: Callback<ArrayList<QueenItem>> {
            override fun onFailure(call: Call<ArrayList<QueenItem>>, t: Throwable) {
                Log.d("error", t.toString())
            }

            override fun onResponse(
                call: Call<ArrayList<QueenItem>>,
                response: Response<ArrayList<QueenItem>>
            ) {
                Log.d("responose", response.body().toString())
                recyclerview.apply {
                    layoutManager= LinearLayoutManager(context)
                    adapter= QueenAdapter(response.body()!!)
                }

            }

        })
    }

}