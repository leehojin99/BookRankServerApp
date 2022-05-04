package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.LibraryInfo_DTO;
import java.util.List;
public class LibrayInfo_DAO {
    private SqlSessionFactory sqlSessionFactory = null;

    public LibrayInfo_DAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
    public List<LibraryInfo_DTO> selectAll(){
        List<LibraryInfo_DTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            list = session.selectList("mapper.libraryInfo.selectLibraryInfoAll");
        }
        catch(Exception e) {
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
        return list;
    }

    public void insertData(LibraryInfo_DTO libraryInfo_DTO){
        SqlSession session = sqlSessionFactory.openSession();
        try{
            session.insert("insertLibraryInfo",libraryInfo_DTO);
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
            session.delete("deleteLibraryInfoAll");
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

