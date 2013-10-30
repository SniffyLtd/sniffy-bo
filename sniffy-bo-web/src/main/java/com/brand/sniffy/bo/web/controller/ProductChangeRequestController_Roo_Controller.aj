// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.brand.sniffy.bo.web.controller;

import com.brand.sniffy.bo.core.model.ProductChangeRequest;
import com.brand.sniffy.bo.core.service.ComponentService;
import com.brand.sniffy.bo.core.service.ProducerService;
import com.brand.sniffy.bo.core.service.ProductService;
import com.brand.sniffy.bo.web.controller.ProductChangeRequestController;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
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
    ComponentService ProductChangeRequestController.componentService;
    
    @Autowired
    ProducerService ProductChangeRequestController.producerService;
    
    @Autowired
    ProductService ProductChangeRequestController.productService;
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String ProductChangeRequestController.show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("productchangerequest", ProductChangeRequest.findProductChangeRequest(id));
        uiModel.addAttribute("itemId", id);
        return "productchangerequests/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String ProductChangeRequestController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("productchangerequests", ProductChangeRequest.findProductChangeRequestEntries(firstResult, sizeNo));
            float nrOfPages = (float) ProductChangeRequest.countProductChangeRequests() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("productchangerequests", ProductChangeRequest.findAllProductChangeRequests());
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
        productChangeRequest.merge();
        return "redirect:/productchangerequests/" + encodeUrlPathSegment(productChangeRequest.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String ProductChangeRequestController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, ProductChangeRequest.findProductChangeRequest(id));
        return "productchangerequests/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String ProductChangeRequestController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        ProductChangeRequest productChangeRequest = ProductChangeRequest.findProductChangeRequest(id);
        productChangeRequest.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/productchangerequests";
    }
    
    void ProductChangeRequestController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("productChangeRequest_requestdate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
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