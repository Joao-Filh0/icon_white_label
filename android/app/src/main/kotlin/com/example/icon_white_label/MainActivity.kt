package com.example.icon_white_label

import android.content.ComponentName
import android.content.pm.PackageManager
import android.util.Log
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant


class MainActivity : FlutterActivity() {
    private val channelMethod = "changeIcon"

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine)


        MethodChannel(
            flutterEngine.dartExecutor.binaryMessenger,
            channelMethod
        ).setMethodCallHandler { call, result ->
            if (call.method == "changeIcon") {
                val newIcon: String? = call.argument("name")
                Log.d("TAG", "START")

                packageManager.setComponentEnabledSetting(
                    ComponentName("com.example.icon_white_label", "com.example.icon_white_label.MainActivityBahia"),
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP
                )
                packageManager.setComponentEnabledSetting(
                    ComponentName("com.example.icon_white_label", "com.example.icon_white_label.MainActivity"),
                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP
                )
                Log.d("TAG", "END")
            } else {
                result.notImplemented()
            }
        }


    }
}
