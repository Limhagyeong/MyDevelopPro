package com.sist.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.sist.web.commons.Paging;
import com.sist.web.dao.ShopDAO;
import com.sist.web.entity.Goodslist;

@Service
public class ShopServiceImpl implements ShopService{

	@Autowired
	private ShopDAO sdao;
	@Autowired
	private Paging paging;

	@Override
	public List<Goodslist> goodsList(int start,String g_name) {
		 if (g_name==null) {
	            return sdao.goodsListData(start);
	        } 
		 else {
	            return sdao.goodsFindData(start, g_name);
	        }
	}
	
	 public int TotalPage(String g_name) {
	        if (g_name==null) {
	            return sdao.goodsTotalpage();
	        } 
	        else {
	            return sdao.goodsFindTotalpage(g_name);
	        }
	    }


}
