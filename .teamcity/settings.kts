import jetbrains.buildServer.configs.kotlin.v2019_2.*

version = "2021.1"

project {
    subProject(MainProject())
}

class MainProject() : Project() {
    init {
        name = "Main"
        id(name.toId())
    }
}
