package view;

import persistence.dto.SeoulData_DTO;

import java.util.List;

public class SeoulData_View {
    public void printAll(List<SeoulData_DTO> dtos){
        System.out.println("isbn | clf_no | borrow_cnt | rank");
        for (SeoulData_DTO dto : dtos){
            System.out.println(
                    dto.getIsbn()+" "
                    +dto.getClf_no()+" "
                    +dto.getBorrow_cnt()+" "
                    +dto.getRank()
            );
        }
    }
}
