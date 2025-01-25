package com.htc.spring.entity.relation.main;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.htc.spring.entity.relation.config.SpringEntityRelationConfig;
import com.htc.spring.entity.relation.entity.Cattle;
import com.htc.spring.entity.relation.entity.CattleHouse;
import com.htc.spring.entity.relation.entity.CattleTransfer;
import com.htc.spring.entity.relation.entity.Employees;
import com.htc.spring.entity.relation.entity.Feeds;
import com.htc.spring.entity.relation.entity.Role;
import com.htc.spring.entity.relation.entity.Users;
import com.htc.spring.entity.relation.service.CattleFeedService;
import com.htc.spring.entity.relation.service.CattleHouseService;
import com.htc.spring.entity.relation.service.CattleService;
import com.htc.spring.entity.relation.service.CattleTransferService;
import com.htc.spring.entity.relation.service.CattleTreatmentService;
import com.htc.spring.entity.relation.service.CurativeService;
import com.htc.spring.entity.relation.service.EmployeesService;
import com.htc.spring.entity.relation.service.FeedsService;
import com.htc.spring.entity.relation.service.RoleService;
import com.htc.spring.entity.relation.service.UsersService;

public class SpringEntityRelationshipController {
	static Logger log = LogManager.getLogger(SpringEntityRelationshipController.class);
	static ApplicationContext context = new AnnotationConfigApplicationContext(SpringEntityRelationConfig.class);

	static CattleService cattleService = (CattleService) context.getBean("cattleService");
	static FeedsService feedsService = (FeedsService) context.getBean("feedsService");
	static CattleHouseService cattleHouseService = (CattleHouseService) context.getBean("cattleHouseService");
	static CattleTransferService cattleTransferService = (CattleTransferService) context
			.getBean("cattleTransferService");
	static CattleTreatmentService cattleTreatmentService = (CattleTreatmentService) context
			.getBean("cattleTreatmentService");
	static CurativeService curativeService = (CurativeService) context.getBean("curativeService");
	static EmployeesService employeesService = (EmployeesService) context.getBean("employeesService");
	static CattleFeedService cattleFeedService = (CattleFeedService) context.getBean("cattleFeedService");
	static RoleService roleService = (RoleService) context.getBean("roleService");
	static UsersService usersService = (UsersService) context.getBean("usersService");

	public static void main(String[] args) {
//    	doCrudOperationForCattle();
//    	doCrudOperationForFeeds();
//    	doCrudOperationForCattleHouse();
//    	doCrudOperationForRole();
//		doCrudOperationForUsers();
//    	doCrudOperationForCattleTransfer();
//		doCrudOperationForEmployees();
		doManyToManyOperation();

//		log.info("CATTLE INFORMATION : "+cattleService.getAllCattle());
//		log.info("Employees INFORMATION : "+employeesService.getAllEmployees());
//		log.info("ROLE INFORMATION : "+roleService.getAllRole());
//		log.info("USERS INFORMATION : "+usersService.getAllUsers());
//		log.info("CATTLE TRANSFER INFORMATION : "+cattleTransferService.getAllCattleTransfer());

	}

	private static void doManyToManyOperation() {
		Role role = roleService.getRoleById(1001);
		Role role2 = roleService.getRoleById(1002);
		Users user = new Users(108, "Harish", "****", role2);
		Set<Role> roleSet = new HashSet<Role>();
		roleSet.add(role);
		roleSet.add(role2);
		user.setRoles(roleSet);
		usersService.addUser(user);
		log.info("Many TO Many Achieved");
	}

	private static void doCrudOperationForEmployees() {
		Users user = usersService.getUserById(101);
		Users user2 = usersService.getUserById(102);
		Employees employee = new Employees(1, user, "Male", "Dept1", 1234567890, new Date(), "Chennai");
		Employees employee2 = new Employees(2, user, "Female", "Dept2", 1234567890, new Date(), "Mumbai");
		Employees employee3 = new Employees(3, user2, "Male", "Dept1", 1234567890, new Date(), "Chennai");
		Employees employee4 = new Employees(4, user2, "Female", "Dept2", 1234567890, new Date(), "Mumbai");
		employeesService.addEmployees(employee);
		employeesService.addEmployees(employee2);
		employeesService.addEmployees(employee3);
		employeesService.addEmployees(employee4);
		log.info("Employees Information added");
		List<Employees> employeeList = employeesService.getAllEmployees();
		log.info("Employees List Information Loaded" + employeeList);
		employeesService.getEmployeesById(employee.getEmployeeId());
		log.info("Employees Information Loaded");
		employee.setDepartment("Dept3");
		employeesService.updateEmployees(employee);
		log.info("Employees Information Updated");
		employeesService.deleteEmployees(employee.getEmployeeId());
		employeesService.deleteEmployees(employee.getEmployeeId());
		log.warn("Employees Information Deleted");
	}

