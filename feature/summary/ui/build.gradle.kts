plugins {
    alias(libs.plugins.quiz.android.feature)
    alias(libs.plugins.quiz.android.library.compose)
}

android {
    namespace = "com.canerture.feature.summary.ui"
}

dependencies {
    implementation(projects.feature.summary.domain)
}