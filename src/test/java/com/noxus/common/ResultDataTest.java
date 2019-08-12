package com.noxus.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noxus.web.domain.ResultData;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * @author sorata
 * @date 2019-07-23 17:58
 */
public class ResultDataTest {

    @Test
    public void warp(){

        ResultData unwarp = ResultData.ok("sss").unwarp((x) -> {

            x.put("un", "dddd");
            x.remove("data");
        });

        try {
            //new ObjectMapper().

            System.out.println(new ObjectMapper().writeValueAsString(unwarp));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(((Map)unwarp.getData()).get("un"),"dddd");



        ResultData ok = ResultData.ok(200, x -> {
            x.put("a", "ddd");
        });


        try {
            //new ObjectMapper().
            System.out.println(new ObjectMapper().writeValueAsString(ok));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }



        Assert.assertEquals(((Map)ok.getData()).get("a"),"ddd");
    }


}
