package service;

import persistence.dao.PastRankData_DAO;
import persistence.dto.PastRankData_DTO;
import java.util.List;

public class PastRankData_Service {
    private final PastRankData_DAO pastRankData_dao;

    public PastRankData_Service(PastRankData_DAO pastRankData_dao){
        this.pastRankData_dao = pastRankData_dao;
    }

    public List<PastRankData_DTO> selectLibraryInfoAll(){
        return pastRankData_dao.selectAll();
    }
    public void insertPastRank(String isbn,int rank){
        PastRankData_DTO pastRankData_dto = new PastRankData_DTO();
        pastRankData_dto.setIsbn(isbn);
        pastRankData_dto.setRank(rank);
        pastRankData_dao.insertData(pastRankData_dto);
    }
    public void deleteLibraryDataAll(){
        pastRankData_dao.deleteAll();
    }
}
