package com.example.fragmentwithtablayout.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentwithtablayout.R
import com.example.fragmentwithtablayout.adapter.RecyclerViewAdapter
import com.example.fragmentwithtablayout.model.News

class Home2Fragment : Fragment() {
    private lateinit var adapter: RecyclerViewAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var newsArrayList: ArrayList<News>


    private lateinit var imageId: Array<Int>
    private lateinit var headingId: Array<String>
    private lateinit var news: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager =layoutManager
        recyclerView.setHasFixedSize(true)

        adapter = RecyclerViewAdapter(newsArrayList)
        recyclerView.adapter = adapter
    }

    private fun dataInitialize(){
        newsArrayList = arrayListOf<News>()

        imageId = arrayOf(
            R.drawable.j,
            R.drawable.i,
            R.drawable.h,
            R.drawable.g,
            R.drawable.f,
            R.drawable.e,
            R.drawable.d,
            R.drawable.c,
            R.drawable.b,
            R.drawable.a
        )

        headingId = arrayOf(
            getString(R.string.head_10),
            getString(R.string.head_9),
            getString(R.string.head_8),
            getString(R.string.head_7),
            getString(R.string.head_6),
            getString(R.string.head_5),
            getString(R.string.head_4),
            getString(R.string.head_3),
            getString(R.string.head_2),
            getString(R.string.head_1)
        )

        news = arrayOf(
            getString(R.string.news_j),
            getString(R.string.news_i),
            getString(R.string.news_h),
            getString(R.string.news_g),
            getString(R.string.news_f),
            getString(R.string.news_e),
            getString(R.string.news_d),
            getString(R.string.news_c),
            getString(R.string.news_b),
            getString(R.string.news_a)
        )

        for (i in imageId.indices){
            val news = News(imageId[i], headingId[i])
            newsArrayList.add(news)
        }
    }
}