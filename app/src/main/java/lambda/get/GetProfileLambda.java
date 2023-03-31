package lambda.get;


import activity.requests.get.GetProfileRequest;
import activity.results.get.GetProfileResult;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import lambda.LambdaActivityRunner;
import lambda.LambdaRequest;
import lambda.LambdaResponse;

public class GetProfileLambda
        extends LambdaActivityRunner<GetProfileRequest, GetProfileResult>
        implements RequestHandler<LambdaRequest<GetProfileRequest>, LambdaResponse> {
    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetProfileRequest> input, Context context) {
        return super.runActivity(
                () -> input.fromPath(path ->
                        GetProfileRequest.builder()
                                .withId(path.get("profileId"))
                                .build()),
                (request, serviceComponent) ->
                        serviceComponent.provideGetProfileActivity().handleRequest(request)
        );
    }
}
