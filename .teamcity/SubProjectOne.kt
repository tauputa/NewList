import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.project

class SubProjectOne : Project() {   // derived class for SubProjectOne must call base class constructor
    init {
        name = "SubProjectOne"
        id(name.toId())
        subProject(SubProjectTwo()) // instantiate SubProjectTwo class with default constructor
    }
}

