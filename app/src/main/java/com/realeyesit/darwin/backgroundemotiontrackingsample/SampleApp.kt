package com.realeyesit.darwin.backgroundemotiontrackingsample

import android.app.Application
import com.realeyesit.darwin.Tracking

class SampleApp: Application() {

    override fun onCreate() {
        super.onCreate()

        Tracking.initWith(this) {
            // the project hash received from RealEyes
            projectHash = "drwtst"

            // consent configuration is required, so that the SDK can keep
            // track of the consent that was accepted by the user.
            // If the content of the consent changes, the SDK will
            // trigger a new consent dialog.
            consent {
                // The consent text that should be shown to the user.
                text = "This is the SDK demo app! Do you agree?"

                // The privacy policy url that should be shown to the user.
                privacyPolicyUrl = "https://en.wikipedia.org/wiki/Privacy_policy"
            }

            emotionTracking {
                // enable the emotions that you'd like to track
                trackAttention()
                trackContempt()
                trackEmpathy()
            }
        }

        // start the tracking
        Tracking.start()
    }
}