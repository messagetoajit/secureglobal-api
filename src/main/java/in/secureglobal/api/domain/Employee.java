package in.secureglobal.api.domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@PrimaryKey
	private String id;
	private String name;
	private String address;
	private String email;
}
