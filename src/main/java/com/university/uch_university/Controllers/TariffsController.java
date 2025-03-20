package com.university.uch_university.Controllers;

import com.university.uch_university.Models.Tariffs;
import com.university.uch_university.Service.BaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.UUID;

@Controller
@RequestMapping("/tariffs")
public class TariffsController extends BaseController<Tariffs, UUID> {

    public TariffsController(BaseService<Tariffs, UUID> baseService) {
        super(baseService, Tariffs.class,
                "tariffs",
                new LinkedHashMap<>() {
                    {
                        put("Выход", "/logout");
                        put("Список потреблений воды","/consuption/all");
                        put("Список показателей счетчиков", "/readings/all");
                        put("Список счетчиков", "/meters/all");
                        put("Список методов оплаты", "/paymentsMethods/all");
                        put("Список платежей", "/payments/all");
                    }
                },
                "модели Тарифа на потребление воды",
                "Список моделей тарифов на потребление воды"
        );
    }
}
