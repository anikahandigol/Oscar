package furhatos.app.oscar.flow.main

import furhatos.flow.kotlin.*

val Advice : State = state(ConversationParent) {
    onEntry {
        furhat.say("Advice state reached")
    }
}