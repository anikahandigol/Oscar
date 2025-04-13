package furhatos.app.oscar.flow.main

import furhat.libraries.standard.GesturesLib
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures

val Success : State = state {
    onEntry {
        furhat.say(utterance {
            +Gestures.BigSmile
            +"Well, I believe the platform number for the train you are looking for is, platform 24."
            +GesturesLib.ExpressSmileLaughing1()
            +"I had a great time talking to yoU! Bon voyage!"
        })
        goto(Idle)
    }
}