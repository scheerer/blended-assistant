package blendedsoftware;

public class SpeechUtils {

    private SpeechUtils() {
    }

    public static String withVoice(String text, Voice voice) {
        return String.format("<voice name=\"%s\"><lang xml:lang=\"%s\">%s</lang></voice>",
                voice.voiceName(), voice.locale(), text);
    }
}
