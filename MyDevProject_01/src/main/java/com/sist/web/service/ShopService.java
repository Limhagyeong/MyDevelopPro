package com.sist.web.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.entity.Goodslist;

public interface ShopService {
	// 상품 메인
    List<Goodslist> goodsList(int start,String g_name);
    // 페이지
    public int TotalPage(String g_name);

}
