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
    implementation("org.seleniumhq.selenium:selenium-java:4.1.2")

    testImplementation(kotlin("test"))
    testImplementation("io.github.bonigarcia:webdrivermanager:5.1.0")
}

tasks.test {
    useTestNG()
}