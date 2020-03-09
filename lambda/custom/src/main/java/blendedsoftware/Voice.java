package blendedsoftware;

public enum Voice {
    IVY("Ivy", "en-US"),
    JOANNA("Joanna", "en-US"),
    JOEY("Joey", "en-US"),
    JUSTIN("Justin", "en-US"),
    KENDRA("Kendra", "en-US"),
    KIMBERLY("Kimberly", "en-US"),
    MATTHEW("Matthew", "en-US"),
    SALLI("Salli", "en-US"),

    RUSSELL("Russell", "en-AU")
    ;

    private final String voiceName;
    private final String locale;

    Voice(String voiceName, String locale) {
        this.voiceName = voiceName;
        this.locale = locale;
    }


    public String voiceName() { return voiceName; }
    public String locale() { return locale; }
}

//
//English, American (en-US): Ivy, Joanna, Joey, Justin, Kendra, Kimberly, Matthew, Salli
//English, Australian (en-AU): Nicole, Russell
//English, British (en-GB): Amy, Brian, Emma
//English, Indian (en-IN): Aditi, Raveena
//German (de-DE): Hans, Marlene, Vicki
//Spanish, Castilian (es-ES): Conchita, Enrique
//Hindi (hi-IN): Aditi
//Italian (it-IT): Carla, Giorgio
//Japanese (ja-JP): Mizuki, Takumi
//French (fr-FR): Celine, Lea, Mathieu