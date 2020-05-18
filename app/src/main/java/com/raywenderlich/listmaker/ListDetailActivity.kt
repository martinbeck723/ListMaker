package com.raywenderlich.listmaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ListDetailActivity : AppCompatActivity() {
    lateinit var list: TaskList
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_detail)
        // 1
        list = intent.getParcelableExtra(MainActivity.INTENT_LIST_KEY)
// 2
        title = list.name
    }
}
