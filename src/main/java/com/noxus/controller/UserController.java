package com.noxus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sorata
 * @date 2019-07-24 15:38
 */
@RestController
public class UserController {

    private static final String OP = "ajdjksjdijwidjipawjdipiwdpiwpihiphiwphfpiwhfpihwhfi8whfiiwhifhw8h8f8qwhf8h8wqh8hwqhf8whfwhqhf8whfwjiqjiqphjiwhiqhiwhqfh8hwq8f80yh380hyf8h8wh8fhq80hfwqhdq8hwf8hqhfh08hf0808hqf80yhfqh8dajwijdiwjpfqwpijfpihwqpihfpiwqhfhiwhfjfijfpijeipjfopijsfojeoqfojeofjeojfieihfsiehjighiehifheihfiejijfeiwjui3u9w3uu92r83yhr839r8wyfhe8whf8h8f83hy8y283y8y8r0y238ry380yhfre0wfu08ewhfh08ewh08hf808h3jri3h939h39h9h2uf0932hfu3h2rhf3hf";

    private static final String tp = "ajdjksjdijwidjipawjdipiwdpiwpihiphiwphfpiwhfpihwhfi8whfiiwhifhw8h8f8qwhf8h8wqh8hwqhf8whfwhqhf8whfwjiqjiqphjiwhiqhiwhqfh8hwq8f80yh380hyf8h8wh8fhq80hfwqhdq8hwf8hqhfh08hf0808hqf80yhfqh8dajwijdiwjpfqwpijfpihwqpihfpiwqhfhiwhfjfijfpijeipjfopijsfojeoqfojeofjeojfieihfsiehjighiehifheihfiejijfeiwjui3u9w3uu92r83yhr839r8wyfhe8whf8h8f83hy8y283y8y8r0y238ry380yhfre0wfu08ewhfh08ewh08hf808h3jri3h939h39h9h2uf0932hfu3h2rhf3hf";

    @RequestMapping("/hello")
    public String token(){
        return new StringBuilder().append(OP).append(OP).append(OP).append(OP)
                .append(OP).append(OP).append(OP).toString();
    }


    public static void main(String[] args) {

    }

}
