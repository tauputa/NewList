import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.project

version = "2021.1"

project {
    subProject(SubProjectOne)    // contains subproject
}

