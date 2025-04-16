package furhatos.app.oscar.flow.main

import furhat.libraries.standard.GesturesLib
import furhatos.app.oscar.nlu.UserIsInterested
import furhatos.app.oscar.nlu.UserNotInterested
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures

val TrainFacts : State = state(parent = ConversationParent) {
    onEntry {
        if (trainList.isEmpty()) {
            goto(Fail)
        }
        resetPolSelector()
        val dialogue = getDialogue(trainList)
        furhat.say(interruptable = true) {
            +dialogue
        }
        furhat.listen()
    }

    onResponse<UserIsInterested> {
        furhat.say("Awesome....! I'm happy you think so!")
        goto(Success)
    }

    onResponse<UserNotInterested> {
        furhat.say("Oh, did you not like that? Maybe this is more up your speed!")
        reentry()
    }
}

val train1 = utterance {
    +GesturesLib.PerformSmile1
    +"Ah.......The Eurostar! The services are amazing.........."
    +GesturesLib.PerformThoughtful2
    +"actually in 2023, Thalys and Eurostar combined."
    +GesturesLib.ExpressSmile1()
    +" Convenient right?"
}

val train2 = utterance {
    +Gestures.BigSmile
    +"The Eurostar is so convenient, "
    +GesturesLib.ExpressSmileAstonished()
    +"did you know it can go up to 300km/h! "
    +GesturesLib.ExpressSmile1()
    +".....That's pretty fast huh?"
}

val train3 = utterance {
    +GesturesLib.PerformBigSmile1
    +"Did you know, the Eurostar..........."
    +GesturesLib.PerformThoughtful2
    +"well actually Thalys, at the time........... "
    +GesturesLib.ExpressSmile1()
    +"was actually on of the first trains to implement WiFi. "
    +GesturesLib.ExpressHappiness1()
    +"What an innovation! impressive right? "
}

val train4 = utterance {
    +Gestures.BigSmile
    +"Fun fact about the Eurostar is the train has featured in many films......... "
    +GesturesLib.ExpressSmileAstonished()
    +"including Harry Potter and The Chamber of Secrets........ and Somers Town."
    +GesturesLib.ExpressSmileLaughing1()
    +"Pretty cool right? "
}

val trainList = mutableListOf(train1, train2, train3, train4)