package dependency;

import activity.create.CreateEventsActivity;
import activity.create.CreateProfileActivity;
import activity.create.CreateQuestionActivity;
import activity.get.GetEventsActivity;
import activity.get.GetProfileActivity;
import activity.get.GetQuestionActivity;
import activity.get.GetUserActivity;
import activity.requests.create.CreateEventsRequest;
import activity.requests.create.CreateProfileRequest;
import activity.requests.create.CreateQuestionRequest;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class, MetricsModule.class})
public interface ServiceComponent {

    GetProfileActivity provideGetProfileActivity();

    GetUserActivity provideGetUserActivity();

    GetEventsActivity provideGetEventsActivity();

    GetQuestionActivity provideGetQuestionActivity();

    CreateProfileActivity provideCreateProfileActivity();

    CreateEventsActivity provideCreateEventsActivity();

    CreateQuestionActivity provideCreateQuestionActivity();
}
