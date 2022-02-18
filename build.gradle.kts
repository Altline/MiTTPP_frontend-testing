plugins {
    kotlin("jvm") version "1.6.10"
}

group = "hr.ferit.dominikzivko"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
}

tasks.test {
    useTestNG()
}