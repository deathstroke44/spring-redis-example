package com.redis.cache.springredisexample.sevice.mapConversion;

import javafx.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class StudentDataConversionService {
    private ArrayList<Pair> changeList=new ArrayList<>();

    public StudentDataConversionService() {
        Pair temp;
        temp=new Pair("fname","fatherName");
        System.out.println(temp);
        changeList.add(temp);
        temp=new Pair("mname","motherName");
        changeList.add(temp);
        temp=new Pair("roll_no","rollNo");
        changeList.add(temp);
        temp=new Pair("regno","regNo");
        changeList.add(temp);
        temp=new Pair("pass_year","passYear");
        changeList.add(temp);
        temp=new Pair("gpa_exc4th","gpaExceptFourth");
        changeList.add(temp);
        temp=new Pair("res_detail","resultDetail");
        changeList.add(temp);
        temp=new Pair("res_mail","resultMail");
        changeList.add(temp);
        temp=new Pair("i_code","iCode");
        changeList.add(temp);
        temp=new Pair("board_name","boardName");
        changeList.add(temp);
        temp=new Pair("exam_name","examName");
        changeList.add(temp);
        temp=new Pair("stud_group","studentGroup");
        changeList.add(temp);
        temp=new Pair("stud_type","studentType");
        changeList.add(temp);
        temp=new Pair("ltrgd","letterGrade");
        changeList.add(temp);
        temp=new Pair("c_code","cCode");
        changeList.add(temp);
        temp=new Pair("t_code","tCode");
        changeList.add(temp);
        temp=new Pair("z_code","zCode");
        changeList.add(temp);
        temp=new Pair("stud_sex","studentSex");
        changeList.add(temp);
        temp=new Pair("i_code","iCode");
        changeList.add(temp);
        temp=new Pair("I_update","iUpdate");
        changeList.add(temp);
        temp=new Pair("ltrgd_ca","letterGradeCa");
        changeList.add(temp);
        temp=new Pair("trade_name","tradeName");
        changeList.add(temp);

    }
    public Map getConvertedMap(Map institutionMap)
    {

        String id="";
        if(institutionMap.containsKey("exam_name"))
        {
            id=id+(String) institutionMap.get("exam_name");
        }
        if(institutionMap.containsKey("board_name"))
        {
            id=id+(String) institutionMap.get("board_name");
        }
        if(institutionMap.containsKey("session"))
        {
            id=id+(String) institutionMap.get("session");
        }
        if(institutionMap.containsKey("regno"))
        {
            id=id+(String) institutionMap.get("regno");
        }
        for(Pair pair:changeList)
        {
            String key=(String) pair.getKey();
            String value=(String)pair.getValue();
            if(institutionMap.containsKey(key))
            {
                Object prevValue=institutionMap.get(key);
                institutionMap.remove(key);
                institutionMap.put(value,prevValue);
            }
        }
        institutionMap.put("id",id);
        return institutionMap;
    }
}
