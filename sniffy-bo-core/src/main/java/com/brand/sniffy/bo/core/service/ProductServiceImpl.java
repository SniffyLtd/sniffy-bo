package com.brand.sniffy.bo.core.service;

import java.util.Date;
import java.util.List;

import javax.validation.ValidationException;

import com.brand.sniffy.bo.core.model.Component;
import com.brand.sniffy.bo.core.model.Product;
import com.brand.sniffy.bo.core.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void saveProduct(Product product) {
		if(product.getId() == null){
			product.setCreationTime(new Date().getTime());
			product.setDeleted(false);
		}
		product.setLastUpdate(new Date().getTime());
		product.setDeleted(false);
		validateComponents(product);
		productRepository.save(product);
	}

	private void validateComponents(Product product) {
		for(Component component : product.getComponents()){
			if(component.getTmp()){
				throw new ValidationException("Product can't have temporary components.");
			}
		}
	}

	@Override
	public Product updateProduct(Product product) {
		product.setLastUpdate(new Date().getTime());
		product.setDeleted(false);
		validateComponents(product);
		return productRepository.save(product);
	}

	@Override
	public Product findByBarcode(String barcode) {
		return productRepository.findByBarcodeAndDeleted(barcode, false);
	}

	@Override
	public Product findByName(String name) {
		Product product = productRepository.findByName(name);
		if(product == null){
			List<Product> results = productRepository.findByEquivalentNamesLikeAndDeleted(name, false);
			if(results.size() >0){
				product = results.get(0);
			}
		}
		return product;
	}

	@Override
	public void deleteProduct(Product product) {
		product.setDeleted(true);
		product.setLastUpdate(new Date().getTime());
		productRepository.save(product);
	}

	@Override
	public long countAllProducts() {
		return productRepository.countByDeleted(false);
	}

	@Override
	public Product findProduct(Long id) {
		return productRepository.findOne(id);
	}

	@Override
	public List<Product> findAllProducts() {
		return productRepository.findByDeleted(false);
	}

	@Override
	public List<Product> findProductEntries(int firstResult, int maxResults) {
		return productRepository.findByDeleted(false, new PageRequest(firstResult / maxResults, maxResults)).getContent();
	}

}
