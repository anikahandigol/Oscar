package furhatos.app.oscar.flow.main

import furhat.libraries.standard.GesturesLib
import furhatos.app.oscar.flow.Parent
import furhatos.app.oscar.nlu.AskForPlatform
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures

val FinalSmallTalk : State = state(Parent) {
    onEntry {
        furhat.say(dialogue2)
        furhat.listen()
    }

    onResponse<AskForPlatform> {
        furhat.say(random(response1, response2))
        furhat.say(utterance{
            +Gestures.BigSmile
            +"But in the meantime, I know some cool facts about trains that maybe you'd like........!"})
        goto(TrainFacts)
    }

    onResponse {
        furhat.say(utterance{
            +Gestures.BigSmile
            +"Ahhhh that's great! I hope you enjoy your time there!"
            +GesturesLib.ExpressSmileLaughing1()
            +"Before you start your journey, here are some facts I've learnt over my time as a train guide.......!"})
        goto(TrainFacts)
    }

}