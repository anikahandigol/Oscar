package furhatos.app.oscar.flow.main

import furhat.libraries.standard.GesturesLib
import furhatos.app.oscar.nlu.*
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures
import furhatos.nlu.common.No

val Advice : State = state(ConversationParent) {
    onEntry {
        if (adviceMap.isNotEmpty()) {
            val chosenDialogueKey = adviceMap.keys.random()
            val goToState = adviceMap[chosenDialogueKey]
            adviceMap.remove(chosenDialogueKey)
            goto(goToState!!)
        }
        goto(Fail)
    }
}

val advice1 = utterance {
    +GesturesLib.ExpressSmile1()
    +".........One tip ........you've got to see the Eiffel Tower at night."
    +GesturesLib.PerformThoughtful2
    +"It lights up, then sparkles every hour for five minutes......"
    +GesturesLib.ExpressSmileLaughing1()
    +"Pure magic!"
    +"I went at sunset, and the view was stunning. But the real surprise?"
    +GesturesLib.PerformThoughtful2
    +"Those sparkles....."
    +GesturesLib.ExpressSmileAstonished()
    +"felt like a moment in a movie! Don't you think that's just marvelous?"
}

val advice2 = utterance {
    +GesturesLib.PerformEyeBrows1
    +".........That reminds me, always keep your phone in front of you in Paris."
    +GesturesLib.ExpressGazeAversion2()
    +"I didn't, and while I was foraging through my backpack,"
    +GesturesLib.PerformShock1
    +"someone swipes my phone out of my back pocket! By the time i realised what had happened,"
    +Gestures.ExpressSad
    +"it was long gone..... a local just said"
    +GesturesLib.ExpressSmileSide1()
    +"'first time?'"
    +GesturesLib.ExpressSmileLaughing1()
    +"Now I wear my bag kangaroo. Good tip, right?"
}

val advice3 = utterance {
    +GesturesLib.ExpressSmile1()
    +"By the way, when you're in Paris, remember that Paris doesn’t do dinner without reservations."
    +GesturesLib.PerformSad1
    +"I learnt that the hard way. At 8 pm, starving, I ended up with a 30 euro hotel sandwich and Mcdonald's by the Seine......."
    +"So yeah......... book ahead,"
    +Gestures.Smile()
    +"especially on the weekends! Smart tip right?"
}

val advice4 = utterance {
    +GesturesLib.PerformBigSmile1
    +" I'll share a tip with you that you won’t find online, Parisian cafés can turn you into a philosopher."
    +"I ordered one espresso and three hours later,"
    +GesturesLib.ExpressSmileSide1()
    +"I’d written half a novel,"
    +GesturesLib.ExpressConsidering1()
    +"overheard a breakup,"
    +Gestures.Smile()
    +"and perfected people-watching. "
    +GesturesLib.PerformEyeBrows1
    +"For €3, you don’t just get coffee, you get a window into Parisian life. "
    +"Fun fact, don't you think?"
}

val adviceOneQuestions = mutableMapOf<Int, String>(
    1 to "Have you ever seen a view that took your breath away? What made it so special?",
//    2 to "If you could choose someone with whom you would watch the Eiffel Tower sparkle, who would you choose?",
//    3 to "What time of day do you love most when visiting a city........ sunrise, sunset or night?"
)

val adviceTwoQuestions = mutableMapOf<Int,String>(
    1 to "If your phone got stolen in a foreign country, what would you miss most...... maps, music, or photos?",
//    2 to "What’s your go-to strategy for keeping your things safe in a new city?",
//    3 to "Have you ever been caught off guard while traveling?"
)

val adviceThreeQuestions = mutableMapOf<Int,String>(
    1 to "What’s the most memorable meal you’ve had while traveling—and was it planned or spontaneous?",
//    2 to "How do you usually find great places to eat in a new city—recommendations, wandering, or apps?",
//    3 to "Would you rather splurge on a fancy dinner or discover a hidden street food gem?"
)

val adviceFourQuestions = mutableMapOf<Int,String>(
    1 to "What’s your perfect way to spend an afternoon in a foreign city—busy exploring or sitting still and soaking it in?",
//    2 to "If you could eavesdrop on any kind of conversation in a café, what would it be about?",
//    3 to "Have you ever had a moment where you felt like you belonged somewhere unexpected?"
)

