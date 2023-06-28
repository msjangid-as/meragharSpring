interface inte{
    default int fun(int value){
        System.out.println("Interface print "+ value);
        return value;
    }
        }
class A{
    public int fun(int value) {
        System.out.println("Class A");
        return value;
    }
}

class myExecutor extends A implements inte {
    public static void main(String[]args){
        System.out.println("Main method print");
        myExecutor me=new myExecutor();
        me.fun(3);
    }


    @Override
    public int fun(int value) {
        System.out.println("Class print "+value);
        return value;
    }
}