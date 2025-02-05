interface IA {
    void doSomething();
}

class A implements IA {
    @Override
    public void doSomething() {
        System.out.println("A is doing something");
    }
}

class B {
    private IA a;

    public B(IA a) {
        this.a = a;
    }
    
    public void useA() {
        a.doSomething();
    }
}

class C {
    private IA a;

    public C(IA a) {
        this.a = a;
    }
    
    public void useA() {
        a.doSomething();
    }
}


public class Solution {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);
        C c = new C(a);
        
        b.useA();
        c.useA();
    }
    
}
