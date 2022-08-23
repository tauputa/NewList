import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.project

version = "2021.1"

class SubProjectTwo : Project() {   // derived class for SubProjectTwo must call base class constructor
    init {
        name = "SubProjectTwo"
        id(name.toId())
    }
}