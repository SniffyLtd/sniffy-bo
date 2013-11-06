package com.brand.sniffy.bo.web.controller;
import com.brand.sniffy.bo.core.model.Product;
import com.brand.sniffy.bo.core.model.ProductChangeRequest;
import com.brand.sniffy.bo.core.service.ProductChangeRequestService;
import com.brand.sniffy.bo.core.utils.ProductMergeRequest;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;


import javax.validation.Valid;

@RequestMapping("/products")
@Controller
@RooWebScaffold(path = "products", formBackingObject = Product.class)
public class ProductController {
	
	@Autowired
	private ProductChangeRequestService productChangeRequestService;
	
	@RequestMapping(value = "/request/{id}", method = RequestMethod.GET, produces = "text/html")
	public String newProductFromRequest(@PathVariable("id") Long id,  Model uiModel){
		
		ProductChangeRequest productChangeRequest = productChangeRequestService.findOne(id);
		Product product = productChangeRequestService.createProduct(productChangeRequest);
		populateEditForm(uiModel, product);
        return "products/create";
	}
	
	@RequestMapping(value = "/request/merge", method = RequestMethod.POST, produces = "text/html")
	public String margeProductFromRequest(@Valid ProductMergeRequest productMergeRequest, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest){
		
		Product product = productChangeRequestService.applyChangesToProduct(productMergeRequest);
		populateEditForm(uiModel, product);
		return "products/update";
	}
	
}
