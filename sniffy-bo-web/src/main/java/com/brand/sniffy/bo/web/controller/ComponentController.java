package com.brand.sniffy.bo.web.controller;

import com.brand.sniffy.bo.core.model.Component;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/components")
@Controller
@RooWebScaffold(path = "components", formBackingObject = Component.class)
public class ComponentController {
}
