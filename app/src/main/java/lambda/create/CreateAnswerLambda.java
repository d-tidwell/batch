package lambda.create;

import activity.requests.create.CreateAnswerRequest;
import activity.requests.create.CreateQuestionRequest;
import activity.results.create.CreateAnswerResult;
import activity.results.create.CreateQuestionResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import lambda.LambdaActivityRunner;
import lambda.LambdaRequest;
import lambda.LambdaResponse;

public class CreateAnswerLambda
    extends LambdaActivityRunner<CreateAnswerRequest, CreateAnswerResult>
    implements RequestHandler<LambdaRequest<CreateAnswerRequest>, LambdaResponse>
    {
        @Override
        public LambdaResponse handleRequest(LambdaRequest<CreateAnswerRequest> input, Context context) {
            return super.runActivity(
                    () -> input.fromBody(CreateAnswerRequest.class),
                    (request, serviceComponent) ->
                            serviceComponent.provideCreateAnswerActivity().handleRequest(request)
            );
        }
}
