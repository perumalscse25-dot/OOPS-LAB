public class Ex6_WrapperImmutableDemo {
    public static void main(String args[]) {
        // Integer Wrapper
        Integer i = Integer.valueOf(100);
        System.out.println("Before Modification");
        System.out.println("Integer Value : " + i);
        System.out.println("Hash Code     : " + System.identityHashCode(i));

        // Modification
        i = i + 50;
        System.out.println("\nAfter Modification");
        System.out.println("Integer Value : " + i);
        System.out.println("Hash Code     : " + System.identityHashCode(i));

        // Double Wrapper
        Double d = Double.valueOf(25.5);
        System.out.println("\nBefore Modification");
        System.out.println("Double Value  : " + d);
        System.out.println("Hash Code     : " + System.identityHashCode(d));

        // Modification
        d = d * 2;
        System.out.println("\nAfter Modification");
        System.out.println("Double Value  : " + d);
        System.out.println("Hash Code     : " + System.identityHashCode(d));
    }
}
