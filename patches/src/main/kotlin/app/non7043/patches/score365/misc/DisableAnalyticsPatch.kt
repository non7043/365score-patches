package app.non7043.patches.score365.misc

import app.non7043.patches.score365.utils.COMPATIBILITY_365SCORE
import app.morphe.patcher.Fingerprint
import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch

private object AppsFlyerStartFingerprint : Fingerprint(
    definingClass = "Lcom/appsflyer/AppsFlyerLib;",
    name = "start",
    returnType = "V",
)

private object AppsFlyerLogEventFingerprint : Fingerprint(
    definingClass = "Lcom/appsflyer/AppsFlyerLib;",
    name = "logEvent",
    returnType = "V",
)

private object FirebaseAnalyticsLogEventFingerprint : Fingerprint(
    definingClass = "Lcom/google/firebase/analytics/FirebaseAnalytics;",
    name = "logEvent",
    returnType = "V",
)

/**
 * Removes analytics and tracking SDK initialization and event logging from 365Score
 * (AppsFlyer and Firebase Analytics).
 */
@Suppress("unused")
val disableAnalyticsPatch = bytecodePatch(
    name = "Disable analytics",
    description = "Removes analytics and tracking (AppsFlyer, Firebase Analytics) from 365Score.",
) {
    compatibleWith(*COMPATIBILITY_365SCORE)

    execute {
        val targets = listOf(
            AppsFlyerStartFingerprint,
            AppsFlyerLogEventFingerprint,
            FirebaseAnalyticsLogEventFingerprint,
        )

        for (target in targets) {
            target.method.addInstructions(
                0,
                "return-void",
            )
        }
    }
}
