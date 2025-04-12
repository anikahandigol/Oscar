package furhatos.app.oscar.flow.main

import furhatos.flow.kotlin.*

val Fail : State = state {
    onEntry {
        furhat.say("Fail state reached")
    }
}