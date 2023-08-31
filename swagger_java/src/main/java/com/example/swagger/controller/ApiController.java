package com.example.swagger.controller;


import com.alibaba.druid.util.StringUtils;
import com.example.swagger.entity.SwaggerData;
import com.example.swagger.service.SwaggerDataService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {
    @Data
    public static class Request implements Serializable {

        private String url;
        private String method;
        private Map<String, String> headers;
        private Map<String, String> params;
    }

    @Data
    public static class Response {
        private int responseCode;
        private Map<String, List<String>> headers;
        private StringBuffer params;
    }
    @Autowired
    private SwaggerDataService swaggerDataService;
//    @Autowired
//    private ApiControllerService apiControllerService;

//    @RequestMapping(method = RequestMethod.GET)
//    public R<Response> handleGetRequest(Request request) throws IOException {
//        // 处理GET请求
//        Response response = apiControllerService.GetRequestSender(request.getUrl(), request.getHeaders(), request.getParams());
//        return R.success(response);
//    }

    @PostMapping("/sendJson")
    public ResponseEntity<?> handlePostRequest(@RequestBody Map<String, Object> requestData) {
        log.info(String.valueOf(requestData));

        try {
            Long id = Long.valueOf(String.valueOf(requestData.get("id")));
            SwaggerData result = swaggerDataService.getInputOutputParamsById(id);

            String method = result.getMethod();
            if (StringUtils.equalsIgnoreCase(method, "get")) {
                System.out.println("getgetget");
            } else if (StringUtils.equalsIgnoreCase(method, "post")) {
                System.out.println("postpostpost");
            } else {
                System.out.println("other");
            }

            // 进一步处理逻辑

            return ResponseEntity.ok().build();
        } catch (NumberFormatException e) {
            // 处理 ID 转换异常
            return ResponseEntity.badRequest().body("Invalid ID format");
        } catch (NullPointerException e) {
            // 处理空指针异常或缺少的参数
            return ResponseEntity.badRequest().body("Missing or null ID parameter");
        }
    }






}

//    @RequestMapping(method = RequestMethod.PUT)
//    public ResponseEntity<String> handlePutRequest(@RequestBody String requestBody) {
//        // 处理PUT请求，requestBody包含请求体的内容
//        return ResponseEntity.ok("PUT request handled with request body: " + requestBody);
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE)
//    public ResponseEntity<String> handleDeleteRequest() {
//        // 处理DELETE请求
//        return ResponseEntity.ok("DELETE request handled");
//    }

