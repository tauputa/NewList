import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.project
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.maven

version = "2021.1"

project {
    subProject(SubProjectOne)
    buildType(Maven("topProject","clean compile","-Dmaven.test.failure.ignore=true"))
    }

object SubProjectOne : Project({ // singleton object is unique sub project
    name = "SubProjectOne"
    id(name.toId())
    subProject(SubProjectTwo)
    buildType(Maven("SubProjectOne","clean test","-Dmaven.test.failure.ignore=true -Dtest=*.unit.*Test"))
})

object SubProjectTwo : Project({ // singleton object is unique sub project
    name = "SubProjectTwo"
    id(name.toId())
    buildType(Maven("SubProjectTwo","clean test","-Dmaven.test.failure.ignore=true -Dtest=*.integration.*Test"))
})

class Maven(name:String,goals:String,runnerArgs:String?=null): BuildType({
    id(name)            // use the name string variable as the unique build id - we can use another string variable though

    this.name = name    // use the name string variable to populate the name used in this class
    vcs {
        root(DslContext.settingsRoot)
    }
    steps {
        maven {
            this.goals = goals             // use the goals string var from the constructor to populate the goals member
            this.runnerArgs = runnerArgs   // use the runnerArgs from the constructor to populate the runnerArgs member
            mavenVersion = bundled_3_6()
        }
    }
    requirements {
        contains("teamcity.agent.name", "linux")
    }
})
