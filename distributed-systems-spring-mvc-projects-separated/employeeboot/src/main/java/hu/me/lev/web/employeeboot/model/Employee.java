package hu.me.lev.web.employeeboot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Employee {
    @NotNull
    private int id;
    @NotBlank
    private String name;
    @NotNull
    @Min(18)
    private int age;
    @NotNull
    @Max(20000)
    private int salary;
}
