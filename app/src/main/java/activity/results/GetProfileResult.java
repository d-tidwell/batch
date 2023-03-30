package activity.results;

import models.ProfileModel;

public class GetProfileResult {
    private final ProfileModel Profile;

    private GetProfileResult(ProfileModel Profile) {
        this.Profile = Profile;
    }

    public ProfileModel getProfile() {
        return Profile;
    }

    @Override
    public String toString() {
        return "GetProfileResult{" +
                "Profile=" + Profile +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ProfileModel Profile;

        public Builder withProfile(ProfileModel Profile) {
            this.Profile = Profile;
            return this;
        }

        public GetProfileResult build() {
            return new GetProfileResult(Profile);
        }
    }
}
