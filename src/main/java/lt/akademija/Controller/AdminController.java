package lt.akademija.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.akademija.Model.Admin;
import lt.akademija.Model.CreateAdminCmd;
import lt.akademija.Model.User;
import lt.akademija.Service.AdminService;
import lt.akademija.Service.UserService;

@RestController
@Api(value = "Admin")
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private UserService userService;

	@GetMapping(value = "/admins")
	@ApiOperation(value = "Get admin list", notes = "Returns list of all admins")
	// @PreAuthorize("hasRole('Admin')")
	public List<Admin> getAdmins() {
		return adminService.getAdmins();
	}

	@GetMapping(value = "/admins/{id}")
	@ApiOperation(value = "Get admin", notes = "Returns a single admin")
	//@PreAuthorize("hasRole('Admin')")
	public User getAdmin(@PathVariable Long id) {
		return adminService.getAdmin(id);
	}

	@GetMapping(value = "/userRole")
	@ApiOperation(value = "Get user role", notes = "Returns a single user role")
	public String getUserRole() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		return userService.getUserRole(currentPrincipalName);
	}

	@PostMapping(value = "admin/admins/new")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create admins", notes = "Creates admin")
	//@PreAuthorize("hasRole('Admin')")
	public void createAdmin(@RequestBody CreateAdminCmd cmd) {
		adminService.createAdmin(cmd);
	}

	@PutMapping(value = "/admins/{id}")
	@ApiOperation(value = "Update admin", notes = "Updates admin details")
	//@PreAuthorize("hasRole('Admin')")
	public void updateAdmin(@RequestBody CreateAdminCmd cmd, @PathVariable Long id) {
		adminService.updateAdmin(cmd, id);
	}

}
