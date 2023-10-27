import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author clap of thunder
 * @date 2023-10-26 17:32
 * @description
 */
public class Test {
    public static void main(String[] args) {
        String fileName = "演示著作权-规则";
        String appCode = fileName.substring(0, fileName.indexOf("-"));
        System.out.println(appCode);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formatDateTime = now.format(formatter);
        System.out.println("当前时刻的字符串: " + formatDateTime);
    }
}
