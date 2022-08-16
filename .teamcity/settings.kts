
package _Self.buildTypes                                  
import jetbrains.buildServer.configs.kotlin.v2019_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs

version = "2021.1"

project {                   
    description = "Maven 3.6 java project forked from anewtodolist"
    buildType(Sausage_Meat) 
}

object Sausage_Meat : BuildType({    
    id("Build")                       
    name = "Build"

    vcs {
        root(DslContext.settingsRoot) 
    }

    steps {
        maven {                 
            goals = "clean test" 
            runnerArgs = "-Dmaven.test.failure.ignore=true" 
            mavenVersion = bundled_3_6() 
        }
    }

    triggers {
        vcs { 
        }
    }
    requirements {
        contains("teamcity.agent.name", "linux") 
    }
})

