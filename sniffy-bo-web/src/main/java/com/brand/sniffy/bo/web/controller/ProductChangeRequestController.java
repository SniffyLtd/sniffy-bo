package com.brand.sniffy.bo.web.controller;
import com.brand.sniffy.bo.core.model.ProductChangeRequest;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/productchangerequests")
@Controller
@RooWebScaffold(path = "productchangerequests", formBackingObject = ProductChangeRequest.class, create = false)
public class ProductChangeRequestController {
}
