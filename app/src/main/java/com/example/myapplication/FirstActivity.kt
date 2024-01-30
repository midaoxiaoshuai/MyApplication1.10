package com.example.myapplication

import android.app.AlertDialog
import android.app.appsearch.AppSearchResult.RESULT_OK
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

class FirstActivity : BaseActivity() {
    private val tag = "FirstActivity"
    lateinit var downloadBinder: MyService.DownloadBinder
    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service:
        IBinder
        ) {
            downloadBinder = service as MyService.DownloadBinder
            downloadBinder.startDownload()
            downloadBinder.getProgress()
        }
        override fun onServiceDisconnected(name: ComponentName) {
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag, "onCreate")
        setContentView(R.layout.first_layout)
//        supportActionBar?.hide()
        if (savedInstanceState != null) {
            val tempData = savedInstanceState.getString("data_key")
            Log.d(tag, "tempData is $tempData")
        }
        val button: Button = findViewById(R.id.button1)
        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent, 1)
        }
        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)
        }
        val startNormalActivity: Button = findViewById(R.id.startNormalActivity)
        startNormalActivity.setOnClickListener {
            val intent = Intent(this, NormalActivity::class.java)
            startActivity(intent)
        }
        val startDialogActivity: Button = findViewById(R.id.startDialogActivity)
        startDialogActivity.setOnClickListener {
            val intent = Intent(this, DialogActivity::class.java)
            startActivity(intent)
        }
        val startAlertDialog: Button = findViewById(R.id.startAlertDialog)
        startAlertDialog .setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("This is Dialog")
                setMessage("Something important.")
                setCancelable(false)
                setPositiveButton("OK") { dialog, which ->
                }
                setNegativeButton("Cancel") { dialog, which ->
                }
                show()
            }
        }
        val startServiceBtn:Button = findViewById(R.id.startServiceBtn)
        startServiceBtn.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            startService(intent) // 启动Service
        }
        val stopServiceBtn:Button = findViewById(R.id.stopServiceBtn )
        stopServiceBtn.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            stopService(intent) // 停止Service
        }
//        val bindServiceBtn:Button = findViewById(R.id.bindServiceBtn )
//        bindServiceBtn.setOnClickListener {
//            val intent = Intent(this, MyService::class.java)
//            bindService(intent, connection, Context.BIND_AUTO_CREATE)
// 绑定Service
//        }
//        val unbindServiceBtn:Button = findViewById(R.id.unbindServiceBtn)
//        unbindServiceBtn.setOnClickListener {
//            unbindService(connection) // 解绑Service
//        }
        val button3:Button = findViewById(R.id.button )
        button3.setOnClickListener {
            val intent =
                Intent("com.example.broadcasttest.MY_BROADCAST")
            intent.setPackage(packageName)
            sendOrderedBroadcast(intent, null)
        }
        val forceOffline:Button = findViewById(R.id.forceOffline )
        forceOffline.setOnClickListener {
            val intent =
                Intent("com.example.broadcastbestpractice.FORCE_OFFLINE")
            sendBroadcast(intent)
        }
    }


//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.main, menu)
//        return true
//    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> Toast.makeText(this, "You clicked Add",
                Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "You clicked Remove",
                Toast.LENGTH_SHORT).show()
        }
        return true
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data:
    Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {
                val returnedData = data?.getStringExtra("data_return")
                Log.d("FirstActivity", "returned data is $returnedData")
            }
        }
    }
//    override fun onStart() {
//        super.onStart()
//        Log.d(tag, "onStart")
//    }
//    override fun onResume() {
//        super.onResume()
//        Log.d(tag, "onResume")
//    }
//    override fun onPause() {
//        super.onPause()
//        Log.d(tag, "onPause")
//    }
//    override fun onStop() {
//        super.onStop()
//        Log.d(tag, "onStop")
//    }
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d(tag, "onDestroy")
//    }
//    override fun onRestart() {
//        super.onRestart()
//        Log.d(tag, "onRestart")
//    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val tempData = "Something you just typed"
        outState.putString("data_key", tempData)
    }
}