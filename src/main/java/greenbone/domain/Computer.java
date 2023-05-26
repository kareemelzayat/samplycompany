package greenbone.domain;

import greenbone.constraints.IpAddress;
import greenbone.constraints.MacAddress;
import greenbone.model.ComputerDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

@Entity
@Validated
public class Computer implements Serializable {
    @Id @GeneratedValue
    Long id = null;

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

    public Computer() {}

    public Computer(@NonNull String macAddress, @NonNull String name, @NonNull String ipAddress) {
        this.macAddress = macAddress;
        this.name = name;
        this.ipAddress = ipAddress;
    }

    public Computer(@NonNull String macAddress, @NonNull String name, @NonNull String ipAddress, String employeeAbbreviation) {
        this.macAddress = macAddress;
        this.name = name;
        this.ipAddress = ipAddress;
        this.employeeAbbreviation = employeeAbbreviation;
    }

    public Computer(@NonNull String macAddress, @NonNull String name, @NonNull String ipAddress, String employeeAbbreviation, String description) {
        this.macAddress = macAddress;
        this.name = name;
        this.ipAddress = ipAddress;
        this.employeeAbbreviation = employeeAbbreviation;
        this.description = description;
    }

    public Computer(@Nullable Long id, @NonNull String macAddress, @NonNull String name, @NonNull String ipAddress, String employeeAbbreviation, String description) {
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

    @NonNull
    public String getMac() {
        return macAddress;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getIp() {
        return ipAddress;
    }

    public void setIp(@NonNull String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Nullable
    public String getEmployeeAbbreviation() {
        return employeeAbbreviation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmployeeAbbreviation(@Nullable String employeeAbbreviation) {
        this.employeeAbbreviation = employeeAbbreviation;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    public ComputerDto toDto() {
        return new ComputerDto(id, macAddress, name, ipAddress, employeeAbbreviation, description);
    }
}
