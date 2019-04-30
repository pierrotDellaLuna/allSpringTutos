package ictcg.com.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import ictcg.com.model.Student;
import ictcg.com.repository.StudentRepository;

@RestController
public class StudentResourceController {
	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/students")
	public List<Student> retrieveAllStudents() {
		return studentRepository.findAll();
	}

	@GetMapping("/students/{id}")
	public Resource<Student> retrieveStudent(@PathVariable long id) {
		Optional<Student> student = studentRepository.findById(id);

		if (!student.isPresent())
			throw new StudentNotFoundException("id-" + id);
		
		//Resource is a simple class wrapping a domain object and allows adding links to it.

		Resource<Student> resource = new Resource<Student>(student.get());
		
		//We add the link to retrieve all students method to the links.

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllStudents());

		resource.add(linkTo.withRel("all-students"));
		
//		"_links": {
//		    "all-students": {
//		      "href": "http://localhost:8080/students"
//		    }

		return resource;
	}
	
/*	
 * 
 * @GetMapping(produces = { "application/hal+json" })
	public Resources<Customer> getAllCustomers() {
	    List<Customer> allCustomers = customerService.allCustomers();
	 
	    for (Customer customer : allCustomers) {
	        String customerId = customer.getCustomerId();
	        Link selfLink = linkTo(CustomerController.class).slash(customerId).withSelfRel();
	        customer.add(selfLink);
	        if (orderService.getAllOrdersForCustomer(customerId).size() > 0) {
	        
	  //++      The ControllerLinkBuilder offers rich support for Spring MVC Controllers. 
	  //++      The following example shows how to build HATEOAS hyperlinks based on the getOrdersForCustomer() method 
	  //++      of the CustomerController class:
	        
	            Link ordersLink = linkTo(methodOn(CustomerController.class)
	              .getOrdersForCustomer(customerId)).withRel("allOrders");
	              
	              //++
//	The methodOn() obtains the method mapping by making dummy invocation of the target method 
//	on the proxy controller 
//	and sets the customerId as the path variable of the URI.
	              
	            customer.add(ordersLink);
	        }
	    }
	 
	    Link link = linkTo(CustomerController.class).withSelfRel();
	    Resources<Customer> result = new Resources<Customer>(allCustomers, link);
	    return result;
	    
	}
	
	*/

	@DeleteMapping("/students/{id}")
	public void deleteStudent(@PathVariable long id) {
		studentRepository.deleteById(id);
	}

	@PostMapping("/students")
	public ResponseEntity<Object> createStudent(@RequestBody Student student) {
		Student savedStudent = studentRepository.save(student);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedStudent.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable long id) {

		Optional<Student> studentOptional = studentRepository.findById(id);

		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		student.setId(id);
		
		studentRepository.save(student);

		return ResponseEntity.noContent().build();
	}
	
	

}
