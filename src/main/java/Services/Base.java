package Services;

import Model.Hodim;

import java.sql.*;
import java.util.Scanner;

public class Base {
    private  String url="jdbc:postgresql://localhost:5432/CRUD";
    private  String user_name="postgres";
    private  String password="1234";
    public String Yaratish(Hodim hodim) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection= DriverManager.getConnection(url,user_name,password);
        Statement statement=connection.createStatement();
        String query="INSERT INTO hodimlar(ism, familya, manzil, e_pochta)" +
                "VALUES('"+hodim.getIsm()+"','"+hodim.getFamilya()+"','"+hodim.getManzil()+"','"+hodim.getE_pochta()+"')";
        statement.execute(query);
        return "ma'lumotlar saqlandi";
    }

    public void Oqish() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection= DriverManager.getConnection(url,user_name,password);
        Statement statement=connection.createStatement();
        String query="SELECT * FROM hodimlar";
        ResultSet resultSet=statement.executeQuery(query);
        while (resultSet.next()){
            int id=resultSet.getInt(1);
            String ism=resultSet.getString(2);
            String familya=resultSet.getString(3);
            String manzil=resultSet.getString(4);
            String e_pochta=resultSet.getString(5);
            System.out.println("id: "+id+"\nIsmi: "+ism+"\nFamilya: "+familya+"\nManzil: "+manzil+"\nE-pochta: "+e_pochta);
        }
    }

    public void Ochirish(int id) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection= DriverManager.getConnection(url,user_name,password);
        Statement statement=connection.createStatement();
        String query="DELETE FROM hodimlar WHERE id="+id;
        statement.execute(query);
        System.out.println("Ma'lumot o'chirildi");
    }

    public void Tahrirlash(int id1 ,Hodim hodim1) throws ClassNotFoundException, SQLException {
//        int hisob=0;
        Class.forName("org.postgresql.Driver");
        Connection connection= DriverManager.getConnection(url,user_name,password);
        Statement statement=connection.createStatement();
        Statement statement1=connection.createStatement();

        String query="SELECT COUNT(*) FROM hodimlar WHERE id="+id1;
        ResultSet resultSet=statement.executeQuery(query);
        if (resultSet.next()){
            int count=resultSet.getInt(1);
            if (count==1){
                String query1="UPDATE hodimlar set ";
                if (!hodim1.getIsm().equals("")){
                    query1+="ism='"+hodim1.getIsm()+"', ";
                }
                if (!hodim1.getFamilya().equals("")){
                    query1+="familya='"+hodim1.getFamilya()+"', ";
                }
                if (!hodim1.getManzil().equals("")){
                    query1+="manzil='"+hodim1.getManzil()+"', ";
                }
                if (!hodim1.getE_pochta().equals("")){
                    query1+="e_pochta='"+hodim1.getE_pochta()+"' ";
                }
                if (!query1.equals("UPDATE hodimlar set ")){
                    if (query1.endsWith("', ")){
                        query1=query1.substring(0,query1.length()-2);
                    }
                    query1+=" WHERE id="+id1;
                    statement1.execute(query1);
                    System.out.println("Tahrirlandi");
                }else {
                    System.out.println("O'zgartirish kiritilmadi");
                }

            }else {
                System.out.println("Bunday id li hodim mavjud emas");
            }
        }

        /*
//        String query="SELECT * FROM hodimlar";
//        ResultSet resultSet=statement.executeQuery(query);
//        Scanner cin=new Scanner(System.in);
//        while (resultSet.next()){
//            int Id= resultSet.getInt(1);
//            String ism=resultSet.getString(2), ism1="";
//            String familya=resultSet.getString(3), familya1="";
//            String manzil=resultSet.getString(4), manzil1="";
//            String e_pochta=resultSet.getString(5), e_pochta1="";
//            if (id1==Id){
//                hisob++;
//                System.out.println("Ismi: "+ism);
//                ism1 = cin.nextLine();
//                System.out.println("Familyasi: "+familya);
//                familya1 = cin.nextLine();
//                System.out.println("Manzili: "+manzil);
//                manzil1 = cin.nextLine();
//                System.out.println("E-pochta: "+e_pochta);
//                e_pochta1 = cin.nextLine();
//
//                if (ism1.equals("") || ism1.equals(ism)){
//                    System.out.println("Ism o'zgarmadi");
//                }else {
//                    ism=ism1;
//                    System.out.println("Ism o'zgardi");
//                }
//                if (familya1.equals("") || familya1.equals(familya)){
//                    System.out.println("Familya o'zgarmadi");
//                }else {
//                    familya=familya1;
//                    System.out.println("Familya o'zgardi");
//                }
//                if (manzil1.equals("") || manzil1.equals(manzil)){
//                    System.out.println("Manzil o'zgarmadi");
//                }else {
//                    manzil=manzil1;
//                    System.out.println("Manzil o'zgardi");
//                }
//                if (e_pochta1.equals("") || e_pochta1.equals(e_pochta)){
//                    System.out.println("E-pochta o'zgarmadi");
//                }else {
//                    e_pochta=e_pochta1;
//                    System.out.println("E-pochta o'zgardi");
//                }
//                String Query="UPDATE hodimlar SET ism='"+ism+"', familya='"+familya+"', manzil='"+manzil+"', e_pochta='"+e_pochta+"'WHERE id="+id1;
//                statement1.execute(Query);
//            }
//        }
//        if (hisob==0){
//            System.out.println("Bunday id li hodim bazada mavjud emas!!!");
//        }*/
    }

    public void Saqlash(Hodim hodim) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection= DriverManager.getConnection(url,user_name,password);
        String Query="INSERT INTO hodimlar(ism, familya, manzil, e_pochta) " +
                "VALUES(?, ?, ?, ?)";
        PreparedStatement statement=connection.prepareStatement(Query);
        statement.setString(1, hodim.getIsm());
        statement.setString(2, hodim.getFamilya());
        statement.setString(3, hodim.getManzil());
        statement.setString(4, hodim.getE_pochta());
        statement.executeUpdate();
        System.out.println("Hodim ma'lumotlari saqlndi!");
    }
//    public String Oqish() throws ClassNotFoundException, SQLException {
//        Class.forName("org.postgresql.Driver");
//        Connection connection= DriverManager.getConnection(url,user_name,password);
//        Statement statement=connection.createStatement();
//        String query="SELECT id, ism, familya, manzil, e_pochta FROM hodimlar";
//        ResultSet resultSet = statement.executeQuery(query);
//        String malumot="";
//        while (resultSet.next()) {
//            malumot+="Id: "+resultSet.getString("id")+"\nIsmi: "+resultSet.getString("ism")+"\nFamilyasi: "+resultSet.getString("familya")
//            +"\nManzil: "+resultSet.getString("manzil")+"\nE-pochta: "+resultSet.getString("e_pochta")+"\n";
//        }
////        return String.valueOf(statement.execute(query));
//        return malumot;
//    }

}
