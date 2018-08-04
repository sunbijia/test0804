/**
 * @author bijia.sun@hand-china.com
 * @date 2018/8/4 11:28
 */
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Exam2
{

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入年月日，正确格式书写yyyy-mm-dd");
        SimpleDateFormat sformat= new SimpleDateFormat("yyyy-mm-dd");
        String sDate =reader.readLine();
        String[] str=sDate.split("-");
        String y = str[0];
        String m = str[1];
        String d = str[2];
        // TODO Auto-generated method stub
        Calendar ca=new GregorianCalendar();
//        int ye=ca.get(Calendar.YEAR);
//        int mo=ca.get(Calendar.MONTH)+1;
//        int da=ca.get(Calendar.DAY_OF_MONTH);
        int ye = Integer.parseInt(y);
        int mo = Integer.parseInt(m);
        int da = Integer.parseInt(d);
        String date=ye+"-"+mo+"-"+da;
        String[] dateArray=date.split("-");
        Integer year=Integer.valueOf(dateArray[0]);
        Integer month=Integer.valueOf(dateArray[1]);
        Integer day=Integer.valueOf(dateArray[2]);
        String nextDay=getNextDay(year,month,day);
        System.out.println("下一天为:"+nextDay);

    }
    public static String getNextDay(int year,int month,int day){

        //超过了当月的最大日期
        if((day+1)>getDaysInMonth(year,month)){
            if(month==12){
                return (year+1)+"-01-01";
            }
            else{
                return year+"-"+(month+1)+"-01";
            }
        }
        else{
            return year+"-"+month+"-"+(day+1);
        }

    }
    //通过年份和月份，确定对应的月份一共有多少天
    public static int getDaysInMonth(int year,int month){
        int days=0;
        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
            days=31;
        }
        else if(month==2){
            if(isBissextile(year))days=29;
            else days=28;
        }else{
            days=30;
        }
        return days;
    }
    public static boolean isBissextile(int year){

        if((year%4==0&&year%100!=0)||(year%400==0))return true;
        return false;
    }

}
