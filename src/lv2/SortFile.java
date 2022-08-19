package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortFile { // [3차] 파일명 정렬

   public static void main(String[] args) {
//      String[] files = { "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" };
//      String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
      String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-15", "foo014foo01e.ti", "F1 14", "t1287395078.exe"};
//      String[] files = {"muzi1.png1", "MUZI3.png2", "MUZI1.png1", "muzi1.png4"};
//      String[] files = {"O00321", "O49qcGPHuRLR5FEfoO00321"};
//      String[] files = {"ver-10.zip", "ver-9.zip"};
//      String[] files = {"foo10bar020.zip", "foo010bar020.zip"};
//      String[] files = {"foo010bar020.zip", "foo10bar020.zip"};
//      String[] files = {"f1728", "F15 -", "f15", "kj-2097woinh"};
      
      System.out.println(solution(files));
   }

   static class File {
      String head;
      String num;
      String tail;
      
      public File(String head, String num, String tail) {
         this.head = head;
         this.num = num;
         this.tail = tail;
      }
   }
   private static String[] solution(String[] files) {
      String[] answer = new String[files.length];
      
      List<File> list = new ArrayList<>();
      for (int i = 0; i < files.length; i++) {
         int idx = 0;
         StringBuilder sb = new StringBuilder();
         
         // HEAD 찾기
         for (int j = 0; j < files[i].length(); j++) {
            if(Character.isDigit(files[i].charAt(j))) {  // 숫자라면
               idx = j;  // 현재 인덱스 기억하고
               break;  // head 찾는 반복문 종료
            }
            sb.append(files[i].charAt(j));
         }
         String h = sb.toString();
         System.out.println("HEAD : " + h);
         
         // Number 찾기
         sb = new StringBuilder();
         for (int j = idx; j < files[i].length(); j++) {

            if(!Character.isDigit(files[i].charAt(j))) {  // 숫자가 아니라면
               idx = j;  // 현재 인덱스 종료
               break;  // number 찾는 반복문 종료
            }
            sb.append(files[i].charAt(j));
            if(j == files[i].length()-1) {  // 마지막 인덱스이므로 종료
               idx = j;  // 현재 인덱스 종료
               break;
            }
         }
         String n = sb.toString();
         System.out.println("NUMBER : " + n);
         
         // Tail 찾기
         String t = "";
         if(idx < files[i].length()-1) {  // idx가 문자열 마지막 인덱스가 아니라면
            t = files[i].substring(idx);  // 나머지 뒷부분 tail로 저장
         }
         System.out.println("Tail : " + t);
         
         File f = new File(h, n, t);
         System.out.println(h + n + t);
         list.add(f);  // list에 저장
      }
      
      // File명 정렬
      Collections.sort(list, new Comparator<File>() {

         @Override
         public int compare(File o1, File o2) {
            // HEAD가 같다면 NUMBER순으로 정렬 (대소문자 구분x)
            String h1 = o1.head.toLowerCase();
            String h2 = o2.head.toLowerCase();
            if(h1.equals(h2)) {
               return Integer.parseInt(o1.num) - Integer.parseInt(o2.num);  // 정수로 바꿔서 비교
            }
            
            // HEAD를 사전순으로 정렬
            return h1.compareTo(h2);
         }
      });
      
      for (int i = 0; i < list.size(); i++) {
         answer[i] = list.get(i).head + list.get(i).num + list.get(i).tail;
      }
      
      System.out.println(Arrays.toString(answer));
      return answer;
   }

}