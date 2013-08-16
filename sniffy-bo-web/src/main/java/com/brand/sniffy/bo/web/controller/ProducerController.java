package com.brand.sniffy.bo.web.controller;

import com.brand.sniffy.bo.core.model.Producer;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/producers")
@Controller
@RooWebScaffold(path = "producers", formBackingObject = Producer.class)
public class ProducerController {
}
