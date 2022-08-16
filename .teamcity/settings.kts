import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs

version = "2021.1"

project {                   
    params {
        // This makes it impossible to change the build settings through the UI
        param("teamcity.ui.settings.readOnly", "true")
    }

    description = "Maven 3.6 java project forked from anewtodolist"
    buildType(CleanTest) 

    sequential{
        buildType(CleanTest)
    }
}

object CleanTest : BuildType({    
    id("Clean_Test_ID")                       
    name = "Clean_Test_Name"

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
//    triggers {
//        vcs {
//       }
//    }
})

