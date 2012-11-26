package com.chyuan.product.controllers;

import java.util.List;

import net.paoding.rose.web.InvocationLocal;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

import org.springframework.beans.factory.annotation.Autowired;

import com.chyuan.interceptor.LoginRequired;
import com.chyuan.product.home.ProductHome;
import com.chyuan.product.model.Product;
import com.chyuan.utils.Constants;
import com.chyuan.utils.Page;
import com.chyuan.utils.RePageConstants;
/**
 * 产品展示：后台控制器
 * @author song.zhang@boco.jp
 *
 */
@LoginRequired
@Path("/admin/product")
public class ProductAdminController {
	@Autowired
	private InvocationLocal inv;
	@Autowired
	private ProductHome productHome;
	
	/**
	 * 后台：产品展示列表
	 * @param type 语言类型
	 * @return
	 */
	@Get("/list/{type}")
	public String productListBank(@Param("type")Integer type) {
		int pageIndex = inv.getParameter("page") != null ? Integer.parseInt(inv.getParameter("page")) : 1;
		int total = productHome.countGetProductList(type, null);
		int start = (pageIndex - 1) * Constants.PAGE_SIZE;
		List<Product> productList = productHome.getProductList(type, start, Constants.PAGE_SIZE, null);
		Page<Product> page = new Page<Product>(total, Constants.PAGE_SIZE, pageIndex, productList);
		inv.addModel("page", page);
		inv.addModel("productList", productList);
		inv.addModel("type", type);
		return RePageConstants.A_PRODUCT_LIST;
	}
	
	/**
	 * 后台：跳转产品页面（添加）
	 * @param type
	 * @return
	 */
	@Get("/add/{type}")
	public String productPageAdd(@Param("type")Integer type){
		String titler = "添加";
		inv.addModel("titler", titler);
		inv.addModel("type", type);
		return RePageConstants.A_PRODUCT;
	}
	
	/**
	 * 后台：跳转产品页面（编辑）
	 * @param id
	 * @param type
	 * @return
	 */
	@Get("/edit/{id}/{type}")
	public String productPageAdd(@Param("id")Long id, @Param("type")Integer type){
		String titler = "编辑";
		Product product = productHome.getProduct(id);
		inv.addModel("product", product);
		inv.addModel("titler", titler);
		inv.addModel("type", type);
		return RePageConstants.A_PRODUCT;
	}
	
	/**
	 * 后台：保存产品
	 * @param news
	 * @return
	 */
	@Post("/save")
	public String productSave(Product product){
		productHome.saveProduct(product);
		String product_msg = "产品保存成功！";
		inv.addModel("type", product.getType());
		return "@<script>alert(\"" + product_msg + "\");location.href=\"/admin/product/list/" + product.getType() + "\";</script>";
	}
	
	/**
	 * 后台：删除产品
	 * @param id
	 * @param type
	 * @return
	 */
	@Get("/delete/{id}/{type}")
	public String productDelete(@Param("id")Long id, @Param("type")Integer type){
		productHome.deleteProduct(id);
		return "@<script>alert(\"产品删除成功！\");location.href=\"/admin/product/list/" + type + "\";</script>";
	}
}
