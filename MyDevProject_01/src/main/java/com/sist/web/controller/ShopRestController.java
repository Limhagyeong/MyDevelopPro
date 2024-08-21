package com.sist.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.sist.web.commons.Paging;
import com.sist.web.entity.Goodslist;
import com.sist.web.service.ShopServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ShopRestController {

	@Autowired
	private ShopServiceImpl sService;
	@Autowired
	private Paging paging;
	
	@RequestMapping("shop/main")
	public String shop_main(@RequestParam(defaultValue="1") String page, 
							String g_name,
							Model model) 
	{
		int curpage=Integer.parseInt(page);
		int rowsize=20;
		int start=paging.start(rowsize, curpage);
		
		List<Goodslist> glist=sService.goodsList(start, g_name);
		int totalpage=sService.TotalPage(g_name);
		
		final int BLOCK=10;
		int startpage=paging.startpage(BLOCK, curpage);
		int endpage=paging.endpage(BLOCK, curpage, totalpage);

		model.addAttribute("glist",glist);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("startpage",startpage);
		model.addAttribute("endpage",endpage);
		
		model.addAttribute("main_html","shop/main");
		
		return "main";
	}
	

}
