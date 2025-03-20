package com.university.uch_university.Controllers;

import com.university.uch_university.Models.*;
import com.university.uch_university.Repository.ProfileRepository;
import com.university.uch_university.Repository.UserRepository;
import com.university.uch_university.Service.BaseService;
import com.university.uch_university.Service.MetersService;
import com.university.uch_university.Service.ProfileService;
import com.university.uch_university.Service.UserService;
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
import java.util.stream.Collectors;

@Controller
@RequestMapping("/readings")
public class ReadingsController extends BaseController<Readings, UUID> {

    @Autowired
    MetersService metersService;

    @Autowired
    ProfileService profileService;

    @Autowired
    UserService userService;

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    UserRepository userRepository;

    public ReadingsController(BaseService<Readings, UUID> baseService) {
        super(baseService,
                Readings.class,
                "readings",
                new LinkedHashMap<>(){
                    {
                        put("Выход", "/logout");
                        put("Список потреблений воды","/consuption/all");
                        put("Список тарифов", "/tariffs/all");
                        put("Список счетчиков", "/meters/all");
                        put("Список методов оплаты", "/paymentsMethods/all");
                        put("Список платежей", "/payments/all");
                    }},
                "модели Показателя счетчика",
                "Список моделей показателей счетчика"
                );
    }

    @Override
    @GetMapping("/all")
    public String getAll(Model model,
                         @RequestParam(name = "page", required = false, defaultValue = "1") int page) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Map<String, Object> sublist = Map.of(
                "meters", metersService.findAll()
        );
        Profile current = profileRepository.findRepositoryById(getCurrentUserId());
        Users user = userRepository.findUsersByProfile(current);

        List<Readings> readings = new ArrayList<>();
        if (user != null && current.getRoles().stream().toList().contains(RoleEnum.USER)) {
            readings = baseService.findAll().stream()
                    .filter(r -> r.getMeters().getUsers().equals(user)) // Фильтруем Readings по пользователю
                    .collect(Collectors.toList()); // Собираем обратно в список
            urls = new LinkedHashMap<>(){
                {
                    put("Выход", "/logout");
                }};
        }
        else if (user == null && current.getRoles().stream().toList().contains(RoleEnum.USER)) {
            urls = new LinkedHashMap<>(){
                {
                    put("Выход", "/logout");
                }};

        }
        else readings = baseService.findAll();
        Pagination<Readings> list = new Pagination<>(new ArrayList<>(readings), page);
        var instance = cls.newInstance();
        ArrayList<String> columns = (ArrayList<String>) instance.getClass().getMethod("getColumns").invoke(instance);
        model.addAttribute("title_model", title_model);
        model.addAttribute("urls", urls);
        model.addAttribute("page", page);
        model.addAttribute("columns", columns);
        model.addAttribute("titleSite", title_model);
        model.addAttribute("list", list);
        model.addAttribute("title_list", title_list);
        model.addAttribute("newobject", instance);
        model.addAttribute("subtitle", subtitle);
        model.addAttribute("sublist", sublist);
        return "base";
    }

    public UserDetails getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            return (UserDetails) principal;
        }
        return null;
    }
    public  UUID getCurrentUserId() {
        String currentUsername = getCurrentUser().getUsername();
        for (Profile profile : profileService.findAll())
            if (profile.getUsername().equals(currentUsername))
                return profile.getId();
        return null;
    }
}
