import java.util.*;
import java.io.*;
class Match implements Comparable<Match>{
    private String name;
    private Club club ;
    private int quantity;

    public Match(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name.substring(1,3);
    }

    public void setName(String name) {
        this.name = name;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getRevenue(){
        return quantity * club.getUnitPrice();
    }
    @Override
    public String toString() {
        return String.format("%s %s %d", name, club.getName(), getRevenue());
    }

    @Override
    public int compareTo(Match o) {
        if(this.getRevenue() == o.getRevenue()){
            return this.getClub().getName().compareTo(o.getClub().getName());
        }
        else if(this.getRevenue() > o.getRevenue()) return -1;
        return 1;
    }
}
class Club{
    private String id, name;
    private int unitPrice;

    public Club(String id, String name, int unitPrice) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Club> clubList = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            int uniPrice = sc.nextInt();
            clubList.add(new Club(id, name, uniPrice));
        }
        int q = sc.nextInt();
        ArrayList<Match> matchList = new ArrayList<>();
        for(int i = 0; i < q;i++){
            String name = sc.next();
            int quantity = sc.nextInt();
            matchList.add(new Match(name, quantity));
        }
        for(int i = 0; i < q; i++){
            for(Club club : clubList){
                if(matchList.get(i).getName().equals(club.getId())){
                    matchList.get(i).setClub(club);
                    break;
                }
            }
        }
        Collections.sort(matchList);
        for(Match match : matchList){
            System.out.println(match);
        }
    }
}