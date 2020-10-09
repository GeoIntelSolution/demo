package com.example.demo.controller;


import com.example.demo.vo.SVNItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.model.IModel;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {
    @RequestMapping(value = "/")
    public String index(Model model){

        List<SVNItem> itemList =new ArrayList<>();
        itemList.add(new SVNItem(1,"asa","sa","2q3","sa","as"));
        itemList.add(new SVNItem(2,"asa","sa","2q3","sa","as"));
        itemList.add(new SVNItem(3,"asa","s1a","2q3","sa","as1"));
        itemList.add(new SVNItem(4,"asa","s2a","2q3","sa","as"));
        itemList.add(new SVNItem(5,"asa","s3a","2q3","sa","as"));
        itemList.add(new SVNItem(6,"asa","s3a","2q3","sa","as"));
        model.addAttribute("Infos",itemList);
        return "index";
    }
}
