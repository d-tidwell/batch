package lambda;

import activity.requests.GetQuestionRequest;
import activity.results.GetQuestionResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

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
