package com.university.uch_university.Controllers;

import com.university.uch_university.Models.Payments;
import com.university.uch_university.Service.BaseService;
import com.university.uch_university.Service.PaymentsMethodService;
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
@RequestMapping("/payments")
public class PaymentsController extends BaseController<Payments, UUID>{

    @Autowired
    PaymentsMethodService paymentsMethodService;

    public PaymentsController(BaseService<Payments, UUID> baseService) {
        super(baseService,
                Payments.class,
                "payments",
                new LinkedHashMap<>(){
                    {
                        put("Выход", "/logout");
                        put("Список потреблений воды","/consuption/all");
                        put("Список показателей счетчиков", "/readings/all");
                        put("Список тарифов", "/tariffs/all");
                        put("Список счетчиков", "/meters/all");
                        put("Список методов оплаты", "/paymentsMethods/all");
                    }},
                "модели Платежа",
                "Список модеелей платежей"
        );
    }

    @Override
    @GetMapping("/all")
    public String getAll(Model model,
                         @RequestParam(name = "page", required = false, defaultValue = "1") int page) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Map<String, Object> sublist = Map.of(
                "paymentsMethod", paymentsMethodService.findAll()
        );
        model.addAttribute("sublist", sublist);
        return super.getAll(model, page);
    }

}
