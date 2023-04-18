package com.dm.OnlineBookStore.controller;

import com.dm.OnlineBookStore.entity.Book;
import com.dm.OnlineBookStore.entity.CartItem;
import com.dm.OnlineBookStore.entity.User;
import com.dm.OnlineBookStore.service.BookStoreService;
import com.dm.OnlineBookStore.service.ShoppingCartService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BookStoreControllerTest {

    @InjectMocks
    private BookStoreController bookStoreController;

    @Mock
    private BookStoreService bookStoreService;

    @Mock
    private ShoppingCartService shoppingCartService;

    @Mock
    private User user;

    @Test
    public void testAddBookToStore() throws Exception {
        Long id = 1L;
        int quantityToAdd = 2;

        // Perform PUT request
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookStoreController).build();
        mockMvc.perform(MockMvcRequestBuilders.put("/api/add-book/" + id + "/" + quantityToAdd))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Verify that the book was added to the store
        Mockito.verify(bookStoreService, Mockito.times(1)).addBook(Mockito.eq(id), Mockito.eq(quantityToAdd), Mockito.eq(user));
    }

    @Test
    public void testRemoveBookItem() throws Exception {
        Long cartItemId = 1L;

        // Perform DELETE request
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookStoreController).build();
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/remove-book/" + cartItemId))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Verify that the book item was removed from the cart
        Mockito.verify(bookStoreService, Mockito.times(1)).removeBook(Mockito.eq(cartItemId));
    }

    @Test
    public void testSearchBook() throws Exception {
        String search = "Java";

        // Mock the search result
        List<CartItem> searchResult = new ArrayList<>();
       // searchResult.add(new CartItem(new Book(), 1));
        Mockito.when(bookStoreService.searchBookItem(Mockito.eq(search))).thenReturn(searchResult);

        // Perform GET request
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookStoreController).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/api/search-book").param("search", search))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].book.title").value("Java Programming"));
    }

    @Test
    public void testCheckOut() throws Exception {
        String promotionCode = "DISCOUNT";
        Long cartId = 1L;

        // Perform PUT request
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookStoreController).build();
        mockMvc.perform(MockMvcRequestBuilders.put("/api/checkOut").param("promotionCode", promotionCode).param("cartId", cartId.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Verify that the checkout was successful
        Mockito.verify(shoppingCartService, Mockito.times(1)).checkOut(Mockito.eq(cartId), Mockito.eq(promotionCode));
    }
}
