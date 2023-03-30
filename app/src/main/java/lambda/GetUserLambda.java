package lambda;


import activity.requests.GetProfileRequest;
import activity.requests.GetUserRequest;
import activity.results.GetProfileResult;
import activity.results.GetUserResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetUserLambda
        extends LambdaActivityRunner<GetUserRequest, GetUserResult>
        implements RequestHandler<LambdaRequest<GetUserRequest>, LambdaResponse> {
    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetUserRequest> input, Context context) {
        return super.runActivity(
                () -> input.fromPath(path ->
                        GetUserRequest.builder()
                                .withId(path.get("id"))
                                .build()),
                (request, serviceComponent) ->
                        serviceComponent.provideGetUserActivity().handleRequest(request)
        );
    }
}
