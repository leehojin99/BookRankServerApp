package service;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import persistence.dao.SeoulData_DAO;
import persistence.dto.SeoulData_DTO;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class SeoulData_Service {
    private final SeoulData_DAO seoulData_dao;

    public SeoulData_Service(SeoulData_DAO seoulData_dao){
        this.seoulData_dao = seoulData_dao;
    }

    public List<SeoulData_DTO> selectSeoulDataAll(){
        return seoulData_dao.selectAll();
    }
    public void insertSeoulData(String isbn, int clf_no, int borrow_cnt){
        SeoulData_DTO seoulData_dto = new SeoulData_DTO();
        seoulData_dto.setIsbn(isbn);
        seoulData_dto.setClf_no(clf_no);
        seoulData_dto.setBorrow_cnt(borrow_cnt);
        seoulData_dao.insertData(seoulData_dto);
    }
    public void updateSeoulDataRankWithNewRank(String isbn, int newRank){
        SeoulData_DTO seoulData_dto = new SeoulData_DTO();
        seoulData_dto.setIsbn(isbn);
        seoulData_dto.setRank(newRank);
        seoulData_dao.updateRankWithNewRank(seoulData_dto);
    }
    public void deleteSeoulDataAll(){
        seoulData_dao.deleteAll();
    }

}
