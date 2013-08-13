// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.brand.application.bo.web.controller;

import com.brand.application.bo.core.model.Component;
import com.brand.application.bo.core.repository.ComponentRatingRepository;
import com.brand.application.bo.core.repository.ComponentRepository;
import com.brand.application.bo.web.controller.ComponentController;
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

privileged aspect ComponentController_Roo_Controller {
    
    @Autowired
    ComponentRepository ComponentController.componentRepository;
    
    @Autowired
    ComponentRatingRepository ComponentController.componentRatingRepository;
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String ComponentController.create(@Valid Component component, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, component);
            return "components/create";
        }
        uiModel.asMap().clear();
        componentRepository.save(component);
        return "redirect:/components/" + encodeUrlPathSegment(component.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String ComponentController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Component());
        return "components/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String ComponentController.show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("component", componentRepository.findOne(id));
        uiModel.addAttribute("itemId", id);
        return "components/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String ComponentController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("components", componentRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / sizeNo, sizeNo)).getContent());
            float nrOfPages = (float) componentRepository.count() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("components", componentRepository.findAll());
        }
        return "components/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String ComponentController.update(@Valid Component component, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, component);
            return "components/update";
        }
        uiModel.asMap().clear();
        componentRepository.save(component);
        return "redirect:/components/" + encodeUrlPathSegment(component.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String ComponentController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, componentRepository.findOne(id));
        return "components/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String ComponentController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Component component = componentRepository.findOne(id);
        componentRepository.delete(component);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/components";
    }
    
    void ComponentController.populateEditForm(Model uiModel, Component component) {
        uiModel.addAttribute("component", component);
        uiModel.addAttribute("componentratings", componentRatingRepository.findAll());
    }
    
    String ComponentController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
