package service;

import persistence.MyBatisConnectionFactory;
import persistence.dao.*;

public class ServerController {
    SeoulData_DAO seoulData_dao;
    SeoulData_Service seoulData_service;

    AladinData_DAO aladinData_dao;
    AladinData_Service aladinData_service;

    KolisNet_DAO kolisNet_dao;
    KolisNet_Service kolisNet_service;

    LibrayInfo_DAO librayInfo_dao;
    LibraryInfo_Service libraryInfo_service;

    PastRankData_DAO pastRankData_dao;
    PastRankData_Service pastRankData_service;
    public ServerController(){
        seoulData_dao = new SeoulData_DAO(MyBatisConnectionFactory.getSqlSessionFactory());
        seoulData_service = new SeoulData_Service(seoulData_dao);

        aladinData_dao = new AladinData_DAO(MyBatisConnectionFactory.getSqlSessionFactory());
        aladinData_service = new AladinData_Service(aladinData_dao);

        kolisNet_dao = new KolisNet_DAO(MyBatisConnectionFactory.getSqlSessionFactory());
        kolisNet_service = new KolisNet_Service(kolisNet_dao);

        librayInfo_dao = new LibrayInfo_DAO(MyBatisConnectionFactory.getSqlSessionFactory());
        libraryInfo_service = new LibraryInfo_Service(librayInfo_dao);

        pastRankData_dao = new PastRankData_DAO(MyBatisConnectionFactory.getSqlSessionFactory());
        pastRankData_service = new PastRankData_Service(pastRankData_dao);
    }
    public void serverMain(){
        //
        DailyWork dailyWork = new DailyWork(seoulData_service,aladinData_service,kolisNet_service,libraryInfo_service,pastRankData_service);
        dailyWork.updateData();
    }
}
