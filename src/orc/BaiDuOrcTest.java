package orc;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * @author dinghy
 * @date 2021/1/4 15:39
 */
public class BaiDuOrcTest {
    //设置APPID/AK/SK
    public static final String APP_ID = "23482496";
    public static final String API_KEY = "Bsrnxt310PC115GpEuwBCSKo";
    public static final String SECRET_KEY = "QLG4pbP2mFiWkrPqwPUzNSPvOP8oG5zQ";
    public static void main(String[] args) throws FileNotFoundException {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
     //   client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量

        // 调用接口
        String path = "E:/software/attach.jpg";
        File file = new File(path);
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "false");
        JSONObject res = client.basicGeneralUrl("https://fs2.yanwentech.com/files/ywwl/-1/auditList/ebe91491dd434c49bdf670845ef00658/1/1345248676948406273.jpg?timestamp=1609748228895&nonce=8074&signature=c330ab772fd8b8f4c4530cad0b47f0b7fc85c3da",options);
        System.out.println(res.toString(2));

    }
}
