package greenbone.service;

import greenbone.model.AdminNotification;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminNotificationService {

    @Value("notificationServiceUrl")
    private String url;

    private final HttpClient<AdminNotification, String> httpClient = new HttpClient<>(url);

    void notifyThreeComputers(String employeeAbbreviation) {
        final String level = "warning";
        final AdminNotification adminNotification = new AdminNotification(
                level,
                employeeAbbreviation,
                "employee" + employeeAbbreviation + "already has 3 assigned computers"
        );

        ResponseEntity<String> response = doRequest(adminNotification);
        System.out.println("Response Body: " + response.getBody());
        System.out.println("Status Code: " + response.getStatusCode().value());
    }

    private ResponseEntity<String> doRequest(AdminNotification adminNotification) {
        return httpClient.doRequest(HttpMethod.POST, adminNotification, String.class);
    }
}
