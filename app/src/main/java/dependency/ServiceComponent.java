package dependency;

import activity.GetProfileActivity;
import activity.GetUserActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class, MetricsModule.class})
public interface ServiceComponent {

    GetProfileActivity provideGetProfileActivity();

    GetUserActivity provideGetUserActivity();
}
