public class MyException extends Exception {
    public MyException(String s)
    {
        super(s);
    }
    public static void main(String[] args) {
        System.out.println("MyException.main() entered.");
        try
        {
            throw new MyException("Soumen throws an exception!!");
        }
        catch(MyException e){
            System.out.println("Custom Exception generated!!");
            e.printStackTrace();
        }

        System.out.println("MyException.main() exited.");
    }
}
