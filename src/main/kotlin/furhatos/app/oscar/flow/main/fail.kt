package furhatos.app.oscar.flow.main

import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures

val fail1 = createFrownUtterance("Well, it looks like it's time for my break. You can look for my colleague for help if that's what you would prefer. Goodbye.")
val fail2 = createFrownUtterance("I'm afraid we're in peak advisory hours, which means I'm required to direct all non-emergency queries to our website and the online chatbot. Thank you and goodbye.")
val fail3 = createFrownUtterance("As for your particular inquiry, you'll want our Station Manager! Their office is on the other side of the station but they will be able to help you easily with your request. Thank you and have a nice day.")
val fail4 = createFrownUtterance("I'd love to help more, but we're required to take our 15-minute workstation break as per the mandated schedule. The information kiosk near the cafe on the right has the same database I access, to help you find your platform. Thank you and goodbye.")

val Fail: State = state {
    onEntry {
        furhat.say(
            random(
                fail1,
                fail2,
                fail3,
                fail4
            )
        )
        goto(Idle)

    }
}

fun createFrownUtterance(text: String): Utterance {
    return utterance {
        +Gestures.BrowFrown
        +text
    }
}