package lambda.get;

import activity.requests.get.GetAnswerRequest;
import activity.results.get.GetAnswerResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import lambda.LambdaActivityRunner;
import lambda.LambdaRequest;
import lambda.LambdaResponse;

public class GetAnswerLambda
        extends LambdaActivityRunner<GetAnswerRequest, GetAnswerResult>
        implements RequestHandler<LambdaRequest<GetAnswerRequest>, LambdaResponse>

    {
        @Override
        public LambdaResponse handleRequest(LambdaRequest<GetAnswerRequest> input, Context context) {
        return super.runActivity(
                () -> input.fromPath(path ->
                        GetAnswerRequest.builder()
                                .withId(path.get("answerId"))
                                .build()),
                (request, serviceComponent) ->
                        serviceComponent.provideGetAnswerActivity().handleRequest(request)
        );
    }
}
