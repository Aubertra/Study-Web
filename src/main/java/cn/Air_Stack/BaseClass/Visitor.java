package cn.Air_Stack.BaseClass;

public class Visitor {
    private int id;
    private String visitorname;
    private int viewnumber;
    private String viewtype;

    Visitor(){}

    public  Visitor(String visitorname){
        this.visitorname = visitorname;
    }

    public String getVisitorname() {
        return visitorname;
    }

    public void setVisitorname(String visitorname) {
        this.visitorname = visitorname;
    }

    public void setViewnumber(int viewnumber) {
        this.viewnumber = viewnumber;
    }

    public int getViewnumber() {
        return viewnumber;
    }

    public void setViewtype(String viewtype) {
        this.viewtype = viewtype;
    }

    public String getViewtype() {
        return viewtype;
    }
}
