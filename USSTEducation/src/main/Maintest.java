package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import Connection.*;
import Util.*;
import com.bean.*;

public class Maintest {
    public static void main(String[] args) throws SQLException {
        Connection con = DBcon.getConnection();
        //List<TAnswer> css= DBAnswerUtil.getAllAnswerInfo();
        //Iterator<TAnswer> it = css.iterator();
       //  while(it.hasNext()) {
        //     TAnswer c1 = it.next();
        //    System.out.println(c1.getTeacherid()+" "+c1.getAcontent());
        //  }
        //TAnswer tAnswer=new TAnswer(1,"1","1","1","1","1","1");
        //DBAnswerUtil.getAnswerbymesid(1);
        //String a=DBAnswerUtil.getTeaidByMid(0);
        //TAnswer tAnswer = new TAnswer(1,"1","test","今天","000","w");
        //DBAnswerUtil.insertAnswerInfo(tAnswer);
         //String a=DBAnswerUtil.getTeaidByMid(0);
        Ccclass ccclass=new Ccclass("0003","李三","计算机组成");
        DBclassUtil.modifyClass(ccclass);
        System.out.println(ccclass.getTname()+ccclass.getCClass());
       /* String now = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        now = dateFormat.format (new Date());
        System.out.println("con"+con);
        String mid ="2";
        int mmID= Integer.parseInt(mid);
        //int id1 = Integer.parseInt(id);
       System.out.println(mmID);
        Message message=DBmeUtil.getMessageInfonly1id(2);
        message.setCcontext("亲亲");
        try {
            DBmeUtil.modifyMesInfo(message);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        //Message mes = new Message(11,"dadad","ddd",now,"数据","数据结构");
        //DBmeUtil.insertMesInfo(mes);

        //List<Message> css=DBmeUtil.getMessagelikeName("男");
        //Iterator<Message> it = css.iterator();
       // while(it.hasNext()) {
      //      Message c1 = it.next();
       //     System.out.println(c1.getTtitle()+" "+c1.getClasstype());
      //  }

        //查询全部表单信息
       /* String class1="计算机";
        List<Message> mes =new ArrayList<Message>();
        mes=DBmeUtil.getMessageInfoByClass(class1);
        Iterator<Message> it = mes.iterator();
        while(it.hasNext()) {
            Message message = it.next();
            System.out.println(message.getDdate()+"  "+message.getNname()+"  "+message.getTtitle()+"  "+message.getCcontext());
        }*/
        //
       // List<Message> mess= new ArrayList<>();
       // Message message=null;
       // mess=DBmeUtil.getAllMessageInfo();
       // System.out.println(mess);

        /*
        测试按姓名查询内容
        Message mes = new Message(now,"杀手","标题","正文");
        //Student stu = new Student(now,"六","男",21,"计算机","郑州");
        Message message = DBmeUtil.getMessageInfoByName("杀手");
        System.out.println(message.getDdate()+"  "+message.getNname()+"  "+message.getTtitle()+"  "+message.getCcontext());



        //修改表单内容
        Message message=new Message(now,"hitman","标题","正文");
        try {
            DBmeUtil.modifyMesInfo(message);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //按标题删除内容
        String title = "标题";
    	DBmeUtil.deleteMesInfo(title);
        添加信息


        Message mes = new Message(now,"男","标题语言","今晚");
    	DBmeUtil.insertMesInfo(mes);


        查询全部表单信息
        List<Message> mes = DBmeUtil.getAllMessageInfo();
        Iterator<Message> it = mes.iterator();
        while(it.hasNext()) {
            Message message = it.next();
            System.out.println(message.getDdate()+"  "+message.getNname()+"  "+message.getTtitle()+"  "+message.getCcontext());
        }
        int c=0;
        c=DBUserUtil.CheckuserID("zjy","123456");
        System.out.println(c);*/


        DBcon.closeConnection();
    }
}
