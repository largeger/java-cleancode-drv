class A {
    private B b;
    
    public A(B b) {
        this.b = b;
    }
}

class B {
    private C c;
    
    public B(C c) {
        this.c = c;
    }
}

class C {
    private A a;
    
    public C(A a) {
        this.a = a;
    }
}

public class Problem {
    public static void main(String[] args) {
        A a = new A(new B(new C(new A(null))));
    }
}
