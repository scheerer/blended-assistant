package blendedsoftware.handlers;

import blendedsoftware.SpeechUtils;
import blendedsoftware.Voice;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static blendedsoftware.SkillUtils.getMessage;
import static com.amazon.ask.request.Predicates.requestType;

/**
 * Default initial Intent handler
 */
public class LaunchRequestHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(requestType(LaunchRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = String.format(getMessage(input, "WELCOME_MESSAGE"));

        String helpExamples = getMessage(input, "HELP_EXAMPLES");
        String repromptText = String.format(getMessage(input, "WELCOME_REPROMPT"), helpExamples);

        return input.getResponseBuilder()
                .withSpeech(SpeechUtils.withVoice(speechText + repromptText, Voice.RUSSELL))
                .withReprompt(repromptText)
                .build();
    }

}
