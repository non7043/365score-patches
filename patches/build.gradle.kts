// IMPORTANT: Replace non7043 with your actual GitHub username
group = "non7043"

plugins {
    alias(libs.plugins.morphe.patcher)
    alias(libs.plugins.kotlin.jvm)
}

patches {
    about {
        name = "365Score Patches"
        description = "Morphe patches for the 365Score sports app"
        // IMPORTANT: Update this to your actual GitHub repo SSH URL
        source = "git@github.com:non7043/365score-patches.git"
        author = "non7043"
        contact = "na"
        // IMPORTANT: Update this to your actual GitHub repo URL
        website = "https://github.com/non7043/365score-patches"
        license = "GNU General Public License v3.0"
    }
}

dependencies {
    compileOnly(libs.arsclib)
    implementation(libs.gson)
    implementation(libs.morphe.patches.library)
}
