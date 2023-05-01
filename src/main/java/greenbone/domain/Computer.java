package greenbone.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

@Entity
public class Computer implements Serializable {
    @Id @GeneratedValue
    Long id;

    @NonNull
    private String mac;

    @NonNull
    private String name;

    @NonNull
    private String ip;

    @Nullable
    private String employeeAbbreviation;

    @Nullable
    private String description;

    public Computer() {}

    public Computer(@NonNull String mac, @NonNull String name, @NonNull String ip) {
        this.mac = mac;
        this.name = name;
        this.ip = ip;
    }

    public Computer(@NonNull String mac, @NonNull String name, @NonNull String ip, String employeeAbbreviation) {
        this.mac = mac;
        this.name = name;
        this.ip = ip;
        this.employeeAbbreviation = employeeAbbreviation;
    }

    public Computer(@NonNull String mac, @NonNull String name, @NonNull String ip, String employeeAbbreviation, String description) {
        this.mac = mac;
        this.name = name;
        this.ip = ip;
        this.employeeAbbreviation = employeeAbbreviation;
        this.description = description;
    }

    @NonNull
    public String getMac() {
        return mac;
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
        return ip;
    }

    public void setIp(@NonNull String ip) {
        this.ip = ip;
    }

    @Nullable
    public String getEmployeeAbbreviation() {
        return employeeAbbreviation;
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
}
