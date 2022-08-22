import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs

version = "2021.1"

project {
    subProject(MainProject())
}

class MainProject() : Project() {
    init {
        name = "Main"
        id(name.toId())

        val bts = sequential {
            buildType(Maven("Build","clean compile","-Dmaven.test.failure.ignore=true"))
            parallel{
                buildType(Maven("Unit","clean test","-Dmaven.test.failure.ignore=true -Dtest=*.unit.*Test"))
                buildType(Maven("Integration","clean test","-Dmaven.test.failure.ignore=true -Dtest=*.integration.*Test"))
            }
            buildType(Maven("Package","clean package","-Dmaven.test.failure.ignore=true -DskipTests"))
        }.buildTypes()

        bts.forEach{          // loop over the slice of maven class instances with forEach loops (forEach loops require it parameters)
            buildType(it)
        }

//    for (i in bts) {    // this for loop also works nicely too
//        buildType(i)
//    }

        bts.last().triggers{  // add vcs trigger for last element in list - ie package
            vcs {
            }
        }
    }
}

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
