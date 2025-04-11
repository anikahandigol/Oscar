package furhatos.app.oscar

import furhatos.app.oscar.flow.Init
import furhatos.flow.kotlin.Flow
import furhatos.skills.Skill

class OscarSkill : Skill() {
    override fun start() {
        Flow().run(Init)
    }
}

fun main(args: Array<String>) {
    Skill.main(args)
}
