package com.tainan.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;




// 客戶資料資訊服務
@RestController
public class QueryTestController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//原本
	@GetMapping(path="/company/findd",produces="application/json")
    public String findd(@RequestParam("d")String dir) {
		String targetDir="N'"+dir+"'";
		String sqlname="SELECT id,[name],addr,phone,d FROM sorted_final where [d]="+targetDir;
        //如果沒有數據，則 list 大小爲 0，不會爲 null 出現空指針異常
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sqlname);
        System.out.println(mapList.getClass().getSimpleName());
        System.out.println(mapList.size());
        String message = new Gson().toJson(mapList);
        return message;
    }
	
	// 測試兩個條件 d&place->OK
	@GetMapping(path="/company/findd2",produces="application/json")
	@ResponseBody
    public String findd2(@RequestParam("d")String dir, @RequestParam("p")String plac) {
		String targetDir="N'"+dir+"'";
		String targetPlac="N'"+plac+"'";
		String sqlname="SELECT id,[name],addr,phone,d FROM sorted_final where [d]="+targetDir+" and [place]="+targetPlac;
        //如果沒有數據，則 list 大小爲 0，不會爲 null 出現空指針異常
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sqlname);
        System.out.println(mapList.getClass().getSimpleName());
        System.out.println(mapList.size());
        String message = new Gson().toJson(mapList);
        return message;
    }
	
	
	@GetMapping(path="/company/findd3",produces="application/json")
	@ResponseBody
    public String findd3(@RequestParam("d")String dir, @RequestParam("p")String plac,@RequestParam("c")String clas) {
		String targetDir="N'%"+dir+"%'";
		String targetPlac="N'%"+plac+"%'";
		String targetClas="N'%"+clas+"%'";
		String sqlname="SELECT id,[name],addr,phone,d,content,place,classify FROM sorted_final where [d] like "+targetDir+" and [place] like "+targetPlac+"and [classify] like "+targetClas;
        //如果沒有數據，則 list 大小爲 0，不會爲 null 出現空指針異常
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sqlname);
        System.out.println(mapList.getClass().getSimpleName());
        System.out.println(mapList.size());
        String message = new Gson().toJson(mapList);
        return message;
    }
	
	
//-----------------------多選部分------------------------------------------------//

	@GetMapping(path="/company/findbyplaceandclassify",produces="application/json")//住+機+(機、住)食衣住行育樂多選
    public String findbyplaceandclassify(@RequestParam("d")String dir,@RequestParam("place")String place[],@RequestParam("classify")String classify[])
	{
		String targetDir="N'"+dir+"'";
		String targetplace1="'%"+place[0]+"%'";
		String place2="";
		String targetclassify1="'%"+classify[0]+"%'";
		String targetclassify2="";
		if (place.length==2)
		{
			place2+=" or [place] like '%"+place[1]+"%'";
		}
		for (int i =1;i<classify.length;i++) 
		{
			if (classify.length>i)
			{
				targetclassify2+=" or [classify] like "+"'%"+classify[i]+"%'";
			}
		}
		String sqlname="SELECT id,[name],addr,phone,d,content,place,classify FROM [sorted_final] where [d] = " +targetDir+" and ( [place] like "+ targetplace1+place2+")and ([classify] like "+targetclassify1+ targetclassify2+")";
        System.out.println(sqlname);
		List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sqlname);
        String message = new Gson().toJson(mapList);
        return message;
    }
//-----------------------多選部分END------------------------------------------------//

	

	
}

