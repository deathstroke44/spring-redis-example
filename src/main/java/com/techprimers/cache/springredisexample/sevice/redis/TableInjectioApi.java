package com.techprimers.cache.springredisexample.sevice.redis;

import com.techprimers.cache.springredisexample.model.TableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class TableInjectioApi {
    private String TableNames="Table";
    private String TableMapName="TableMap";
    @Autowired
    private RedisRepository redisRepository;

    @Autowired
    private RedisMapRepo redisMapRepo;

    @PostMapping("/add")
    public Long add(@RequestBody TableList tableList)
    {
        redisRepository.addToList(TableNames,tableList.getArrayList());
        return redisRepository.listSize(TableNames);
    }
    @GetMapping("/delete/{key}")
    public void add(@PathVariable("key") String key)
    {
        redisRepository.deleteKey(key);
    }
    @GetMapping("/last")
    public String  add()
    {
        return redisRepository.getLeftItem(TableNames);
    }

    @GetMapping("/add-to-map/{tableName}/{Status}")
    Map<String,String> updateMap(@PathVariable("tableName") String tableName, @PathVariable("Status") Long Status)
    {

        return redisMapRepo.addTOMap(tableName,Status);
    }
    @GetMapping("/get-from-map/{tableName}")
    String getFromMap(@PathVariable("tableName") String tableName)
    {

        return redisMapRepo.get(tableName);
    }
}
