package com.techprimers.cache.springredisexample.sevice.redis;

import com.techprimers.cache.springredisexample.model.ID;
import com.techprimers.cache.springredisexample.model.MapObject;
import com.techprimers.cache.springredisexample.model.TableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Map;

@Component
public class TableInjectionService {
    private String TableNames="Table";
    private String TableMapName="TableMap";
    @Autowired
    private RedisRepository redisRepository;

    @Autowired
    private RedisMapRepo redisMapRepo;

    @Autowired
    private RedisInstitutionMapRepo redisInstitutionMapRepo;

    public Long addTablesToList(TableList tableList)
    {
        redisRepository.addToList(TableNames,tableList.getArrayList());
        return redisRepository.listSize(TableNames);
    }
    public void deleteKey(String key)
    {
        redisRepository.deleteKey(key);
    }

    public String popLeftTable()
    {
        return redisRepository.getLeftItem(TableNames);
    }


    Map<String,Long> updateTableMap(String tableName,Long Status)
    {
        return redisMapRepo.addTOMap(tableName,Status);
    }

    Map<String,Long> addAllTablesToMap(ArrayList<String > tableList)
    {
        return redisMapRepo.addListTOMap(tableList);
    }



    Long getStatusOfTableMap(@PathVariable("tableName") String tableName)
    {

        return redisMapRepo.get(tableName);
    }
    public Map addInstitution(MapObject map)
    {
        redisInstitutionMapRepo.addTOMap(new ID((String) map.getMap().get("eiin"),(String) map.getMap().get("boardName")),map.getMap());
        return redisInstitutionMapRepo.get(new ID((String) map.getMap().get("eiin"),(String) map.getMap().get("boardName")));
    }
    public Map getInstitutionDetails(@RequestBody MapObject map)
    {
        return redisInstitutionMapRepo.get(new ID((String) map.getMap().get("eiin"),(String) map.getMap().get("boardName")));
    }
}
