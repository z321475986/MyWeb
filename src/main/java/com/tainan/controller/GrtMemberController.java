package com.tainan.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class GrtMemberController {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@GetMapping(path="/company/findm",produces="application/json")
    public String findn(@RequestParam("n")String phone,@RequestParam("p")String password) {
		String targetPhone="'"+phone+"'";
		String targetPassword="'"+password+"'";
		String sqlname="SELECT * FROM memberdata where [phone]="+targetPhone+" and password="+targetPassword;
		System.out.println(sqlname);
        //如果沒有數據，則 list 大小爲 0，不會爲 null 出現空指針異常
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sqlname);
        System.out.println(mapList.size());
        String message = new Gson().toJson(mapList);
        System.out.println(message.length());
        return message;
	}
}
