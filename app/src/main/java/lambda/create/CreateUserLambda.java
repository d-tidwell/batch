package lambda.create;

import activity.requests.create.CreateUserRequest;
import activity.results.create.CreateUserResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import lambda.LambdaActivityRunner;
import lambda.LambdaRequest;
import lambda.LambdaResponse;

public class CreateUserLambda
    extends LambdaActivityRunner<CreateUserRequest, CreateUserResult>
    implements RequestHandler<LambdaRequest<CreateUserRequest>, LambdaResponse>

    {
        @Override
        public LambdaResponse handleRequest(LambdaRequest<CreateUserRequest> input, Context context) {
            return super.runActivity(
                    () -> input.fromBody(CreateUserRequest.class),
                    (request, serviceComponent) ->
                            serviceComponent.provideCreateUserActivity().handleRequest(request)
            );
        }
}