	private static void doCrudOperationForUsers() {

		Role role = roleService.getRoleById(1001);
		Role role2 = roleService.getRoleById(1002);
		Users user = new Users(105, "Hari", "****", role);
		Users user2 = new Users(106, "Ajith", "****", role2);
		usersService.addUser(user);
		usersService.addUser(user2);
		log.info("Users Information added");
		List<Users> userList = usersService.getAllUsers();
		log.info("Users List Information Loaded" + userList);
		usersService.getUserById(user.getUserId());
		log.info("Users Information Loaded");
		user.setUserPwd("#####");
		usersService.updateUser(user);
		log.info("Users Information Updated");
		usersService.deleteUser(user.getUserId());
		usersService.deleteUser(user2.getUserId());
		log.warn("Users Information Deleted");

	}

	private static void doCrudOperationForRole() {

		Role role = new Role(1003, "Role1");
		Role role2 = new Role(1004, "Role2");
		roleService.addRole(role);
		roleService.addRole(role2);
		log.info("Role Information added");
		roleService.getAllRole();
		log.info("Role List Information Loaded");
		roleService.getRoleById(role.getRoleId());
		log.info("Role Information Loaded");
		role.setRoleName("Role1");
		roleService.updateRole(role);
		log.info("Role Information Updated");
		roleService.deleteRole(role.getRoleId());
		roleService.deleteRole(role2.getRoleId());
		log.warn("Role Information Deleted");

	}

	private static void doCrudOperationForCattleTransfer() {

		CattleHouse cattleHouse = cattleHouseService.getCattleHouseById(101);
		CattleHouse cattleHouse2 = cattleHouseService.getCattleHouseById(102);
		CattleTransfer cattleTransfer = new CattleTransfer(201, "Delhi", cattleHouse, "Space", new Date());
		CattleTransfer cattleTransfer2 = new CattleTransfer(202, "Punjab", cattleHouse2, "Dirty", new Date());
		cattleTransferService.addCattleTransfer(cattleTransfer);
		cattleTransferService.addCattleTransfer(cattleTransfer2);
		log.info("CattleTransfer Information added");
		cattleTransferService.getAllCattleTransfer();
		log.info("CattleTransfer List Information Loaded");
		cattleTransferService.getCattleTransferById(cattleTransfer.getTransferId());
		log.info("Feed Information Loaded");
		cattleTransfer.setTransferReason("Need Extra Space");
		cattleTransferService.updateCattleTransfer(cattleTransfer);
		log.info("CattleTransfer Information Updated");
		cattleTransferService.deleteCattleTransfer(cattleTransfer.getTransferId());
		log.warn("CattleTransfer Information Deleted");

	}

	private static void doCrudOperationForCattleHouse() {
		CattleHouse cattleHouse = new CattleHouse(101, "Chennai", "Vacancy", "Roopen", new Date(), "Good");
		CattleHouse cattleHouse2 = new CattleHouse(102, "Banagalore", "Vacancy", "Sathish", new Date(), "Better");
		cattleHouseService.addCattleHouse(cattleHouse);
		cattleHouseService.addCattleHouse(cattleHouse2);
		log.info("CattleHouse Information added");
		cattleHouseService.getAllCattleHouse();
		log.info("CattleHouse List Information Loaded");
		cattleHouseService.getCattleHouseById(cattleHouse.getCattleHouseId());
		log.info("Feed Information Loaded");
		cattleHouse.setRecord("Bad");
		cattleHouseService.updateCattleHouse(cattleHouse);
		log.info("CattleHouse Information Updated");
		cattleHouseService.deleteCattleHouse(cattleHouse.getCattleHouseId());
		log.warn("CattleHouse Information Deleted");
	}

	private static void doCrudOperationForFeeds() {
		Feeds feeds = new Feeds(1, "Paddy", new Date(), "Code01", 24, "Sivakarthi", "Vizag");
		feedsService.addFeed(feeds);
		log.info("Feeds Information added");
		feedsService.getAllFeeds();
		log.info("Feeds List Information Loaded");
		feedsService.getFeedById(feeds.getFeedId());
		log.info("Feed Information Loaded");
		feeds.setFeedName("Powder");
		feedsService.updateFeed(feeds);
		log.info("Feed Information Updated");
		feedsService.deleteFeed(feeds.getFeedId());
		log.warn("Feed Information Deleted");

	}

	private static void doCrudOperationForCattle() {

		CattleHouse cattleHouse = cattleHouseService.getCattleHouseById(101);
		CattleHouse cattleHouse2 = cattleHouseService.getCattleHouseById(102);
		CattleTransfer cattleTransfer = cattleTransferService.getCattleTransferById(201);
		Cattle cattle = new Cattle(1, new Date(), 100, new Date(), "Tanjavur", cattleHouse, cattleTransfer, true, 0,
				"Healthy");
		Cattle cattle2 = new Cattle(2, new Date(), 300, new Date(), "Kanyakumari", cattleHouse2, cattleTransfer, true,
				0, "Unhealthy");
		cattleService.addCattle(cattle);
		cattleService.addCattle(cattle2);
		log.info("Cattle Information Added");
		List<Cattle> cattleList = cattleService.getAllCattle();
		log.info("Cattle List Information Loaded " + cattleList);
		cattleService.getCattleById(cattle.getCattleId());
		log.info("Cattle Information Loaded");
		cattle.setOriginalArea("Bangalore");
		cattleService.updateCattle(cattle);
		log.info("Cattle Information Updated");
		cattleService.deleteCattle(cattle.getCattleId());
		log.warn("Cattle Information Deleted");

	}

}