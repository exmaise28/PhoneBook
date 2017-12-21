package phoneBook;
import java.io.*;
import java.util.*;
public class phoneBook{
	public static void main  (String[] args) {
     phoneBook cl=new phoneBook();
     BufferedReader br;
     String ch="";
     try
         {  
            System.out.println("Phone Book Application");
         do
            {
                                    cl.menu();
                                    br=new BufferedReader (new InputStreamReader(System.in));
                                    System.out.print("Enter your option:      ");
                                    ch=br.readLine();
                                    if (ch.equals("1"))
                                        cl.new_record();
                                    if (ch.equals("2"))
                                        cl.display_record();
                                    if (ch.equals("3"))
                                        cl.display_by_name();
                                    if (ch.equals("4"))
                                        cl.display_by_city();
                                    if (ch.equals("5"))
                                        cl.display_record_first_letter();
                                    if (ch.equals("6"))
                                        cl.display_Phone_Number();
                                    if (ch.equals("7"))
                                        cl.replace_record();
                                    if (ch.equals("8"))
                                        cl.delete_record();
                                    if (ch.equals("9"))
                                                System.out.println("Good-Bye");
            } while(!ch.equals("9"));
         }
         catch(Exception E){}
     }
	public void new_record()
    {
       String id,name,city,add,number,total;
         boolean bln=false;
              try
        {
          Properties pr=new Properties();
          FileInputStream fin=new FileInputStream("PhoneHome.dat");
           if(fin!=null)
             {
             pr.load(fin);
             }   
            BufferedReader br1=new BufferedReader (new InputStreamReader(System.in));
              FileOutputStream fout=new  FileOutputStream("PhoneHome.dat");
                  for(;;)
                   {
                     System.out .println("Enter the ‘ID’, ‘q’ for quit:");
                     id=br1.readLine().toUpperCase();
                     bln=pr.containsKey(id);
                     if(bln)
                      {
                       System.out.println("ID number already exists, Please Enter another ID number:");
                       continue;
                      }
                    if((id.toUpperCase()).equals("Q"))
                    break;
                    System.out.println("Enter name:");
              name=br1.readLine().toUpperCase();
              System.out.println("Enter Phone number:");
              number=br1.readLine().toUpperCase();
                System.out.println("Enter address:");
              add=br1.readLine().toUpperCase();
              System.out.println("Enter city:");
              city=br1.readLine().toUpperCase();
              total="    Name="+name+","+"Phone number="+number+","+" Address="+add+","+"    City="+city;
                    total=total.toUpperCase();
              pr.put(id,total);
              pr.store(fout,"My Telephone Book");
                 }
              fout.close();
        }
          catch(Exception e)
          {
                System.out.println(e);
          }
    }
	
	public void display_record()
    {
        String id;
        String total="";
                int x=1;
        try
        {
            FileInputStream fin=new FileInputStream("PhoneHome.dat");
            Properties pr1=new Properties();
            pr1.load(fin);
            Enumeration enum1=pr1.keys();
            while(enum1.hasMoreElements())
            {
              id=enum1.nextElement().toString();
              total=pr1.get(id).toString();
              StringTokenizer stk=new StringTokenizer(total,"=,");
                          System.out .println("RECORD ::"+x+"\n");
                          x++;
              while(stk.hasMoreTokens())
              {
                  String key=stk.nextToken();
                  String value=stk.nextToken();
                  System.out.println("\t"+key+"::\t\t::"+value);
                                   try
                                     {
                                       Thread.sleep(100);
                                     }
                                      catch(Exception e){}
              }
                          System.out.println("");
                          System.out.println("");
            }
             fin.close();
        }
        catch(Exception e){}
    }
	
	public void display_by_name(){
            String name,id,total;
            String key[]=new String[4];
            String value[]=new String[4];
            int i=0;
        System.out.println("Enter Full Name For Searching Record :-");
        try
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                  name=br.readLine().toUpperCase();
                  FileInputStream fin=new FileInputStream("PhoneHome.dat");
            Properties pr1=new Properties();
            pr1.load(fin);
            Enumeration enum1=pr1.keys();
            while(enum1.hasMoreElements())
            {
              id=enum1.nextElement().toString();
              total=pr1.get(id).toString();
              StringTokenizer stk=new StringTokenizer(total,"=,");
                     while(stk.hasMoreTokens()){
                         for(i=0;i<4;i++){
                           key[i]=stk.nextToken();
                           value[i]=stk.nextToken();
                         }
                           if(value[0].equals(name)){
                              for(i=0;i<4;i++){
                                 System.out.println("\t"+key[i]+":"+value[i]);
                                try
                                     {
                                     Thread.sleep(100);
                                     }
                                      catch(Exception e){}
                               }                           
                            }
              }
                      System.out.println("");  
            }
             fin.close();
        }
        catch(Exception e){
            System.out.println(e);
            }
}

