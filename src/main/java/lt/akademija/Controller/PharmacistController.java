package lt.akademija.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.akademija.Model.CreatePharmacistCmd;
import lt.akademija.Model.Pharmacist;
import lt.akademija.Model.User;
import lt.akademija.Service.PharmacistService;

@RestController
@Api(value = "Pharmacist")
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api")
public class PharmacistController {

	@Autowired
	private PharmacistService pharmacistService;

	@GetMapping(value = "/pharmacists")
	@ApiOperation(value = "Get pharmacist list", notes = "Returns list of all pharmacists")
	//@PreAuthorize("hasRole('Admin')")
	public List<Pharmacist> getPharmacists() {
		return pharmacistService.getPharmacists();
	}

	@GetMapping(value = "/pharmacists/{id}")
	@ApiOperation(value = "Get pharmacist", notes = "Returns a single pharmacist")
	//@PreAuthorize("hasRole('Admin') or hasRole('Pharmacist')")
	public User getPharmacist(@PathVariable Long id) {
		return pharmacistService.getPharmacist(id);
	}

	@PostMapping(value = "/admin/pharmacists/new")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create pharmacists", notes = "Creates pharmacist")
	//@PreAuthorize("hasRole('Admin')")
	public void createPharmacist(@RequestBody CreatePharmacistCmd cmd) {
		pharmacistService.createPharmacist(cmd);
	}

	@PutMapping(value = "/pharmacists/{id}")
	@ApiOperation(value = "Update pharmacist", notes = "Updates pharmacist details")
	//@PreAuthorize("hasRole('Admin')")
	public void updatePharmacist(@RequestBody CreatePharmacistCmd cmd, @PathVariable Long id) {
		pharmacistService.updatePharmacist(cmd, id);
	}

}
