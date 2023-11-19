package classes;

public class Main {
    public static void main(String[] args) {
        RecordContato rc = new RecordContato("Maria","duda.cv2404@gmail");
        System.out.println(rc.nome());
        System.out.println(rc.email());
    }
}