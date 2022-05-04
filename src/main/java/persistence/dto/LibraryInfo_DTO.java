package persistence.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LibraryInfo_DTO {
    public LibraryInfo_DTO(){}
    private String lib_name;
    private String off_day;
    private String weekday;
    private String satday;
    private String holiday;
    private String address;
    private String call_no;
}
