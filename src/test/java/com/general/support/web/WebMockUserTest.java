/**
 * WebUserTest
 * @description
 * @author jixinshi
 * @date 2021/3/9 11:34 AM
 * @version 2.11.2
 */
package com.general.support.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * WebUserTest
 * @description
 * 启动spring服务（除了web服务），mock web 访问接口。
 * 场景：无需关心ip、port，访问服务controller
 * 注意：需要关闭 druid.web-stat-filter.enabled: false
 * @author jixinshi
 */
@SpringBootTest
@AutoConfigureMockMvc
public class WebMockUserTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testMock() throws Exception {
        this.mockMvc.perform(get("/user/list")).andDo(print()).andExpect(status().isOk());
    }
}
