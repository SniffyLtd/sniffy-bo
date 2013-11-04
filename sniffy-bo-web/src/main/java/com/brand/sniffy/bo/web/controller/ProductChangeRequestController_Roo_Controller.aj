// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.brand.sniffy.bo.web.controller;

import com.brand.sniffy.bo.core.model.ProductChangeRequest;
import com.brand.sniffy.bo.core.service.ProductService;
import com.brand.sniffy.bo.web.controller.ProductChangeRequestController;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect ProductChangeRequestController_Roo_Controller {
    
    @Autowired
    ProductService ProductChangeRequestController.productService;
    
    @RequestMapping(produces = "text/html")
    public String ProductChangeRequestController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("productchangerequests", productChangeRequestService.findProductChangeRequestEntries(firstResult, sizeNo));
            float nrOfPages = (float) productChangeRequestService.countAllProductChangeRequests() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("productchangerequests", productChangeRequestService.findAllProductChangeRequests());
        }
        addDateTimeFormatPatterns(uiModel);
        return "productchangerequests/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String ProductChangeRequestController.update(@Valid ProductChangeRequest productChangeRequest, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, productChangeRequest);
            return "productchangerequests/update";
        }
        uiModel.asMap().clear();
        productChangeRequestService.updateProductChangeRequest(productChangeRequest);
        return "redirect:/productchangerequests/" + encodeUrlPathSegment(productChangeRequest.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String ProductChangeRequestController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, productChangeRequestService.findProductChangeRequest(id));
        return "productchangerequests/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String ProductChangeRequestController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        ProductChangeRequest productChangeRequest = productChangeRequestService.findProductChangeRequest(id);
        productChangeRequestService.deleteProductChangeRequest(productChangeRequest);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/productchangerequests";
    }
    
    void ProductChangeRequestController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("productChangeRequest_requestdate_date_format", "dd-MM-yyyy");
    }
    
    void ProductChangeRequestController.populateEditForm(Model uiModel, ProductChangeRequest productChangeRequest) {
        uiModel.addAttribute("productChangeRequest", productChangeRequest);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("components", componentService.findAllComponents());
        uiModel.addAttribute("producers", producerService.findAllProducers());
        uiModel.addAttribute("products", productService.findAllProducts());
    }
    
    String ProductChangeRequestController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
