package manager;

public class Format {
    private String name; // Member Name
    private int lng; // a national language grades
    private int mth; // mathematics grades
    private int sp; // sports grades
    private double avg; // average grades

    public Format(String name, int lng, int mth, int sp){
        super();
        this.name = name;
        this.lng = lng;
        this.mth = mth;
        this.sp = sp;
        avg = (double)(lng+mth+sp)/3;
    }
    public Format(){
        super();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLng() {
        return lng;
    }

    public void setLng(int lng) {
        this.lng = lng;
    }

    public int getMth() {
        return mth;
    }

    public void setMth(int mth) {
        this.mth = mth;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg() {
        this.avg = (double)(lng+mth+sp)/3;
    }

    public void print(){
        System.out.printf("%s : %d\t%d\t%d\t%.2f\n",name,lng,mth,sp,avg);
    }
}
