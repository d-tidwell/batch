package lambda.get;


import activity.requests.get.GetEventsRequest;
import activity.results.get.GetEventsResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import lambda.LambdaActivityRunner;
import lambda.LambdaRequest;
import lambda.LambdaResponse;

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
