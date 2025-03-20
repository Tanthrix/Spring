package com.university.uch_university.Controllers;

import com.university.uch_university.Models.Profile;
import com.university.uch_university.Service.BaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.UUID;

@Controller
@RequestMapping("/profiles")
public class ProfilesController extends BaseController<Profile, UUID> {
    public ProfilesController(BaseService<Profile, UUID> baseService) {
        super(baseService, Profile.class,
                "profiles",
                new LinkedHashMap<>(){
                    {
                        put("Выход", "/logout");
                        put("Список пользователей", "/users/all");
                    }},
                "модели профиля пользователя",
                "Список моделей профилей пользователей"
        );
    }
}
