package lambda.get;

import activity.requests.get.GetAnswerRequest;
import activity.results.get.GetAnswerResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import lambda.LambdaActivityRunner;
import lambda.LambdaRequest;
import lambda.LambdaResponse;

public class GetCalendarLambda
        extends LambdaActivityRunner<GetCalendarRequest, GetCalendarResult>
        implements RequestHandler<LambdaRequest<GetCalendarRequest>, LambdaResponse>

    {
        @Override
        public LambdaResponse handleRequest(LambdaRequest<GetCalendarRequest> input, Context context) {
        return super.runActivity(
                () -> input.fromPath(path ->
                        GetCalendarRequest.builder()
                                .withId(path.get("profileId"))
                                .build()),
                (request, serviceComponent) ->
                        serviceComponent.provideGetCalendarActivity().handleRequest(request)
        );
    }
}
