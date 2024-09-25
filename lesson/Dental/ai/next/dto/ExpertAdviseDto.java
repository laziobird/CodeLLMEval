package ai.next.dto;

import lombok.Data;
import java.util.Date;

@Data
public class ExpertAdviseDto {
    private Integer id;
    private Integer presOrderId;
    private String advise;
    private DoctorDto doctorDto;
    private Date createdAt;
    private Date updatedAt;




}
