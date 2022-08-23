import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.project

object SubProjectOne : Project({ // singleton object is unique sub project
    name = "SubProjectOne"
    id(name.toId())
    subProject(SubProjectTwo)
    buildType(Maven("SubProjectOne","clean test","-Dmaven.test.failure.ignore=true -Dtest=*.unit.*Test"))
})
