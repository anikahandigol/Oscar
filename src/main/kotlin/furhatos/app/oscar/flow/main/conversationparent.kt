package furhatos.app.oscar.flow.main

import furhat.libraries.standard.GesturesLib
import furhatos.app.oscar.flow.Parent
import furhatos.app.oscar.nlu.PoliteInterrupt
import furhatos.app.oscar.nlu.RudeInterrupt
import furhatos.flow.kotlin.*

val ConversationParent : State = state(Parent) {

    onResponse<RudeInterrupt>(instant = true, cond = {it.interrupted}) {
        furhat.pauseSpeaking()
        if (rudeList.isEmpty()) {
            goto(Fail)
        }
        val response = rudeList.random()
        rudeList.remove(response)
        furhat.resumeSpeaking(at = UtterancePoint.SEGMENT) { +response }
    }
    onResponse<PoliteInterrupt>(instant = true, cond = {it.interrupted}) {
        polCounter++
        furhat.pauseSpeaking()
        if (polCounter > 2) {
            goto(Fail)
        }
        val index = polSelector.random()
        polSelector.remove(index)
        furhat.resumeSpeaking(at = UtterancePoint.SEGMENT) { +polList[index] }
    }
}

val polInterrupt1 = utterance {
    +GesturesLib.PerformShock1
    +"Ah, right!"
    +GesturesLib.PerformThoughtful2
    +"Your Eurostar train to Paris is leaving at 2 pm, and should be at platformmm........"
    +GesturesLib.PerformTripleBlink
    +"oh, right, I was saying something......! "
}

val polInterrupt2 = utterance {
    +GesturesLib.ExpressSmileApologetic2()
    +"Oh... I apologise, I just love talking about travelling, I even have a travel instagram account! Anyway......"
    +GesturesLib.PerformThoughtful2
    +"Your Eurostar train to Paris is leaving at 2 pm, and should be at platformmm........"
    +GesturesLib.PerformShock1
    +"Oh, I almost forgot to tell you something else....!"
}

var polCounter = 0

val polList = listOf(polInterrupt1, polInterrupt2)

var polSelector = mutableListOf<Int>(0,1)

fun resetPolSelector() {
    polSelector = mutableListOf(0, 1)
}


val rudeInterrupt1 = utterance {
    +GesturesLib.ExpressIrritation2()
    +"Sorry for boring you, some travellers actually like hearing my fun facts......"
    +GesturesLib.ExpressUncertaintyOrDiscomfort()
    +"seems like you don't really appreciate this...."
    +GesturesLib.ExpressGazeAversion1()
    +"Your Eurostar train to Paris is leaving at 2 pm, and should be at platformmm........"
    +GesturesLib.PerformTripleBlink
    +"oh, but before you go...... "
}

val rudeInterrupt2 = utterance {
    +GesturesLib.ExpressAnger1()
    +"I do not really appreciate it when people interrupt me {UserName}"
    +GesturesLib.ExpressRecallDown()
    +"Your Eurostar train to Paris is leaving at 2 pm, and should be at platformmm........"
    +GesturesLib.PerformTripleBlink
    +"oh, right, as I was saying..... "
}

val rudeList = mutableListOf(rudeInterrupt1, rudeInterrupt2)
