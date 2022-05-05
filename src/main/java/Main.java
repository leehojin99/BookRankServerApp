import persistence.MyBatisConnectionFactory;
import persistence.dao.*;
import persistence.dto.SeoulData_DTO;
import service.*;
import view.SeoulData_View;

import java.util.List;

//config/config.xml => 환경설정,매퍼등록,매퍼 파라미터로 객체 사용시 정의
//sqlmapper/~mapper.xml => 쿼리작성
//DTO => 데이터객체        (그냥 데이터)
//DAO => 데이터액세스객체   (인터페이스??비슷하게 생각)

//@@@@@@데이터베이스에서 변경해야 할 내용
//      main_table을 seoul_data로 변경
//      seoul_data의 rank의 notnoll특성 해제
//      aladin의 isbn을 varchar(13)로 변경

public class Main{
    public static void main(String[] args) {
        SeoulData_DAO seoulData_dao = new SeoulData_DAO(MyBatisConnectionFactory.getSqlSessionFactory());
        SeoulData_Service seoulData_service = new SeoulData_Service(seoulData_dao);

        AladinData_DAO aladinData_dao = new AladinData_DAO(MyBatisConnectionFactory.getSqlSessionFactory());
        AladinData_Service aladinData_service = new AladinData_Service(aladinData_dao);

        KolisNet_DAO kolisNet_dao = new KolisNet_DAO(MyBatisConnectionFactory.getSqlSessionFactory());
        KolisNet_Service kolisNet_service = new KolisNet_Service(kolisNet_dao);

        LibrayInfo_DAO librayInfo_dao = new LibrayInfo_DAO(MyBatisConnectionFactory.getSqlSessionFactory());
        LibraryInfo_Service libraryInfo_service = new LibraryInfo_Service(librayInfo_dao);

        PastRankData_DAO pastRankData_dao = new PastRankData_DAO(MyBatisConnectionFactory.getSqlSessionFactory());
        PastRankData_Service pastRankData_service = new PastRankData_Service(pastRankData_dao);

//        SeoulData_View seoulData_view = new SeoulData_View();
//
//        List<SeoulData_DTO> allData;
//        allData = seoulData_service.selectSeoulDataAll();
//        seoulData_view.printAll(allData);
//
//        seoulData_service.insertSeoulData("q1",11,22);
//
//        allData = seoulData_service.selectSeoulDataAll();
//        seoulData_view.printAll(allData);
//
//        seoulData_service.updateSeoulDataRankWithNewRank("q1",99);
//
//        allData = seoulData_service.selectSeoulDataAll();
//        seoulData_view.printAll(allData);
//
//        seoulData_service.deleteSeoulDataAll();
        PastRankBackup pastRankBackup = new PastRankBackup(seoulData_service, pastRankData_service);
        pastRankBackup.backupSeoulDataToPastRankData();
    }
}
