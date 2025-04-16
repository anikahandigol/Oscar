package furhatos.app.oscar.flow.main

import furhat.libraries.standard.GesturesLib
import furhatos.app.oscar.flow.Parent
import furhatos.app.oscar.nlu.AskForPlatform
import furhatos.app.oscar.nlu.MyTellName
import furhatos.app.oscar.nlu.UserIsFine
import furhatos.app.oscar.nlu.UserIsSad
import furhatos.flow.kotlin.*
import furhatos.gestures.Gesture
import furhatos.gestures.Gestures
import furhatos.nlu.common.Greeting
import furhatos.nlu.common.No
import furhatos.nlu.common.TellName

val Greeting: State = state(Parent) {
    onEntry {
        furhat.say(
            random(
                greeting1,
                greeting2,
                greeting3,
                greeting4
            )
        )
        furhat.listen(5000)
    }

    onResponse<UserIsFine> {
        furhat.say(utterance{
            +Gestures.BigSmile
            +"Oh yay, that's great to hear! I'm Oscar, and what's your beautiful name?" })
        furhat.listen()
    }

    onResponse<UserIsSad> {
        furhat.say(utterance{
            +Gestures.ExpressSad
            +"Aw, sorry to hear that, I hope I can make things a little better for you today. I'm Oscar by the way, what's your name?" })
        furhat.listen()
    }

    onResponse<No> {
        furhat.say(random(
            sad1, sad2, sad3, sad4
        ))
    }

    onResponse<AskForPlatform> {
        furhat.say(
            utterance{
            +random( ask1, ask2, ask3, ask4)
            +GesturesLib.PerformHeadDown()})
        goto(SmallTalk)
    }

    onResponse<MyTellName> {

        furhat.say(
            utterance{

                +GesturesLib.ExpressSmileAstonished()
                +"That's a beautiful name....!"
                +Gestures.Smile
                +"Is there anything I can help you with today?" }
        )
        furhat.listen()
    }

    onResponse<Greeting> {
        reentry()
    }
}

fun createGestureUtterance(text: String, gesture : Gesture, loc: String): Utterance {
    if (loc == "last") {
        return utterance {
            +text
            +gesture
        }
    }
    return utterance {
        +gesture
        +text
    }
}

val greeting1 = createGestureUtterance("Hey! How are you doing today?", Gestures.BigSmile, "first")
val greeting2 = createGestureUtterance("Hi! How's your day been treating you?", Gestures.BigSmile, "first")
val greeting3 = createGestureUtterance("Hello! How is everything going today?", Gestures.BigSmile, "first")
val greeting4 = createGestureUtterance("Hey there! good to see you! How's it going?", Gestures.BigSmile, "first")

val sad1 = createGestureUtterance("Awww.... are you sure?", Gestures.ExpressSad, "first")
val sad2 = createGestureUtterance("Okay, then.",Gestures.ExpressSad, "first")
val sad3 = createGestureUtterance("Ah, how I love my job.", Gestures.ExpressSad, "first")
val sad4 = createGestureUtterance("Alright, I'll just be here, with no one to talk to.", Gestures.ExpressSad, "first")

val ask1 = createGestureUtterance("Absolutely, let me check that for you right away........", Gestures.BigSmile, "first")
val ask2 = createGestureUtterance("I'd be happy to help with that- just one moment.........", Gestures.BigSmile, "first")
val ask3 = createGestureUtterance("Hmmm, good question! Let me verify that quickly.........", GesturesLib.ExpressThinking(), "first")
val ask4 = createGestureUtterance("Sure thing! Let me pull that up for you right away........", Gestures.BigSmile, "first")
