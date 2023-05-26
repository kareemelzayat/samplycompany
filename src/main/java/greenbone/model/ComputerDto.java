package greenbone.model;

import greenbone.constraints.IpAddress;
import greenbone.constraints.MacAddress;
import greenbone.domain.Computer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ComputerDto {

    private Long id;

    @MacAddress
    @NotBlank(message = "MAC address is required")
    private String macAddress;

    @NotBlank(message = "Name is required")
    private String name;

    @IpAddress
    @NotBlank(message = "IP address is required")
    private String ipAddress;

    @Pattern(regexp = "[a-zA-Z]{3}", message = "Employee abbreviation must consist of 3 letters")
    private String employeeAbbreviation;

    @Size(max = 255, message = "Description cannot exceed 255 characters")
    private String description;

    public ComputerDto(String macAddress, String name, String ipAddress, String employeeAbbreviation, String description) {
        this.macAddress = macAddress;
        this.name = name;
        this.ipAddress = ipAddress;
        this.employeeAbbreviation = employeeAbbreviation;
        this.description = description;
    }

    public ComputerDto(Long id, String macAddress, String name, String ipAddress, String employeeAbbreviation, String description) {
        this.id = id;
        this.macAddress = macAddress;
        this.name = name;
        this.ipAddress = ipAddress;
        this.employeeAbbreviation = employeeAbbreviation;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getEmployeeAbbreviation() {
        return employeeAbbreviation;
    }

    public void setEmployeeAbbreviation(String employeeAbbreviation) {
        this.employeeAbbreviation = employeeAbbreviation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Computer toEntity() {
        return new Computer(id, macAddress, name, ipAddress, employeeAbbreviation, description);
    }
}
