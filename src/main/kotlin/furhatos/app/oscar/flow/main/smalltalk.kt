package furhatos.app.oscar.flow.main

import furhat.libraries.standard.GesturesLib
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures

val SmallTalk : State = state {
    onEntry {
        furhat.say(dialogue1)
        furhat.listen()
    }

    onResponse {

        if (!smallTalkOver) {
            smallTalkOver = true
            furhat.say(dialogue2)
            furhat.say(dialogue3)
            furhat.listen()
        }

        furhat.say(utterance{
            +Gestures.BigSmile
            +"Ooh, Interesting...! I have so much to say about Paris...!" })
        goto(ParisFacts)
    }

}
var smallTalkOver = false

val dialogue1 = utterance {
    +"......Give me a second, the schedule is loading... So... have you been here in Amsterdam for long?"
    +GesturesLib.ExpressInterest1()
}
val dialogue2 = utterance {
    +GesturesLib.ExpressWarmSmile1()
    +"Oh, I see, very cool...!"
    +GesturesLib.ExpressThinking()
    +"...Also, I see the problem... the platform assignments got moved... let me find the new platform for you..."
}
val dialogue3 = utterance {
    +"......Is this a business trip or a little weekend getaway?"
    +Gestures.BigSmile
}
