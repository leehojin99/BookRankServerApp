package service;

import persistence.dto.SeoulData_DTO;

import javax.xml.crypto.Data;
import java.util.List;

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
    public void updateData(){
        DataInserter dataInserter= new DataInserter(seoulData_service,aladinData_service,kolisNet_service,libraryInfo_service);
        //1. 전일자 순위 삭제
//        deletePastRank();
        //2. 전일자 순위 새로 저장
//        makeSeoulDataToPastRankData();
        //3. 현재 데이터 삭제
        deletePastData();
        //4. 데이터 파싱 후 저장
        dataInserter.inputDataWithApi();
        //5. rank값 삽입

    }
    private void deletePastRank(){
        pastRankData_service.deletePastRankDataAll();
    }
    public void makeSeoulDataToPastRankData(){
        List<SeoulData_DTO> seoulData_dtos = seoulData_service.selectSeoulDataAll();
        for (SeoulData_DTO dto : seoulData_dtos){
            pastRankData_service.insertPastRank(dto.getIsbn(), dto.getRank());
        }
    }
    private void deletePastData(){
        seoulData_service.deleteSeoulDataAll();
        aladinData_service.deleteAladinDataAll();
        kolisNet_service.deleteKolisNetAll();
        libraryInfo_service.deleteLibraryDataAll();
    }
}
