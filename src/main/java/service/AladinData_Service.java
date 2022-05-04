package service;

import persistence.dao.AladinData_DAO;
import persistence.dto.AladinData_DTO;
import java.util.List;

public class AladinData_Service {
    private final AladinData_DAO aladinData_dao;

    public AladinData_Service(AladinData_DAO aladinData_dao){
        this.aladinData_dao = aladinData_dao;
    }

    public List<AladinData_DTO> selectAladinDataAll(){
        return aladinData_dao.selectAll();
    }
    public void insertAladinData(String isbn,String cov_url,int rating,String book_description,
                                int ebook,String title,String author,String publisher){
        AladinData_DTO aladinData_dto = new AladinData_DTO();
        aladinData_dto.setIsbn(isbn);
        aladinData_dto.setCov_url(cov_url);
        aladinData_dto.setRating(rating);
        aladinData_dto.setBook_description(book_description);
        aladinData_dto.setEbook(ebook);
        aladinData_dto.setTitle(title);
        aladinData_dto.setAuthor(author);
        aladinData_dto.setPublisher(publisher);
        aladinData_dao.insertData(aladinData_dto);
    }
    public void deleteAladinDataAll(){
        aladinData_dao.deleteAll();
    }
}
