package com.vilin.springsecurity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProdectController {

    @RequestMapping("/index")
    public String index(){
        return "/index";
    }

    @RequestMapping("/add")
    public String add(){
        return "/product/productAdd";
    }

    @RequestMapping("/update")
    public String update(){
        return "/product/productUpdate";
    }

    @RequestMapping("/list")
    public String list(){
        return "/product/productList";
    }

    @RequestMapping("/delete")
    public String delete(){
        return "/product/productDelete";
    }
}
