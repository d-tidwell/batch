package lambda.update;

import activity.requests.update.UpdateProfileRequest;
import activity.results.update.UpdateProfileResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import lambda.LambdaActivityRunner;
import lambda.LambdaRequest;
import lambda.LambdaResponse;

public class AddEventToCalendarLambda
        extends LambdaActivityRunner<AddEventToCalendarRequest, AddEventToCalendarResult>
        implements RequestHandler<LambdaRequest<AddEventToCalendarRequest>, LambdaResponse> {
        @Override
        public LambdaResponse handleRequest(LambdaRequest<AddEventToCalendarRequest> input, Context context) {
            return super.runActivity(
                    () -> input.fromBody(AddEventToCalendarRequest.class),
                    (request, serviceComponent) ->
                            serviceComponent.provideAddEventToCalendarActivity().handleRequest(request)
            );
        }
}
