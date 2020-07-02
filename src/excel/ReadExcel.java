package excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;

import java.util.List;

/**
 * @author dinghy
 * @date 2020/6/2 15:16
 */
public class ReadExcel {
    public static void main(String[] args) {
        try {
            EasyExcel.read("demo.xlsx", DemoData.class, new DemoDataListener()).sheet().doRead();
            ExcelReaderBuilder excelReaderBuilder = EasyExcel.read("demo.xlsx");
            ExcelReaderSheetBuilder sheet = excelReaderBuilder.head(DemoData.class).sheet(0);
            List<DemoData> objects = sheet.doReadSync();
            System.out.println("读完了.....................");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
