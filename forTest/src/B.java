public class B extends A
{
    public B()
    {
        System.out.println("B");
    }
    public B(int x)
    {
        super(x);
        System.out.println(super.getClass());
    }
    public void Print()
    {
        System.out.println("hello");
    }
};