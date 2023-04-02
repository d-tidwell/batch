package activity.requests.create;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = CreateUserRequest.Builder.class)
public class CreateUserRequest {
    private boolean newUser;
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String phoneNumber;

    public CreateUserRequest(boolean newUser, String id, String firstName, String lastName, String username, String phoneNumber) {
        this.newUser = newUser;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.phoneNumber = phoneNumber;
    }

    public boolean getNewUser(){
        return newUser;
    }
    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {
        private boolean newUser;
        private String id;
        private String firstName;
        private String lastName;
        private String username;
        private String phoneNumber;

        public Builder withNewUser(boolean newUser){
            this.newUser = newUser;
            return this;
        }
        public Builder withId(String id){
            this.id = id;
            return this;
        }
        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public CreateUserRequest build() {
            return new CreateUserRequest(id, firstName, lastName, username, phoneNumber);
        }

    }
}
