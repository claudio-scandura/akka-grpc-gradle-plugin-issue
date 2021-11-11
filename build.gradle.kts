import akka.grpc.gradle.AkkaGrpcPluginExtension
import groovy.lang.GroovyObject

gradle.startParameter.showStacktrace = ShowStacktrace.ALWAYS

plugins {
    java
    idea
    id("com.lightbend.akka.grpc.gradle") version "2.1.0" apply false
}


java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    compileOnly("org.scala-lang:scala-library_2.13.4")
}

subprojects {

    repositories {
        mavenCentral()
        mavenLocal()
    }

    apply {
        plugin("java")
        plugin("idea")
    }


        // All -api modules will have the following
        apply {
            plugin("com.lightbend.akka.grpc.gradle")
        }

        dependencies {
            compileOnly("org.scala-lang:scala-library:2.13.4")
        }

        tasks {


        }

        configure<AkkaGrpcPluginExtension> {
            // This is here in case we need to customise code generation
        }
}


tasks {
    wrapper {
        gradleVersion = "7.3"
        distributionType = Wrapper.DistributionType.BIN
    }

}

