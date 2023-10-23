package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.AudioManager
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var audioManager: AudioManager
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val audioJackReceiver = AudioJackBroadcastReceiver()
        val filter = IntentFilter(Intent.ACTION_HEADSET_PLUG)
        registerReceiver(audioJackReceiver, filter)


        val switchButton = findViewById<Button>(R.id.switchButton)
        switchButton.setOnClickListener {
//            audioManager.setMode(AudioManager.MODE_IN_COMMUNICATION);
                audioManager.setSpeakerphoneOn(true)
                audioManager.setMode(AudioManager.MODE_IN_COMMUNICATION);
        }
    }



}