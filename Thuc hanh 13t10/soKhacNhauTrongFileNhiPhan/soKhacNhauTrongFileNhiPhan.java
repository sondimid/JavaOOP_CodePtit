package soKhacNhauTrongFileNhiPhan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class soKhacNhauTrongFileNhiPhan {
    public static void main(String[] args) throws IOException {
        ObjectInputStream file = new ObjectInputStream(new FileInputStream("DATA.IN"));
    }
}
