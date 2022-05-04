package persistence.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PastRankData_DTO {
    public PastRankData_DTO(){}
    private String isbn;
    private int rank;
}
