public class LambdaExpr1 {
    public static void main(String[] args) {


        IHello obj1 = () -> {
            System.out.println("hi this is lambda expression");
        };
        IGreetMe obj2=(a)->{
            return "good morning: "+a;
        };
        ICalculate obj3=(x,y)->{
            return x+y;
        };

        obj1.sayHello();
        System.out.println(obj2.greetMe("amal"));
        System.out.println(obj3.calculateNum(12,11));
    }
}