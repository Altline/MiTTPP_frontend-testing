val seleniumVersion = "4.1.2"
val webDriverManagerVersion = "5.1.0"
val log4jVersion = "2.17.1"

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
    implementation("org.seleniumhq.selenium:selenium-java:$seleniumVersion")
    implementation("org.apache.logging.log4j:log4j-api:$log4jVersion")
    implementation("org.apache.logging.log4j:log4j-core:$log4jVersion")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:$log4jVersion")

    testImplementation(kotlin("test"))
    testImplementation("io.github.bonigarcia:webdrivermanager:$webDriverManagerVersion")
}

tasks.test {
    useTestNG {
        suites("src/test/resources/testng.xml")
        useDefaultListeners = true
        outputDirectory = file("$projectDir/TestReports/TestNgReport/")
    }
    reports.html.outputLocation.set(file("$projectDir/TestReports/GradleReport/"))
}