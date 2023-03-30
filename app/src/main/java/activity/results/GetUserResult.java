package activity.results;

import models.UserModel;

public class GetUserResult {
    private final UserModel User;

    private GetUserResult(UserModel User) {
        this.User = User;
    }

    public UserModel getUser() {
        return User;
    }

    @Override
    public String toString() {
        return "GetUserResult{" +
                "User=" + User +
                '}';
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

        public GetUserResult build() {
            return new GetUserResult(User);
        }
    }
}