val AdviceOneQuestion : State = state(parent = ConversationParent) {
    onEntry {
        val randomQuestionKey = adviceOneQuestions.keys.random()
        println("length of advice questions: $adviceOneQuestions.size")
        if (adviceOneQuestions.isNotEmpty()) {
            furhat.say(interruptable = true) {+adviceOneQuestions[randomQuestionKey]!!}
            furhat.listen()
        }
    }
    onResponse<No> {
        furhat.say( utterance {
            +Gestures.ExpressSad
            +"Aww, that's a shame. "
            +Gestures.Smile
            +"I hope you get to experience it this time!"})
        goto(AdviceOne)
    }

    onResponse<AdviceOneYes> {
        furhat.say(utterance {
            +Gestures.Smile
            +"Wow, that sounds amazing! Definitely sticks with you!"
        })
        goto(AdviceOne)
    }

    onResponse<AskForPlatform> {
        furhat.say() {+Gestures.Smile
        +"I'll get to that in a minute.... after all, good things comes to those who wait!!"}
        goto(AdviceOne)
    }
}

val AdviceOne : State = state(parent = ConversationParent) {
    onEntry {
        furhat.ask(interruptable = true) {
            +advice1
        }
        furhat.listen()
    }

    onResponse<UserIsInterested> {
        furhat.say("Yay!! I'm glad you found that helpful! I hope it makes your trip more enjoyable")
        goto(FinalSmallTalk)
    }

    onResponse<UserNotInterested> {
        furhat.say("Aw, did you not find that helpful? perhaps this could be of use to you instead...")
        goto(Advice)
    }

    onResponse<AskForPlatform> {
        furhat.say() {+Gestures.Smile
            +"I'll get to that in a minute.... after all, good things comes to those who wait!!"}
        goto(Advice)
    }
}

val AdviceTwoQuestion : State = state(parent = ConversationParent) {
    onEntry {
        val randomQuestionKey = adviceTwoQuestions.keys.random()
        if (adviceTwoQuestions.isNotEmpty()) {
            furhat.ask(interruptable = true){ adviceTwoQuestions[randomQuestionKey]!! }
            furhat.listen()
        }
        println("length of advice questions: $adviceTwoQuestions.size")
    }
    onResponse<AdviceTwoMaps> {
        furhat.say( utterance {
            +GesturesLib.PerformDoubleNod()
            +"I can totally relate, wouldn't want to get lost in a foreign country..."})
        goto(AdviceTwo)
    }

    onResponse<AdviceTwoMusic> {
        furhat.say(utterance {
            +GesturesLib.PerformDoubleNod()
            +"That's definitely true, the trip back home would be a boring one without any music to jam to!" })
        goto(AdviceTwo)
    }

    onResponse<AdviceTwoPhotos> {
        furhat.say(utterance {
            +GesturesLib.PerformDoubleNod()
            +"Ah yes, if that happens, hope you are on the cloud!" })
        goto(AdviceTwo)
    }

    onResponse<AskForPlatform> {
        furhat.say() {+Gestures.Smile
            +"I'll get to that in a minute.... after all, good things comes to those who wait!!"}
        goto(AdviceTwo)
    }
}

val AdviceTwo : State = state(parent = ConversationParent) {
    onEntry {
        furhat.say(interruptable = true){+advice2}
        furhat.listen()
    }

    onResponse<UserIsInterested> {
        furhat.say("Yay!! I'm glad you found that helpful! I hope it makes your trip more enjoyable")
        goto(FinalSmallTalk)
    }

    onResponse<UserNotInterested> {
        furhat.say("Aw, did you not find that helpful? perhaps this could be of use to you instead...")
        goto(Advice)
    }

    onResponse<AskForPlatform> {
        furhat.say() {+Gestures.Smile
            +"I'll get to that in a minute.... after all, good things comes to those who wait!!"}
        goto(Advice)
    }
}

