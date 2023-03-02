//페이지 연동이 최우선, 연동 후 view(jsp) 작업
package com.spring.product;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/*.xml"})

public class ProductControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(ProductControllerTest.class);

    @Inject
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        logger.info("설정 중.....");
    }

    @Test
    public void TestListGET() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("list"));
    }
    
    @Test
    public void testWriteGET() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("./write"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testWritePOST() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/write")
                .param("product", "새로운 상품")
                .param("price", "10000")
                .param("quantity", "100")
                .param("company", "새로운 회사")
        )
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(flash().attribute("msg", "INSERT"))
                .andExpect(redirectedUrl("/list"));
    }

    @Test
    public void testListGET() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("list"));
    }

    @Test
    public void testViewGET() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/view?num=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("ProductVO"));
    }

    @Test
    public void testModifyGET() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("./modify?num=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("boardVO"));
    }

    @Test
    public void testModifyPOST() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/modify")
                .param("num", "1")
                .param("product", "새로운 상품")
                .param("price", "10000")
                .param("quantity", "100")
                .param("company", "새로운 회사")
        )
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(flash().attribute("msg", "MODIFY"))
                .andExpect(redirectedUrl("/list"));
    }

    @Test
    public void testDeleteGET() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/delete")
                .param("num", "22")
        )
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(flash().attribute("msg", "DELETE"))
                .andExpect(redirectedUrl("/list"));
    }    
}
