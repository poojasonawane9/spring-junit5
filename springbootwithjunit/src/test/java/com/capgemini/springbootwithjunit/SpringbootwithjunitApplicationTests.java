package com.capgemini.springbootwithjunit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.capgemini.springbootwithjunit.controller.ProductController;
import com.capgemini.springbootwithjunit.entity.Product;
import com.capgemini.springbootwithjunit.service.ProductService;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class SpringbootwithjunitApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean
	ProductService service;

	
	@Autowired
	ProductController controller;
	
	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}
	
	@Test
	public void testList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/new"))
				.andExpect(status().isOk());
	}
	
	@Test
	public void deleteIdTest() throws Exception{
		Product product =new Product(2,"Mary");
		doReturn(true).when(service).deleteProduct(2);
		mockMvc.perform(delete("/product/delete")).andExpect(status().isOk());
	}
	
	@Test
	public void readByIdTest() throws Exception {
		Product product = new Product(2,"Britania");
		when(service.findById(2)).thenReturn(product);
		mockMvc.perform(get("/product/2")).andExpect(MockMvcResultMatchers.jsonPath("$.productId", is(2)));
		}

	@Test
	public void testIdNotFound() throws Exception {
		Product product = new Product(6,"Oreo");
		doReturn(false).when(service).deleteProduct(101);
		this.mockMvc.perform(delete("/product/3")).andDo(print()).andExpect(status().isNotFound());
	}
	
	@Test
	public void testCreateProduct() throws Exception {
		Product product = new Product(3,"Patanjali");
		when(service.addSingleProduct(product)).thenReturn(product);
		mockMvc.perform(post("/product/newEntry"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.productId", is("productId")))
		.andExpect(jsonPath("$.description",is("description")));
	}
	
}
