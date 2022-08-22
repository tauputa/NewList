import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.project

version = "2021.1"

project {
    subProject(MainProject)  // MainProject kts file must be named MainProject.kts
}

object MainProject : Project({ // singleton object is unique sub project
    name = "Main"
    id(name.toId())
})
