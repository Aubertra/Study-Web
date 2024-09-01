package cn.Air_Stack.BaseClass;

public class Order {
    private int id;
    private String visitorName;
    private String viewType;
    private String viewtime;

    public Order() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getViewType() {
        return viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    public String getViewtime() {
        return viewtime;
    }

    public void setViewtime(String viewtime) {
        this.viewtime = viewtime;
    }
}
