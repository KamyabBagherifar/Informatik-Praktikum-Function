package currying;


public class Operators {

    static int max(int a ,int b){
        return Math.max(a, b);
    }

    static boolean not(boolean a){
        return !a;
    }

    static boolean und(boolean a , boolean b){
        return a || b;
    }

    static boolean oder(boolean a , boolean b){
        return a && b;
    }

    static boolean nor(boolean a , boolean b){
        return not(oder(a,b));

    }

    static boolean nand(boolean a, boolean b){
        return not(und(a,b));
    }



}
