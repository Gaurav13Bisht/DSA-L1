public class mainclass {

    public static void main(String args[]) {
        /*
         * EnrollNo obj1 = new EnrollNo(); obj1.setnb("Gaurav", "Bisht");
         * 
         * obj1.seten(30);
         * 
         * System.out.println(obj1.getnb()); System.out.print(obj1.geten());
         * 
         * 
         * // ABSTRACT CLASS absClassImplem obj2 = new absInheritedfinal(); // OR
         * absInherited obj2 = new absInheritedfinal(); // OR absInheritedfinal obj2 =
         * new absInheritedfinal(); obj2.setCG(9, 'A');
         * System.out.println(obj2.getCG());
         * 
         * 
         * // Object Cloning EnrollNo obj3 = new EnrollNo(); obj3.setnb("Gaurav",
         * "Bisht"); obj3.seten(30);
         * 
         * // Shallow copy EnrollNo obj4; obj4 = obj3; System.out.println(obj4.getnb());
         * System.out.println(obj4.geten()); // Deep copy : in this we manually copy all
         * the values of one object into the new one
         * 
         * // USING clone() method INCOMPLETE / DOUBT
         * 
         * EnrollNo obj5 = (EnrollNo)obj3.clone(); System.out.println(obj5.getnb());
         * System.out.println(obj5.geten());
         * 
         * // OBJECT PASSING EnrollNo obj6 = new EnrollNo(); obj6.seten(30); EnrollNo
         * obj7 = new EnrollNo(); obj7.objPassed(obj6); System.out.print(obj7.geten());
         * 
         */
        // MEMBER, STATIC AND ANONYMOUS INNER CLASS AND LAMBDA EXPRESSION
        MemberAndStaticInnerClass obj8 = new MemberAndStaticInnerClass();
        // MEMBER INNER CLASS
        MemberAndStaticInnerClass.memberClass obj9 = obj8.new memberClass();
        System.out.println(obj9.gett());
        // STATIC INNER CLASS
        MemberAndStaticInnerClass.staticClass obj10 = new MemberAndStaticInnerClass.staticClass();
        System.out.println(obj10.get());
        // ANONYMOUS INNER CLASS
        MemberAndStaticInnerClass obj11 = new MemberAndStaticInnerClass() {

            public int gettt() {
                return l;
            }

        };
        System.out.println(obj11.gettt());
        // LAMBDA EXPRESSION
        forLambda obj12 = () -> System.out.println("Hello");
        obj12.show();
    }
}
