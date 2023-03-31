package lambda.create;

import activity.requests.create.CreateProfileRequest;
import activity.results.create.CreateProfileResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import lambda.LambdaActivityRunner;
import lambda.LambdaRequest;
import lambda.LambdaResponse;

public class CreateProfileLambda
    extends LambdaActivityRunner<CreateProfileRequest, CreateProfileResult>
    implements RequestHandler<LambdaRequest<CreateProfileRequest>, LambdaResponse>{
        @Override
        public LambdaResponse handleRequest(LambdaRequest<CreateProfileRequest> input, Context context) {
            return super.runActivity(
                    () -> input.fromBody(CreateProfileRequest.class),
                    (request, serviceComponent) ->
                            serviceComponent.provideCreateProfileActivity().handleRequest(request)
            );
        }
}
