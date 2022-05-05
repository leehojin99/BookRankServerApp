import service.*;

public class DeletePastData {
    SeoulData_Service seoulData_service;
    AladinData_Service aladinData_service;
    KolisNet_Service kolisNet_service;
    LibraryInfo_Service libraryInfo_service;
    PastRankData_Service pastRankData_service;
    public DeletePastData
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
    public void deletePastRank(){
        pastRankData_service.deleteLibraryDataAll();
    }
    public void deletePastData(){
        seoulData_service.deleteSeoulDataAll();
        aladinData_service.deleteAladinDataAll();
        kolisNet_service.deleteKolisNetAll();
        libraryInfo_service.deleteLibraryDataAll();
    }
}
