package com.brand.sniffy.bo.core.service;
import java.util.List;

import org.springframework.roo.addon.layers.service.RooService;

import com.brand.sniffy.bo.core.model.Product;

@RooService(domainTypes = { com.brand.sniffy.bo.core.model.Product.class })
public interface ProductService {
	
	public void saveProduct(Product product);
	
	public Product updateProduct(Product product);

	public Product findByBarcode(String barcode);

	public Product findByName(String name);

	public void deleteProduct(Product product);
	
	public long countAllProducts();    
	
    public Product findProduct(Long id);
    
    public List<Product> findAllProducts(); 
    
    public List<Product> findProductEntries(int firstResult, int maxResults);

}
