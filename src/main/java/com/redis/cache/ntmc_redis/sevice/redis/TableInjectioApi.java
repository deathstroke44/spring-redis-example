package com.redis.cache.ntmc_redis.sevice.redis;

import com.redis.cache.ntmc_redis.model.MapObject;
import com.redis.cache.ntmc_redis.model.TableList;
import com.redis.cache.ntmc_redis.sevice.mapConversion.StudentDataConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TableInjectioApi {
    private String TableNames="Table";
    private String TableMapName="TableMap";

    @Autowired
    private StudentDataConversionService studentDataConversionService;

    @Autowired
    private TableInjectionService tableInjectionService;

    @Autowired
    private RedisRepository redisRepository;

    @Autowired
    private RedisMapRepo redisMapRepo;

    @Autowired
    private RedisInstitutionMapRepo redisInstitutionMapRepo;

    @PostMapping("/add")
    public Long add(@RequestBody TableList tableList)
    {
        return tableInjectionService.addTablesToList(tableList.getArrayList());
//        redisRepository.addToList(TableNames,tableList.getArrayList());
//        return redisRepository.listSize(TableNames);
    }
    @GetMapping("/delete/{key}")
    public void add(@PathVariable("key") String key)
    {
        tableInjectionService.deleteKey(key);
//        redisRepository.deleteKey(key);
    }
    @GetMapping("/last")
    public String  add()
    {
        return tableInjectionService.popLeftFromTable();
//        return redisRepository.getLeftItem(TableNames);
    }

    @PostMapping("/add-all-tables-to-map")
    Map<String,Long> updateMap(@RequestBody TableList tableList)
    {
        return tableInjectionService.addAllTablesToMap(tableList.getArrayList());
//        return redisMapRepo.addTOMap(tableName,Status);
    }

    @GetMapping("/add-to-map/{tableName}/{Status}")
    Map<String,Long> updateMap(@PathVariable("tableName") String tableName, @PathVariable("Status") Long Status)
    {
        return tableInjectionService.updateTableStatus(tableName,Status);
//        return redisMapRepo.addTOMap(tableName,Status);
    }
    @GetMapping("/get-from-map/{tableName}")
    Long getFromMap(@PathVariable("tableName") String tableName)
    {
        return tableInjectionService.getStatusOfTable(tableName);
//        return redisMapRepo.get(tableName);
    }
    @GetMapping("/get-full-map")
    Map<String,Long> grtFullTableMap()
    {
        return tableInjectionService.getStatusOfAllTables();
    }
    @PostMapping("/institution/add")
    public Map add(@RequestBody MapObject map)
    {
        return tableInjectionService.addInstitution(map.getMap());
//        redisInstitutionMapRepo.addTOMap(new ID((String) map.getMap().get("eiin"),(String) map.getMap().get("boardName")),map.getMap());
//        return redisInstitutionMapRepo.get(new ID((String) map.getMap().get("eiin"),(String) map.getMap().get("boardName")));
    }
    @PostMapping("/institution/get")
    public Map getInstitutionDetails(@RequestBody MapObject map)
    {
        return tableInjectionService.getInstitutionDetails(map.getMap());
//        return redisInstitutionMapRepo.get(new ID((String) map.getMap().get("eiin"),(String) map.getMap().get("boardName")));
    }
    @PostMapping("/student/map-convert")
    public Map convertStudentMap(@RequestBody MapObject map)
    {
        return studentDataConversionService.getConvertedMap(map.getMap());
//        redisInstitutionMapRepo.addTOMap(new ID((String) map.getMap().get("eiin"),(String) map.getMap().get("boardName")),map.getMap());
//        return redisInstitutionMapRepo.get(new ID((String) map.getMap().get("eiin"),(String) map.getMap().get("boardName")));
    }
}