public void display_by_city(){
    String city="",id,total;
    String key2[]=new String[4];
    String value2[]=new String[4];
    int i=0;
             System.out.println("Enter City For Search in Record :-");
          try
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                  city=br.readLine().toUpperCase();
                  FileInputStream fin=new FileInputStream("PhoneHome.dat");
            Properties pr1=new Properties();
            pr1.load(fin);
            Enumeration enum1=pr1.keys();
            while(enum1.hasMoreElements()){
              id=enum1.nextElement().toString();
              total=pr1.get(id).toString();
              StringTokenizer stk=new StringTokenizer(total,"=,");
              while(stk.hasMoreTokens()){
                   key2[i]=stk.nextToken();
                           value2[i]=stk.nextToken();
                         if(i==3){
                           if(value2[i].equals(city)){
                              for(int j=0;j<4;j++){
                                 System.out.println("\t"+key2[j]+":\t"+value2[j]);
                                 try
                                     {
                                       Thread.sleep(100);
                                     }
                                      catch(Exception e){}
                               }   
                            }
                          }
                         i++;
                         if(i>3)
                           i=0;
              }
                          System.out.println("");
                          System.out.println("");
            }
             fin.close();
        }
        catch(Exception e){
            System.out.println(e);
            }
   }

public void display_record_first_letter(){
    String name,id,total,str="";
    String key2[]=new String[4];
    String[] value2=new String[4]; 
    int i=0;
        try
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                  System.out.println("Enter The First Letter of First Name: ");
                  name=br.readLine();
                  name=name.substring(0,1).toUpperCase();
                  FileInputStream fin=new FileInputStream("PhoneHome.dat");
            Properties pr1=new Properties();
            pr1.load(fin);
            Enumeration enum1=pr1.keys();
            while(enum1.hasMoreElements())
            {
              id=enum1.nextElement().toString();
              total=pr1.get(id).toString();
              StringTokenizer stk=new StringTokenizer(total,"=,");
                     while(stk.hasMoreTokens())
              {  
                           for(i=0;i<4;i++)
                           {
                           key2[i]=stk.nextToken();
                           value2[i]=stk.nextToken();
                          }
                          str=value2[0].substring(0,1);
                           if(str.equals(name))
                            {
                             for(i=0;i<4;i++)
                              {
                                System.out.println("\t"+key2[i]+":\t"+value2[i]); 
                                try
                                     {
                                       Thread.sleep(100);
                                     }
                                      catch(Exception e){}
                            }
                          }
              }
                          System.out.println("");
                          System.out.println("");
            }
             fin.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
}

public void display_Phone_Number(){
	String number,id,total;
    String key[]=new String[4];
    String value[]=new String[4];
    int i=1;
             System.out.println("Enter Phone Number For Search in Record :-");
          try
        {
        	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
              number=br.readLine();
              FileInputStream fin=new FileInputStream("PhoneHome.dat");
        Properties pr1=new Properties();
        pr1.load(fin);
        Enumeration enum1=pr1.keys();
        while(enum1.hasMoreElements())
        {
          id=enum1.nextElement().toString();
          total=pr1.get(id).toString();
          StringTokenizer stk=new StringTokenizer(total,"=,");
                 while(stk.hasMoreTokens()){
                     for(i=0;i<4;i++){
                       key[i]=stk.nextToken();
                       value[i]=stk.nextToken();
                     }
                       if(value[1].equals(number)){
                          for(i=0;i<4;i++){
                             System.out.println("\t"+key[i]+":"+value[i]);
                            try
                                 {
                                 Thread.sleep(100);
                                 }
                                  catch(Exception e){}
                           }                           
                        }
          }
                  System.out.println("");  
        }
         fin.close();
    }
    catch(Exception e){
        System.out.println(e);
        }
}

	public void replace_record()
      {
           String id,name,city,add,number,total,list;
         boolean bln=false;
              try
        {
          Properties pr=new Properties();
          FileInputStream fin=new FileInputStream("PhoneHome.dat");
           if(fin!=null)
             {
             pr.load(fin);
             }   
            BufferedReader br1=new BufferedReader (new InputStreamReader(System.in));
              FileOutputStream fout=new  FileOutputStream("PhoneHome.dat");
                  for(;;)
                   {
                     System.out .println("Enter the ‘ID number’, ‘q’ for quit:");
               id=br1.readLine().toUpperCase();
                     if((id.toUpperCase()).equals("Q"))
                    break;
                     bln=pr.containsKey(id);
                     if(bln)
                      {
                       System.out.println("ID number already exists, ");
                    System.out.println("enter name:");
              name=br1.readLine().toUpperCase();
              System.out.println("enter Phone number:");
              number=br1.readLine().toUpperCase();
                System.out.println("enter address:");
              add=br1.readLine().toUpperCase();
              System.out.println("enter city:");
              city=br1.readLine().toUpperCase();
              total="    Name="+name+","+"Phone Number="+number+","+" Address="+add+","+"    City="+city;
                    total=total.toUpperCase();
              pr.put(id,total);
              pr.store(fout,"My Telephone Book");
                 }
                    else
                         {
                           System.out.println("ID number does not Exists, Please Enter A Valid ID number:");
                           continue;
                         }
               }
             pr.store(fout,"My Phone Book");
                   fout.close();
        }
          catch(Exception e)
          {
                System.out.println(e);
          }
    }

	public void delete_record()
   {
   String id;
         boolean bln=false;
              try
        {
          Properties pr1=new Properties();
          FileInputStream fin=new FileInputStream("PhoneHome.dat");
          if(fin!=null)
            pr1.load(fin);
            BufferedReader br1=new BufferedReader (new InputStreamReader(System.in));
              FileOutputStream fout=new  FileOutputStream("PhoneHome.dat");
                  for(;;)
                   {
                     System.out .println("Enter the ‘ID number’, ‘q’ for quit:");
               id=br1.readLine().toUpperCase();
                     if((id.toUpperCase()).equals("Q"))
                        break;
                     bln=pr1.containsKey(id);
                     if(bln)
                      {
                       System.out.println("ID number  exists :");
                       String str=pr1.remove(id).toString();
                       pr1.store(fout,"My Phone Book");
                       try
                                     {
                                       Thread.sleep(100);
                                     }
                                      catch(Exception e){} 
                      System.out.println("Record deleted successfully");
                      }
                        else
                         {
                           System.out.println("Enter Existing ID number:");
                            pr1.store(fout,"My Phone Book"); 
                         }
                  }
              pr1.store(fout,"My Phone Book");
                    fin.close();
                    fout.close();
        }
          catch(Exception e)
          {
                System.out.println(e);
          }
    }

