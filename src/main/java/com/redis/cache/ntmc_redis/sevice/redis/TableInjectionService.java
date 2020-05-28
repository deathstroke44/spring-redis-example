package com.redis.cache.ntmc_redis.sevice.redis;

import com.redis.cache.ntmc_redis.model.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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

    public Long addTablesToList(ArrayList<String> tableList)
    {
        redisRepository.addToList(TableNames,tableList);
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



    Long getStatusOfTableMap(String tableName)
    {

        return redisMapRepo.get(tableName);
    }

    Map getStatusOfAllTables()
    {

        return redisMapRepo.getCompleteMap();
    }

    public Map addInstitution(Map map)
    {
        redisInstitutionMapRepo.addTOMap(new ID((String) map.get("eiin"),(String) map.get("boardName")),map);
        return redisInstitutionMapRepo.get(new ID((String) map.get("eiin"),(String) map.get("boardName")));
    }
    public Map getInstitutionDetails(@RequestBody Map map)
    {
        return redisInstitutionMapRepo.get(new ID((String) map.get("eiin"),(String) map.get("boardName")));
    }
}
