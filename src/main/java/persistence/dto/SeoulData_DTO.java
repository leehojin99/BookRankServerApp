package persistence.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeoulData_DTO {
    public SeoulData_DTO(){}
    private String isbn;
    private int clf_no;
    private int borrow_cnt;
    private int rank;
}
