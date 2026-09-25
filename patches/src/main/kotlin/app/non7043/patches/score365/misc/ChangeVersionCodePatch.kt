package app.non7043.patches.score365.misc

import app.non7043.patches.score365.utils.COMPATIBILITY_365SCORE
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patcher.patch.options.PatchOption.StringOption

/**
 * Changes the version code reported by 365Score.
 *
 * ## Why this is useful
 * - Prevents Google Play / the app's server from detecting you are on an older version
 * - Stops the Play Store from auto-updating the patched app over your patched version
 * - Can allow "downgrading" an existing install to an older patched version
 *
 * ## Default
 * The version code is bumped to a very high value (999999) so no future release
 * can automatically override it. You can override this in Morphe Manager options.
 */
val changeVersionCodePatch = bytecodePatch(
    name = "Change version code",
    description = "Changes the version code of 365Score to prevent forced updates and Play Store overwrites.",
) {
    compatibleWith(*COMPATIBILITY_365SCORE)

    // User-configurable option exposed in Morphe Manager
    val versionCode = stringOption(
        key = "versionCode",
        default = "999999",
        title = "Version code",
        description = "The version code to spoof. Default is 999999 (higher than any real release).",
        required = false,
    )

    execute {
        // TODO: Fingerprint and patch the PackageInfo or BuildConfig.VERSION_CODE
        // reference that the app uses for its update/force-update checks.
        //
        // Alternatively, this can be done at the manifest level by Morphe's
        // resource patching if the patcher supports editing AndroidManifest.xml.
    }
}
