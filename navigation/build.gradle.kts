plugins {
    alias(libs.plugins.quiz.android.library)
    alias(libs.plugins.quiz.android.library.compose)
    alias(libs.plugins.kotlinx.serialization.plugin)
}

android {
    namespace = "com.canerture.quiz.navigation"

}

dependencies {
    implementation(libs.navigation.compose)
    implementation(libs.kotlinx.serialization)

    implementation(projects.feature.splash.ui)
    implementation(projects.feature.welcome.ui)
    implementation(projects.feature.login.ui)
    implementation(projects.feature.register.ui)
    implementation(projects.feature.home.ui)
}