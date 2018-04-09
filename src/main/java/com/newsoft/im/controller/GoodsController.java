package com.newsoft.im.controller;

import com.newsoft.im.exception.handler.RestResult;
import com.newsoft.im.exception.handler.RestResultGenerator;
import com.newsoft.im.model.domain.Goods;
import com.newsoft.im.model.domain.User;
import com.newsoft.im.service.GoodsService;
import com.newsoft.im.util.LocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;

/**
 * @author
 * @create 2018-03-21 15:29
 * Description:
 */
@RestController
@SessionAttributes("user")
@RequestMapping(value = "/api/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping(value = "/add")
    public RestResult add(@ModelAttribute("user") User user, String name, Long tid, Double price) {
        Goods goods = new Goods(null, name, tid, price, user.getUId(), LocalUtils.getCurrentDate());
        return RestResultGenerator.genSuccessResult(goodsService.add(goods));
    }

    @RequestMapping(value = "/search")
    public RestResult search(@ModelAttribute("user") User user, Long gid) {
        return RestResultGenerator.genSuccessResult(goodsService.search(gid));
    }

    @RequestMapping(value = "/delete")
    public RestResult delete(@ModelAttribute("user") User user, String gids) {
        ArrayList<Goods> list = new ArrayList<Goods>();
        if (gids.contains(",")) {
            String[] gidArr = gids.split(",");
            for (String gid : gidArr) {
                list.add(goodsService.getOne(Long.valueOf(gid)));
            }
        } else {
            list.add(goodsService.getOne(Long.valueOf(gids)));
        }
        goodsService.delete(list);
        return RestResultGenerator.genSuccessResult(null);
    }


}
