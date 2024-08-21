package com.sist.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.Goodslist;
// Spring Data JPA 제공 인터페이스를 확장하여 사용 -> 나는 쿼리 작성만 하면 됨
@Repository
public interface ShopDAO extends JpaRepository<Goodslist, Integer> {
	// 상품 전체 리스트
	@Query(value="SELECT * FROM goodslist "
			+ "WHERE gno NOT IN(242,243,240) "
			+ "ORDER BY gno DESC "
			+ "LIMIT :start,18", nativeQuery = true)
	public List<Goodslist> goodsListData(@Param("start") int start);
	
	@Query(value="SELECT CEIL(COUNT(*)/18.0) FROM goodslist",nativeQuery = true)
	public int goodsTotalpage();
	
	// 상품 검색 리스트
    @Query(value="SELECT * FROM goodslist "
            + "WHERE gno NOT IN(242,243,240) AND g_name LIKE CONCAT('%',:g_name,'%') "
            + "ORDER BY gno DESC "
            + "LIMIT :start,18", nativeQuery = true)
    public List<Goodslist> goodsFindData(@Param("start") int start, @Param("g_name") String g_name);
    
    @Query(value="SELECT CEIL(COUNT(*)/18.0) FROM goodslist "
            + "WHERE g_name LIKE CONCAT('%',:g_name,'%')", nativeQuery = true)
    public int goodsFindTotalpage(@Param("g_name") String g_name);


}
