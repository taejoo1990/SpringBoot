public class Main {
    public static void main(String[] args) {
        String str = "www.google.com/books/it?page=10&size=20&name=spring-boot";

        //Base64
        Encoder encoder = new Encoder(new Base64Encoder());
        String base64 = encoder.encode(str);
        System.out.println("base64 = " + base64);
        // url encoding
        encoder = new Encoder(new UrlEncoder());
        String url = encoder.encode(str);
        System.out.println("url = " + url);

    }
}