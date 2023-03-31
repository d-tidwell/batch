package lambda;


import activity.requests.GetEventsRequest;
import activity.requests.GetUserRequest;
import activity.results.GetEventsResult;
import activity.results.GetUserResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetEventsLambda
        extends LambdaActivityRunner<GetEventsRequest, GetEventsResult>
        implements RequestHandler<LambdaRequest<GetEventsRequest>, LambdaResponse> {
    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetEventsRequest> input, Context context) {
        return super.runActivity(
                () -> input.fromPath(path ->
                        GetEventsRequest.builder()
                                .withId(path.get("eventId"))
                                .build()),
                (request, serviceComponent) ->
                        serviceComponent.provideGetEventsActivity().handleRequest(request)
        );
    }
}
