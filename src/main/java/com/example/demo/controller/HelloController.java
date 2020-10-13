package com.example.demo.controller;

import com.example.demo.MyBean;
import com.example.demo.vo.SVNItem;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {
    @Autowired
    private MyBean bean;
    @RequestMapping(value = "/at",method = RequestMethod.GET)
    public String getSth(){
        System.out.println( bean.getName());
        return  "";
    }

    @RequestMapping(value = "/queryNew",method = RequestMethod.GET)
    public String getView(){
        List<SVNItem> itemList =new ArrayList<>();
        itemList.add(new SVNItem(1,"zxs","sa","2q3","sa","as"));
        itemList.add(new SVNItem(2,"zxs","sa","2q3","sa","as"));
        itemList.add(new SVNItem(3,"zxs","s1a","2q3","sa","as1"));
        itemList.add(new SVNItem(4,"zxs","s2a","2q3","sa","as"));
        itemList.add(new SVNItem(5,"zxs","s3a","2q3","sa","as"));
        itemList.add(new SVNItem(6,"zxs","s3a","2q3","sa","as"));
        return new Gson().toJson(itemList);
    }

//    @RequestMapping(value = "/edit",method = RequestMethod.GET)
//    public String getEditView(@PathParam("id") String id){
//        SVNItem svnItem = new SVNItem(1, "zxs", "sa", "2q3", "sa", "as");
//        return new Gson().toJson(svnItem);
//    }

}
