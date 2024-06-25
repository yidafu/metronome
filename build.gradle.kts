plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.jetbrainsCompose) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
}

repositories {
    maven { setUrl("https://mirrors.cloud.tencent.com/nexus/repository/maven-public/") }
}


allprojects {

    repositories {
        maven { setUrl("https://mirrors.cloud.tencent.com/nexus/repository/maven-public/") }
    }
}