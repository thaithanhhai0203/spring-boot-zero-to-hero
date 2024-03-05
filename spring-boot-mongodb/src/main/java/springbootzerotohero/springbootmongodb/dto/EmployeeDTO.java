package springbootzerotohero.springbootmongodb.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Builder
public class EmployeeDTO {
    private String id;
    private String employeeName;
    private String location;
    private BigDecimal salary;
}
