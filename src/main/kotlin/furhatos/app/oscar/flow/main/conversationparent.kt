package furhatos.app.oscar.flow.main

import furhatos.app.oscar.nlu.PoliteInterrupt
import furhatos.app.oscar.nlu.RudeInterrupt
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.onResponse
import furhatos.flow.kotlin.state

val ConversationParent : State = state {
    onResponse<RudeInterrupt> {}
    onResponse<PoliteInterrupt> {}
}