package com.ks.bestblog.service;


import com.ks.bestblog.dto.request.InsertMenuRequest;
import com.ks.bestblog.dto.response.InsertMenuResponse;
import com.ks.bestblog.entity.Menu;
import com.ks.bestblog.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.awt.SystemColor.menu;

@Service
@RequiredArgsConstructor
public class InsertMenuService {
    private final MenuRepository menuRepository;

    public InsertMenuResponse insertMenu (InsertMenuRequest insertMenuRequest) {


       Menu insertMenu = Menu.from(insertMenuRequest);
       Menu savedmenu = menuRepository.save(insertMenu);
        return InsertMenuResponse.of(savedmenu);
    }
}
