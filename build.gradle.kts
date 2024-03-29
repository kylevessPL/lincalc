import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm") version "1.7.20"
    id("org.openjfx.javafxplugin") version "0.0.13"
}

group = "pl.piasta"
version = "1.0-SNAPSHOT"

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

repositories {
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

javafx {
    version = "17.0.2"
    modules = listOf("javafx.controls")
}

dependencies {
    implementation("no.tornado:tornadofx:2.0.0-SNAPSHOT")
    implementation("ch.obermuhlner:kotlin-big-math:2.3.0")
    implementation("ch.obermuhlner:big-math:2.3.2")
}

application {
    mainClass.set("pl.piasta.lincalc.LinCalcKt")
    applicationDefaultJvmArgs += "-Dnashorn.args=--no-deprecation-warning"
}
