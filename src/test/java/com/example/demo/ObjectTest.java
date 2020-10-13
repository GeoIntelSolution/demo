package com.example.demo;

import com.example.demo.vo.SVNItem;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

public class ObjectTest {
    @Test
    public void g2son(){
        SVNItem svnItem =new SVNItem(1,"zxs","gyx","2q3","sa","as");
        System.out.println(new Gson().toJson(svnItem));

    }
}
