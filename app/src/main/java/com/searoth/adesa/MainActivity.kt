package com.searoth.adesa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.searoth.adesa.databinding.ActivityMainBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mainActivityViewModel: MainActivityViewModel by lazy {
        ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
    }

    private val groupAdapter = GroupAdapter<ViewHolder>()
    lateinit var layoutBinding: ActivityMainBinding
    private lateinit var groupLayoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        layoutBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            activityViewModel = mainActivityViewModel
        }

        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
        setupAdapter()
    }

    fun setupAdapter(){
        groupAdapter.apply {
            spanCount = 12
        }
        groupLayoutManager = GridLayoutManager(this, groupAdapter.spanCount).apply {
            spanSizeLookup = groupAdapter.spanSizeLookup
        }
        rv_main.apply {
            layoutManager = groupLayoutManager
            adapter = groupAdapter
        }
        groupAdapter.add(mainActivityViewModel.mainSection)
    }
}
