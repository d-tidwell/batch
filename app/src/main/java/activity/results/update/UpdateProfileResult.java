package activity.results.update;


import models.ProfileModel;
public class UpdateProfileResult{
    private final ProfileModel profile;

    private UpdateProfileResult(ProfileModel profile){
        this.profile = profile;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private ProfileModel profile;

        public Builder withProfile(ProfileModel profile) {
            this.profile = profile;
            return this;
        }

        public UpdateProfileResult build() {
            return new UpdateProfileResult(profile);
        }
    }
}