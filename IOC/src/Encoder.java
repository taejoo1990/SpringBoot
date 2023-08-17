public class Encoder{

    private IEncoder iEncoder ;

    public Encoder(IEncoder iEncoder) {
        this.iEncoder =iEncoder;
    }

    public String encode(String str){
        return iEncoder.encode(str);
    }
}
