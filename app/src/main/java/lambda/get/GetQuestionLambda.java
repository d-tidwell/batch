package lambda.get;

import activity.requests.get.GetQuestionRequest;
import activity.results.get.GetQuestionResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import lambda.LambdaActivityRunner;
import lambda.LambdaRequest;
import lambda.LambdaResponse;

public class GetQuestionLambda
        extends LambdaActivityRunner<GetQuestionRequest, GetQuestionResult>
        implements RequestHandler<LambdaRequest<GetQuestionRequest>, LambdaResponse>

    {
        @Override
        public LambdaResponse handleRequest(LambdaRequest<GetQuestionRequest> input, Context context) {
        return super.runActivity(
                () -> input.fromPath(path ->
                        GetQuestionRequest.builder()
                                .withId(path.get("questionId"))
                                .build()),
                (request, serviceComponent) ->
                        serviceComponent.provideGetQuestionActivity().handleRequest(request)
        );
    }
}
