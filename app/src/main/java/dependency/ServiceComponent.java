package dependency;

import activity.create.CreateAnswerActivity;
import activity.create.CreateEventsActivity;
import activity.create.CreateProfileActivity;
import activity.create.CreateQuestionActivity;
import activity.create.CreateUserActivity;
import activity.get.GetAnswerActivity;
import activity.get.GetEventsActivity;
import activity.get.GetProfileActivity;
import activity.get.GetQuestionActivity;
import activity.get.GetUserActivity;
import activity.update.AddEventToCalendarActivity;
import activity.update.UpdateProfileActivity;
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

    CreateUserActivity provideCreateUserActivity();

    CreateAnswerActivity provideCreateAnswerActivity();

    UpdateProfileActivity provideUpdateProfileActivity();

    AddEventToCalendarActivity provideAddEventToCalendarActivity();

    GetAnswerActivity provideGetAnswerActivity();
}
