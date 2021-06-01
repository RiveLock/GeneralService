/**
 * WebUserTest
 * @description
 * @author jixinshi
 * @date 2021/3/9 11:34 AM
 * @version 2.11.2
 */
package com.happy.exercise.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * WebUserTest
 * @description
 * 自己启动web服务，自己访问
 * 场景：真实服务访问
 * @author jixinshi
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebRealUserTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testRandPort() {
        ResponseEntity<List> responseEntity = this.testRestTemplate.getForEntity("http://localhost:" + port + "/general/user/list", List.class);
        assertThat(responseEntity).isNotNull();
        System.out.println(responseEntity);
    }
}
