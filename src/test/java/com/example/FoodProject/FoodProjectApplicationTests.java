package com.example.FoodProject;

import com.example.FoodProject.model.*;
import com.example.FoodProject.repositories.MenuItemRepository;
import com.example.FoodProject.repositories.OrderRepository;
import com.example.FoodProject.repositories.UserRepository;
import com.example.FoodProject.services.MenuItemService;
import com.example.FoodProject.services.OrderService;
import com.example.FoodProject.services.UserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.util.*;
import static com.example.FoodProject.model.ERole.ROLE_ADMIN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest
@ActiveProfiles("test")

class FoodProjectApplicationTests {

	@Autowired
	private MenuItemRepository menuItemRepository;

	@Autowired
	private MenuItemService menuItemService;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	Logger logger = LoggerFactory.getLogger(FoodProjectApplicationTests.class);

	@Test
	public void getAllMenuItems() {
		when(menuItemRepository.findAll()).thenReturn(
				new LinkedList<MenuItem>(Arrays.asList(
						new MenuItem(1, "Kofta", 90, "Kofta and Rice", "kenvkevmk mnevkmlnevjnkcvnjenckmkcmn cnk"),
						new MenuItem(2, "ShishTawook", 50, "Shish and Rice", "emvnvrkmrlv"),
						new MenuItem(6, "Burger", 70, "Burger Sandwich", "ekmv"),
						new MenuItem(7, "Cheese Pizza", 75, "Pizza of 4 Types pf Cheese", "fml4v")
				)));

		List<MenuItem> expected = menuItemRepository.findAll();
		List<MenuItem> actual = menuItemService.getAllItems();
		logger.info("Actual:" + actual.toString());
		logger.info("Expected:" + expected.toString());

		assertEquals(expected, actual);
	}

	@Test
	public void getAllUsers() {
		Role role = new Role(3,ROLE_ADMIN);
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		when(userRepository.findAll()).thenReturn(
				new LinkedList<User>(Arrays.asList(
						new User(1L, "Ahmed", "ahmed@gmail.com", "12345", roles),
						new User(2L, "Osama", "billy@gmail.com", "Shish and Rice", roles),
						new User(3L, "Bilkasy", "billy85@gmail.com","87854" , roles)
				)));

		List<User> expected = userRepository.findAll();
		List<User> actual = userService.getAllUsers();

		logger.info("Actual:" + actual.toString());
		logger.info("Expected:" + expected.toString());

		assertEquals(expected, actual);
		assertEquals(expected, actual);
	}

	@Test
	public void getAllOrders() {
		Role role = new Role(3,ROLE_ADMIN);
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);

		List<MenuItem> items = new ArrayList<MenuItem>();
		MenuItem item1 = new MenuItem(1, "Kofta Grilled", 90, "Kofta and Rice", "kenvkevmk mnevkmlnevjnkcvnjenckmkcmn cnk");
		MenuItem item2 = new MenuItem(1, "Burger", 90, "Kofta and Rice", "kenvkevmk mnevkmlnevjnkcvnjenckmkcmn cnk");
		items.add(item1);
		items.add(item2);

		User user1 = new User(1L,"Bilkasy","Bilkasy@gmail.com","12345",roles);
		User user2 = new User(2L,"Ahmed","Ahmed@gmail.com","12345",roles);

		Order expected1 = new Order(1,1L,user1,items);
		Order expected2 = new Order(2,2L,user2,items);
		List<Order>expected = new ArrayList<Order>();
		expected.add(expected1);
		expected.add(expected2);

		when(orderRepository.findAll()).thenReturn(expected);

		List<Order> actual = orderService.getAllOrders();

		logger.info("Actual:" + actual.toString());
		logger.info("Expected:" + expected.toString());

		assertEquals(expected, actual);
	}

	@Test
	public void getMenuItemByName() {
		when(menuItemRepository.findByName("Kofta")).thenReturn(
				new MenuItem(1, "Kofta", 90, "Kofta and Rice", "kenvkevmk mnevkmlnevjnkcvnjenckmkcmn cnk")
		);
		MenuItem expected = menuItemRepository.findByName("Kofta");
		MenuItem actual = menuItemService.findByName("Kofta");

		logger.info("Actual:" + actual.toString());
		logger.info("Expected:" + expected.toString());

		assertEquals(expected, actual);
	}

	@Test
	public void getUserById() {
		Role role = new Role(3,ROLE_ADMIN);
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		when(userRepository.findById(1L))
				.thenReturn(Optional.of(new User(1L, "Ahmed", "ahmed@gmail.com", "12345", roles)));
		Optional<User> expected = userRepository.findById(1L);
		Optional<User> actual = Optional.ofNullable(userService.getOneUserById(1L));

		logger.info("Actual:" + actual.toString());
		logger.info("Expected:" + expected.toString());

		assertEquals(expected, actual);
	}

	@Test
	public void postMenuItem() {
		MenuItem item = new MenuItem(1, "Kofta Grilled", 90, "Kofta and Rice", "kenvkevmk mnevkmlnevjnkcvnjenckmkcmn cnk");

		menuItemRepository.save(item);

		when(menuItemRepository.findByName("Kofta Grilled")).thenReturn(item);

		MenuItem actual = menuItemService.findByName("Kofta Grilled");

		assertEquals(item, actual);
	}

	@Test
	public void postMenuItem2()
	{
		MenuItem item = new MenuItem(1, "Kofta Grilled", 90, "Kofta and Rice", "kenvkevmk mnevkmlnevjnkcvnjenckmkcmn cnk");

		String actual = menuItemService.addMenuItem(item);
		String expected = "MenuItem is added Successfully";

		assertEquals(expected, actual);
	}

	@Test
	public void test()
	{

		Role role = new Role(3,ROLE_ADMIN);
		Set<Role> roles = new HashSet<Role>();
 		roles.add(role);
 		List<MenuItem> items = new ArrayList<MenuItem>();
		User user = new User(1L,"Bilkasy","Bilkasy@gmail.com","12345",roles);
		MenuItem item = new MenuItem(1, "Kofta Grilled", 90, "Kofta and Rice", "kenvkevmk mnevkmlnevjnkcvnjenckmkcmn cnk");
		items.add(item);
		Order order = new Order(1,1L,user,items);

		when(userRepository.findById(1L)).thenReturn(Optional.of(user));
		when(menuItemRepository.findByName("Kofta Grilled")).thenReturn(item);
		when(orderRepository.findById(1)).thenReturn(order);

		userService.addUser(user);
		menuItemService.addMenuItem(item);
		orderService.postAnOrder(order);

		User userActual = userService.getOneUserById(1L);
		MenuItem itemActual = menuItemService.findByName("Kofta Grilled");
		Order orderActual = orderService.getOrderById(1);

		assertEquals(user,userActual);
		assertEquals(item,itemActual);
		assertEquals(order,orderActual);
	}

}
