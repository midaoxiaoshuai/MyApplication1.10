package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class NormalActivity : BaseActivity() {
    private val exoList = ArrayList<Exo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal)

        val recyclerView:RecyclerView = findViewById(R.id.recyclerView )
        initFruits()
        val layoutManager = StaggeredGridLayoutManager(3,
            StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
//        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        val adapter = ExoAdapter(exoList)
        recyclerView.adapter = adapter
    }

    private fun initFruits() {
        repeat(2) {
            exoList.add(Exo("边伯贤", R.drawable.beakhyun ))
            exoList.add(Exo("吴世勋", R.drawable.sehun ))
            exoList.add(Exo("朴灿烈", R.drawable.chanyaol  ))
            exoList.add(Exo("金钟仁", R.drawable.kai  ))
            exoList.add(Exo("都敬秀", R.drawable.doo  ))
            exoList.add(Exo("金钟大", R.drawable.chen  ))
            exoList.add(Exo("金俊勉", R.drawable.suho  ))
            exoList.add(Exo("金珉錫", R.drawable.xiumin  ))
        }
    }
}
