package com.rusteye.csb;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csb.sdk.ContentBody;
import com.alibaba.csb.sdk.HttpCaller;
import com.alibaba.csb.sdk.HttpCallerException;
import com.alibaba.csb.sdk.HttpParameters;
import com.alibaba.csb.sdk.HttpReturn;
import com.alibaba.fastjson.JSON;

@RestController
public class RevokeController {
	
	@GetMapping("revokeCsb")
	public String revokeCsb() {
		Map<String, Object> params = new HashMap<>();
	    params.put("String", "String");
	    
	    HttpParameters.Builder builder = HttpParameters.newBuilder()
	    .requestURL("http://192.168.0.206:8086//pathRoot/echo")
	    .api("edas-consumer")
	    .version("1.0.0")
	    .method("POST")
	    .contentBody(new ContentBody(JSON.toJSONString(params)));
	    
	    HttpReturn response = null;
	    try {
	        response = HttpCaller.invokeReturn(builder.build());
	    } catch (HttpCallerException e) {
	        throw new RuntimeException(e);
	    }
	    
        java.lang.String result = JSON.parseObject(response.getResponseStr(), java.lang.String.class);
        return result;
	}
}
