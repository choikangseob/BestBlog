package com.ks.bestblog.service.practice;


import com.ks.bestblog.dto.request.practice.InsertMenuRequest;
import com.ks.bestblog.dto.response.practice.InsertMenuResponse;
import com.ks.bestblog.entity.practice.Menu;
import com.ks.bestblog.repository.pratice.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
