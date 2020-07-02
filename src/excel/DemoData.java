package excel;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * @author dinghy
 * @date 2020/6/2 15:11
 */
public class DemoData {
    @ExcelProperty( "名字")
    private Integer id;
    @ExcelProperty( "序号")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DemoData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
