package com.newsoft.im.controller;

import com.newsoft.im.exception.handler.RestResult;
import com.newsoft.im.exception.handler.RestResultGenerator;
import com.newsoft.im.model.domain.User;
import com.newsoft.im.service.RecordService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@SessionAttributes("user")
@RequestMapping(value = "/api/record")
public class RecordController {
    @Autowired
    RecordService recordService;

    @RequestMapping(value = "/search")
    public RestResult search(@ModelAttribute("user") User user, Long gid, String startDate, String endDate) {
        log.debug("gid = {}, startDate = {}, endDate = {}", gid, startDate, endDate);
        return RestResultGenerator.genSuccessResult(recordService.search(gid, startDate, endDate));
    }
}
