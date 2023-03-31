package lambda.create;

import lambda.LambdaResponse;

public class CreateUserLambda {
    extends LambdaActivityRunner<CreateUserRequest, CreateUserResult>
        implements RequestHandler<LambdaRequest<CreateUserRequest>, LambdaResponse> {
        @Override
        public LambdaResponse handleRequest(LambdaRequest<CreateUserRequest> input, Context context) {
            return super.runActivity(
                    () -> input.fromBody(CreateUserRequest.class),
                    (request, serviceComponent) ->
                            serviceComponent.provideCreateUserActivity().handleRequest(request)
            );
        }
}
