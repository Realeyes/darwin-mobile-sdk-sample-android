package com.realeyesit.darwin.backgroundemotiontrackingsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import com.realeyesit.darwin.Tracking
import com.realeyesit.darwin.consent
import com.realeyesit.darwin.consent.BottomSheetConsent

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openUsageAccessSettings.setOnClickListener {
            // Start usage access settings, where the user can enable access for this app
            startActivityForResult(Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS), 1)
        }

        askCameraPermission.setOnClickListener {
            requestPermissions(arrayOf(android.Manifest.permission.CAMERA), 2)
        }

        Tracking.consent.requests.observe(this, BottomSheetConsent(this))
        trackingConsentMaydisplay.setOnClickListener {
            // Signal the SDK that now would be a good time to show the consent (if needed)
            Tracking.consent.mayDisplay()
        }

        trackingOptout.setOnClickListener {
            Tracking.optOut(listOf("some reason"))
        }
    }
}
