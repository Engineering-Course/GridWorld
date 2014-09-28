import imagereader.Runner;

public final class ImageRunner {
    private ImageRunner(){}
    public static void main(String[] args){
        MyImageIO image = new MyImageIO();
        MyImageProcessor processing = new MyImageProcessor();
        Runner.run(image, processing);
    }
}
