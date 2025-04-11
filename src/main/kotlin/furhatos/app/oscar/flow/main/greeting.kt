package furhatos.app.oscar.flow.main

import furhat.libraries.standard.GesturesLib
import furhatos.app.oscar.flow.Parent
import furhatos.app.oscar.nlu.AskForPlatform
import furhatos.app.oscar.nlu.UserIsFine
import furhatos.app.oscar.nlu.UserIsSad
import furhatos.flow.kotlin.*
import furhatos.gestures.Gesture
import furhatos.gestures.Gestures
import furhatos.nlu.common.No
import furhatos.nlu.common.TellName
import furhatos.skills.UserManager

// import furhatos.nlu.common.Yes

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
        furhat.listen()
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
    }

    onResponse<No> {
        furhat.say(random(
            sad1, sad2, sad3, sad4
        ))
    }

    onResponse<AskForPlatform> {
        furhat.run {
            say(utterance {
                +"Oh, Paris, wow! Give me a second, I'll look that up for you..."
                +GesturesLib.PerformHeadDown()
            })
        }
        //goto()
    }

    onResponse<TellName> {
        val name = it.intent.name

        furhat.say(
            "What a beautiful name, $name! Is there anything I can help you with today?"
        )
        furhat.listen()
    }

}

fun createGestureUtterance(text: String, gesture : Gesture): Utterance {
    return utterance {
        +gesture
        +text
    }
}

val greeting1 = createGestureUtterance("Hey! How are you today?", Gestures.BigSmile)
val greeting2 = createGestureUtterance("Hi! How are you doing today?", Gestures.BigSmile)
val greeting3 = createGestureUtterance("Hello! How is it going?", Gestures.BigSmile)
val greeting4 = createGestureUtterance("Hey there! How's it going?", Gestures.BigSmile)

val sad1 = createGestureUtterance("Awww.... are you sure?", Gestures.ExpressSad)
val sad2 = createGestureUtterance("Okay, then.",Gestures.ExpressSad)
val sad3 = createGestureUtterance("Ah, how I love my job.", Gestures.ExpressSad)
val sad4 = createGestureUtterance("Alright, I'll just be here, with no one to talk to.", Gestures.ExpressSad)
