public class Client {
    public static void main(String[] args) {
        //case 1
        // P obj =  new P();
        // System.out.println(obj.d);
        // System.out.println(obj.d1);
        // obj.fun();
        // obj.fun1();

        //case 2
  
        P obj = new C();
        System.out.println(obj.d);     // 1
        System.out.println(obj.d1);    // 10
        obj.fun();                     // child ka override wala fun
        obj.fun1();                    // parent ka fun1
        System.out.println(((C)obj).d2); // 20 typecasting
        System.out.println(((C)obj).d1); // 10
        ((C)obj).fun2();               // now works
        
        	// Case 3
//		C obj = new  P();

		// case 4
		C obj = new C();
		System.out.println(obj.d);
		System.out.println(((P) (obj)).d);
		System.out.println(obj.d1);// 10
		System.out.println(obj.d2);/// 20
		obj.fun();
		obj.fun2();
		obj.fun1();

    }
}
