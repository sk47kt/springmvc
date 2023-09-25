package sk47kt.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class MappingController {

    @RequestMapping("/hello-basic")
    public String helloBasic() {
        log.info("hellobasic");
        return "OK";
    }

    @GetMapping("/get-mapping")
    public String GetMapping() {
        log.info("getMapping");
        return "get";
    }

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("mappingPath userid={}", data);
        return data;
    }

    @GetMapping("/mapping_v2/{Id}")
    public String mappingPath_v2(@PathVariable String Id) {
        log.info("mappingPath userid={}", Id);
        return Id;
    }

    @GetMapping("/mapping/user/{Id}/order/{orderId}")
    public String mappingPath_v2(@PathVariable String Id, @PathVariable Long orderId) {
        log.info("mappingPath userid={} orderId={}", Id, orderId);
        return Id + orderId;
    }

    //http://localhost:8080/mapping-param?mode=debug
    @GetMapping(value = "/mapping-param", params = "mode=debug") //특정 파라미터 정보 있어야 호출
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingheader() {
        log.info("mappingParam");
        return "ok";
    }

    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE) //Content-Type [{"key":"Content-Type","value":"application/json","description":null,"type":"text","enabled":true}]
    public String mappingConsume() {
        log.info("consume:json");
        return "ok";
    }

    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE) //Accept [{"key":"Accept","value":"text/html","description":null,"type":"text","enabled":true}]
    public String mappingProduces() {
        log.info("mappingproduces");
        return "OK";
    }
}
