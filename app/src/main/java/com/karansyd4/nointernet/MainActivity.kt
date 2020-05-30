package com.karansyd4.nointernet

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.karansyd4.nointernet.network.NetworkConnectionLiveData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeInternetConnection()
    }

    private fun observeInternetConnection() {
        val connectionLiveData = NetworkConnectionLiveData(this)
        connectionLiveData.observe(this, Observer { isConnected ->
            isConnected?.let {
                internetAvailable(it)
            }
        })
    }

    private fun internetAvailable(connected: Boolean) {
        when (connected) {
            true -> {
                txtInternetStatus.setBackgroundColor(resources.getColor(android.R.color.holo_green_dark))
                txtInternetStatus.text = getString(R.string.network_connected)
                Toast.makeText(this, getString(R.string.network_connected), Toast.LENGTH_SHORT).show()
            }
            false -> {
                txtInternetStatus.setBackgroundColor(resources.getColor(android.R.color.holo_red_dark))
                txtInternetStatus.text = getString(R.string.network_disconnected)
                Toast.makeText(this, getString(R.string.network_disconnected), Toast.LENGTH_SHORT).show()
            }
        }
    }
}