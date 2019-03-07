package com.springmvc.pojo;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PageBean {

    private int pageNow;        //当前页
    private int pageAll;        //总页数:算出来的
    private int sum;            //总数
    private int pageSize;       //每一页的大小
//    private String goodsName;      //搜索的商品名称
    private List<SearchGoods> goodsList;

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageAll() {
        pageAll = sum / pageSize;
        return sum % pageSize == 0 ? pageAll : pageAll + 1;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

//    public String getGoodsName() {
//        return goodsName;
//    }
//
//    public void setGoodsName(String goodsName) {
//        this.goodsName = goodsName;
//    }

    public List<SearchGoods> getGoodsList() {

        return goodsList;
    }

    public void setGoodsList(List<SearchGoods> goodsList) {
        this.goodsList = goodsList;
    }


//    @Override
//    public String toString() {
//        return "PageBean{" +
//                "pageNow=" + pageNow +
//                ", pageAll=" + getPageAll() +
//                ", sum=" + sum +
//                ", pageSize=" + pageSize +
//                ", goodsName='" + goodsName + '\'' +
//                ", goodsList=" + goodsList +
//                '}';
//    }

    @Override
    public String toString() {
        return "PageBean{" +
                "pageNow=" + pageNow +
                ", pageAll=" + getPageAll() +
                ", sum=" + sum +
                ", pageSize=" + pageSize +
                ", goodsList=" + goodsList +
                '}';
    }
}