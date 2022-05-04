package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.SeoulData_DTO;
import java.util.List;

public class SeoulData_DAO {
    private SqlSessionFactory sqlSessionFactory = null;

    public  SeoulData_DAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
    public List<SeoulData_DTO> selectAll(){
        List<SeoulData_DTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            list = session.selectList("mapper.seoul_data.selectSeoulDataAll");
        }
        catch(Exception e) {
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
        return list;
    }

    public void insertData(SeoulData_DTO seoulData_dto){
        SqlSession session = sqlSessionFactory.openSession();
        try{
            session.insert("insertSeoulData",seoulData_dto);
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

    public void updateRankWithNewRank(SeoulData_DTO seoulData_dto){
        SqlSession session = sqlSessionFactory.openSession();
        try{
            session.update("updateSeoulDataRankWithNewRank",seoulData_dto);
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
            session.delete("deleteSeoulDataAll");
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

