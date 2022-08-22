import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.project

version = "2021.1"

project {
    subProject(MainProject())  // MainProject kts file must be named MainProject.kts
}

class MainProject : Project() {
    init {
        name = "Main"
        id(name.toId())
    }
}
