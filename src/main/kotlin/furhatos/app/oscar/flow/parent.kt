package furhatos.app.oscar.flow

import furhatos.app.oscar.flow.main.Idle
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures

val Parent: State = state {

    onUserEnter(instant = true) {
        when { // "it" is the user that entered
            furhat.isAttendingUser -> furhat.glance(it) // Glance at new users entering
            !furhat.isAttendingUser -> furhat.attend(it) // Attend user if not attending anyone
        }
    }

    onUserLeave(instant = true) {
        when {
            !users.hasAny() -> { // last user left
                furhat.attendNobody()
                goto(Idle)
            }
            furhat.isAttending(it) -> furhat.attend(users.other) // current user left
            !furhat.isAttending(it) -> furhat.glance(it.head.location) // other user left, just glance
        }
    }

    onNoResponse {
        furhat.say(utterance {
            +Gestures.ExpressSad
            +"Hello, is anybody there? I can't hear you." })
        furhat.listen()
    }

    onResponse {
        furhat.say("Sorry, I didn't understand that.")
        furhat.listen()
    }
}
