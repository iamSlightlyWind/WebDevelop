package SQLManage;

public class Paper {
    public int id;
    public String title;
    public String date;
    
    public Paper (int id, String title, String date){
        this.id = id;
        this.title = title;
        this.date = date;
    }
    
    public int getId(){
        return id;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getDate(){
        return date;
    }
}
