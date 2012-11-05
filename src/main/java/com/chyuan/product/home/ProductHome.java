package com.chyuan.product.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chyuan.product.dao.ProductDAO;
import com.chyuan.product.model.Product;

@Component
public class ProductHome {
	@Autowired
	private ProductDAO productDao;
	
	public Product getProduct(Long id){
		return productDao.getProduct(id);
	}
	
	public List<Product> getProductList(Integer type, int start, int pageSize, String searchText){
		return productDao.getProductList(type, start, pageSize, searchText);
	}
	
	public int countGetProductList(Integer type, String searchText){
		return productDao.countGetProductList(type, searchText);
	}
	
	public void saveProduct(Product product){
		if(null == product.getId()){
			productDao.insertProduct(product);
		}else{
			productDao.updateProduct(product);
		}
	}
	
	public void deleteProduct(Long id){
		productDao.deleteProduct(id);
	}
}
