// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.0-alpha04" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.google.relay") version "0.3.05"
    id ("com.google.dagger.hilt.android") version "2.46.1" apply false
    id ("org.jetbrains.kotlin.jvm") version "1.8.0" apply false




}


buildscript {
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.46.1")

    }
}