package quarz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author dinghy
 * @date 2020/8/13 11:42
 */
public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.err.println("Hello!  HelloJob is executing.");
        System.out.println(jobExecutionContext.getTrigger().getKey().getName());
    }
}
