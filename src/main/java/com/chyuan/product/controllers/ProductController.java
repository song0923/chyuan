package com.chyuan.product.controllers;

import java.util.List;

import net.paoding.rose.web.InvocationLocal;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

import org.springframework.beans.factory.annotation.Autowired;

import com.chyuan.product.home.ProductHome;
import com.chyuan.product.model.Product;
import com.chyuan.utils.Constants;
import com.chyuan.utils.Page;
import com.chyuan.utils.RePageConstants;
/**
 * 产品展示：前台控制器
 * @author song.zhang@boco.jp
 *
 */
@Path("/product")
public class ProductController {
	@Autowired
	private InvocationLocal inv;
	@Autowired
	private ProductHome productHome;
	
	/**
	 * 前台：查看产品明细
	 * @param id
	 * @return
	 */
	@Get("/detail/{id}")
	public String productDetail(@Param("id")Long id){
		Product product = productHome.getProduct(id);
		inv.addModel("product", product);
		return RePageConstants.PRODUCT_DETAIL;
	}
	
	/**
	 * 前台：产品展示列表
	 * @param type
	 * @return
	 */
	@Get("/list/{type}")
	public String productList(@Param("type")Integer type){
		int pageIndex = inv.getParameter("page") != null ? Integer.parseInt(inv.getParameter("page")) : 1;
		int total = productHome.countGetProductList(type, null);
		int start = (pageIndex - 1) * Constants.PRODUCT_PAGE_SIZE;
		List<Product> productList = productHome.getProductList(type, start, Constants.PRODUCT_PAGE_SIZE, null);
		Page<Product> page = new Page<Product>(total, Constants.PRODUCT_PAGE_SIZE, pageIndex, productList);
		inv.addModel("page", page);
		inv.addModel("productList", productList);
		return RePageConstants.PRODUCT_LIST;
	}
}
