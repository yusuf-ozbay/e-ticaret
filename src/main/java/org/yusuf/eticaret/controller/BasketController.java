package org.yusuf.eticaret.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yusuf.eticaret.controller.mapper.BasketMapper;
import org.yusuf.eticaret.request.BasketRequest;
import org.yusuf.eticaret.response.BasketResponse;
import org.yusuf.eticaret.service.BasketService;


@RestController
@RequestMapping("baskets")
public class BasketController {

    @Autowired
    BasketService basketService;

    @PostMapping
    public BasketResponse save(@RequestBody BasketRequest basketRequest) {
        return BasketMapper.toRespose(basketService.save(BasketMapper.toDto(basketRequest)));

    }

}
