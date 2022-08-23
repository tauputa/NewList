import jetbrains.buildServer.configs.kotlin.v2019_2.*

object SubProjectTwo : Project({ // singleton object is unique sub project
    name = "Sausage"
    id(name.toId())
})
