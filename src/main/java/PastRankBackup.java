import persistence.dto.SeoulData_DTO;
import service.PastRankData_Service;
import service.SeoulData_Service;

import java.util.List;

public class PastRankBackup {
    SeoulData_Service seoulData_service;
    PastRankData_Service pastRankData_service;
    List<SeoulData_DTO> seoulData_dtos;
    public PastRankBackup(SeoulData_Service seoulData_service, PastRankData_Service pastRankData_service){
        this.seoulData_service = seoulData_service;
        this.pastRankData_service = pastRankData_service;
    }

    public void backupSeoulDataToPastRankData(){
        seoulData_dtos = seoulData_service.selectSeoulDataAll();
        for (SeoulData_DTO dto : seoulData_dtos){
            pastRankData_service.insertPastRank(dto.getIsbn(), dto.getRank());
        }
    }
}
