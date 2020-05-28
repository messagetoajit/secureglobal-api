package in.secureglobal.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.secureglobal.api.domain.Employee;
import in.secureglobal.api.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Tag(name="Employee endpoints", description="Employee endpoints")
@RequestMapping("secureglobal/api/v1/employees")
public class EmployeeController {
 
    @Autowired
    EmployeeService employeeService;
 
    @GetMapping(value="", produces=MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get employees", description = "Get list of employees")
    @ApiResponses(value={
    	@ApiResponse(responseCode="200", description="Success"),
    	@ApiResponse(responseCode="400", description="Bad Requesst", content=@Content(schema=@Schema(implementation=Error.class)))
    })
    public Flux<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
 
    @GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get employee by id", description = "Get employee by id")
    @ApiResponses(value={
    	@ApiResponse(responseCode="200", description="Success"),
    	@ApiResponse(responseCode="400", description="Bad Requesst", content=@Content(schema=@Schema(implementation=Error.class)))
    })
    public Mono<Employee> getEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }
    
    @DeleteMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete employee by id", description = "Delete employee by id")
    @ApiResponses(value={
    	@ApiResponse(responseCode="200", description="Success"),
    	@ApiResponse(responseCode="400", description="Bad Requesst", content=@Content(schema=@Schema(implementation=Error.class)))
    })
    public Mono<Void> deleteEmployeeById(@PathVariable String id) {
        return employeeService.deleteEmployeeById(id);
    }
 
    @PutMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update employee", description = "Update employee")
    @ApiResponses(value={
    	@ApiResponse(responseCode="200", description="Success"),
    	@ApiResponse(responseCode="400", description="Bad Requesst", content=@Content(schema=@Schema(implementation=Error.class)))
    })
    public Mono<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }
    
    @PostMapping(value="", produces=MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create employee", description = "Create employee")
    @ApiResponses(value={
    	@ApiResponse(responseCode="200", description="Success"),
    	@ApiResponse(responseCode="400", description="Bad Requesst", content=@Content(schema=@Schema(implementation=Error.class)))
    })
    public Mono<Employee> createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }
}
