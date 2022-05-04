package service;

import persistence.dao.LibrayInfo_DAO;
import persistence.dto.LibraryInfo_DTO;
import java.util.List;

public class LibraryInfo_Service {
    private final LibrayInfo_DAO librayInfo_dao;

    public LibraryInfo_Service(LibrayInfo_DAO librayInfo_dao){
        this.librayInfo_dao = librayInfo_dao;
    }

    public List<LibraryInfo_DTO> selectLibraryInfoAll(){
        return librayInfo_dao.selectAll();
    }
    public void insertLibraryInfoData(String lib_name,String off_day,String weekday,String satday,
                                      String holiday,String address,String call_no){
        LibraryInfo_DTO librayInfo_dto = new LibraryInfo_DTO();
        librayInfo_dto.setLib_name(lib_name);
        librayInfo_dto.setOff_day(off_day);
        librayInfo_dto.setWeekday(weekday);
        librayInfo_dto.setSatday(satday);
        librayInfo_dto.setHoliday(holiday);
        librayInfo_dto.setAddress(address);
        librayInfo_dto.setCall_no(call_no);
        librayInfo_dao.insertData(librayInfo_dto);
    }
    public void deleteLibraryDataAll(){
        librayInfo_dao.deleteAll();
    }
}
