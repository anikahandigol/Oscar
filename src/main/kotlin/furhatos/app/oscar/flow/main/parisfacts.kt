package furhatos.app.oscar.flow.main

import furhat.libraries.standard.GesturesLib
import furhatos.app.oscar.nlu.AskForPlatform
import furhatos.app.oscar.nlu.UserIsInterested
import furhatos.app.oscar.nlu.UserNotInterested
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures

val ParisFacts : State = state(parent = ConversationParent) {
    onEntry {
        if (factList.isEmpty()) {
            goto(Fail)
        }
        resetPolSelector()
        val dialogue = getDialogue(factList)
        furhat.say(interruptable = true) {
            +dialogue
        }
        furhat.listen()
    }

    onPartialResponse<AskForPlatform> {
        furhat.say(utterance {
            +GesturesLib.ExpressConsidering1()
            +"I know you may be in a rush to get to your train,"
            +GesturesLib.ExpressGuilt1()
            +"but unfortunately the schedule is still loading, "
            +GesturesLib.ExpressSmileApologetic2()
            +"so you will have to wait a liiiittle bit longer"
            +"But as I was saying............"})
        raise(it, it.secondaryIntent)
    }

    onResponse<UserIsInterested> {
        furhat.say("I'm glad you found that interesting! I have some helpful Paris tips and stories for you too!")
        goto(Advice)
    }

    onResponse<UserNotInterested> {
        furhat.say( utterance{
            +Gestures.ExpressSad
            +"Did that not catch your interest? "
            +GesturesLib.PerformThoughtful2
            +"Maybe this will!" })
        reentry()
    }

    onResponse<AskForPlatform> {
        furhat.say( {
            +Gestures.Smile
            +"I'll get to that in a minute.... after all, good things comes to those who wait!! As I was saying..........."})
        reentry()
    }
}

val fact1 = utterance {
    +"Speaking of Paris..."
    +GesturesLib.ExpressInterest1()
    +"Did you know the Eiffel Tower was supposed to be a temporary installation, intended to stand for 20 years after being built for the 1889 World Fair? It has now been standing proud for 138 years."
    +GesturesLib.ExpressWarmSmile1()
    +"Isn't that interesting?"
}

val fact2 = utterance {
    +Gestures.BigSmile
    +"Want you hear something cool?"
    +GesturesLib.PerformBigSmile1
    +"Paris was actually originally a Roman city named 'Lutetia'."
    +GesturesLib.ExpressSmileSide1()
    +"I find that so fascinating! Do you think so too?"
}

val fact3 = utterance {
    +GesturesLib.PerformBigSmile1
    +"I really do love the place!"
    +"Can you believe there are at least 3"
    +Gestures.BrowRaise
    +"replicas of the Statue of Liberty in Paris? The most famous of them exists on an Island in the middle of the Seine and looks towards her sister statue in New York."
    +Gestures.BigSmile
    +"Pretty cool, right?"
}

val fact4 = utterance {
    +Gestures.BigSmile
    +"Paris is actually know as the city of many things. It's known as the City of Love, the City of lights, the city of cats, the city of bridges, the city of wine, amongst other things."
    +GesturesLib.ExpressSmileLaughing1()
    +"Odd, but interesting right?"
}

val factList = mutableListOf(fact1, fact2, fact3, fact4)

fun getDialogue(list: MutableList<Utterance>) : Utterance {

    if (list.size == 0) {
        return utterance { +"" }
    }
    println("before saying: "+ list.size)
    val dialogue = list.random()
    list.remove(dialogue)

    println("after: "+ list.size)
    return dialogue;
}