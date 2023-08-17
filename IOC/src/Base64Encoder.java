import java.util.Base64;

public class Base64Encoder implements IEncoder{

    public String encode(String text){
        return Base64.getEncoder().encodeToString(text.getBytes());
    }
}
