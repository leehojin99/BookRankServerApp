import service.*;

public class DailyWork {

    SeoulData_Service seoulData_service;
    AladinData_Service aladinData_service;
    KolisNet_Service kolisNet_service;
    LibraryInfo_Service libraryInfo_service;
    PastRankData_Service pastRankData_service;
    public DailyWork
    (
        SeoulData_Service seoulData_service,
        AladinData_Service aladinData_service,
        KolisNet_Service kolisNet_service,
        LibraryInfo_Service libraryInfo_service,
        PastRankData_Service pastRankData_service
    )
    {
        this.seoulData_service = seoulData_service;
        this.aladinData_service = aladinData_service;
        this.kolisNet_service = kolisNet_service;
        this.libraryInfo_service = libraryInfo_service;
        this.pastRankData_service = pastRankData_service;
    }
    public void DailyWork(){
        PastRankBackup pastRankBackup = new PastRankBackup(seoulData_service,pastRankData_service);
        DeletePastData deletePastData = new DeletePastData(seoulData_service,aladinData_service,kolisNet_service,libraryInfo_service,pastRankData_service);

        //1. 전일자 순위 삭제
        deletePastData.deletePastRank();
        //2. 전일자 순위 새로 저장
        pastRankBackup.backupSeoulDataToPastRankData();
        //3. 현재 데이터 삭제
        deletePastData.deletePastData();
        //4. 데이터 파싱 후 저장

    }
}
