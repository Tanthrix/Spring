package com.university.uch_university.Controllers;

import com.university.uch_university.Models.Meters;
import com.university.uch_university.Service.BaseService;
import com.university.uch_university.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/meters")
public class MetersController extends BaseController<Meters, UUID> {

    @Autowired
    UserService userService;


    public MetersController(BaseService<Meters, UUID> baseService) {
        super(baseService,
                Meters.class,
                "meters",
                new LinkedHashMap<>(){{
                    put("Выход", "/logout");
                    put("Список потреблений воды","/consuption/all");
                    put("Список показателей счетчиков", "/readings/all");
                    put("Список тарифов", "/tariffs/all");
                    put("Список методов оплаты", "/paymentsMethods/all");
                    put("Список платежей", "/payments/all");
                }},
                "модели Счетчика воды",
                "Список моделей счетчиков воды");
    }

    @Override
    @GetMapping("/all")
    public String getAll(Model model,
                         @RequestParam(name = "page", required = false, defaultValue = "1") int page) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Map<String, Object> sublist = Map.of(
                "users", userService.findAll()
        );
        model.addAttribute("sublist", sublist);
        return super.getAll(model, page);
    }
}
