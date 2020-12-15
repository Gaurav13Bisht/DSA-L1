
abstract class absClassImplem {

    public int cgpaSem1;
    public char gradeSem1;

    public abstract void setCG(int c, char g);

    public abstract String getCG();
}

abstract class absInherited extends absClassImplem {

    public void setCG(int c, char g) {
        cgpaSem1 = c;
        gradeSem1 = g;
    }

    public abstract String getCG();
}

class absInheritedfinal extends absInherited {
    public String getCG() {
        return cgpaSem1 + " " + gradeSem1;
    }
}