package com.techprimers.cache.springredisexample.sevice.redis;

import com.techprimers.cache.springredisexample.model.MapObject;
import com.techprimers.cache.springredisexample.model.TableList;
import com.techprimers.cache.springredisexample.sevice.mapConversion.StudentDataConversionService;
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
        return tableInjectionService.addTablesToList(tableList);
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
        return tableInjectionService.popLeftTable();
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
        return tableInjectionService.updateTableMap(tableName,Status);
//        return redisMapRepo.addTOMap(tableName,Status);
    }
    @GetMapping("/get-from-map/{tableName}")
    Long getFromMap(@PathVariable("tableName") String tableName)
    {
        return tableInjectionService.getStatusOfTableMap(tableName);
//        return redisMapRepo.get(tableName);
    }
    @PostMapping("/institution/add")
    public Map add(@RequestBody MapObject map)
    {
        return tableInjectionService.addInstitution(map);
//        redisInstitutionMapRepo.addTOMap(new ID((String) map.getMap().get("eiin"),(String) map.getMap().get("boardName")),map.getMap());
//        return redisInstitutionMapRepo.get(new ID((String) map.getMap().get("eiin"),(String) map.getMap().get("boardName")));
    }
    @PostMapping("/institution/get")
    public Map getInstitutionDetails(@RequestBody MapObject map)
    {
        return tableInjectionService.getInstitutionDetails(map);
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
