// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("com.google.gms.google-services") version "4.4.2" apply false

}
dependencies {
    implementation("androidx.cardview:cardview:1.0.0") // atau versi terbaru
    // ... dependensi lain ...
}

fun implementation(s: String) {

}
