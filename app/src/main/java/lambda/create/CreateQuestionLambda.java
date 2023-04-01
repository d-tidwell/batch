package lambda.create;

import activity.requests.create.CreateQuestionRequest;
import activity.results.create.CreateQuestionResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import lambda.LambdaActivityRunner;
import lambda.LambdaRequest;
import lambda.LambdaResponse;

public class CreateQuestionLambda
    extends LambdaActivityRunner<CreateQuestionRequest, CreateQuestionResult>
    implements RequestHandler<LambdaRequest<CreateQuestionRequest>, LambdaResponse>
    {
        @Override
        public LambdaResponse handleRequest(LambdaRequest<CreateQuestionRequest> input, Context context) {
            return super.runActivity(
                    () -> input.fromBody(CreateQuestionRequest.class),
                    (request, serviceComponent) ->
                            serviceComponent.provideCreateQuestionActivity().handleRequest(request)
            );
        }
}
