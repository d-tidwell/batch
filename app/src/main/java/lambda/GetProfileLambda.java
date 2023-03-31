package lambda;


import activity.requests.GetProfileRequest;
import activity.results.GetProfileResult;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

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
