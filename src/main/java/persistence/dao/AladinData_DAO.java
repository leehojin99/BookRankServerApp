package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.AladinData_DTO;
import java.util.List;
public class AladinData_DAO {
    private SqlSessionFactory sqlSessionFactory = null;

    public AladinData_DAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
    public List<AladinData_DTO> selectAll(){
        List<AladinData_DTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            list = session.selectList("mapper.aladin_data.selectAladinDataAll");
        }
        catch(Exception e) {
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
        return list;
    }

    public void insertData(AladinData_DTO aladinData_dto){
        SqlSession session = sqlSessionFactory.openSession();
        try{
            session.insert("insertAladinData",aladinData_dto);
            session.commit();
        }
        catch(Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        finally {
            session.close();
        }
    }

    public void deleteAll(){
        SqlSession session = sqlSessionFactory.openSession();
        try{
            session.delete("deleteAladinDataAll");
            session.commit();
        }
        catch(Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        finally {
            session.close();
        }
    }
}

