package com.payment.dashboard.usercomposeview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity {
    /*: AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //enableEdgeToEdge()
        binding. composeView.apply {
            // setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                // In Compose world
                //  CustomTheme {
               // Text("Hello Compose!")
                //  }

                val list = mutableListOf("")
                for(i in 0 until 100){
                    list.add("Item: $i")
                }
                LazyColumn {
                    items(list){ item->
                        Text(text = item, style = MaterialTheme.typography.titleLarge)
                    }
                }
            }
        }
        //setContentView(binding.root)

        setContentView(binding.root)

    }*/
}