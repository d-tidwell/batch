package lambda.update;

import activity.requests.update.UpdateProfileRequest;
import activity.results.update.UpdateProfileResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import lambda.LambdaActivityRunner;
import lambda.LambdaRequest;
import lambda.LambdaResponse;

public class UpdateProfileLambda
        extends LambdaActivityRunner<UpdateProfileRequest, UpdateProfileResult>
        implements RequestHandler<LambdaRequest<UpdateProfileRequest>, LambdaResponse> {
        @Override
        public LambdaResponse handleRequest(LambdaRequest<UpdateProfileRequest> input, Context context) {
            return super.runActivity(
                    () -> input.fromBody(UpdateProfileRequest.class),
                    (request, serviceComponent) ->
                            serviceComponent.provideUpdateProfileActivity().handleRequest(request)
            );
        }
}
