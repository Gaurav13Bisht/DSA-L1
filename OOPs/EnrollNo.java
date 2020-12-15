
public class EnrollNo extends NameBranch {

    int roll;

    public void seten(int e) {
        roll = e;
    }

    public int geten() {
        return roll;
    }

    public void objPassed(EnrollNo obj) {
        this.roll = obj.roll;
    }

}
