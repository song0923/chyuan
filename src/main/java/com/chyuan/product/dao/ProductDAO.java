package com.chyuan.product.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.chyuan.product.model.Product;

@DAO
public interface ProductDAO {
	String TABLE_NAME = " product ";
	String FIELDS = " id,title,content,create_time,type,thumbnail ";
	
	/**
	 * 获取一条产品
	 * @param id
	 * @return
	 */
	@SQL(" select " + FIELDS + " from " + TABLE_NAME + " where id = :1 ")
	public Product getProduct(Long id);
	
	/**
	 * 获取产品分页数据
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@SQL(" select " + FIELDS + " from " + TABLE_NAME + " where type = :1 " +
			" #if(:4){and (title like :4 or content like :4)} " +
			" order by create_time desc limit :2 , :3 ")
	public List<Product> getProductList(Integer type, int start, int pageSize, String searchText);
	
	/**
	 * 获取产品总记录数
	 * @return
	 */
	@SQL(" select count(1) from " + TABLE_NAME + " where type = :1 " +
			" #if(:2){and (title like :2 or content like :2)} ")
	public int countGetProductList(Integer type, String searchText);
	
	@SQL(" insert into " + TABLE_NAME + "(" + FIELDS + ")" + " values(:1.id, :1.title, :1.content, now(), :1.type, :1.thumbnail) ")
	public void insertProduct(Product product);
	
	@SQL(" update " + TABLE_NAME + " set title = :1.title, content = :1.content, type = :1.type, thumbnail = :1.thumbnail where id = :1.id ")
	public void updateProduct(Product product);
	
	@SQL(" delete from " + TABLE_NAME + " where id = :1 ")
	public void deleteProduct(Long id);
}
