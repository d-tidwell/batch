package dependency;

import activity.create.CreateProfileActivity;
import activity.get.GetEventsActivity;
import activity.get.GetProfileActivity;
import activity.get.GetQuestionActivity;
import activity.get.GetUserActivity;
import activity.requests.create.CreateProfileRequest;
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
}