public void menu()
           {
        char ch=30;
            char ch1=31;
            int l;
            for(int i=0;i<27;i++)
            {
              System.out.print(" ");
            }
            for(l=0;l<2;l++)
           {
            for(int j=0;j<38;j++)
            {
              System.out.print(ch);
            }
              System.out.println("");
               for(int k=0;k<27;k++)
            {
              System.out.print(" ");
            }
          }
            System.out.print(ch); 
            System.out.print(ch1);
            for(int i=0;i<34;i++)
            System.out.print(" ");
            System.out.print(ch);
            System.out.print(ch1);
            System.out.println("");
            for(int i=0;i<27;i++)
            System.out.print(" ");
            System.out.print(ch);
            System.out.print(ch1+" ");
            

            System.out.print (" 1. Enter new Record:           ");
            System.out.print(" "+ch);
            System.out.println(ch1+" ");
            for(int i=0;i<26;i++)
            System.out.print(" ");
            System.out.print(" "+ch1);
            System.out.print(ch+" ");
           
           
        System.out.print (" 2. Display All Records:         ");
            System.out.print(" "+ch);
            System.out.println(ch1+" ");
            for(int i=0;i<26;i++)
            System.out.print(" ");
            System.out.print(" "+ch);
            System.out.print(ch1+" ");

           
        System.out.print (" 3. Search Record by Full name:      ");
            System.out.print(" "+ch);
            System.out.println(ch1+" ");
            for(int i=0;i<26;i++)
            System.out.print(" ");
            System.out.print(" "+ch);
            System.out.print(ch1+" ");
           

        System.out.print (" 4. Search Record by city:      ");
            System.out.print(" "+ch);
            System.out.println(ch1+" ");
            for(int i=0;i<26;i++)
            System.out.print(" ");
            System.out.print(" "+ch);
            System.out.print(ch1+" ");

   
        System.out.print (" 5. Search Record by 1st letter of 1st Name:       ");
            System.out.print(" "+ch);
            System.out.println(ch1+" ");          
            for(int i=0;i<26;i++)
            System.out.print(" ");
            System.out.print(" "+ch);
            System.out.print(ch1+" ");
            
       System.out.print (" 6. Search Record by Phone Number:      ");
            System.out.print(" "+ch);
            System.out.println(ch1+" ");
            for(int i=0;i<26;i++)
            System.out.print(" ");
            System.out.print(" "+ch);
            System.out.print(ch1+" ");
           
           
            System.out .print(" 7. Replace Record:             ");
            System.out.print(" "+ch);
            System.out.println(ch1+" ");                     
            for(int i=0;i<26;i++)
            System.out.print(" ");
            System.out.print(" "+ch);
            System.out.print(ch1+" ");

            
        System.out .print(" 8. Delete Record:              ");
            System.out.print(" "+ch);
            System.out.println(ch1+" ");                      
            for(int i=0;i<26;i++)
            System.out.print(" ");
            System.out.print(" "+ch);
            System.out.print(ch1+" ");
           
          
        System.out .print(" 9. Exit:                       ");
            System.out.print(" "+ch);
            System.out.println(ch1+" ");
            for(int j=0;j<27;j++)
            System.out.print(" ");
            System.out.print(ch); 
            System.out.print(ch1);
            for(int i=0;i<34;i++)
            System.out.print(" ");
            System.out.print(ch);
            System.out.print(ch1);
            System.out.println("");
            for(int i=0;i<27;i++)
            System.out.print(" ");
            for(int i=0;i<38;i++)
            System.out.print(ch);
            System.out.println("");
            for(int i=0;i<27;i++)
            System.out.print(" ");
            for(int i=0;i<38;i++)
            System.out.print(ch);
           }
}