val AdviceThreeQuestion : State = state(parent = ConversationParent) {
    onEntry {
        val randomQuestionKey = adviceThreeQuestions.keys.random()
        println("length of advice questions: $adviceThreeQuestions.size")

        if (adviceThreeQuestions.isNotEmpty()) {
            furhat.say(interruptable = true){+adviceThreeQuestions[randomQuestionKey]!!}
            furhat.listen()
        }
    }
    onResponse<AdviceThreePlanned> {
        furhat.say( utterance {
            +Gestures.BigSmile
            +"Ahh, you're definitely a person who knows what they want!"})
        goto(AdviceThree)
    }

    onResponse<AdviceThreeSpontaneous> {
        furhat.say(utterance {
            +Gestures.Smile
            +"That's sounds amazing, going with flow and the scent of good food!"
            +GesturesLib.PerformDoubleNod()
            +"It's a risky game to play though......."
        })
        goto(AdviceThree)
    }

    onResponse<AdviceThreeIDontKnow>{
        furhat.say(utterance {
            +Gestures.ExpressSad
            +"Ahhh, that's okay, I'm sure you'll find lots of memorable meals in Paris!"})
        goto(AdviceThree)

    }

    onResponse<AskForPlatform> {
        furhat.say() {+Gestures.Smile
            +"I'll get to that in a minute.... after all, good things comes to those who wait!!"}
        goto(AdviceThree)
    }
}

val AdviceThree : State = state(parent = ConversationParent) {
    onEntry {
        furhat.say(interruptable = true){+advice3}
        furhat.listen()
    }

    onResponse<UserIsInterested> {
        furhat.say("Yay!! I'm glad you found that helpful! I hope it makes your trip more enjoyable")
        goto(FinalSmallTalk)
    }

    onResponse<UserNotInterested> {
        furhat.say("Aw, did you not find that helpful? perhaps this could be of use to you instead...")
        goto(Advice)
    }

    onResponse<AskForPlatform> {
        furhat.say() {+Gestures.Smile
            +"I'll get to that in a minute.... after all, good things comes to those who wait!!"}
        goto(Advice)
    }
}

val AdviceFourQuestion : State = state(parent = ConversationParent) {
    onEntry {
        val randomQuestionKey = adviceFourQuestions.keys.random()
        println("length of advice questions: $adviceFourQuestions.size")

        if (adviceFourQuestions.isNotEmpty()) {
            furhat.say(interruptable = true){+adviceFourQuestions[randomQuestionKey]!!}
            furhat.listen()
        }
    }
    onResponse<AdviceFourExploring> {
        furhat.say( utterance {
            +GesturesLib.PerformDoubleNod()
            +"Oh that's great! I love exploring too, it's the best way to gain new experiences...... "
            +GesturesLib.ExpressSmileLaughing1()
            +"shenanigans too"})
        goto(AdviceFour)
    }

    onResponse<AdviceFourSitting> {
        furhat.say(utterance {
            +Gestures.Smile
            +"That sounds nice! It's always great to slow down and unwind, and soak in the day in a new place"
        })
        goto(AdviceFour)
    }

    onResponse<AskForPlatform> {
        furhat.say() {+Gestures.Smile
            +"I'll get to that in a minute.... after all, good things comes to those who wait!!"}
        goto(AdviceFour)
    }
}

val AdviceFour : State = state(parent = ConversationParent) {
    onEntry {
        furhat.say(interruptable = true){+advice4}
        furhat.listen()
    }

    onResponse<UserIsInterested> {
        furhat.say("Yay!! I'm glad you found that helpful! I hope it makes your trip more enjoyable")
        goto(FinalSmallTalk)
    }

    onResponse<UserNotInterested> {
        furhat.say("Aw, did you not find that helpful? perhaps this could be of use to you instead...")
        goto(Advice)
    }

    onResponse<AskForPlatform> {
        furhat.say() {+Gestures.Smile
            +"I'll get to that in a minute.... after all, good things comes to those who wait!!"}
        goto(Advice)
    }
}

val adviceMap = mutableMapOf<Int, State>(
    1 to AdviceOneQuestion,
    //2 to AdviceTwoQuestion,
    3 to AdviceThreeQuestion,
    4 to AdviceFourQuestion
)


