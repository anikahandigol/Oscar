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
        furhat.say("Glad you found that interesting! I have some helpful Paris tips and stories for you too!")
        goto(Success)
    }

    onResponse<UserNotInterested> {
        furhat.say("Oh, did that not catch your interest? Maybe this will!")
        reentry()
    }
}

val train1 = utterance {
    +"Speaking of Paris..."
    +GesturesLib.ExpressInterest1()
    +"Did you know the Eiffel Tower was supposed to be a temporary installation, intended to stand for 20 years after being built for the 1889 World Fair? It has now been standing proud for 138 years."
    +GesturesLib.ExpressWarmSmile1()
    +"Isn't that interesting?"
}

val train2 = utterance {
    +Gestures.BigSmile
    +"Want you hear something cool?"
    +GesturesLib.PerformBigSmile1
    +"Paris was actually originally a Roman city named 'Lutetia'."
    +GesturesLib.ExpressSmileSide1()
    +"I find that so fascinating! Do you think so too?"
}

val train3 = utterance {
    +GesturesLib.PerformBigSmile1
    +"I really do love the place!"
    +"Can you believe there are at least 3"
    +Gestures.BrowRaise
    +"replicas of the Statue of Liberty in Paris? The most famous of them exists on an Island in the middle of the Seine and looks towards her sister statue in New York."
    +Gestures.BigSmile
    +"Pretty cool, right?"
}

val train4 = utterance {
    +Gestures.BigSmile
    +"Paris is actually know as the city of many things. It's known as the City of Love, the City of lights, the city of cats, the city of bridges, the city of wine, amongst other things."
    +GesturesLib.ExpressSmileLaughing1()
    +"Odd, but interesting right?"
}

val trainList = mutableListOf(train1, train2, train3, train4)