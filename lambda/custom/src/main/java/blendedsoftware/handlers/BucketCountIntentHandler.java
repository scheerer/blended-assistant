package blendedsoftware.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Directive;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.alexa.presentation.apl.RenderDocumentDirective;
import com.amazon.ask.response.ResponseBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static blendedsoftware.SkillUtils.supportsApl;
import static com.amazon.ask.request.Predicates.intentName;

public class BucketCountIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("BucketCountIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        AmazonS3 s3Client = AmazonS3Client.builder().build();
        List<Bucket> buckets = s3Client.listBuckets();
        int bucketCount = s3Client.listBuckets().size();

        String speechText = "";
        String repromptText = "What else can I help you with?";


        if (bucketCount == 0) {
            speechText = "You do not have any buckets.";
        } else if (bucketCount == 1) {
            speechText = "You have only one bucket.";
        } else {
            speechText = String.format("You have %d buckets.", bucketCount);
        }

        String bucketNames = buckets.stream()
                .map(b -> b.getName())
                .collect(Collectors.joining("\n"));

        ResponseBuilder response = input.getResponseBuilder()
                .withSpeech(speechText + repromptText)
                .withReprompt(repromptText)
                .withSimpleCard("All Buckets", bucketNames);

        if (supportsApl(input)) {
//            Map<String, Object> aplDocument = new HashMap();
//            Map<String, Object> aplDataSources = new HashMap();
//
//            Directive renderDocument = RenderDocumentDirective.builder()
//                    .withDocument(aplDocument)
//                    .withDatasources(aplDataSources)
//                .build();
//            response = response.addDirective(renderDocument);
        }

        return response.build();
    }

}
