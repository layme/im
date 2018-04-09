package com.newsoft.im.controller;

import com.newsoft.im.exception.handler.RestResult;
import com.newsoft.im.exception.handler.RestResultGenerator;
import com.newsoft.im.model.domain.User;
import com.newsoft.im.service.StockService;
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
@RequestMapping(value = "api/stock")
public class StockController {
    @Autowired
    StockService stockService;

    @RequestMapping(value = "/search")
    public RestResult search(@ModelAttribute("user") User user, Long gid) {
        return RestResultGenerator.genSuccessResult(stockService.search(gid));
    }

    @RequestMapping(value = "/in")
    public RestResult in(@ModelAttribute("user") User user, Long gid, Integer number, String remark) {
        stockService.inRepository(gid, number, remark, user.getUId());
        return RestResultGenerator.genSuccessResult(null);
    }

    @RequestMapping(value = "/out")
    public RestResult out(@ModelAttribute("user") User user, Long gid, Integer number, String remark) {
        stockService.outRepository(gid, number, remark, user.getUId());
        return RestResultGenerator.genSuccessResult(null);
    }
}
