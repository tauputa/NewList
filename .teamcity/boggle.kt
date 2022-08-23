import jetbrains.buildServer.configs.kotlin.v2019_2.*

object SubProjectOne : Project({ // singleton object is unique sub project
    name = "Rory"
    id(name.toId())
    subProject(SubProjectTwo)    // contains subproject
})

