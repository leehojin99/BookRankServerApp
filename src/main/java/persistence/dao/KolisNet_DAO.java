package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.KolisNet_DTO;
import java.util.List;
public class KolisNet_DAO {
    private SqlSessionFactory sqlSessionFactory = null;

    public KolisNet_DAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
    public List<KolisNet_DTO> selectAll(){
        List<KolisNet_DTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            list = session.selectList("mapper.kolisnet.selectKolisNetAll");
        }
        catch(Exception e) {
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
        return list;
    }

    public void insertData(KolisNet_DTO kolisNet_dto){
        SqlSession session = sqlSessionFactory.openSession();
        try{
            session.insert("insertKolisNet",kolisNet_dto);
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
            session.delete("deleteKolisNetAll");
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

