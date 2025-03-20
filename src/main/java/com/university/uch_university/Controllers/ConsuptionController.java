package com.university.uch_university.Controllers;

import com.university.uch_university.Models.Consuption;
import com.university.uch_university.Models.Profile;
import com.university.uch_university.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
@RequestMapping("/consuption")
public class ConsuptionController extends BaseController<Consuption, UUID> {

    @Autowired
    TariffsService tariffsService;

    @Autowired
    PaymentsService paymentsService;

    @Autowired
    ReadingsService readingsService;

    public ConsuptionController(BaseService<Consuption, UUID> baseService) {
        super(baseService,
                Consuption.class,
                "consuption",
                new LinkedHashMap<>(){{
                    put("Выход", "/logout");
                    put("Список тарифов","/tariffs/all");
                    put("Список показателей счетчиков", "/readings/all");
                    put("Список счетчиков", "/meters/all");
                    put("Список методов оплаты", "/paymentsMethods/all");
                    put("Список платежей", "/payments/all");
                }},
                "модели Потребления воды",
                "Список моделей потребления воды");
    }

    @Override
    @GetMapping("/all")
    public String getAll(Model model,
                         @RequestParam(name = "page", required = false, defaultValue = "1") int page) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Map<String, Object> sublist = Map.of(
                "tariffs", tariffsService.findAll(),
                "readings", readingsService.findAll(),
                "payments", paymentsService.findAll()
        );
        model.addAttribute("sublist", sublist);
        return super.getAll(model, page);
    }
}
