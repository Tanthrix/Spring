package com.university.uch_university.Controllers;

import com.university.uch_university.Models.PaymentsMethod;
import com.university.uch_university.Service.BaseService;
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
import java.util.*;

@Controller
@RequestMapping("/paymentsMethods")
public class PaymentsMethodController extends BaseController<PaymentsMethod, UUID> {

    public PaymentsMethodController(BaseService<PaymentsMethod, UUID> baseService) {
        super(baseService, PaymentsMethod.class,
                "paymentsMethods",
                new LinkedHashMap<>(){{
                    put("Выход", "/logout");
                    put("Список потреблений воды","/consuption/all");
                    put("Список показателей счетчиков", "/readings/all");
                    put("Список тарифов", "/tariffs/all");
                    put("Список счетчиков", "/meters/all");
                    put("Список платежей", "/payments/all");
                }},
                "модели Метода оплаты",
                "Список моделей методов оплаты"
        );
    }


}
