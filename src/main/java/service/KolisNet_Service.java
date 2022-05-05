package service;

import persistence.dao.KolisNet_DAO;
import persistence.dto.KolisNet_DTO;
import java.util.List;

public class KolisNet_Service {
    private final KolisNet_DAO kolisNet_dao;

    public KolisNet_Service(KolisNet_DAO kolisNet_dao){
        this.kolisNet_dao = kolisNet_dao;
    }

    public List<KolisNet_DTO> selectKolisNetAll(){
        return kolisNet_dao.selectAll();
    }
    public void insertKolisNetData(String isbn,String rec_key,String lib_name){
        KolisNet_DTO kolisNet_dto = new KolisNet_DTO();
        kolisNet_dto.setIsbn(isbn);
        kolisNet_dto.setRec_key(rec_key);
        kolisNet_dto.setLib_name(lib_name);
        kolisNet_dao.insertData(kolisNet_dto);
    }
    public void deleteKolisNetAll(){
        kolisNet_dao.deleteAll();
    }
}
