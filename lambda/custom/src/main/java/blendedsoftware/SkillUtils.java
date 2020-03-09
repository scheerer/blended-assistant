package blendedsoftware;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.SupportedInterfaces;
import com.amazon.ask.model.User;
import com.amazon.ask.model.interfaces.system.SystemState;
import com.amazonaws.services.lambda.runtime.Context;

import java.util.Locale;
import java.util.ResourceBundle;

public class SkillUtils {

    private SkillUtils() {
    }

    public static AttributesManager getAttributesManager(HandlerInput input) {
        return input.getAttributesManager();
    }

    public static User getUser(HandlerInput input) {
        return getSystemState(input).getUser();
    }

    public static SystemState getSystemState(HandlerInput input) {
        return input.getRequestEnvelope()
                .getContext()
                .getSystem();
    }

    public static boolean supportsApl(HandlerInput input) {
        SupportedInterfaces supportedInterfaces = getSystemState(input)
                .getDevice()
                .getSupportedInterfaces();
        return supportedInterfaces.getAlexaPresentationAPL() != null;
    }

    public static String getMessage(HandlerInput handlerInput, String messageKey) {
        return getResourceBundle(handlerInput, "Messages").getString(messageKey);
    }

    public static ResourceBundle getResourceBundle(HandlerInput handlerInput, String bundleName) {
        final Locale locale = new Locale(handlerInput.getRequestEnvelope().getRequest().getLocale());
        return ResourceBundle.getBundle(bundleName, locale);
    }
}
