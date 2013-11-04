package com.brand.sniffy.bo.web.controller;
import com.brand.sniffy.bo.core.model.ProductChangeRequest;
import com.brand.sniffy.bo.core.service.CategoryService;
import com.brand.sniffy.bo.core.service.ComponentService;
import com.brand.sniffy.bo.core.service.ProducerService;
import com.brand.sniffy.bo.core.service.ProductChangeRequestService;
import com.brand.sniffy.bo.core.service.ProductService;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

@RequestMapping("/productchangerequests")
@Controller
@RooWebScaffold(path = "productchangerequests", formBackingObject = ProductChangeRequest.class, create = false)
public class ProductChangeRequestController {
	
	@Autowired
	private ProductChangeRequestService productChangeRequestService;
	
	@Autowired
	private ComponentService componentService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProducerService producerService;
	
	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("productchangerequest", productChangeRequestService.findProductChangeRequest(id));
        uiModel.addAttribute("itemId", id);
        uiModel.addAttribute("components", componentService.findAll());
        uiModel.addAttribute("categories", categoryService.findAll());
        uiModel.addAttribute("producers", producerService.findAll());
        return "productchangerequests/show";
    }
}
