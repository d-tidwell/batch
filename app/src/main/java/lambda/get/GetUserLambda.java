package lambda.get;


import activity.requests.get.GetUserRequest;
import activity.results.get.GetUserResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import lambda.LambdaActivityRunner;
import lambda.LambdaRequest;
import lambda.LambdaResponse;

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
