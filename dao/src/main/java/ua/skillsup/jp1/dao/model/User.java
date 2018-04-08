package ua.skillsup.jp1.dao.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

	private Long id;
	private String firstName;
	private String lastName;
	private int age;
}
