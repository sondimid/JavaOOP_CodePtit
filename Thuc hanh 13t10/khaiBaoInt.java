import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class khaiBaoInt {
    public static void main(String[] args) {
        String filePath = "CODE.cpp"; // Đường dẫn tới file mã nguồn
        int totalIntCount = 0;

        String intRegex = "\\bint\\b[^;]*;";
        Pattern pattern = Pattern.compile(intRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Kiểm tra từng dòng xem có khai báo biến int nào không
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    // Tách các biến đã khai báo trong dòng (ví dụ: int a, b, c;)
                    String declaration = matcher.group();
                    totalIntCount += countVariables(declaration);
                }
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }

        int totalBytes = totalIntCount * 4;
        System.out.println(totalBytes);
    }

    private static int countVariables(String declaration) {
        declaration = declaration.replaceFirst("\\bint\\b", "").replace(";", "").trim();
        if (declaration.isEmpty()) return 0;

        // Tách các biến theo dấu phẩy
        String[] variables = declaration.split(",");
        return variables.length;
    }
}
