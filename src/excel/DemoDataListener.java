package excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

/**
 * @author dinghy
 * @date 2020/6/2 15:12
 */
public class DemoDataListener extends AnalysisEventListener<DemoData> {
    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {
        System.out.println(demoData.toString());
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("读完了...............");
    }

    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
        super.onException(exception, context);
    }
}
