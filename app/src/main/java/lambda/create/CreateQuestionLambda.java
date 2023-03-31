package lambda.create;

import lambda.LambdaResponse;

public class CreateQuestionLambda {
    extends LambdaActivityRunner<CreateQuestionRequest, CreateQuestionResult>
        implements RequestHandler<LambdaRequest<CreateQuestionRequest>, LambdaResponse> {
        @Override
        public LambdaResponse handleRequest(LambdaRequest<CreateQuestionRequest> input, Context context) {
            return super.runActivity(
                    () -> input.fromBody(CreateQuestionRequest.class),
                    (request, serviceComponent) ->
                            serviceComponent.provideCreateQuestionActivity().handleRequest(request)
            );
        }
}
