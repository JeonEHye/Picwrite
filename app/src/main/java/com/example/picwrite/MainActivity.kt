package com.example.picwrite

import AlbumAdapter
import AlbumViewModel
import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.picwrite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val albumViewModel: AlbumViewModel by viewModels()
    private lateinit var albumAdapter: AlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        // ViewBinding을 사용하지 않으려면 아래 두 줄을 주석 처리하고, 기존 findViewById를 사용할 수 있습니다.
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView: RecyclerView = findViewById(R.id.album_recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 4)

        // 빈 리스트로 초기화한 어댑터를 리사이클러뷰에 설정
        albumAdapter = AlbumAdapter(emptyList())
        recyclerView.adapter = albumAdapter

        // ViewModel의 데이터 변경을 관찰하여 어댑터에 반영
        albumViewModel.items.observe(this, Observer { items ->
            albumAdapter = AlbumAdapter(items)
            recyclerView.adapter = albumAdapter
        })

        // BottomNavigationView 설정
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_calendar, R.id.navigation_album, R.id.navigation_settings
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}

//
//package com.example.picwrite
//
//import AlbumAdapter
//import AlbumViewModel
//import android.os.Bundle
//import androidx.activity.viewModels
//import com.google.android.material.bottomnavigation.BottomNavigationView
//import androidx.appcompat.app.AppCompatActivity
//import androidx.lifecycle.Observer
//import androidx.navigation.findNavController
//import androidx.navigation.ui.AppBarConfiguration
//import androidx.navigation.ui.setupActionBarWithNavController
//import androidx.navigation.ui.setupWithNavController
//import androidx.recyclerview.widget.GridLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.picwrite.databinding.ActivityMainBinding
//
//class MainActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityMainBinding
//    private val albumViewModel: AlbumViewModel by viewModels()
//    private lateinit var albumAdapter: AlbumAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
////        binding = ActivityMainBinding.inflate(layoutInflater)
////        setContentView(binding.root)
//
//        val recyclerView: RecyclerView = findViewById(R.id.album_recyclerView)
//        recyclerView.layoutManager = GridLayoutManager(this, 4)
//
//        AlbumAdapter = AlbumAdapter(emptyList())
//        recyclerView.adapter = AlbumAdapter
//
//        AlbumViewModel.items.observe(this, Observer { items ->
//            AlbumAdapter = AlbumAdapter(items)
//            recyclerView.adapter = AlbumAdapter
//
//            val navView: BottomNavigationView = binding.navView
//
//            val navController = findNavController(R.id.nav_host_fragment_activity_main)
//            // Passing each menu ID as a set of Ids because each
//            // menu should be considered as top level destinations.
//            val appBarConfiguration = AppBarConfiguration(
//                setOf(
//                    R.id.navigation_calendar, R.id.navigation_album, R.id.navigation_settings
//                )
//            )
//            setupActionBarWithNavController(navController, appBarConfiguration)
//            navView.setupWithNavController(navController)
//        })
//    }
//}