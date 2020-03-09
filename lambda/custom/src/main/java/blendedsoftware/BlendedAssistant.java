package blendedsoftware;

import blendedsoftware.handlers.*;
import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

public class BlendedAssistant extends SkillStreamHandler {

	private static Skill getSkill() {
		return Skills.standard()
				.addRequestHandlers(
						new LaunchRequestHandler(),
						new BucketCountIntentHandler(),
						new CancelAndStopIntentHandler(),
						new HelpIntentHandler(),
						new SessionEndedRequestHandler(),
						new FallbackIntentHandler())
				.build();
	}

	public BlendedAssistant() {
		super(getSkill());
	}

}
