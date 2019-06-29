public class Calc {
    public Calc(){
        try {
            // Runtime.getRuntime().exec("calc");
            java.lang.Runtime.getRuntime().exec("open /Applications/Calculator.app");
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] argv){
        Calc e = new Calc();
    }
}