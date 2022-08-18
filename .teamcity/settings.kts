import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs

version = "2021.1"

project {                   
    val bts = buildType(Maven("Build","clean compile","-Dmaven.test.failure.ignore=true"))
    bts.buildTypes()		
}

class Maven(Name:String,Goal:String,RunnerArgs:String?=null) : BuildType({ 
    id(Name)                              // use Name for Build_ID
    this.name = Name                      // assign Name to this.name
    vcs {
        root(DslContext.settingsRoot)
    }
    steps {
        maven {
            this.goals = Goal             // assign Goal to this.goals 
            this.runnerArgs = RunnerArgs  // assign RunnerArgs to this.runnerArgs
            mavenVersion = bundled_3_6() 
        }
    }
})
