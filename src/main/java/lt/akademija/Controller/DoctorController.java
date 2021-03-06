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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.akademija.Model.CreateDoctorCmd;
import lt.akademija.Model.Doctor;
import lt.akademija.Model.Patient;
import lt.akademija.Model.Prescription;
import lt.akademija.Model.Record;
import lt.akademija.Model.User;
import lt.akademija.Service.DoctorService;

@RestController
@Api(value = "Doctor")
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@GetMapping(value = "/doctors")
	@ApiOperation(value = "Get doctor list", notes = "Returns list of all doctors")
	//@PreAuthorize("hasRole('Admin')")
	public List<Doctor> getDoctors() {
		return doctorService.getDoctors();
	}

	@GetMapping(value = "/doctors/{id}")
	@ApiOperation(value = "Get doctor", notes = "Returns a single doctor")
	//@PreAuthorize("hasRole('Admin')")
	public User getDoctor(@PathVariable Long id) {
		return doctorService.getDoctor(id);
	}

	@GetMapping(value = "/doctors/{id}/patients")
	@ApiOperation(value = "Get all doctor patients", notes = "Returns all doctor patients")
	//@PreAuthorize("hasRole('Doctor')")
	public List<Patient> getDoctorPatients(@PathVariable Long id) {
		return doctorService.getDoctorPatients(id);
	}

	@GetMapping(value = "/doctors/{id}/records")
	@ApiOperation(value = "Get all doctor records", notes = "Returns all doctor records")
	//@PreAuthorize("hasRole('Doctor')")
	public List<Record> getDoctorRecords(@PathVariable Long id) {
		return doctorService.getDoctorRecords(id);
	}

	@GetMapping(value = "/doctors/{id}/prescriptions")
	@ApiOperation(value = "Get all doctor prescriptions", notes = "Returns all doctor prescriptions")
	//@PreAuthorize("hasRole('Doctor')")
	public List<Prescription> getDoctorPrescriptions(@PathVariable Long id) {
		return doctorService.getDoctorPrescriptions(id);
	}

	@PostMapping(value = "admin/doctors/new")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create doctors", notes = "Creates doctor")
	//@PreAuthorize("hasRole('Admin')")
	public void createDoctor(@RequestBody CreateDoctorCmd cmd) {
		doctorService.createDoctor(cmd);
	}

	@PutMapping(value = "/doctors/{id}")
	@ApiOperation(value = "Update doctor", notes = "Updates doctor details")
	//@PreAuthorize("hasRole('Admin')")
	public void updateDoctor(@RequestBody CreateDoctorCmd cmd, @PathVariable Long id) {
		doctorService.updateDoctor(cmd, id);
	}

}
