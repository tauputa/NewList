import jetbrains.buildServer.configs.kotlin.v2019_2.*

object SubProjectTwo : Project({ // singleton object is unique sub project
    name = "Zara"
    id(name.toId())
})
