package furhatos.app.oscar.nlu

import furhatos.nlu.Intent
import furhatos.util.Language

class AskForPlatform : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Paris",
            "Eurostar",
            "Amsterdam",
            "train",
            "2 pm",
            "platform",
            "Where do I catch the Eurostar to +Paris at 2pm?",
            "Where’s the platform for the Eurostar to +Paris at 2?",
            "Which platform does the 2pm Eurostar to +Paris leave from?",
            "Where can I board the Eurostar going to +Paris at 2 o’clock?",
            "Where should I go to get the 2pm Eurostar to +Paris?",
            "Where is the platform for the Eurostar going to Paris at 2 pm?",
            "can you help me",
            "can you tell me what",
            "can you tell me where",
            "tell me what",
            "tell me where"
        )
    }
}

class UserIsFine : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "me well",
            "i'm well",
            "been well",
            "I'm fine",
            "I'm okay",
            "I'm doing well",
            "All good",
            "I'm fine",
            "fine",
            "alright",
            "I'm alright",
            "great",
            "okay",
            "I'm great",
            "Everything is fine",
            "I'm good",
            "I feel good",
            "I feel fine",
            "Doing well",
            "Pretty good",
            "Can't complain",
            "Feeling alright",
            "Not bad",
            "good",
            "it's going good",
            "its going great",
            "it's going well",
            "it's going alright",
            "I'm doing amazing",
            "I'm doing good",
            "I'm doing fine",
            "I didn't know",
            "I did not know",
            "Eiffel Tower",
            "more than one",

        )
    }
}

class UserIsSad : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "I'm sad",
            "I'm down",
            "I'm tired",
            "I'm having trouble",
            "I'm hungry",
            "I'm not feeling well",
            "I'm feeling a bit sick",
            "its going bad",
            "not good",
            "im stressed",
            "stressed",
            "tired"
        )
    }
}

class UserIsInterested : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Yeah",
            "Cool",
            "Yes",
            "awesome",
            "fascinating",
            "Absolutely",
            "I'm in",
            "Fascinating",
            "Interesting",
            "Amazing",
            "Lovely",
            "I love that",
            "It is",
            "Yeah",
            "Great",
            "Yep",
            "Nice"
        )
    }
}

class UserNotInterested : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "No",
            "I don't think so",
            "I don't want",
            "I'm not sure",
            "I don't feel like it",
            "I don't think so",
            "Sort of",
            "Not really",
            "Not at all",
            "Nope",
            "Sure",
            "Kinda",
            "Kind of",
            "It is not",
            "I guess",
            "i don't care",
        )
    }
}

class PoliteInterrupt : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Sorry",
            "please",
            "i'm in a rush",
            "i'm in a hurry",
            "could you",
            "thanks",
            "thank you",
            "apologies",
            "i apologise",
            "sorry for interrupting",
            "i hate to interrupt",
            "could you tell me",
            "can you tell me"
        )
    }
}

class RudeInterrupt : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "ugh",
            "bro",
            "can you just tell me",
            "i don't care",
            "oh my god",
            "come on",
            "c'mon",
            "stop",
            "stop talking",
            "whatever",
            "damn",
            "just",
            "just give me",
            "just tell me",
            "shut up",
            "i don't have time for this"
        )
    }
}

class AdviceOneYes : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Yeah I have seen",
            "Pretty cool",
            "beautiful",
            "pretty",
            "definitely",
            "cool",
            "Yes",
            "I saw",
            "I have seen",
            "I went",
            "I got to see",
            "magnificent",
            "truly"
        )
    }
}

class AdviceTwoMaps : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Maps",
            "map",
            "I would miss maps",
            "i would miss the map app"
        )
    }
}

class AdviceTwoMusic : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Music",
            "spotify",
            "apple music",
            "youtube music",
            "songs",
            "lyrics",
            "dance",
            "I would miss music",
            "i would miss the music app"
        )
    }
}

class AdviceTwoPhotos : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Photos",
            "gallery",
            "picture",
            "pictures",
            "I would miss photos",
            "i would miss the photos app"
        )
    }
}

class AdviceThreePlanned : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Planned",
            "it was planned",
            "recommendation",
            "it was recommended to me",
            "i searched for it",
            "i found it"
        )
    }
}

class AdviceThreeSpontaneous : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Spontaneously",
            "not planned",
            "random",
            "randomly",
            "did not expect",
            "didn't expect"
        )
    }
}

class AdviceThreeIDontKnow : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "I dont know",
            "don't know",
            "not sure",
            "have not had"
        )
    }
}

class AdviceFourExploring : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Exploring",
            "explore",
            "Roaming",
            "roam",
            "roam around",
            "going",
            "discover",
            "discovering",
            "new",
            "new places",
            "new people",
            "meet people"
        )
    }
}

class AdviceFourSitting : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "chill",
            "chilling",
            "relax",
            "relaxing",
            "take it slow",
            "slow",
            "slowly",
            "take my time",
            "sit",
            "sitting",
            "tired",
        )
    }
}

class MyTellName(val name: String? = null) : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "My name is",
            "Call me",
            "Name is"
        )
    }
}

class EasterEggTriggers : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Can you tell me more",
            "tell me more",
            "i want to know",
            "I want to know more"
        )
    }
}