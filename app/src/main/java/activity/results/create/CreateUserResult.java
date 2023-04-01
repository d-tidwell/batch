package activity.results.create;

import models.EventsModel;
import models.UserModel;

public class CreateUserResult {
    private final UserModel User;

    private CreateUserResult(UserModel User){
        this.User = User;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private UserModel User;

        public Builder withUser(UserModel User) {
            this.User = User;
            return this;
        }

        public CreateUserResult build() {
            return new CreateUserResult(User);
        }
    }
}
