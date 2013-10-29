package com.brand.sniffy.bo.web.controller;
import com.brand.sniffy.bo.core.model.ComponentRating;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/componentratings")
@Controller
@RooWebScaffold(path = "componentratings", formBackingObject = ComponentRating.class)
public class ComponentRatingController {
}
