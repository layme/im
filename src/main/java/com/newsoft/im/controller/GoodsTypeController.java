package com.newsoft.im.controller;

import com.newsoft.im.exception.handler.RestResult;
import com.newsoft.im.exception.handler.RestResultGenerator;
import com.newsoft.im.model.domain.GoodsType;
import com.newsoft.im.model.domain.User;
import com.newsoft.im.service.GoodsTypeService;
import com.newsoft.im.util.LocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author
 * @create 2018-03-30 23:50
 * Description:
 */
@RestController
@SessionAttributes("user")
@RequestMapping(value = "/api/goodstype")
public class GoodsTypeController {
    @Autowired
    GoodsTypeService goodsTypeService;

    @RequestMapping(value = "/add")
    public RestResult add(@ModelAttribute("user") User user, String typeName) {
        GoodsType goodsType = new GoodsType();
        goodsType.setUId(user.getUId());
        goodsType.setName(typeName);
        goodsType.setRegTime(LocalUtils.getCurrentDate());
        goodsTypeService.add(goodsType);
        goodsType = null;
        return RestResultGenerator.genSuccessResult(null);
    }

    @RequestMapping(value = "/search")
    public RestResult search(@ModelAttribute("user") User user) {
        return RestResultGenerator.genSuccessResult(goodsTypeService.findAll());
    }

    @RequestMapping(value = "/update")
    public RestResult update(@ModelAttribute("user") User user, GoodsType goodsType) {
        goodsTypeService.update(goodsType);
        return RestResultGenerator.genSuccessResult(null);
    }
}
