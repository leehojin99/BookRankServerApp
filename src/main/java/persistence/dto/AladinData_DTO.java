package persistence.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AladinData_DTO {
    public AladinData_DTO(){}
    private String isbn;
    private String cov_url;
    private int rating;
    private String book_description;
    private int ebook;
    private String title;
    private String author;
    private String publisher;
}
