package cn.Air_Stack.BaseClass;

public class Goods {
    private int id;
    private String goodsName;
    private int goodsview;

    public Goods(){

    }
    public Goods(String goodsName){
        this.goodsName = goodsName;
        this.goodsview = 0;
    }

    public Goods(String goodsName, int goodsview){
        this.goodsview = goodsview;
        this.goodsName = goodsName;
    }


    public int getGoodsview() {
        return goodsview;
    }

    public void setGoodsview(int goodsview) {
        this.goodsview = goodsview;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
