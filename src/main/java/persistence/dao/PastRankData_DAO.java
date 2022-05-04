package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.PastRankData_DTO;
import java.util.List;
public class PastRankData_DAO {
    private SqlSessionFactory sqlSessionFactory = null;

    public PastRankData_DAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
    public List<PastRankData_DTO> selectAll(){
        List<PastRankData_DTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            list = session.selectList("mapper.pastRankData.selectPastRankAll");
        }
        catch(Exception e) {
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
        return list;
    }

    public void insertData(PastRankData_DTO pastRankData_DTO){
        SqlSession session = sqlSessionFactory.openSession();
        try{
            session.insert("insertPastRankNet",pastRankData_DTO);
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
            session.delete("deletePastRankNetAll");
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

