package lambda.create;

import lambda.LambdaResponse;

public class CreateEventsLambda {
    extends LambdaActivityRunner<CreateEventsRequest, CreateEventsResult>
        implements RequestHandler<LambdaRequest<CreateEventsRequest>, LambdaResponse> {
        @Override
        public LambdaResponse handleRequest(LambdaRequest<CreateEventsRequest> input, Context context) {
            return super.runActivity(
                    () -> input.fromBody(CreateEventsRequest.class),
                    (request, serviceComponent) ->
                            serviceComponent.provideCreateEventsActivity().handleRequest(request)
            );
        }
}
