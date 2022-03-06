package Java8Functions;

import java.util.HashMap;
import java.util.function.Function;

public enum StatusEnum {

    FUNDING_REJECTED {
        @Override
        public void execute(HashMap<String, Object> map){

            final HashMap<String, Object> fundRejection = statusPipelines.saveStatus
                    .andThen(statusPipelines.callLMS)
                    .andThen(statusPipelines.createCashEvents)
                    .andThen(statusPipelines.sendEmail)
                    .apply(map);
        }
    },
    FUNDING_SUCCESSFUL {
        @Override
        public void execute(HashMap<String, Object> map){


            final Function<HashMap<String, Object>, HashMap<String, Object>> fundSuccess = statusPipelines.saveStatus
                    .andThen(statusPipelines.createCashEvents)
                    .andThen(statusPipelines.sendEmail);

            fundSuccess.apply(map);
        }
    };

    public StatusPipelines statusPipelines = new StatusPipelines();

    abstract void execute(HashMap<String, Object> map);
}
