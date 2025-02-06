interface IA {
    void setB(IB b);
}

interface IB {
    void setC(IC c);
}

interface IC {
    void setA(IA a);
}

class A implements IA {
    private IB b;
    
    public A() {}

    @Override
    public void setB(IB b) {
        this.b = b;
    }
}

class B implements IB {
    private IC c;
    
    public B() {}

    @Override
    public void setC(IC c) {
        this.c = c;
    }
}

class C implements IC {
    private IA a;
    
    public C() {}

    @Override
    public void setA(IA a) {
        this.a = a;
    }
}


public class Solution {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        
        a.setB(b);
        b.setC(c);
        c.setA(a);
        
        // Now you can use the objects as needed
        // For example:
        // b.useA();
    }
    
}
