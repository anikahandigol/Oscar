package furhatos.app.oscar.flow.main

import furhat.libraries.standard.GesturesLib
import furhatos.app.oscar.flow.Parent
import furhatos.app.oscar.nlu.AskForPlatform
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures

//var currentQuestion : Utterance = utterance { +"" }

val SmallTalk : State = state(Parent) {
    onEntry {
        //questionsAsked++
        furhat.say(utterance {
            +GesturesLib.ExpressInterest1()
            +"So............"})
        furhat.say(dialogue1)
        //currentQuestion = dialogue1
        furhat.listen()
    }

    onResponse<AskForPlatform> {
        furhat.say(random(response1, response2))
        furhat.say(utterance{
            +Gestures.BigSmile
            +"But in the meantime, I have so much to say about Paris!"})
        goto(ParisFacts)
    }

    onResponse {

//        if (questionsAsked < 2) {
//            questionsAsked++
//            furhat.say(dialogue3)
//            furhat.say(dialogue2)
//            currentQuestion = dialogue2
//            furhat.listen()
//        }

        furhat.say(utterance{
            +Gestures.BigSmile
            +"Ooh, that's really interesting...! I have so much to say about Paris...!" })
        goto(ParisFacts)
    }

}
//var questionsAsked = 0

val dialogue1 = utterance {
    +GesturesLib.ExpressInterest1()
    +"....... have you been here in Amsterdam for long?"
}
val dialogue3 = utterance {
    +GesturesLib.PerformBigSmile1
    +"Oh, I see, very cool...!"
}
val dialogue2 = utterance {
    +Gestures.BigSmile
    +"....So.....Is this a business trip or a little weekend getaway?"
}

val response1 = utterance {
    +GesturesLib.ExpressThinking()
    +"......Give me a second, the schedule is loading............... "
    +GesturesLib.PerformHeadDown()}
val response2 = utterance {
    +GesturesLib.ExpressThinking()
    +"I see the problem... the platform assignments got moved... let me find the new platform for you................."
    +GesturesLib.PerformHeadDown()}