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
        buildType(Anothertodolist_Build)
    }
}

object Anothertodolist_Build : BuildType({
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
})
