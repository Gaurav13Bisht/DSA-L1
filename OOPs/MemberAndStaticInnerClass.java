
public class MemberAndStaticInnerClass {

    public int i = 6;
    public int l = 8;

    public int gettt() {
        return l;
    }

    class memberClass {
        public int j = 8;

        public int gett() {
            return j;
        }
    }

    static class staticClass {
        public int k = 8;

        public int get() {
            return k;
        }
    }
}

interface forLambda {
    public void show();

}
