package dependency;

import activity.GetEventsActivity;
import activity.GetProfileActivity;
import activity.GetQuestionActivity;
import activity.GetUserActivity;
import activity.requests.GetQuestionRequest;
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
}
