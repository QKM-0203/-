import java.util.Arrays;

public enum Enum {

    String{
        @Override
        public void Fun(){
            System.out.println("String1");
        }
    },
    Summer{
        @Override
        public void Fun() {
            System.out.println("Summer1");
        }
    };

    public abstract void Fun();

}
interface EnumDemo{
    public void Fun();
}
class EnumDemo1{
    public static void main(String[] args) {
        Enum[] values = Enum.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(Enum.String);
        }
        String s = "String";
        System.out.println(Enum.valueOf(s));
        Enum a = Enum.String;
        switch(a){
            case String:
                System.out.println("String");
        }
    }

}