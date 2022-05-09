import persistence.MyBatisConnectionFactory;
import persistence.dao.*;
import service.*;

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
        ServerController serverController = new ServerController();
        serverController.serverMain();
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

//        service.PastRankBackup pastRankBackup = new service.PastRankBackup(seoulData_service, pastRankData_service);
//        pastRankBackup.backupSeoulDataToPastRankData();
//

    }
}
