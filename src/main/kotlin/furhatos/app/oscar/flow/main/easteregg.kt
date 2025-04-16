package furhatos.app.oscar.flow.main

import furhat.libraries.standard.GesturesLib
import furhatos.flow.kotlin.*

val EasterEgg : State = state {
    onEntry {
        furhat.say(utterance {
            +GesturesLib.PerformShock1
            +"OH.......! That's a great question!"
            +GesturesLib.ExpressHappiness1()
            +"Wow..... usually people aren't really interested when I talk about my love for travelling......."
            +GesturesLib.PerformDoubleNod
            +"But I wouldn't want to take up too much of your time."
            +GesturesLib.PerformThoughtful2
            +"If you want to hear more about travelling, "
            +GesturesLib.ExpressSmileSide1()
            +"I post regular facts and tips about travelling in Europe on my instagram! "
            +GesturesLib.PerformSmile1
            +"Why don't you give me a follow? Its oscarthefurhat!"
        })
        goto(Success)
    }
}