package lambda.create;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import activity.requests.create.CreateEventsRequest;
import activity.results.create.CreateEventsResult;
import lambda.LambdaActivityRunner;
import lambda.LambdaRequest;
import lambda.LambdaResponse;

public class CreateEventsLambda
    extends LambdaActivityRunner<CreateEventsRequest, CreateEventsResult>
    implements RequestHandler<LambdaRequest<CreateEventsRequest>, LambdaResponse>
    {
        @Override
        public LambdaResponse handleRequest(LambdaRequest<CreateEventsRequest> input, Context context) {
            return super.runActivity(
                    () -> input.fromBody(CreateEventsRequest.class),
                    (request, serviceComponent) ->
                            serviceComponent.provideCreateEventsActivity().handleRequest(request)
            );
        }
}
