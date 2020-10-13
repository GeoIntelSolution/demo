package com.example.demo.controller;


import com.example.demo.vo.SVNItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.model.IModel;

import javax.websocket.server.PathParam;
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

    @RequestMapping(value = "/test")
    public String sth(Model model){

        List<SVNItem> itemList =new ArrayList<>();
        itemList.add(new SVNItem(1,"zxs","sa","2q3","sa","as"));
        itemList.add(new SVNItem(2,"zxs","sa","2q3","sa","as"));
        itemList.add(new SVNItem(3,"zxs","s1a","2q3","sa","as1"));
        itemList.add(new SVNItem(4,"zxs","s2a","2q3","sa","as"));
        itemList.add(new SVNItem(5,"zxs","s3a","2q3","sa","as"));
        itemList.add(new SVNItem(6,"zxs","s3a","2q3","sa","as"));
        model.addAttribute("Infos",itemList);
        return "index";
    }

    @GetMapping("/updatePart")
    public ModelAndView getMyView(){
        ModelAndView mv =new ModelAndView("/fragments/table.html::tab");
        List<SVNItem> itemList =new ArrayList<>();
        itemList.add(new SVNItem(1,"zxs","gyx","2q3","sa","as"));
        itemList.add(new SVNItem(2,"zxs","gyx","2q3","sa","as"));
        itemList.add(new SVNItem(3,"zxs","s1a","2q3","sa","as1"));
        itemList.add(new SVNItem(4,"zxs","s2a","2q3","sa","as"));
        itemList.add(new SVNItem(5,"zxs","s3a","2q3","sa","as"));
        itemList.add(new SVNItem(7,"zxs","s3a","2q3","sa","as"));
        mv.addObject("Infos",itemList);
        return mv;
    }

    @RequestMapping(value = "/updatePart2",method = RequestMethod.POST)
    public ModelAndView getMyView2(@RequestBody SVNItem svnItem){
        ModelAndView mv =new ModelAndView("/fragments/table.html::tab");
        List<SVNItem> itemList =new ArrayList<>();
        itemList.add(new SVNItem(1,"zxs","gyx","2q3","sa","as"));
        itemList.add(new SVNItem(2,"zxs","gyx","2q3","sa","as"));
        itemList.add(new SVNItem(3,"zxs","s1a","2q3","sa","as1"));
        itemList.add(new SVNItem(4,"zxs","s2a","2q3","sa","as"));
        itemList.add(new SVNItem(5,"zxs","s3a","2q3","sa","as"));
        itemList.add(new SVNItem(7,"zxs","s3a","2q3","sa","as"));
        mv.addObject("Infos",itemList);
        return mv;
    }


    @GetMapping("/test")
    public String str(Model model){
        model.addAttribute("item",new SVNItem(7,"zxs","s3a","2q3","sa","as"));
        return "test";
    }

    @GetMapping("/test2")
    public String str2(Model model){
//        model.addAttribute("item",new SVNItem(7,"zxs","s3a","2q3","sa","as"));
        return "test2";
    }
     static List<SVNItem> itemList =new ArrayList<>();
    static {
        itemList.add(new SVNItem(1, "zxs", "gyx", "2q3", "sa", "as"));
        itemList.add(new SVNItem(2, "zxs", "gyx", "2q3", "sa", "as"));
        itemList.add(new SVNItem(3, "zxs", "s1a", "2q3", "sa", "as1"));
        itemList.add(new SVNItem(4, "zxs", "s2a", "2q3", "sa", "as"));
        itemList.add(new SVNItem(5, "zxs", "s3a", "2q3", "sa", "as"));
        itemList.add(new SVNItem(6, "zxs", "s3a", "2q3", "sa", "as"));
        itemList.add(new SVNItem(7, "zxs", "s3a", "2q3", "sa", "as"));
    }
    @GetMapping("/del")
    public ModelAndView delView(@PathParam("id") int id){
        ModelAndView mv =new ModelAndView("/fragments/table.html::tab");
        for (int i = 0; i < itemList.size(); i++) {
            if(itemList.get(i).getId()==id){
                itemList.remove(i);
            }
        }
        mv.addObject("Infos",itemList);
        return mv;
    }

    @GetMapping("/edit")
    public ModelAndView editView(@PathParam("id") int id){
        ModelAndView mv =new ModelAndView("/fragments/form.html::form");
        SVNItem target=null;
        for (int i = 0; i < itemList.size(); i++) {
            if(itemList.get(i).getId()==id){
                target =itemList.get(i);
            }
        }
        mv.addObject("item",target);
        return mv;
    }
}
