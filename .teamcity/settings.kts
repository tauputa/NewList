import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.project

version = "2021.1"

project {
    subProject(SubProjectOne)    // contains subproject
    }

object SubProjectOne : Project({ // singleton object is unique sub project
    name = "SubProjectOne"
    id(name.toId())
    subProject(SubProjectTwo)    // contains subproject
})

object SubProjectTwo : Project({ // singleton object is unique sub project
    name = "SubProjectTwo"
    id(name.toId())
})
