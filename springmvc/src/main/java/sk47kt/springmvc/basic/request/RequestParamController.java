package sk47kt.springmvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk47kt.springmvc.basic.HelloData;

import java.io.IOException;
import java.net.BindException;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Controller
//@RestController - @ResponseBody
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username={}, age={}", username, age);
        response.getWriter().write("OK");
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String username,
            @RequestParam("age") int age) {

        log.info("username={}, age={}", username, age);

        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age) {

        log.info("username={}, age={}", username, age);

        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) {
        log.info("username={}, age={}", username, age);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age) {

        log.info("username={}, age={}", username, age);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault( // required 설정되어있어도 default 값이있으니 굳이 required가 필요X
                                       @RequestParam(required = true, defaultValue = "guest") String username,
                                       @RequestParam(required = false, defaultValue = "-1") Integer age) {

        log.info("username={}, age={}", username, age);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamDefault(@RequestParam Map<String, Object> paramMap) {
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData data) {
        log.info("helloData={}",data);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData data) { //@ModelAttribute 생략
        log.info("helloData={}",data);
        return "OK";
    }

}
