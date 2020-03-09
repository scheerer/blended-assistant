package blendedsoftware.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.SessionEndedRequest;

import java.util.Optional;

import static blendedsoftware.SkillUtils.getAttributesManager;
import static com.amazon.ask.request.Predicates.requestType;

public class SessionEndedRequestHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(requestType(SessionEndedRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        // any cleanup logic goes here
        AttributesManager attributesManager = getAttributesManager(input);
        if (attributesManager.getSessionAttributes() != null
                && attributesManager.getSessionAttributes().size() > 0) {

        }

        return input.getResponseBuilder().build();
    }

}