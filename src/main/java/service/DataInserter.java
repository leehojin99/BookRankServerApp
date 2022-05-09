package service;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class DataInserter {
    SeoulData_Service seoulData_service;
    AladinData_Service aladinData_service;
    KolisNet_Service kolisNet_service;
    LibraryInfo_Service libraryInfo_service;
    List<String> addedIsbnList;
    public DataInserter(SeoulData_Service seoulData_service,AladinData_Service aladinData_service, KolisNet_Service kolisNet_service, LibraryInfo_Service libraryInfo_service){
        this.seoulData_service = seoulData_service;
        this.aladinData_service = aladinData_service;
        this.kolisNet_service = kolisNet_service;
        this.libraryInfo_service = libraryInfo_service;
    }
    public void inputDataWithApi(){
        int firstPage;
        int lastPage;
        addedIsbnList = new ArrayList<String>();
//        for (firstPage = 1,lastPage = 1000;lastPage<=3000;firstPage+=1000,lastPage+=1000){
        //테스트용은 100
        for (firstPage = 1,lastPage = 100;lastPage<=100;firstPage+=1000,lastPage+=1000){
            try {
                StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088");
                /*URL*/
                urlBuilder.append("/" + URLEncoder.encode("456d7a59534c45453835477669446c", "UTF-8"));
                /*인증키*/
                urlBuilder.append("/" + URLEncoder.encode("xml", "UTF-8"));
                /*요청파일타입(xml,xmlf,xls,json) */
                urlBuilder.append("/" + URLEncoder.encode("SeoulLibraryBookRentNumInfo", "UTF-8"));
                /*서비스명 (대소문자 구분 필수입니다.)*/
                urlBuilder.append("/" + URLEncoder.encode(Integer.toString(firstPage), "UTF-8"));
                /*요청시작위치*/
                urlBuilder.append("/" + URLEncoder.encode(Integer.toString(lastPage), "UTF-8"));
                /*요청종료위치*/
//      http://openapi.seoul.go.kr:8088/456d7a59534c45453835477669446c/xml/SeoulLibraryBookRentNumInfo/1/1000/
//      http://openapi.seoul.go.kr:8088/456d7a59534c45453835477669446c/xml/SeoulLibraryBookRentNumInfo/1001/2000/
//      http://openapi.seoul.go.kr:8088/456d7a59534c45453835477669446c/xml/SeoulLibraryBookRentNumInfo/2001/3000/

                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                Document document = documentBuilder.parse(urlBuilder.toString());

                document.getDocumentElement().normalize();

                NodeList nodeList = document.getElementsByTagName("row");

                for (int i=0; i<nodeList.getLength();i++){
                    Node node = nodeList.item(i);
                    Element element = (Element) node;

                    String isbn = ParsingUtility.getTagValue("ISBN",element);
                    String clf_no = ParsingUtility.getTagValue("CLASS_NO",element);
                    String borrow_cnt = ParsingUtility.getTagValue("CNT",element);
                    if(isbn!=null&&clf_no!=null&&borrow_cnt!=null){
                        if (!addedIsbnList.contains(isbn)){
                            seoulData_service.insertSeoulData(isbn,Integer.parseInt(clf_no),Integer.parseInt(borrow_cnt));
                            addedIsbnList.add(isbn);
                            inputAladinDataWithApi(isbn);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void inputAladinDataWithApi(String inputISBN){
        try {
            StringBuilder urlBuilder = new StringBuilder("http://www.aladin.co.kr/ttb/api/ItemLookUp.aspx");
//            urlBuilder.append("?ttbkey=" + URLEncoder.encode("ttbspacefx1111001", "UTF-8"));
            urlBuilder.append("?ttbkey=" + URLEncoder.encode("ttbwet9321141002", "UTF-8"));

            if(inputISBN.length()==13)
                urlBuilder.append("&itemIdType=" + URLEncoder.encode("ISBN13", "UTF-8"));
            else
                urlBuilder.append("&itemIdType=" + URLEncoder.encode("ISBN", "UTF-8"));
            urlBuilder.append("&ItemId=" + URLEncoder.encode(inputISBN, "UTF-8"));
            urlBuilder.append("&output=" + URLEncoder.encode("xml", "UTF-8"));
            urlBuilder.append("&Version=" + URLEncoder.encode("20131101", "UTF-8"));
            urlBuilder.append("&OptResult=" + URLEncoder.encode("ebookList", "UTF-8"));

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(urlBuilder.toString());
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("item");

            for (int i=0; i<nodeList.getLength();i++){
                Node node = nodeList.item(i);
                Element element = (Element) node;
                String cov_url = ParsingUtility.getTagValue("cover",element);
                String rating = ParsingUtility.getTagValue("customerReviewRank",element);
                String book_description = ParsingUtility.getTagValue("description",element);
                String title = ParsingUtility.getTagValue("title",element);
                String author = ParsingUtility.getTagValue("author",element);
                String publisher = ParsingUtility.getTagValue("publisher",element);

                int ebook =0;
                //???????
                aladinData_service.insertAladinData(inputISBN,cov_url,Integer.parseInt(rating),book_description,ebook,title,author,publisher);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
