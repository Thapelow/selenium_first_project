plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    dependencies {
//        implementation("org.seleniumhq.selenium:selenium-java:4.8.1")
        // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
        implementation("org.seleniumhq.selenium:selenium-java:4.19.1")

        implementation("io.github.bonigarcia:webdrivermanager:5.8.0")
        implementation("org.slf4j:slf4j-simple:1.7.36")
        implementation("org.junit.jupiter:junit-jupiter:5.9.2")
//        testImplementation("org.seleniumhq.selenium:selenium-chrome-driver:4.8.1")
        // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-chrome-driver
        implementation("org.seleniumhq.selenium:selenium-chrome-driver:4.20.0")

//        testImplementation("org.seleniumhq.selenium:selenium-support:4.8.1")
        // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-support
        implementation("org.seleniumhq.selenium:selenium-support:4.20.0")

        testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.2")

        testImplementation(platform("org.junit:junit-bom:5.10.0"))
        testImplementation("org.junit.jupiter:junit-jupiter")
    }

}

tasks.test {
    useJUnitPlatform()
}
